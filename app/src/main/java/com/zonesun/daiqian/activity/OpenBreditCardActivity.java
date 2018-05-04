package com.zonesun.daiqian.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.fragment.OpenCreCard1Fragment;
import com.zonesun.daiqian.fragment.OpenCreCard2Fragment;
import com.zonesun.daiqian.fragment.OpenCreCard3Fragment;
import com.zonesun.daiqian.fragment.OpenCreCard4Fragment;

public class OpenBreditCardActivity extends FragmentActivity {

	private TextView tv_titleText;
	private LinearLayout ll_obc;
	private OpenCreCard1Fragment fragment1;
	private OpenCreCard2Fragment fragment2;
	private OpenCreCard3Fragment fragment3;
	private OpenCreCard4Fragment fragment4;
	private FragmentManager fm;
	private FragmentTransaction ft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_open_bredit_card);

		init();
	}

	/**
	 * 初始化所有控件对象
	 */
	private void init() {
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		// 设置标题文字
		tv_titleText = (TextView) findViewById(R.id.tv_title_text);
		tv_titleText.setText("贷前管理系统》开卡申请");// 改变标题文字-->个人设置
		ll_obc = (LinearLayout) findViewById(R.id.ll_obc);
		if(GLobleData.DeviceBrand.equals(android.os.Build.BRAND)&&GLobleData.Devicemodel.equals(android.os.Build.MODEL)){
			ft.replace(R.id.ll_obc,new OpenCreCard1Fragment());
			ft.commit();
		} else {

		}


	}

}
