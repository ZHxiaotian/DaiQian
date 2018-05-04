package com.zonesun.daiqian.activity;

import android.app.Activity;
import android.os.Bundle;

import com.living.activity.hxcr.util.Util;
import com.zonesun.daiqian.base.AppManager;

public class RLSBActivity extends Activity {
	private String name;

	private String zjhm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_rlsb);
		// MyApplication.getInstance().addActivity(this);
		name = getIntent().getStringExtra("name");
		zjhm = getIntent().getStringExtra("zjhm");
		Util.getCamera(RLSBActivity.this, name, zjhm);
		finish();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		AppManager.getAppManager().finishActivity(this);
	}
}
