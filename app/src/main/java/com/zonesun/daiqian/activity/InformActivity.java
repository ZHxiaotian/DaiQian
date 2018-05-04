package com.zonesun.daiqian.activity;

import android.annotation.SuppressLint;

import android.os.Bundle;

import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.TextView;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.BaseActivity;

import com.zonesun.daiqian.fragment.InformFragment;

/**
 * 公告通知
 * 
 * @author Administrator
 * 
 */
@SuppressLint("SetJavaScriptEnabled")
public class InformActivity extends BaseActivity {
	private TextView titleText;
	private WebView webView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_inform);
		// 添加方便退出管理
		// MyApplication.getInstance().addActivity(this);
		// 设置文字
		titleText = (TextView) findViewById(R.id.tv_title_text);
		titleText.setText("贷前管理系统》公告通知");
		webView = (WebView) this.findViewById(R.id.webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webView.setWebViewClient(new MyWebViewClient());
		// WebViewClient中的shouldOverrideUrlLoading直接return false
		webView.getSettings().setBuiltInZoomControls(false);// 不支持缩放，true支持缩放。
		webView.setWebChromeClient(new WebChromeClient());// webview载体,此方法是影响到webview显示ui异常时候调用
		webView.loadUrl("http://123.56.180.246:9999/WeiXinAll/wgw/message.html");

	}

	// 给左侧设置fragment
	@Override
	public void allocationFragment() {
		super.createFragment(new InformFragment());
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
