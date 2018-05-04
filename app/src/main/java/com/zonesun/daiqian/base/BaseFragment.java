package com.zonesun.daiqian.base;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/**
 * 所有Fragment基类,指定布局,代替边侧栏布局,管理其中逻辑
 * 
 * @author 张京
 * 
 */
public abstract class BaseFragment extends Fragment {
	public Activity mActivity;
	InputMethodManager manager;

	// fragment创建时调用,此时用来拿到当前actvity对象
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mActivity = getActivity();

	}

	// 此方法中处理Fragment布局
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return initView();// 返回一个Fragment布局
	}

	// 在此方法中初始化页面数据
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initData();
	}

	// 此方法用于返回View对象,处理Fragment布局
	public abstract View initView();

	// 初始化数据方法,不是强制实现
	public void initData() {

	}

}
