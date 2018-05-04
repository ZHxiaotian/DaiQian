package com.zonesun.daiqian.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.util.Constants;

/**
 * 报表查询
 * 
 * @author yll
 * 
 */
public class ReportQueryActivity extends Activity {

	private TextView tv_title;
	//
	private WebView webView;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_report_query);
		// MyApplication.getInstance().addActivity(this);
		initView();

	}

	/**
	 * 初始化控件
	 */
	@SuppressLint("SetJavaScriptEnabled")
	private void initView() {

		tv_title = (TextView) this.findViewById(R.id.tv_title_text);
		tv_title.setText("贷前管理系统》报表查询");
		webView = (WebView) this.findViewById(R.id.my_webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webView.setWebViewClient(new MyWebViewClient());
		// WebViewClient中的shouldOverrideUrlLoading直接return false
		webView.getSettings().setBuiltInZoomControls(false);// 不支持缩放，true支持缩放。
		webView.setWebChromeClient(new WebChromeClient());// webview载体,此方法是影响到webview显示ui异常时候调用

		webView.loadUrl("http://" + Constants.IP + "/DQZF/charts/ywlMonthtj.do");
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

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}

}
