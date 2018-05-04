package com.zonesun.daiqian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.BaseActivity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.fragment.ResearchReportFragment;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.MyEvent;

import de.greenrobot.event.EventBus;

/**
 * 调研报告
 * 
 * @author yll
 * 
 */
public class ResearchReportActivity extends BaseActivity {

	private TextView tv_titleText;

	private WebView webView;

	private String flag;

	@SuppressWarnings("unused")
	private RuHuSurveyEntity.VisitalrearyEntity visitalrearyEntity;

	private String url;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		 AppManager.getAppManager().addActivity(this);  
		setContentView(R.layout.activity_research_report);
//		MyApplication.getInstance().addActivity(this);
		EventBus.getDefault().register(this);
		flag = getIntent().getStringExtra("flag");
		System.out.println("-----------------"+flag);
		initView();

	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResumeFragments() {

		super.onResumeFragments();
	}

	/**
	 * 初始化数据
	 */
	private void initView() {

		// 设置标题文字
		 tv_titleText = (TextView) findViewById(R.id.tv_title_text);
		  tv_titleText.setText("贷前管理系统》调研报告");// 改变标题文字-->个人设置
		 
		webView = (WebView) this.findViewById(R.id.dybg_webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webView.setWebViewClient(new MyWebViewClient());
		// WebViewClient中的shouldOverrideUrlLoading直接return false
		webView.getSettings().setBuiltInZoomControls(false);// 不支持缩放，true支持缩放。
		webView.setWebChromeClient(new WebChromeClient());// webview载体,此方法是影响到webview显示ui异常时候调用

	}

	@Override
	public void allocationFragment() {
		super.createFragment(new ResearchReportFragment());
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		EventBus.getDefault().unregister(this);
		 AppManager.getAppManager().finishActivity(this);  
	}

	/**
	 * eventbus运行在主线程
	 * 
	 * @param event
	 */
	public void onEventMainThread(MyEvent event) {

		// 已走访的数据
		VisitalrearyEntity visitalrearyEntity = event.getVisitalreadyEntity();
		if (visitalrearyEntity != null) {
			System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{"
					+ visitalrearyEntity);
			url = Constants.DYBG + visitalrearyEntity.getApplybc_id();
			System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{" + url);
			webView.loadUrl(url);

		}

	}

	class MyWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView webView, String url) {
			webView.loadUrl(url);
			return true;
		}
	}

	@Override
	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
			return;
		}
		super.onBackPressed();
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			if (flag.equals("1")) {
				finish();

				System.out.println("-----------------1");
			} else if (flag.equals("2")) {
				System.out.println("-----------------2");
				Intent intent = new Intent(this, RuhuSurveyActivity.class);
				startActivity(intent);
				finish();
			}
			

			
			

		}

		return false;

	}

}
