package com.zonesun.daiqian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;

public class VisitYetAdapter extends BaseAdapter {

	private RuHuSurveyEntity entity;
	private Context context;

	public VisitYetAdapter(RuHuSurveyEntity entity, Context context) {
		super();
		this.entity = entity;
		this.context = context;

	}

	private ViewHodler hodler;

	@Override
	public int getCount() {
		return entity.getVisityet().size();
	}

	@Override
	public Object getItem(int position) {
		return entity.getVisityet().get(position);
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
		
		
		if (entity.getVisityet().get(position).getName().equals("")) {
			//hodler.tv_item.setText("未知用户");

		}else {
			// 显示商户的姓名
			hodler.tv_item.setText(entity.getVisityet().get(position).getName());

		}

	
		return convertView;
	}

	class ViewHodler {

		TextView tv_item;
	}

}
