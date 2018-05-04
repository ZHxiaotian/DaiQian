package com.zonesun.daiqian.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.activity.ShowImagesActivity;
import com.zonesun.daiqian.entity.Rows;
import com.zonesun.daiqian.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ZhenxinReshAdapter extends BaseAdapter {

	private Context context;
	private List<Rows> list;
	private Intent intent;

	public ZhenxinReshAdapter(Context context, List<Rows> list) {
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

	// 返回每个ListView的视图展现在ui界面
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Rows rows = list.get(position);
		ViewHolder holder = null;
		// 重复利用item的视图对象
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.zhengxinresh_item,
					null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_zhenxinresh_item_name);

			holder.state = (TextView) convertView
					.findViewById(R.id.tv_zhenxinresh_item_state);

			holder.idnumber = (TextView) convertView
					.findViewById(R.id.tv_zhenxinresh_item_idnumber);

			holder.idurl = (TextView) convertView
					.findViewById(R.id.tv_zhenxinresh_item_idphotourl);

			holder.authorurl = (TextView) convertView
					.findViewById(R.id.tv_zhenxinresh_item_authorphotourl);

			convertView.setTag(holder);
		}
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(rows.getCuname());
		if ("".equals(rows.getStatus())) {
			holder.state.setText("未认证");

		} else if (rows.getStatus().equals("0")) {
			holder.state.setText("未通过");
		} else if (rows.getStatus().equals("1")) {
			holder.state.setText("已通过");
		}




		holder.idnumber.setText(rows.getIdcardno());
		// holder.idurl.setText(Constants.GETIMGURL
		// + list.get(position)
		// .getIdcardurl()
		// .substring(
		// 1,
		// list.get(position).getIdcardurl()
		// .lastIndexOf("]")));
		// holder.authorurl.setText(Constants.GETIMGURL
		// + list.get(position)
		// .getAuthurl()
		// .substring(
		// 1,
		// list.get(position).getAuthurl()
		// .lastIndexOf("]")));
		holder.idurl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<String> lists = new ArrayList<String>();
				String str = rows.getIdcardurl().subSequence(1,

						rows.getIdcardurl().indexOf("]")).toString();
				System.out.println(Constants.GETIMGURL + str.replace("\"", ""));
				isempty(lists, str);
			}
		});
		holder.authorurl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<String> lists = new ArrayList<String>();
				String str = rows.getAuthurl()
						.subSequence(1, rows.getAuthurl().indexOf("]"))
						.toString();
				isempty(lists, str.replace("\"", ""));

			}
		});

		return convertView;
	}

	// 创建viewHolder优化代码
	class ViewHolder {

		TextView name;
		TextView state;
		TextView idnumber;
		TextView idurl;
		TextView authorurl;

	}

	private void isempty(ArrayList<String> list, String url) {

		if (!list.isEmpty() || url != null) {

			intent = new Intent(context, ShowImagesActivity.class);
			intent.putStringArrayListExtra("list", list);
			intent.putExtra("url", url);
			context.startActivity(intent);
		} else {
			Toast.makeText(context, "您还没有添加照片", Toast.LENGTH_LONG).show();
		}
	}

}
