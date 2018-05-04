package com.zonesun.daiqian.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.base.BaseActivity;
import com.zonesun.daiqian.fragment.SlideMenu2Fragment;
import com.zonesun.daiqian.util.MyEvent;

import de.greenrobot.event.EventBus;

public class UploadSussessActivity extends BaseActivity implements
		OnClickListener {

	private FragmentTransaction transaction;
	private FragmentManager manager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_upload_sussess);
		// MyApplication.getInstance().addActivity(this);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub

		findViewById(R.id.frag_cancel).setOnClickListener(this);
		findViewById(R.id.frag_go).setOnClickListener(this);

	}

	private SlideMenu2Fragment sussessFragment = new SlideMenu2Fragment();

	@Override
	public void allocationFragment() {

		super.createFragment(sussessFragment);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		// 查看详情
		case R.id.frag_cancel:
			Intent intent = new Intent(UploadSussessActivity.this,
					ResearchReportActivity.class);
			intent.putExtra("flag", "2");
			startActivity(intent);
			finish();
			break;
		// 继续添加
		case R.id.frag_go:
			EventBus.getDefault().post(new MyEvent(true));
			Intent intent2 = new Intent(this, RuhuSurveyActivity.class);
			startActivity(intent2);
			finish();
			break;
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}

}
