package com.zonesun.daiqian.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;

/**
 * 
 * 巡检系统首页的 "Adapter" 展示相应布局逻辑代码
 * 
 * 
 * 
 */
@SuppressLint("ViewHolder")
public class MainActivityAdapter extends BaseAdapter {
	private Context mContext;

	private int[] mPic = new int[] { R.drawable.ruhudiaocha,
			R.drawable.diaoyanbaogao, R.drawable.diaochayuyue,
			R.drawable.baobiaochaxun, R.drawable.gonggaotongzhi,
			R.drawable.gerenshezhi,R.drawable.ruhudiaocha };

	private String[] mItem = new String[] { "入户调查", "调研报告", "开卡申请", "征信查询",
			"公告通知", "个人设置" ,"先放款后抵押"};

	private int[] mTextColor = new int[] { R.color.content_item_ruhudiaocha,
			R.color.content_item_diaoyanbaogao,
			R.color.content_item_diaochayuyue,
			R.color.content_item_baobiaochaxun,
			R.color.content_item_gonggaotongzhi,
			R.color.content_item_gerenshezhi,
			R.color.content_item_ruhudiaocha
	};

	public MainActivityAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mItem.length;
	}

	@Override
	public Object getItem(int position) {
		return mItem[position];

	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(mContext, R.layout.main_grid_item, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.iv_main_grid);
		TextView textView = (TextView) view.findViewById(R.id.tv_main_grid);

		imageView.setImageResource(mPic[position]);
		textView.setText(mItem[position]);
		textView.setTextColor(mContext.getResources().getColor(
				mTextColor[position]));

		return view;

	}
}
