package com.zonesun.daiqian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;

import java.util.List;

public class WeiFsAdapter extends BaseAdapter {

	private List<String> list;
	private Context context;
	private ViewHodler hodler;


	public WeiFsAdapter(List<String> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {

		return list.size();

	}

	@Override
	public Object getItem(int position) {

		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {

			// 转化布局对象
			convertView = View.inflate(context, R.layout.item_listview, null);
			hodler = new ViewHodler();
			// 获取控件对象
			hodler.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
			convertView.setTag(hodler);

		} else {
			hodler = (ViewHodler) convertView.getTag();

		}
		hodler.tv_item.setText(list.get(position));
		
		return convertView;
	}

	class ViewHodler {

		TextView tv_item;
	}

}
