package com.zonesun.daiqian.view;

import com.zonesun.daiqian.activity.ZhengXinresearchActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;



public class CHScrollViewPd extends HorizontalScrollView {
	
	ZhengXinresearchActivity activity;
	
	public CHScrollViewPd(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		activity = (ZhengXinresearchActivity) context;
	}

	
	public CHScrollViewPd(Context context, AttributeSet attrs) {
		super(context, attrs);
		activity = (ZhengXinresearchActivity) context;
	}

	public CHScrollViewPd(Context context) {
		super(context);
		activity = (ZhengXinresearchActivity) context;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		//ZhengXinresearchActivity.mTouchView = this;
		return super.onTouchEvent(ev);
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//		if(activity.mTouchView == this) {
//			activity.onScrollChanged(l, t, oldl, oldt);
//		}else{
//			super.onScrollChanged(l, t, oldl, oldt);
//		}
	}
}

