package com.zonesun.daiqian.fragment;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.google.gson.Gson;
import com.zonesun.daiqian.activity.LoginActivity;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.adapter.ZhenxinReshAdapter;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.RootData;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.ToastUtil;

import de.greenrobot.event.EventBus;

public class ZhgXinReshProFragment extends BaseFragment {

	NoHttpRequest request;
	SharedPreferences sp;
	// 查询列表的控件对象
	@Bind(R.id.lv_zhenxinresh_progras)
	public ListView lv;
	// 查询按钮
	@Bind(R.id.bt_zhengxin_survey)
	public Button bt_search;
	// 需要查询的文本输入框
	@Bind(R.id.et_zhenxinresh_progras)
	public EditText et_search;

	/*
	 * 初始化界面方法初始化所有控件 (non-Javadoc)
	 * 
	 * @see com.zonesun.daiqian.base.BaseFragment#initView()
	 */
	@Override
	public View initView() {
		// TODO Auto-generated method stub

		View view = View.inflate(mActivity,
				R.layout.fragment_zhengxinressh_progrss, null);

		ButterKnife.bind(this, view);
		EventBus.getDefault().register(this);
		// System.out.println("走了。。。。。。。。");
		if(GLobleData.DeviceBrand.equals(android.os.Build.BRAND)&&GLobleData.Devicemodel.equals(android.os.Build.MODEL)) {
			request = new NoHttpRequest(getActivity(), getActivity()
					.getSharedPreferences("login", getActivity().MODE_PRIVATE));
			request();
		}else{
			ToastUtil.showShort(getActivity(),"当前设别受限，无法获取征信信息");

		}
		return view;

	}

	/**
	 * 注解监听方法用来查询按钮的
	 * 
	 * @param v
	 */
	@OnClick(R.id.bt_zhengxin_survey)
	public void OnClick(View v) {
		Map<String, String> map = new HashMap<String, String>();
		// map.put("Cookie", " =" + sp.getString("MYCOOKIES", null));

		if (et_search.getText().toString().isEmpty()) {

			Toast.makeText(getActivity(), "姓名或身份证号不能为空", Toast.LENGTH_SHORT)
					.show();
		} else {

			System.out.println("ddddddd");
			map.put("filter", et_search.getText().toString());
			request.Request(map, Constants.POSTBankPersonSerach, null,
					NoCode.NOHTTP_WHAT_SEARCHZX);

		}
	}

	/**
	 * EventBus的回调方法
	 * 
	 * @param event
	 */

	public void onEventMainThread(EventT event) {
		if (event.getObj().has("result")) {// 判断是否还是登录状态如果不是登陆状态跳转到登陆界面进行登陆
			System.out.println(event.getObj().toString());
			startLogin();
		} else {
			if (event.getNoCode() == NoCode.NOHTTP_WHAT_SEARCHZX) {

				// 如果是未登陆状态直接跳转到登陆页面登陆

				// System.out.println(event.getObj().toString());
				Gson gson = new Gson();
				// System.out.println(msg.obj.toString());

				RootData data = gson.fromJson(event.getObj().toString(),
						RootData.class);

				if (data != null) {
					selectUserData(data);// 显示查询结果的方法
				} else {
					Toast.makeText(getActivity(), "正在加载请稍等", Toast.LENGTH_SHORT)
							.show();

				}
			} else if (event.getNoCode() == NoCode.NOHTTP_WHAT_ZXCXJD) {

				Gson gson = new Gson();
				System.out.println(event.getObj().toString());
				RootData data = gson.fromJson(event.getObj().toString(),
						RootData.class);

				if (data != null) {
					selectUserData(data);// 显示查询结果的方法
				} else {
					Toast.makeText(getActivity(), "正在加载请稍等", Toast.LENGTH_SHORT)
							.show();
					request();
				}

			}
		}
	}

	/**
	 * 此方法用于判断获取的个人征信的情况并将之展示到界面
	 * 
	 * @param data
	 */
	private void selectUserData(RootData data) {
		if (data.getTotalSize() == 0) {

			Toast.makeText(getActivity(), "调查员您好，您还没有添加需要查询征信的用户请先添加一个用户再查询",
					Toast.LENGTH_LONG).show();
		} else {
			ZhenxinReshAdapter adapter = new ZhenxinReshAdapter(getActivity(),
					data.getRows());
			lv.setAdapter(adapter);
		}
	}

	/**
	 * 重新登陆的方法
	 */
	private void startLogin() {
		Intent intent = new Intent(getActivity(), LoginActivity.class);
		getActivity().startActivity(intent);
	}

	// 测试进行网络请求
	private void request() {
		sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

		Map<String, String> map = new HashMap<String, String>();

		// map.put("Cookie", "JSESSIONID=" + sp.getString("MYCOOKIES", null));

		request.Request(map, Constants.POSTBankInquireForm, null,
				NoCode.NOHTTP_WHAT_ZXCXJD);

	}

	/**
	 * 生命周期方法用于结束自己的操作或释放一些资源
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

}
