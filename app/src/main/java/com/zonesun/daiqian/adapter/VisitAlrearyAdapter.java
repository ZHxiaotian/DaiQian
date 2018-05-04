package com.zonesun.daiqian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;

public class VisitAlrearyAdapter extends BaseAdapter {

	private RuHuSurveyEntity entity;
	private Context context;

	// private RuHuSurveyEntity.VisitalrearyEntity visitalrearyEntity;

	public VisitAlrearyAdapter(RuHuSurveyEntity entity, Context context) {
		super();
		this.entity = entity;
		this.context = context;

	}

	private ViewHodler hodler;

	@Override
	public int getCount() {
		return entity.getVisitalready().size();

	}

	@Override
	public Object getItem(int position) {
		return entity.getVisitalready().get(position);

	}

	@Override
	public long getItemId(int position) {
	//	System.out.println("-------position--------------" + position);
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

	//	System.out.println("-------getView--------------");

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

		// 显示商户的姓名

		hodler.tv_item.setText(entity.getVisitalready().get(position).getName());

		return convertView;
	}

	class ViewHodler {

		TextView tv_item;
	}

}
