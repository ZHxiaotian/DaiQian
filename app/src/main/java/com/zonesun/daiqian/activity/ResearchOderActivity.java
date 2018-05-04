package com.zonesun.daiqian.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.MyApplication;
import com.zonesun.daiqian.entity.ResearchOderEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.EditInputFilter;
import com.zonesun.daiqian.util.MyFocusChangeListener;
import com.zonesun.daiqian.util.MyTextWachert;

import com.zonesun.daiqian.view.AbstractSpinerAdapter;
import com.zonesun.daiqian.view.AbstractSpinerAdapter.IOnItemSelectListener;
import com.zonesun.daiqian.view.CustemObject;
import com.zonesun.daiqian.view.CustemSpinerAdapter;
import com.zonesun.daiqian.view.SpinerPopWindow;

/**
 * 调查预约
 * 
 * @author yll
 * 
 */
public class ResearchOderActivity extends Activity implements
		IOnItemSelectListener {

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			if (msg.what == 1 || msg.what == 0) {
				System.out.println("------------------------输入了" + msg.what);
				System.out.println("------------------------nowname" + nowname);
				System.out.println("------------------------nowzjhm" + nowzjhm);
				if (nowname != null && nowzjhm != null) {
					HttpUtils httpUtils = new HttpUtils();
					RequestParams params = new RequestParams();
					nameValuePairs1
							.add(new BasicNameValuePair("name", nowname));
					nameValuePairs1
							.add(new BasicNameValuePair("idnum", nowzjhm));

					params.setHeader("Cookie",
							"JSESSIONID=" + MyApplication.mySession());
					params.addBodyParameter(nameValuePairs1);
					httpUtils.send(HttpMethod.POST, Constants.SFZYZURL, params,
							new RequestCallBack<String>() {

								@Override
								public void onFailure(HttpException arg0,
										String arg1) {
									System.out.println("----------------网络请求失败"
											+ arg1);

								}

								@Override
								public void onSuccess(ResponseInfo<String> arg0) {

									System.out.println("----------------网络请求成功"
											+ arg0.result);
								}
							});
				}
			}

		};
	};

	private String nowzjhm = null;
	private String nowname = null;
	// 申请人姓名
	@Bind(R.id.xczf_sqrxm_edittext)
	EditText sqrxm_et;
	// 手机号码
	@Bind(R.id.xczf_sjhm_edittext)
	EditText sjhm_et;
	// 证件类型
	@Bind(R.id.xczf_zjlx_spinner_text)
	TextView zjlx_tv_spinner;
	@Bind(R.id.rl_zjlx)
	RelativeLayout zjlx_btn;
	// 证件号码
	@Bind(R.id.xczf_zjhm_edittext)
	EditText zjhm_et;

	// 裸车价格
	@Bind(R.id.xczf_lcjg_edittext)
	EditText lcjg_et;
	// 购车品牌
	@Bind(R.id.xczf_gcpp_edittext)
	TextView gcpp_et;
	@Bind(R.id.rl_buyCarModel)
	RelativeLayout rl_gcpp;
	// 进口车标志
	@Bind(R.id.xczf_jkcbz_spinner_text)
	TextView jkcbz_tv_spinner;
	@Bind(R.id.rl_jkcbz)
	RelativeLayout jkcbz_btn;

	// 车型
	@Bind(R.id.xczf_cx_spinner_text)
	EditText cx_tv_spinner;
	private RelativeLayout cx_btn;

	// 排气量
	@Bind(R.id.xczf_pql_spinner_text)
	TextView pql_tv_spinner;
	@Bind(R.id.rl_pql)
	RelativeLayout pql_btn;

	// 申请人配偶征信状况
	@Bind(R.id.sqrpozxzk_spinner_text)
	TextView sqrpozxzk_tv;
	@Bind(R.id.rl_sqrpozx)
	RelativeLayout sqrpozxzk_btn;
	// 申请人征信状况
	@Bind(R.id.sqrzxzk_spinner_text)
	TextView sqrzxzk_et;
	@Bind(R.id.rl_sqrzx)
	RelativeLayout rl_sqrzx;
	// 申请人学历
	@Bind(R.id.sqrxl_spinner_text)
	TextView sqrxl_tv;
	@Bind(R.id.rl_sqrxl)
	RelativeLayout sqrxl_btn;

	// 申请人家庭收入还款比
	@Bind(R.id.sqrjtsrhdb_edittext)
	TextView sqrjtsrhkb_et;

	// 成数
	@Bind(R.id.cs_edittext)
	TextView cs_et;
	// 信用卡总额度
	@Bind(R.id.xinyongkaZED_edittext)
	TextView xykzed;
	// 分期付款期数
	@Bind(R.id.fqfkqs_edittext)
	TextView fqfkqs_et;
	@Bind(R.id.rl_fqfkqs)
	RelativeLayout fqfkqs_rl;
	// 首月还款金额
	@Bind(R.id.syhkje_edittext)
	TextView syhkje_et;
	// 月还款金额
	@Bind(R.id.yhkje_edittext)
	TextView yhkje_et;
	// 分期付款手续费率
	@Bind(R.id.fqfksxfl_edittext)
	TextView fqfksxfl_et;
	// 手续费金额
	@Bind(R.id.sxfje_textview)
	TextView sxfje_text;
	// 提交按钮
	@Bind(R.id.xczf_btn_tijiao)
	Button btn_tijiao;

	private List<CustemObject> spinnerList = new ArrayList<CustemObject>();
	private AbstractSpinerAdapter<CustemObject> spinnerAdapter;
	private SpinerPopWindow spinnerPopWindow;
	private TextView selectedSpinnerText;
	private ArrayList<NameValuePair> nameValuePairs;
	private ArrayList<NameValuePair> nameValuePairs1;
	// 标题
	@Bind(R.id.tv_title_text)
	TextView tv_titleText;

	private ResearchOderEntity entity;
	@Bind(R.id.fenqiJE_edittext)
	EditText fqJE_et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_research_oder);
		// MyApplication.getInstance().addActivity(this);
		AppManager.getAppManager().addActivity(this);
		ButterKnife.bind(this);
		initView();
		setOnClick();

	}

	/**
	 * 给按钮添加点击事件
	 * 
	 */
	private void setOnClick() {

		// 证件类型

		// 进口车标志

		// 车型
		// cx_btn.setOnClickListener(this);
		// 排气量

		sqrxm_et.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				if (arg1) {

					// nowname =null;
					System.out.println("---------------------------我获取里焦点了");
				} else {
					System.out.println("---------------------------我失去了焦点");
					nowname = sqrxm_et.getText().toString().trim();
					System.out.println("--------------nowname--------"
							+ nowname);
					if (nowname != null) {
						System.out.println("---------------输入数据");
						handler.sendEmptyMessage(1);

					} else {
						System.out.println("---------------没有输入数据");

					}

				}
			}
		});

		zjhm_et.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

				// nowzjhm =null;

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				nowzjhm = zjhm_et.getText().toString().trim();
				System.out.println("==========nowzjhm=================="
						+ nowzjhm.length());
				if (nowzjhm.length() == 18) {
					System.out.println("============================输入完成");
					handler.sendEmptyMessage(0);
				}

			}
		});

	}

	/**
	 * 初始化数据
	 */
	private void initView() {

		nameValuePairs1 = new ArrayList<NameValuePair>();
		entity = new ResearchOderEntity();
		// 初始化实体对象
		spinnerAdapter = new CustemSpinerAdapter(this);
		spinnerPopWindow = new SpinerPopWindow(this);
		spinnerPopWindow.setItemListener(this);

		zjlx_tv_spinner.setText("身份证");

		// 裸车价格

		lcjg_et.setFilters(new InputFilter[] { new EditInputFilter() });
		// lcjg_et.addTextChangedListener(new EditChangedListener(lcjg_et));
		lcjg_et.setOnFocusChangeListener(new MyFocusChangeListener(lcjg_et));

		// 设置标题文字

		tv_titleText.setText("贷前管理系统》调查预约");// 改变标题文字-->个人设置

		// 首月还款金额

		syhkje_et.setFilters(new InputFilter[] { new EditInputFilter() });
		syhkje_et
				.setOnFocusChangeListener(new MyFocusChangeListener(syhkje_et));
		// 月还款金额

		yhkje_et.setFilters(new InputFilter[] { new EditInputFilter() });

		yhkje_et.setOnFocusChangeListener(new MyFocusChangeListener(yhkje_et));

		fqJE_et.addTextChangedListener(new MyTextWachert(fqJE_et, xykzed,
				lcjg_et, fqfkqs_et, syhkje_et, yhkje_et, cs_et, fqfksxfl_et,
				sqrjtsrhkb_et, sxfje_text

		));
		fqfkqs_et.addTextChangedListener(new MyTextWachert(fqJE_et, xykzed,
				lcjg_et, fqfkqs_et, syhkje_et, yhkje_et, cs_et, fqfksxfl_et,
				sqrjtsrhkb_et, sxfje_text));
	}

	/**
	 * 获取数据
	 */
	private void getDate() {

		// 申请人姓名
		String sqrxm = sqrxm_et.getText().toString().trim();
		if (sqrxm.equals("")) {
			Toast.makeText(this, "姓名不能为空", 0).show();
			return;
		}

		entity.setSqrxm(sqrxm);

		// 证件类型
		String zjlx = zjlx_tv_spinner.getText().toString().trim();

		// （1：身份证2：护照3：军人证4：残疾证）
		if (zjlx.equals("身份证")) {
			zjlx = "1";
		} else if (zjlx.equals("护照")) {
			zjlx = "2";
		} else if (zjlx.equals("军人证")) {
			zjlx = "3";
		} else if (zjlx.equals("残疾证")) {
			zjlx = "4";
		}

		entity.setZjlx(zjlx);
		// 证件号码
		String zjhm = zjhm_et.getText().toString().trim();
		if (zjhm.equals("")) {
			Toast.makeText(this, "证件号码不能为空", 0).show();

			return;
		}
		entity.setZjhm(zjhm);
		// 手机号码
		String sjhm = sjhm_et.getText().toString().trim();

		if (sjhm.equals("")) {
			Toast.makeText(this, "手机号码不能为空", 0).show();

			return;
		}
		entity.setSjhm(sjhm);
		// 购车品牌
		String gcpp = gcpp_et.getText().toString().trim();
		entity.setGcpp(gcpp);

		// 裸车价格
		String lcjg = lcjg_et.getText().toString().trim();
		entity.setLcjg(lcjg);

		// 进口车标志
		String jkcbz = jkcbz_tv_spinner.getText().toString().trim();
		entity.setJkcbz(jkcbz);
		// 车型
		String cx = cx_tv_spinner.getText().toString().trim();
		entity.setCx(cx);
		// 排气量
		String pql = pql_tv_spinner.getText().toString().trim();
		entity.setPql(pql);

		// 申请人配偶征信状况
		String sqrpozxzk = sqrpozxzk_tv.getText().toString().trim();
		// 申请人征信状况
		String sqrzxzk = sqrzxzk_et.getText().toString().trim();
		// 申请人学历
		String sqrxl = sqrxl_tv.getText().toString().trim();
		// 申请人家庭收入还款比
		String sqrjtsrhkb = sqrjtsrhkb_et.getText().toString().trim();
		// 成数
		String cs = cs_et.getText().toString().trim();
		// 分期付款
		String fqfkqs = fqfkqs_et.getText().toString().trim();
		// 首月还款金额
		String syhkje = syhkje_et.getText().toString().trim();
		// 月还款金额
		String yhkje = yhkje_et.getText().toString().trim();
		// 分期付款手续费率
		String fqfksxfl = fqfksxfl_et.getText().toString().trim();

		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("equip", "4"));
		// 申请人姓名
		nameValuePairs.add(new BasicNameValuePair("name", sqrxm));
		// 申请人证件类型
		nameValuePairs.add(new BasicNameValuePair("personcerttype", zjlx));
		// 申请人证件号码
		nameValuePairs.add(new BasicNameValuePair("certnum", zjhm));
		// 手机号码
		nameValuePairs.add(new BasicNameValuePair("personmobile", sjhm));
		System.out.println("-------------------" + sjhm);
		// 裸车价格
		nameValuePairs.add(new BasicNameValuePair("onlycar", lcjg));
		// 购车品牌
		nameValuePairs.add(new BasicNameValuePair("pp", gcpp));
		// 进口车标志
		nameValuePairs.add(new BasicNameValuePair("isjk", jkcbz));
		// 车型
		nameValuePairs.add(new BasicNameValuePair("cartype", cx));

		// 排气量
		nameValuePairs.add(new BasicNameValuePair("pql", pql));

		postADDKH();
	}

	/**
	 * 添加客户信息
	 */
	public void postADDKH() {

		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.addBodyParameter(nameValuePairs);
		params.setHeader("Cookie", "JSESSIONID=" + MyApplication.mySession());
		httpUtils.send(HttpMethod.POST, Constants.DQYWADD, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						Toast.makeText(ResearchOderActivity.this,
								"网络访问失败" + arg1, Toast.LENGTH_SHORT).show();
					
						
					}

					@Override
					public void onSuccess(ResponseInfo<String> arg0) {
						// 创建退出对话框
						AlertDialog isExit = new AlertDialog.Builder(
								ResearchOderActivity.this).create();
						// 设置对话框标题
						isExit.setTitle("温馨提示");
						// 设置对话框消息
						isExit.setMessage("用户保存成功，请到入户管理查看。");
						// 添加选择按钮并注册监听
						isExit.setButton("确定", listener);
						isExit.setButton2("取消", listener);
						// 显示对话框
						isExit.show();

					}
				});
	}

	/** 监听对话框里面的button点击事件 */
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:// "确认"按钮
				finish();
				break;
			case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
				clearData();
				break;
			default:
				break;
			}
		}
	};

	@Override
	public void onItemClick(int pos) {

		setSpinnerText(pos);
	}

	private void setSpinnerText(int pos) {
		if (pos >= 0 && pos <= spinnerList.size()) {
			CustemObject value = spinnerList.get(pos);
			selectedSpinnerText.setText(value.toString());
		}
	}

	/**
	 * @param list
	 *            显示列表
	 */
	public void showSpinWindow(String[] list) {
		spinnerList.clear();
		for (int i = 0; i < list.length; i++) {
			CustemObject custemObject = new CustemObject();
			custemObject.data = list[i];
			spinnerList.add(custemObject);
		}

		spinnerAdapter.refreshData(spinnerList, 0);
		spinnerPopWindow.setAdatper(spinnerAdapter);
		spinnerPopWindow.setWidth(selectedSpinnerText.getWidth());
		spinnerPopWindow.showAsDropDown(selectedSpinnerText);
	}

	@OnClick({ R.id.rl_zjlx, R.id.rl_jkcbz, R.id.rl_fqfkqs, R.id.rl_pql,
			R.id.xczf_btn_tijiao, R.id.rl_sqrxl, R.id.sqrpozxzk_btn,
			R.id.rl_sqrpozx, R.id.rl_sqrzx, R.id.rl_buyCarModel })
	public void onClick(View v) {

		// 证件类型
		switch (v.getId()) {

		case R.id.rl_zjlx:
			selectedSpinnerText = zjlx_tv_spinner;

			String zjlx_list[] = getResources().getStringArray(
					R.array.zjlx_list);

			showSpinWindow(zjlx_list);
			break;

		// 进口车标志

		case R.id.rl_jkcbz:
			hintKbTwo();
			selectedSpinnerText = jkcbz_tv_spinner;
			String jkcbz_list[] = getResources().getStringArray(
					R.array.jkcbz_list);
			showSpinWindow(jkcbz_list);
			break;

		// 分期还款期数
		case R.id.rl_fqfkqs:
			hintKbTwo();
			selectedSpinnerText = fqfkqs_et;
			String[] fqhkqs_list = getResources().getStringArray(
					R.array.fqhkqs_list);
			showSpinWindow(fqhkqs_list);
			break;

		// 排气量

		case R.id.rl_pql:
			hintKbTwo();
			selectedSpinnerText = pql_tv_spinner;
			String pql_list[] = getResources().getStringArray(R.array.pql_list);
			showSpinWindow(pql_list);
			break;

		case R.id.xczf_btn_tijiao:
			getDate();
			// clearData();
			break;

		case R.id.rl_sqrxl:

			selectedSpinnerText = sqrxl_tv;
			String sqrxl_list[] = getResources().getStringArray(
					R.array.sqrxl_list);
			showSpinWindow(sqrxl_list);
			break;

		case R.id.sqrpozxzk_btn:

			selectedSpinnerText = sqrpozxzk_tv;
			String sqrpozxzk_list[] = getResources().getStringArray(
					R.array.sqrxl_list);
			// showSpinWindow(sqrpozxzk_list);
			break;
		// 申请人配偶的征信情况
		case R.id.rl_sqrpozx:
			hintKbTwo();
			selectedSpinnerText = sqrpozxzk_tv;
			String[] sqrpozxzklist = getResources().getStringArray(
					R.array.sqrzxzk_list);
			showSpinWindow(sqrpozxzklist);
			break;
		// 申请人征信
		case R.id.rl_sqrzx:
			hintKbTwo();
			selectedSpinnerText = sqrzxzk_et;
			String[] sqrzxzklist = getResources().getStringArray(
					R.array.sqrzxzk_list);
			showSpinWindow(sqrzxzklist);
			break;
		// rl_gcpp 购车品牌
		case R.id.rl_buyCarModel:
			hintKbTwo();
			selectedSpinnerText = gcpp_et;
			String[] cx_list = getResources().getStringArray(R.array.cx_list);
			showSpinWindow(cx_list);
			break;
		default:
			break;
		}

	}

	/**
	 * 清空控件上显示的数据
	 */
	private void clearData() {

		sqrxm_et.setText("");// 申请人姓名
		sjhm_et.setText("");// 手机号码
		zjlx_tv_spinner.setText("");// 证件类型
		zjhm_et.setText("");// 证件号码
		lcjg_et.setText("");// 裸车价格
		gcpp_et.setText("");// 购车品牌
		jkcbz_tv_spinner.setText("");// 进口车标志、
		cx_tv_spinner.setText("");// 车型
		pql_tv_spinner.setText("");// 排气量

	}

	// 此方法只是关闭软键盘
	private void hintKbTwo() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive() && getCurrentFocus() != null) {
			if (getCurrentFocus().getWindowToken() != null) {
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
	}

	private void showDailog() {

		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("调查问卷");
		dialog.setMessage("验证信息错错误，请重新输入");
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dailog, int arg1) {

				dailog.dismiss();
			}
		});
		dialog.create().show();

	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (isShouldHideInput(v, ev)) {
				hideSoftInput(v.getWindowToken());
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 18 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏 19 * 20 * @param
	 * v 21 * @param event 22 * @return 23
	 */
	private boolean isShouldHideInput(View v, MotionEvent event) {
		if (v != null && (v instanceof EditText)) {
			int[] l = { 0, 0 };
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (event.getX() > left && event.getX() < right
					&& event.getY() > top && event.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}

	/**
	 * 多种隐藏软件盘方法的其中一种
	 * 
	 * @param token
	 */
	private void hideSoftInput(IBinder token) {
		if (token != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(token,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	class EditChangedListener implements TextWatcher {

		private boolean isChanged = false;
		private EditText edit;

		public EditChangedListener() {
			super();
		}

		public EditChangedListener(EditText edit) {
			super();
			this.edit = edit;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}
	
	
	
	
}
