package com.zonesun.daiqian.fragment;

import com.zonesun.daiqian.activity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @author 调研报告
 */
public class ReportFragment extends Fragment {
	private View view;// 缓存页面

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_report, container, false);
		}
		ViewGroup p = (ViewGroup) view.getParent();
		if (p != null) {
			p.removeAllViews();
		}

		return view;
	}

	public void ShowToast(String str) {
		Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
	}

}
