package com.zonesun.daiqian.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.entity.DsomeThings;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.LoginReturn;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.DoSomeThsDao;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.HttpCookie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.hugeterry.updatefun.UpdateFunGO;
import cn.hugeterry.updatefun.config.UpdateKey;
import de.greenrobot.event.EventBus;
import im.fir.sdk.FIR;

/**
 * 登录
 *
 * @author yll
 *
 */
public class LoginActivity extends Activity implements OnClickListener,
		OnDismissListener {
	InputMethodManager manager;
	String path = Environment.getExternalStorageDirectory() + "/" + "dq";
	private Button btn_login;// 登录按钮
	public EditText et_user, et_password;// 用户 密码
	private TextView tv_vosioncode;

	private String name;// 用户
	private String password;// 密码
	// private List<NameValuePair> nameValuePairs;//
	// 定义了一个list，该list的数据类型是NameValuePair（简单名称值对节点类型），这个代码多处用于Java像url发送Post请求。在发送post请求时用该list来存放参数
	private SharedPreferences sp;// 存储数据对象
	// private SharedPreferences sp1;// 暂时没用到
	private Editor edit;
	private DoSomeThsDao Dodao;
	public static String MYCOOKIES = null;// 获取到的cookies
	private String result;// 获取的网络数据
	private HttpUtils httpUtils;// 网络请求工具类
	private NoHttpRequest noRequest;

	public Dialog dialog;// 定义登陆时选择的对话框

	public PopupWindow mPopup;
	public ListView mListView;
	public boolean mInitPopup;
	public boolean mShowing;

	// private LoginDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		setContentView(R.layout.activity_login);

		EventBus.getDefault().register(this);// EventBus的注册。

		// File file = new File(path);
		// deleteFile(file);//这是每次启动app用来删除图片缓存文件夹的路径咱们在此注释掉此方法用来解决需求问题
		initView();
		setOnClick();
		getSpDate();
		FIR.init(this);
		UpdateKey.API_TOKEN = "5a293641c50f6ce8222a0f25c0246bc3";
		UpdateKey.APP_ID = "57ddec2fca87a835a10000e3";
		// 下载方式:
		UpdateKey.DialogOrNotification = UpdateKey.WITH_DIALOG;// 通过Dialog来进行下载
//		 UpdateKey.DialogOrNotification=UpdateKey.WITH_NOTIFITION;通过通知栏来进行下载(默认)
		UpdateFunGO.init(this);
//		RequestIdCard();

	}

	/**
	 * 测试请求身份证信息
	 */
//	private void RequestIdCard()  {
//
//		String idno="";
//		String name="";
//		try {
//			idno=URLEncoder.encode("130126199112012719","utf-8");
//			name=URLEncoder.encode("田国雷","utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		RequestParams params=new RequestParams(Constants.GETCARDINFO+"?"+"cardNo="+ idno+"&realName"+name+"&appkey="+"c9032bb83640b1625873e5b442dafb7c");
//
//		x.http().get(params, new Callback.CommonCallback<String>() {
//
//			@Override
//			public void onSuccess(String result) {
//				System.out.println(result);
//				ToastUtil.showShort(LoginActivity.this,result);
//			}
//
//			@Override
//			public void onError(Throwable ex, boolean isOnCallback) {
//				ToastUtil.showShort(LoginActivity.this,ex.toString());
//				System.out.println(ex.toString());
//			}
//
//			@Override
//			public void onCancelled(CancelledException cex) {
//
//			}
//
//			@Override
//			public void onFinished() {
//
//			}
//		});
//	}

	@Override
	protected void onResume() {
		super.onResume();
		UpdateFunGO.onResume(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		UpdateFunGO.onStop(this);
	}

	/**
	 * 获取存储数据
	 */
	private void getSpDate() {

		String name = sp.getString("name", null);
		String password = sp.getString("password", null);
		et_user.setText(name);
		et_password.setText(password);

	}

	/**
	 * 给控件添加点击事件
	 */
	private void setOnClick() {
		btn_login.setOnClickListener(this);

	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		Dodao = new DoSomeThsDao(LoginActivity.this);
		btn_login = (Button) findViewById(R.id.btn_login);
		et_user = (EditText) this.findViewById(R.id.et_login_user);
		et_password = (EditText) this.findViewById(R.id.et_login_password);
		tv_vosioncode = (TextView) this.findViewById(R.id.tv_vosioncode);
		tv_vosioncode.setText("当前版本号：" + getVersion());

		sp = this.getSharedPreferences("login", Context.MODE_PRIVATE);
		// sp1 = this.getSharedPreferences("workstatus", Context.MODE_PRIVATE);
		noRequest = new NoHttpRequest(this, sp);

		et_password.setOnKeyListener(onKeyListener);
		// dao = new LoginDao(LoginActivity.this);
	}

	/**
	 * 2 * 获取版本号 3 * @return 当前应用的版本号 4
	 */
	public String getVersion() {
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 让EditText监听键盘输入法的enter健完成自动登陆
	private OnKeyListener onKeyListener = new OnKeyListener() {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_ENTER) {

				getDate();

				return true
						;
			}
			return false;
		}
	};

	private void getDate() {
		name = et_user.getText().toString();
		password = et_password.getText().toString();

		if ("".equals(name)) {
			Toast.makeText(this, "用戶名不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		if ("".equals(password)) {
			Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		edit = sp.edit();
		edit.putString("name", name);
		edit.putString("password", password);
		edit.commit();

		// requestService();//Xutils 登陆
		requestService1();// NoHttp登陆方法

	}

	/**
	 * 请求网络数据
	 */
	private void requestService1() {
		dialog = createLoadingDialog(this, "正在登陆中。。。。。");
		dialog.show();

		handler.postDelayed(runnable, 2000);

		Map<String, String> map = new HashMap<String, String>();
		map.put("equip", "4");
		map.put("username", name);
		map.put("password", password);

		noRequest.Request(map, Constants.LOGINURL, "", NoCode.NOHTTP_WHAT_LOGIN);

	}

	public void onEventMainThread(EventT event) {

		if (event.getNoCode() == NoCode.NOHTTP_WHAT_LOGIN) {

			setSuccess(event);
		}
	}

	/**
	 * 登陆成功的返回结果处理
	 *
	 * @param event
	 */
	private void setSuccess(EventT event) {

		// 获取Cookie
		MYCOOKIES = getCookies(event.getCookies());
		edit.putString("MYCOOKIES", MYCOOKIES);
		edit.commit();
		// 请求网络成功,获取Json字符串
		String json = event.getObj().toString();
		System.out.println(json+"...........................................");
		Gson gson = new Gson();
		GLobleData.logindata = gson.fromJson(json, LoginReturn.class);

		// Toast.makeText(LoginActivity.this, GLobleData.logindata.toString(),
		// 0).show();

		JSONObject jo;
		try {
			jo = new JSONObject(json);
			result = jo.getString("result");
			System.out.println("---------------" + result);
			if (result.equals("1")) {
				/*
				 * 返回 "1"请求成功,用户名密码保存在sp中,跳转主页面activity
				 */

				// if (0 != dao.insertData(new User(name, password))) {
				//
				// System.out.println("添加成功");
				// } else {
				//
				// System.out.println("添加失败");
				// }
				// Editor edit=sp1.edit();
				//
				// edit.putString("operator",GLobleData.logindata.getData().getJobnum()
				// );
				// edit.commit();
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy年MM月dd日    HH:mm:ss     ", Locale.getDefault());
				Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
				String str = formatter.format(curDate);

				long state = Dodao.addMessage(new DsomeThings(
						GLobleData.logindata.getData().getJobnum(), "1", "登陆",
						str, ""));
				if (state != 0) {
					Toast.makeText(getApplication(), "操作数据保存成功",
							Toast.LENGTH_SHORT).show();
				}
				startActivity(new Intent(LoginActivity.this, MainActivity.class));

				finish();
			} else if (result.equals("0")) {

				Toast.makeText(LoginActivity.this, "用户名密码错误",
						Toast.LENGTH_SHORT).show();
			} else if (result.equals("-1")) {
				System.out.println("未登录");
			}
			handler.removeCallbacks(runnable);
			dialog.dismiss();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取cookies字段
	 */
	private String getCookies(List<HttpCookie> cookies) {
		// // 获取cookie
		// DefaultHttpClient dh = (DefaultHttpClient) httpUtils.getHttpClient();
		// CookieStore cs = dh.getCookieStore();
		// List<Cookie> cookies = cs.getCookies();

		String cookie = null;
		for (int i = 0; i < cookies.size(); i++) {
			System.out.println("cookies.size:::" + cookies.size());
			cookie = cookies.get(i).getValue();
		}
		System.out.println("cookieString:::::" + cookie);
		return cookie;
	}

	private String getCookie() {
		// // 获取cookie
		DefaultHttpClient dh = (DefaultHttpClient) httpUtils.getHttpClient();
		CookieStore cs = dh.getCookieStore();
		List<Cookie> cookies = cs.getCookies();

		String cookie = null;
		for (int i = 0; i < cookies.size(); i++) {
			System.out.println("cookies.size:::" + cookies.size());
			cookie = cookies.get(i).getValue();
		}
		System.out.println("cookieString:::::" + cookie);
		return cookie;
	}

	@Override
	public void onClick(View v) {

		int id = v.getId();
		switch (id) {

			case R.id.btn_login:
				getDate();

				break;

		}

	}

	/**
	 * 得到自定义的progressDialog
	 *
	 * @param context
	 * @param msg
	 * @return
	 */
	ImageView spaceshipImage;
	public Dialog createLoadingDialog(Context context, String msg) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_dialog);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);

		tipTextView.setText(msg);// 设置加载信息

		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
		return loadingDialog;

	}

	public void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			System.out.println("文件不存在！" + "\n");
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			if (getCurrentFocus() != null
					&& getCurrentFocus().getWindowToken() != null) {
				manager.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}
		return super.onTouchEvent(event);

	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		EventBus.getDefault().unregister(this);
		AppManager.getAppManager().finishActivity(this);
	}

	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		mShowing = false;
	}

	Handler handler = new Handler();
	int i = 5;

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			i++;
			if (i == 10) {
				handler.removeCallbacks(runnable);
				i = 5;
				Toast.makeText(LoginActivity.this, "请检查您的网络或是与后台服务器相关维护人员联系。。",
						Toast.LENGTH_SHORT).show();
				if(dialog.isShowing()){

					dialog.dismiss();
				}
//				dialog.cancel();
			} else {
				// TODO Auto-generated method stub

				handler.postDelayed(this, 2000);
			}

		}
	};

	private EditText et;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// View view=View.inflate(MainActivity.this, R.layout.backdialog, null);
		//
		// LinearLayout layout=(LinearLayout)
		// view.findViewById(R.id.ll_backdialog);
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog isExit = new AlertDialog.Builder(this).create();
			// 设置对话框标题
			isExit.setTitle("系统提示");
			// 设置对话框消息
			isExit.setMessage("请输入密码退出");
			// 添加选择按钮并注册监听
			et = new EditText(LoginActivity.this);
			et.setInputType(InputType.TYPE_CLASS_TEXT
					| InputType.TYPE_TEXT_VARIATION_PASSWORD);

			// LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,
			// LayoutParams.WRAP_CONTENT);
			// isExit.addContentView(layout, params);
			isExit.setView(et);
			isExit.setButton("是", listener);
			isExit.setButton2("否", listener);
			// 显示对话框
			isExit.show();

		}

		return super.onKeyDown(keyCode, event);
	};

	/** 监听对话框里面的button点击事件 */
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
				case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
					// finish();
					// AppManager.getAppManager().AppExit(MainActivity.this);
					// MyApplication.getInstance().exit();
					if (et.getText().toString().equals("112233")) {

						AppManager.getAppManager().AppExit(LoginActivity.this);
					} else {

						Toast.makeText(LoginActivity.this, "请输入正确密码",
								Toast.LENGTH_SHORT).show();
					}
					break;
				case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
					break;
				default:
					break;
			}
		}
	};

}
