package com.zonesun.daiqian.fragment;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.activity.RuhuSurveyActivity;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.adapter.VisitAlrearyAdapter;
import com.zonesun.daiqian.adapter.VisitYetAdapter;
import com.zonesun.daiqian.base.BaseFragment;

import com.zonesun.daiqian.entity.MyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisityetEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.MyEvent;


import de.greenrobot.event.EventBus;

/**
 * 入户调查fragment
 * 
 * @author Administrator
 * 
 */
@SuppressLint("HandlerLeak")
public class SlideMenu2Fragment extends BaseFragment implements OnClickListener {

	private View view;// 跟布局View
	private TextView textView1;// 未巡检TextView
	private TextView textView2;// 已巡检TextView
	private TextView textView3;// 今日巡检TextView
	private LinearLayout ll1;// 包裹未巡检LIstView的LinearLayout
	private LinearLayout ll2;// 包裹已巡检LIstView的LinearLayout
	private LinearLayout ll3;// 包裹今日巡检LIstView的LinearLayout
	private ListView listView1;// 展示未巡检数据的ListView
	private ListView listView2;// 展示已巡检数据的ListView
	private ListView listView3;// 展示今日巡检数据的ListView

	/*
	 * 定义boolean变量各自表示TextView是否被点击 true:表示当前状态是展开状态,点击后设置为false
	 * false:表示当前状态为折叠状态,点击后设置为true
	 */
	public boolean isListView1Unfold;// listview1展开或者合并状态
	public boolean isListView2Unfold;// listview2展开或者合并状态
	private boolean isListView3Unfold;// listview3展开或者合并状态
	private int i;// 判断是哪个activity传过来的

	@SuppressWarnings("unused")
	private ArrayList<NameValuePair> nameValuePairs;
	private RuhuSurveyActivity activity;

	private RuHuSurveyEntity entity;

	@SuppressWarnings("unused")
	private VisitalrearyEntity visitalrearyEntity;
	private List<MyEntity> listEntity;

	private String MYCOOKIES;
	private SharedPreferences sp;

	private String num;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		System.out.println("==============onCreate============");
		super.onCreate(savedInstanceState);

		// Bundle args = getArguments();
		// if (args != null) {
		// num = args.getString("num");
		// }
	}

	// public static SlideMenu2Fragment newInstance(String i){
	// SlideMenu2Fragment slideMenuFragment = new SlideMenu2Fragment();
	// Bundle bundle = new Bundle();
	// bundle.putString("num", i);
	// slideMenuFragment.setArguments(bundle);
	// return slideMenuFragment;
	// }

	/**
	 * 初始化控件
	 */
	@Override
	public View initView() {
		System.out.println("===========oncreatview=====================");
		view = View.inflate(mActivity, R.layout.fragment_slidmenu, null);
	
		textView1 = (TextView) view.findViewById(R.id.textView1);
		textView2 = (TextView) view.findViewById(R.id.textview2);
		textView3 = (TextView) view.findViewById(R.id.textView3);

		ll1 = (LinearLayout) view.findViewById(R.id.ll1);
		ll2 = (LinearLayout) view.findViewById(R.id.ll2);
		ll3 = (LinearLayout) view.findViewById(R.id.ll3);

		listView1 = (ListView) view.findViewById(R.id.listView1);
		listView2 = (ListView) view.findViewById(R.id.listView2);
		listView3 = (ListView) view.findViewById(R.id.listView3);

		// activity = (RuhuSurveyActivity) getActivity();

		/*
		 * 初始化页面,默认第一个listView是展开状态,另外两个LIstView是合并状态
		 */
		isListView1Unfold = false;
		isListView2Unfold = true;

		ll1.setVisibility(View.GONE);
		ll3.setVisibility(View.GONE);

		return view;
	}

	/**
	 * 初始化数据
	 */
	@Override
	public void initData() {

		sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
		MYCOOKIES = sp.getString("MYCOOKIES", null);

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

		RequestParams params = new RequestParams();
		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("equip", "4"));
		params.addBodyParameter(nameValuePairs);
		params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.POST, Constants.DQCHLB, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String msg) {
						// activity.progressBar.setVisibility(View.GONE);

						Toast.makeText(mActivity, "网络请求错误" + msg,
								Toast.LENGTH_LONG).show();
					
//						setText(json);

					}

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						if (responseInfo.statusCode == 200) {
							
							if (responseInfo.result != null) {
								// activity.progressBar.setVisibility(View.GONE);
								setText(responseInfo.result);

							}

						}
					}

				});
	}

	private void setText(String json) {
		Gson gson = new Gson();
		entity = gson.fromJson(json, RuHuSurveyEntity.class);
		setAdapter();
		setOnClick();
	}

	/**
	 * 给listview设置适配
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void setAdapter() {

		if (entity.getVisitalready() != null) {
			listView2
					.setAdapter(new VisitAlrearyAdapter(entity, getActivity()));

		}

		if (entity.getVisityet() != null) {
			listView1.setAdapter(new VisitYetAdapter(entity, getActivity()));

		}

		if (entity != null) {

			listEntity = new ArrayList<MyEntity>();

			List<VisitalrearyEntity> listVisitalreary = new ArrayList<VisitalrearyEntity>();
			listVisitalreary = entity.getVisitalready();
			List<VisityetEntity> visityet = new ArrayList<VisityetEntity>();
			visityet = entity.getVisityet();

			if (listVisitalreary != null && listVisitalreary.size() != 0) {

				for (int j = 0; j < listVisitalreary.size(); j++) {
					MyEntity myEntity = new MyEntity(listVisitalreary.get(j)
							.getPhone(), listVisitalreary.get(j).getUsercode(),
							listVisitalreary.get(j).getLh_url(),
							listVisitalreary.get(j).getReason(),
							listVisitalreary.get(j).getYyhke(),
							listVisitalreary.get(j).getCartype(),
							listVisitalreary.get(j).getNowadd_shi(),
							listVisitalreary.get(j).getTogather_url(),
							listVisitalreary.get(j).getUsername(),
							listVisitalreary.get(j).getMph_url(),
							listVisitalreary.get(j).getPersonedu(),
							listVisitalreary.get(j).getCert1_url(),
							listVisitalreary.get(j).getMworkaddress(),
							listVisitalreary.get(j).getCredit(),
							listVisitalreary.get(j).getMworktype(),
							listVisitalreary.get(j).getCert3_url(),
							listVisitalreary.get(j).getMarry(),
							listVisitalreary.get(j).getWorkphone(),
							listVisitalreary.get(j).getZzzm_url(),
							listVisitalreary.get(j).getMcertnum(),
							listVisitalreary.get(j).getZzzk(), listVisitalreary
									.get(j).getWorkadd_all(), listVisitalreary
									.get(j).getWorkname(), listVisitalreary
									.get(j).getStatus(), listVisitalreary
									.get(j).getWorkadd_shi(), listVisitalreary
									.get(j).getMworkphone(), listVisitalreary
									.get(j).getJob(), listVisitalreary.get(j)
									.getNowadd_sheng(), listVisitalreary.get(j)
									.getHkfs(), listVisitalreary.get(j)
									.getMavgmoney(), listVisitalreary.get(j)
									.getNowadd_all(), listVisitalreary.get(j)
									.getHkadd_xian(), listVisitalreary.get(j)
									.getDy_url(), listVisitalreary.get(j)
									.getApplybc_id(), listVisitalreary.get(j)
									.getWorktype(), listVisitalreary.get(j)
									.getHkadd_shi(), listVisitalreary.get(j)
									.getBirth(), listVisitalreary.get(j)
									.getSex(), listVisitalreary.get(j)
									.getWorkadd_sheng(), listVisitalreary
									.get(j).getPlantime(), listVisitalreary
									.get(j).getOnlycar(), listVisitalreary.get(
									j).getMbirth(), listVisitalreary.get(j)
									.getNowadd_detail(), listVisitalreary
									.get(j).getDkyt(), listVisitalreary.get(j)
									.getEd(), listVisitalreary.get(j)
									.getWorkadd_xian(), listVisitalreary.get(j)
									.getCert2_url(), listVisitalreary.get(j)
									.getHkadd_sheng(), listVisitalreary.get(j)
									.getName(), listVisitalreary.get(j)
									.getCerttype(), listVisitalreary.get(j)
									.getIsjk(), listVisitalreary.get(j)
									.getPql(), listVisitalreary.get(j)
									.getAvgmoney(), listVisitalreary.get(j)
									.getDw_url(), listVisitalreary.get(j)
									.getMname(), listVisitalreary.get(j)
									.getMjob(), listVisitalreary.get(j)
									.getMcerttype(), listVisitalreary.get(j)
									.getApplyid(), listVisitalreary.get(j)
									.getHkadd_all(), listVisitalreary.get(j)
									.getHkadd_detail(), listVisitalreary.get(j)
									.getWorkadd_detail(), listVisitalreary.get(
									j).getNowadd_xian(), listVisitalreary
									.get(j).getCustomerid(), listVisitalreary
									.get(j).getMworkname(), listVisitalreary
									.get(j).getCertnum(), listVisitalreary.get(
									j).getMphone(), listVisitalreary.get(j)
									.getXq_url(), listVisitalreary.get(j)
									.getPp(), listVisitalreary.get(j).getHkly());
					listEntity.add(myEntity);

				}
			}
			if (visityet != null && visityet.size() != 0) {

				for (int j = 0; j < visityet.size(); j++) {
					MyEntity myEntity = new MyEntity(
							visityet.get(j).getPhone(), visityet.get(j)
									.getUsercode(),
							visityet.get(j).getLh_url(), visityet.get(j)
									.getReason(), visityet.get(j).getYyhke(),
							visityet.get(j).getCartype(), visityet.get(j)
									.getNowadd_shi(), visityet.get(j)
									.getTogather_url(), visityet.get(j)
									.getUsername(), visityet.get(j)
									.getMph_url(), visityet.get(j)
									.getPersonedu(), visityet.get(j)
									.getCert1_url(), visityet.get(j)
									.getMworkaddress(), visityet.get(j)
									.getCredit(), visityet.get(j)
									.getMworktype(), visityet.get(j)
									.getCert3_url(),
							visityet.get(j).getMarry(), visityet.get(j)
									.getWorkphone(), visityet.get(j)
									.getZzzm_url(), visityet.get(j)
									.getMcertnum(), visityet.get(j).getZzzk(),
							visityet.get(j).getWorkadd_all(), visityet.get(j)
									.getWorkname(),
							visityet.get(j).getStatus(), visityet.get(j)
									.getWorkadd_shi(), visityet.get(j)
									.getMworkphone(), visityet.get(j).getJob(),
							visityet.get(j).getNowadd_sheng(), visityet.get(j)
									.getHkfs(), visityet.get(j).getMavgmoney(),
							visityet.get(j).getNowadd_all(), visityet.get(j)
									.getHkadd_xian(), visityet.get(j)
									.getDy_url(), visityet.get(j)
									.getApplybc_id(), visityet.get(j)
									.getWorktype(), visityet.get(j)
									.getHkadd_shi(), visityet.get(j)
									.getBirth(), visityet.get(j).getSex(),
							visityet.get(j).getWorkadd_sheng(), visityet.get(j)
									.getPlantime(), visityet.get(j)
									.getOnlycar(), visityet.get(j).getMbirth(),
							visityet.get(j).getNowadd_detail(), visityet.get(j)
									.getDkyt(), visityet.get(j).getEd(),
							visityet.get(j).getWorkadd_xian(), visityet.get(j)
									.getCert2_url(), visityet.get(j)
									.getHkadd_sheng(), visityet.get(j)
									.getName(), visityet.get(j).getCerttype(),
							visityet.get(j).getIsjk(),
							visityet.get(j).getPql(), visityet.get(j)
									.getAvgmoney(),
							visityet.get(j).getDw_url(), visityet.get(j)
									.getMname(), visityet.get(j).getMjob(),
							visityet.get(j).getMcerttype(), visityet.get(j)
									.getApplyid(), visityet.get(j)
									.getHkadd_all(), visityet.get(j)
									.getHkadd_detail(), visityet.get(j)
									.getWorkadd_detail(), visityet.get(j)
									.getNowadd_xian(), visityet.get(j)
									.getCustomerid(), visityet.get(j)
									.getMworkname(), visityet.get(j)
									.getCertnum(), visityet.get(j).getMphone(),
							visityet.get(j).getXq_url(), visityet.get(j)
									.getPp(), visityet.get(j).getHkly());

					listEntity.add(myEntity);

				}
			}

			//listView3.setAdapter(new JinRiYuYeAdapter(listEntity, mActivity));
		}
	}

	/**
	 * 设置点击事件
	 */
	private void setOnClick() {

		// 未巡检的条目点击事件
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				reFreshVisitYet(position);
			}
		});

		// 已巡检条目的点击事件
		listView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				reFreshVisitAlready(position);
			}
		});

		// 今日预约条目的点击事件
		listView3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				reFreshJryyEntity(position);
			}
		});
	}

	/**
	 * 刷新主布局的数据pos
	 * 
	 * @param position
	 */
	public void reFreshVisitAlready(int position) {
		EventBus.getDefault().post(
				new MyEvent(entity.getVisitalready().get(position),1));
	}

	/**
	 * 刷新主布局的数据
	 * 
	 * @param position
	 */
	public void reFreshVisitYet(int position) {
		EventBus.getDefault().post(
				new MyEvent(entity.getVisityet().get(position),2));

	}

	public void reFreshJryyEntity(int position) {
		//EventBus.getDefault().post(new MyEvent(listEntity.get(position)));
	}

	public void refreshData() {

		getYZFDate();
	}

}
