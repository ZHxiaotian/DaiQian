package com.zonesun.daiqian.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.fragment.ShowImageFragment;

public class ShowImagesActivity extends FragmentActivity {

	private ViewPager viewPager;
	private List<Fragment> fragments;
	private String url;
	private String[] splits;
	private String result;
    private int size;
    private ShowImageFragment fragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_show_images);
		// MyApplication.getInstance().addActivity(this);
		ArrayList<String> listExtra = getIntent().getStringArrayListExtra(
				"list");
		url = getIntent().getStringExtra("url");
		 size=getIntent().getIntExtra("size",0);
		viewPager = (ViewPager) this.findViewById(R.id.viewpager);
		fragments = new ArrayList<Fragment>();
		System.out.println("listExtra......." + listExtra.size());
		if (listExtra != null && listExtra.size() != 0) {
			for (int i = 0; i < listExtra.size(); i++) {
				
				if(i+1<=size){
				fragment = new ShowImageFragment(listExtra.get(i), null, i + 1,
						listExtra.size(),"新增");
				}else{
					
					fragment = new ShowImageFragment(listExtra.get(i), null, i + 1,
							listExtra.size());
					
					
				}
				fragments.add(fragment);
			}

			viewPager.setAdapter(new MyFrageStatePagerAdapter(
					getSupportFragmentManager()));
		} else {

			if (url.equals("")) {

			} else {

				result = url.replace("[", "").replace("]", "")
						.replace("\"", "");
				if (result.contains(",")) {
					splits = result.split(",");
					System.out.println("splits.....:" + splits.length);
					for (int i = 0; i < splits.length; i++) {
						ShowImageFragment fragment = new ShowImageFragment(
								splits[i], "1", i + 1, splits.length);

						fragments.add(fragment);
						viewPager.setAdapter(new MyFrageStatePagerAdapter(
								getSupportFragmentManager()));
						System.out.println("--------------我是多个");
					}

				} else {
					ShowImageFragment fragment = new ShowImageFragment(result,
							"1", 1, 1);

					fragments.add(fragment);
					viewPager.setAdapter(new MyFrageStatePagerAdapter(
							getSupportFragmentManager()));
					System.out.println("---------------我是一个");
				}
			}
		}

	}

	/**
	 * 定义自己的ViewPager适配器。
	 */
	class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter {

		public MyFrageStatePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);

	}
}
