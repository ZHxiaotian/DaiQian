package com.zonesun.daiqian.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.fragment.NewInquireFragment;
import com.zonesun.daiqian.fragment.ZhgXinReshProFragment;

import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZhengXinresearchActivity extends FragmentActivity {
	// 标题
	@Bind(R.id.tv_title_text)
	public TextView tv_title;
	// 导航切换
	@Bind(R.id.rg_act_zhgxinresh)
	public RadioGroup rg_gup;
	// 内容显示
	@Bind(R.id.rl_act_zhgxinresh)
	public LinearLayout ll_nervous;
	// 子菜单的对象
	@Bind(R.id.rb_act_zhexin_resprogrs)
	public RadioButton rg_zhenxin_searh;
	@Bind(R.id.rb_act_zhexin_newaddresh)
	public RadioButton rg_newadd_searh;
	// 定义操作fragment的事务
	private FragmentManager fm;
	private FragmentTransaction ft;
	public ZhgXinReshProFragment InQuirePfragment;
	public NewInquireFragment naddquirefragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_zheng_xinresearch);

		ButterKnife.bind(ZhengXinresearchActivity.this);
		initView();
	}

	/*
	 * 初始化方法初始化所有空间对象
	 */
	private void initView() {
		// rg_zhenxin_searh = (RadioButton) findViewById();
		// rg_newadd_searh = (RadioButton) findViewById();

		// 设置当前标图显示内容
		tv_title.setText("贷前管理系统》征信查询");
		rg_gup.setOnCheckedChangeListener(listener);
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		InQuirePfragment = new ZhgXinReshProFragment();
		ft.replace(R.id.rl_act_zhgxinresh, InQuirePfragment);
		ft.commit();
		rg_zhenxin_searh.setBackgroundColor(getResources().getColor(R.color.blue));
	}

	/*
	 * 切换当前显示的Fragment
	 */
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			// 开启事务
			ft = fm.beginTransaction();

			switch (checkedId) {
			case R.id.rb_act_zhexin_resprogrs:
				rg_zhenxin_searh.setBackgroundColor(getResources().getColor(R.color.blue));
				rg_newadd_searh.setBackgroundColor(Color.WHITE);
				if (InQuirePfragment != null) {
					ft.replace(R.id.rl_act_zhgxinresh, InQuirePfragment);
				} else {
					InQuirePfragment = new ZhgXinReshProFragment();
					ft.replace(R.id.rl_act_zhgxinresh, InQuirePfragment);
				}

				break;
			case R.id.rb_act_zhexin_newaddresh:
				rg_zhenxin_searh.setBackgroundColor(Color.WHITE);
				rg_newadd_searh.setBackgroundColor(getResources().getColor(R.color.blue));
				if (naddquirefragment != null) {
					ft.replace(R.id.rl_act_zhgxinresh, naddquirefragment);
				} else {
					naddquirefragment = new NewInquireFragment();
					ft.replace(R.id.rl_act_zhgxinresh, naddquirefragment);
				}

				break;

			default:
				break;
			}
			ft.commit();
		}
	};


	/**
	 * 生命周期方法里边做一个获取推送自定义消息的操作；
	 * 
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Bundle bun = getIntent().getExtras();
		if (bun != null) {
			Set<String> keySet = bun.keySet();
			for (String key : keySet) {
				String value = bun.getString(key);
				System.out.println(value);
			}
		}
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
	}

	// 判断当前界面是否需要隐藏软键盘
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
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
	 * 
	 * @param v
	 * @param event
	 * @return
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

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}
}
