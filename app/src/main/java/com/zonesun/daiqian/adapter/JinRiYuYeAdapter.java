package com.zonesun.daiqian.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.entity.MyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisityetEntity;

public class JinRiYuYeAdapter extends BaseAdapter {

	private List<RuHuSurveyEntity.VisitalrearyEntity> list;
	private Context context;
	private ViewHodler hodler;


	public JinRiYuYeAdapter(List<RuHuSurveyEntity.VisitalrearyEntity> list, Context context) {
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

		if (list.get(position).getName().equals("")) {
			
			hodler.tv_item.setText("未知用户");

		}else{
			
			hodler.tv_item.setText(list.get(position).getName());
		}

		return convertView;
	}

	class ViewHodler {

		TextView tv_item;
	}

}
