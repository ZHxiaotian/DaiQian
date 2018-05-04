package com.zonesun.daiqian.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.adapter.VisitAlrearyAdapter;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.MyEvent;

import de.greenrobot.event.EventBus;

/**
 * 调研报告fragment
 * 
 * @author Administrator
 * 
 */
public class ResearchReportFragment extends BaseFragment implements
		OnClickListener {

	public ResearchReportFragment() {
		super();
	}

	private View view;// 跟布局View
	private ImageView head_img;// 员工头像
	private TextView tv_number;// 员工编号
	private TextView tv_name;// 员工姓名
	
	
	private TextView textView2;// 已巡检TextView

	private LinearLayout ll2;// 包裹已巡检LIstView的LinearLayout

	private ListView listView2;// 展示已巡检数据的ListView

	private String date;// 网络请求到的数据
	private List<VisitalrearyEntity> list;
	/*
	 * 定义boolean变量各自表示TextView是否被点击 true:表示当前状态是展开状态,点击后设置为false
	 * false:表示当前状态为折叠状态,点击后设置为true
	 */
	private boolean isListView2Unfold;// listview2展开或者合并状态
	private HashMap<String, Object> map;
	private RuHuSurveyEntity entity;

	private ArrayList<NameValuePair> nameValuePairs;
	private SharedPreferences sp;
	private String MYCOOKIES;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_research_report, null);
		textView2 = (TextView) view.findViewById(R.id.textview2);

		ll2 = (LinearLayout) view.findViewById(R.id.ll2);

		listView2 = (ListView) view.findViewById(R.id.listView2);

		head_img = (ImageView) view.findViewById(R.id.head_imageview);
		tv_number = (TextView) view.findViewById(R.id.gh_tv);
		tv_name = (TextView) view.findViewById(R.id.name_tv);
		// 将调查员的信息设置到界面显示
		BitmapUtils utils = new BitmapUtils(mActivity);
		utils.display(head_img, Constants.GETIMGURL
				+ GLobleData.logindata.getData().getHeadimg());
		tv_number.setText("工号:" + GLobleData.logindata.getData().getOrganid());
		tv_name.setText("姓名:" + GLobleData.logindata.getData().getName());
		/*
		 * 初始化页面,默认第一个listView是展开状态,另外两个LIstView是合并状态
		 */
		isListView2Unfold = true;

		return view;
	}

	@Override
	public void initData() {

		sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
		MYCOOKIES = sp.getString("MYCOOKIES", null);

		// 给三个TextView添加点击监听
		textView2.setOnClickListener(this);

		getYZFDate();

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {

		case R.id.textview2:
			if (isListView2Unfold) {// 表示listView2是展开状态,点击后设置为false,并将ListView2折叠
				isListView2Unfold = false;
				ll2.setVisibility(View.GONE);
			} else {// 表示Listview2是折叠状态,要将listView1展开,并且将状态设置为true;
					// 同时让其他两个ListView值为false,将其余两个折叠
				isListView2Unfold = true;
				ll2.setVisibility(View.VISIBLE);

			}
			break;

		default:
			break;
		}

	}

	/**
	 * 通过get请求获取贷钱业务客户信息
	 */
	private void getYZFDate() {

		RequestParams params = new RequestParams();
		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("equip", "4"));
		params.addBodyParameter(nameValuePairs);
		params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.POST, Constants.DQCHLB, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String msg) {
						Toast.makeText(mActivity, "网络请求错误" + msg,
								Toast.LENGTH_LONG).show();

					}

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {

						if (responseInfo.result != null) {
							setText(responseInfo.result);
						}
					}

				});
	}

	private void setText(String json) {
		Gson gson = new Gson();
		entity = gson.fromJson(json, RuHuSurveyEntity.class);
		System.out.println("---------entity.getVisitalreary()-----------"+entity.getVisitalready());
		setAdapter();
		 setonClick();
	}

	/**
	 * 给listview设置适配
	 */
	protected void setAdapter() {

		if (entity.getVisitalready() != null) {
			listView2
					.setAdapter(new VisitAlrearyAdapter(entity, getActivity()));
		}

	}

	/**
	 * 设置点击事件
	 */
	private void setonClick() {
		listView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				reFreshVisitAlready(position);
			}
		});
	}
	
	
	/**
	 * 刷新主布局的数据pos
	 * 
	 * @param position
	 */
	public void reFreshVisitAlready(int position) {
		EventBus.getDefault().post(
				new MyEvent(entity.getVisitalready().get(position),1));
	}

}
