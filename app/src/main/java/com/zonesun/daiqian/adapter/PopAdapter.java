package com.zonesun.daiqian.adapter;

import java.util.List;

import com.lidroid.xutils.BitmapUtils;
import com.zonesun.daiqian.activity.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class PopAdapter extends BaseAdapter {

	private Context context;
	private List<String> list;

	public PopAdapter(Context context, List<String> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.photo_pop_item, null);
			holder.iv = (ImageView) convertView
					.findViewById(R.id.photo_pop_item_iv);

			convertView.setTag(holder);
		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		BitmapUtils utils = new BitmapUtils(context);
		utils.display(holder.iv, list.get(position));

		return convertView;
	}

	class ViewHolder {

		private ImageView iv;
	}

}
