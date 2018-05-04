package com.zonesun.daiqian.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.adapter.VisitAlrearyAdapter;
import com.zonesun.daiqian.adapter.VisitYetAdapter;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.util.JsonUtils;

/**
 * 个人设置fragment
 * @author Administrator
 * 
 */
@SuppressLint("HandlerLeak")
public class PersonalSettingFragment extends BaseFragment implements OnClickListener {

	private View view;// 跟布局View
	private TextView textView1;// 今日巡检TextView
	private TextView textView2;// 已巡检TextView
	private TextView textView3;// 未巡检TextView
	private LinearLayout ll1;// 包裹今日巡检LIstView的LinearLayout
	private LinearLayout ll2;// 包裹已巡检LIstView的LinearLayout
	private LinearLayout ll3;// 包裹未巡检LIstView的LinearLayout
	private ListView listView1;// 展示今日巡检数据的ListView
	private ListView listView2;// 展示已巡检数据的ListView
	private ListView listView3;// 展示未巡检数据的ListView
	private String date;// 网络请求到的数据
	private List<VisitalrearyEntity> list;
	/*
	 * 定义boolean变量各自表示TextView是否被点击 true:表示当前状态是展开状态,点击后设置为false
	 * false:表示当前状态为折叠状态,点击后设置为true
	 */
	private boolean isListView1Unfold;// listview1展开或者合并状态
	private boolean isListView2Unfold;// listview2展开或者合并状态
	private boolean isListView3Unfold;// listview3展开或者合并状态
	private HashMap<String, Object> map;
	private RuHuSurveyEntity entity;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0) {

				getData();
				setAdapter();
			}
		}

	};

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_ruhu_survey, null);
		textView1 = (TextView) view.findViewById(R.id.textView1);
		textView2 = (TextView) view.findViewById(R.id.textview2);
		textView3 = (TextView) view.findViewById(R.id.textView3);

		ll1 = (LinearLayout) view.findViewById(R.id.ll1);
		ll2 = (LinearLayout) view.findViewById(R.id.ll2);
		ll3 = (LinearLayout) view.findViewById(R.id.ll3);

		listView1 = (ListView) view.findViewById(R.id.listView1);
		listView2 = (ListView) view.findViewById(R.id.listView2);
		listView3 = (ListView) view.findViewById(R.id.listView3);

		/*
		 * 初始化页面,默认第一个listView是展开状态,另外两个LIstView是合并状态
		 */
		isListView1Unfold = true;
		ll2.setVisibility(View.GONE);
		ll3.setVisibility(View.GONE);

		return view;
	}

	@Override
	public void initData() {

		// 给三个TextView添加点击监听
		textView1.setOnClickListener(this);
		textView2.setOnClickListener(this);
		textView3.setOnClickListener(this);

		getYZFDate();

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.textView1:
			if (isListView1Unfold) {// 表示listView1是展开状态,点击后设置为false,并将ListView折叠
				ll1.setVisibility(View.GONE);
				isListView1Unfold = false;
			} else {// 便是Listview1是折叠状态,要将listView1展开,并且将状态设置为true;
					// 同时让其他两个ListView值为false,将其余两个折叠
				isListView1Unfold = true;
				ll1.setVisibility(View.VISIBLE);
				ll2.setVisibility(View.GONE);
				isListView2Unfold = false;
				ll3.setVisibility(View.GONE);
				isListView3Unfold = false;
			}
			break;
		case R.id.textview2:
			if (isListView2Unfold) {// 表示listView2是展开状态,点击后设置为false,并将ListView2折叠
				isListView2Unfold = false;
				ll2.setVisibility(View.GONE);
			} else {// 表示Listview2是折叠状态,要将listView1展开,并且将状态设置为true;
					// 同时让其他两个ListView值为false,将其余两个折叠
				isListView2Unfold = true;
				ll2.setVisibility(View.VISIBLE);
				ll1.setVisibility(View.GONE);
				isListView1Unfold = false;
				ll3.setVisibility(View.GONE);
				isListView3Unfold = false;
			}
			break;
		case R.id.textView3:
			if (isListView3Unfold) {// 此时listview3是展开的,点击后将其合并,状态设置为false
				isListView3Unfold = false;
				ll3.setVisibility(View.GONE);
			} else {// 走此模块说明listView3此时是合并的,将listview3展开,并将其余两个listview折叠
				isListView3Unfold = true;
				ll3.setVisibility(View.VISIBLE);

				ll1.setVisibility(View.GONE);
				isListView1Unfold = false;
				ll2.setVisibility(View.GONE);
				isListView2Unfold = false;
			}

			break;

		default:
			break;
		}

	}

	/**
	 * 通过get请求获取贷钱业务客户信息
	 */
	private void getYZFDate() {
		map = new HashMap<String, Object>();
		map.put("equip", "4");

		new Thread() {

			public void run() {

				try {
					/*SimpleClient.getHttpClient();
					date = SimpleClient.doGet(Constants.DQCHLB, map);
					handler.sendEmptyMessage(0);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}

	/**
	 * 获取转化的json对象
	 */
	private void getData() {
		entity = (RuHuSurveyEntity) JsonUtils.fromJSON(date,
				RuHuSurveyEntity.class);
	};

	/**
	 * 给listview设置适配
	 */
	protected void setAdapter() {

		if (entity.getVisitalready() != null) {
			listView2
					.setAdapter(new VisitAlrearyAdapter(entity, getActivity()));
		}

		if (entity.getVisityet() != null) {
			listView3.setAdapter(new VisitYetAdapter(entity, getActivity()));
		}

		if (entity != null) {
			list = new ArrayList<VisitalrearyEntity>();

			list.addAll(entity.getVisitalready());
			//list.addAll(entity.getVisityet());
			//listView1.setAdapter(new JinRiYuYeAdapter(list, getActivity()));
		}
	}

}
