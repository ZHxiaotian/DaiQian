package com.zonesun.daiqian.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.activity.RuhuSurveyActivity;
import com.zonesun.daiqian.adapter.JinRiYuYeAdapter;
import com.zonesun.daiqian.adapter.VisitAlrearyAdapter;
import com.zonesun.daiqian.adapter.VisitYetAdapter;
import com.zonesun.daiqian.adapter.WeiFsAdapter;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.entity.EventT;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.RuHuData;
import com.zonesun.daiqian.entity.RuHuSurveyEntity;
import com.zonesun.daiqian.entity.RuHuSurveyEntity.VisitalrearyEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.MyEvent;
import com.zonesun.daiqian.util.NoCode;
import com.zonesun.daiqian.util.NoHttpRequest;
import com.zonesun.daiqian.util.ToastUtil;
import com.zonesun.daiqian.view.LoadMoreListView;
import com.zonesun.daiqian.view.LoadMoreListView.IloadListener;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 入户调查fragment
 *
 * @author Administrator
 *
 */
@SuppressLint("HandlerLeak")
public class SlideMenuFragment extends BaseFragment implements OnClickListener,
		IloadListener {

	private View view;// 根布局View
	private ImageView head_img;// 员工头像
	private TextView tv_number;// 员工编号
	private TextView tv_name;// 员工姓名
	private TextView textView1;// 未巡检TextView
	private TextView textView2;// 已巡检TextView
	private TextView textView3;// 今日巡检TextView
	private TextView textView4;// 未发送TextView
	private LinearLayout ll1;// 包裹未巡检LIstView的LinearLayout
	private LinearLayout ll2;// 包裹已巡检LIstView的LinearLayout
	private LinearLayout ll3;// 包裹今日巡检LIstView的LinearLayout
	private LinearLayout ll4;// 包裹未发送LIstView的LinearLayout
	private LoadMoreListView listView1;// 展示未巡检数据的ListView
	private LoadMoreListView listView2;// 展示已巡检数据的ListView
	private LoadMoreListView listView3;// 展示今日巡检数据的ListView
	private ListView listView4;// 展示未发送数据的ListzView

	private boolean isListView1Unfold;// listview1展开或者合并状态
	private boolean isListView2Unfold;// listview2展开或者合并状态
	private boolean isListView3Unfold;// listview3展开或者合并状态
	private boolean isListView4Unfold;// listview展开或者合并状态
	@SuppressWarnings("unused")
	private ArrayList<NameValuePair> nameValuePairs;
	private RuhuSurveyActivity activity;

	private RuHuSurveyEntity entity;

	@SuppressWarnings("unused")
	private VisitalrearyEntity visitalrearyEntity;
	// private List<MyEntity> listEntity;

	// private String MYCOOKIES;
	private SharedPreferences sp;
	private List<RuHuData> 	list;// 未发送的缓存到本地的数据
	private Map<String, String> map = new HashMap<String, String>();
	Realm mRealm;
	List<String> list1;
	private WeiFsAdapter weifsadapter;
	private JinRiYuYeAdapter Yiwancadapter;
	private VisitAlrearyAdapter YizoufAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	/**
	 * 初始化控件
	 */
	@Override
	public View initView() {

		view = View.inflate(mActivity, R.layout.fragment_slidmenu, null);
		EventBus.getDefault().register(this);

		head_img = (ImageView) view.findViewById(R.id.head_imageview);
		tv_number = (TextView) view.findViewById(R.id.gh_tv);
		tv_name = (TextView) view.findViewById(R.id.name_tv);
		// 将调查员的信息设置到界面显示
		BitmapUtils utils = new BitmapUtils(mActivity);
		System.out.println(GLobleData.logindata.getData().getHeadimg()
				+ "......................");
		utils.display(head_img, Constants.GETIMGURL
				+ GLobleData.logindata.getData().getHeadimg());
		tv_number.setText("工号:" + GLobleData.logindata.getData().getOrganid());
		tv_name.setText("姓名:" + GLobleData.logindata.getData().getName());

		textView1 = (TextView) view.findViewById(R.id.textView1);
		textView2 = (TextView) view.findViewById(R.id.textview2);
		textView3 = (TextView) view.findViewById(R.id.textView3);
		textView4 = (TextView) view.findViewById(R.id.textview4);

		ll1 = (LinearLayout) view.findViewById(R.id.ll1);
		ll2 = (LinearLayout) view.findViewById(R.id.ll2);
		ll3 = (LinearLayout) view.findViewById(R.id.ll3);
		ll4 = (LinearLayout) view.findViewById(R.id.ll4);

		listView1 = (LoadMoreListView) view.findViewById(R.id.listView1);
		listView2 = (LoadMoreListView) view.findViewById(R.id.listView2);
		listView3 = (LoadMoreListView) view.findViewById(R.id.listView3);
		listView4 = (ListView) view.findViewById(R.id.listView4);

		activity = (RuhuSurveyActivity) getActivity();

		/*
		 * 初始化页面,默认第一个listView是展开状态,另外两个LIstView是合并状态
		 */
		isListView1Unfold = true;
		ll2.setVisibility(View.GONE);
		ll3.setVisibility(View.GONE);
		ll4.setVisibility(View.GONE);
		return view;
	}

	/**
	 * 初始化数据
	 */
	@Override
	public void initData() {
		Realm.init(getActivity());
		RealmConfiguration config = new RealmConfiguration.Builder()
				.name("Ruhu.realm")
				.build();
		Realm.setDefaultConfiguration(config);
		sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
		// MYCOOKIES = sp.getString("MYCOOKIES", null);
		//RealmResults<User> userList = mRealm.where(User.class).findAll();
		mRealm=Realm.getDefaultInstance();
		list  = mRealm.where(RuHuData.class).findAll();// 查询本地缓存的数据
		// 给三个TextView添加点击监听
		textView1.setOnClickListener(this);
		textView2.setOnClickListener(this);
		textView3.setOnClickListener(this);
		textView4.setOnClickListener(this);
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
					ll4.setVisibility(View.GONE);
					isListView4Unfold = false;
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
					ll4.setVisibility(View.GONE);
					isListView4Unfold = false;
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
					ll4.setVisibility(View.GONE);
					isListView4Unfold = false;
				}

				break;
			case R.id.textview4:
				if (isListView4Unfold) {
					ll4.setVisibility(View.GONE);
					isListView4Unfold = false;
				} else {
					isListView3Unfold = false;
					ll3.setVisibility(View.GONE);

					ll1.setVisibility(View.GONE);
					isListView1Unfold = false;
					ll2.setVisibility(View.GONE);
					isListView2Unfold = false;
					ll4.setVisibility(View.VISIBLE);
					isListView4Unfold = true;
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

		// 用NoHttp请求
		map.put("equip", "4");
		map.put("typea","0");
		// map.put("page", "2");
		// map.put("type","2");
		new NoHttpRequest(mActivity, sp).Request(map, Constants.DQCHLB, null,
				NoCode.NOHTTP_WHAT_RHDCCEDATA);

		// params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);

	}

	/**
	 * 网络请求后数据的回调
	 *
	 * @param event
	 */
	public void onEventMainThread(EventT event) {

		if (event.isIsrefreshl()) {
			onRefreshwfs();
		} else {
			if (event.getNoCode() == NoCode.NOHTTP_WHAT_RHDCCEDATA) {

				// sqliteUtils.close();
				if (event.getObj().toString() != null) {
					activity.progressBar.setVisibility(View.GONE);
					// 提交入户调查界面的事物。
					activity.ft.commit();

					// System.out.println(event.getObj().toString());
					setText(event.getObj().toString());
				}
				// 加载更多的网络请求结果返回
			} else if (event.getNoCode() == NoCode.NOHTTP_WHAT_RHDCLOADMORE) {

				System.out.println(event.getObj().toString());
				refrashAdapter(event.getObj().toString());
			} else {
				activity.progressBar.setVisibility(View.GONE);
				activity.ft.commit();// 提交入户调查界面的事物。
			}
		}
	}

	private void setText(String json) {
		Gson gson = new Gson();
		entity = gson.fromJson(json, RuHuSurveyEntity.class);
		// entity = JSON.parseObject(json, RuHuSurveyEntity.class);
		System.out.println(entity.toString());
		setOnClick();
		setAdapter();
	}

	/**
	 * 给listview设置适配
	 */
	List<VisitalrearyEntity> listVisitalreary;

	protected void setAdapter() {
		listView1.setInterface(this);
		listView3.setInterface(this);
		listView2.setInterface(this);// 将接口传进来
		// 已走访
		if (entity.getVisitalready() != null) {
			// System.out.println("---------------------------"
			// + entity.getVisitalreary());
			// Log.e("YZF", entity.toString());
			// ToastUtil.showShort(getActivity(), "有数据");
			GLobleData.visityetalrearyList = entity.getVisitalready();
			YizoufAdapter = new VisitAlrearyAdapter(entity, getActivity());
			listView2.setAdapter(YizoufAdapter);

		}

		// 未走访
		if (entity.getVisityet() != null) {
			listView1.setAdapter(new VisitYetAdapter(entity, getActivity()));

		}

		// 未发送
		if (list != null && list.size() > 0) {
			list1 = new ArrayList<String>();
			for (RuHuData data : list) {
				if (data.getName() != null) {
					list1.add(data.getName());
				}
				// System.out.println(list1.toString());
			}
			weifsadapter = new WeiFsAdapter(list1, getActivity());
			listView4.setAdapter(weifsadapter);
		}
		// 已完成
		if (entity != null) {

			listVisitalreary = new ArrayList<RuHuSurveyEntity.VisitalrearyEntity>();
			listVisitalreary = entity.getVisitfinished();

			if (listVisitalreary.size() == 0) {
				ToastUtil.showShort(getActivity(), "已完成暂时没有数据");
				return;
			}
			Yiwancadapter = new JinRiYuYeAdapter(listVisitalreary, mActivity);
			listView3.setAdapter(Yiwancadapter);

		}

	}

	/**
	 * 设置点击事件
	 */
	private void setOnClick() {
		System.out.println("onItemClickListener.........1");
		// 未巡检的条目点击事件
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				// ToastUtil.showShort(mActivity, "reFreshVisitYet(position);");
				reFreshVisitYet(position);
			}
		});
		// 已走访条目的点击事件
		listView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				// System.out.println("onItemClickListener.........");
				// // ToastUtil.showShort(mActivity,
				// // "reFreshVisitAlready(position);;");

				reFreshVisitAlready(position);
			}
		});

		// 今日预约条目的点击事件
		listView3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				// ToastUtil
				// .showShort(mActivity, "reFreshJryyEntity(position);;;");
				reFreshJryyEntity(position);
			}
		});
		// 未完成
		listView4.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				// TODO Auto-generated method stub
				// ToastUtil.showShort(mActivity,
				// "refreshWfsData(list1.get(position));");
				refreshWfsData(list1.get(position));

			}
		});
	}

	/**
	 * 刷新主布局的数据pos 已走访数据展示 已走访
	 *
	 * @param position
	 */
	public void reFreshVisitAlready(int position) {
		System.out.println(entity.getVisitalready().get(position));
		EventBus.getDefault().post(
				new MyEvent(entity.getVisitalready().get(position), 2));
	}

	/**
	 * 刷新缓存的list列表
	 */
	public void onRefreshwfs() {
		ToastUtil.showShort(getActivity(), "刷新");
	     list  = mRealm.where(RuHuData.class).findAll();// 查询本地缓存的数据
		if (list != null && list.size() > 0) {

			if(list1!=null&&list1.size()>0){
				list1.clear();
			}else{
				list1=new ArrayList<String>();
			}
			for (RuHuData data : list) {
				if (data.getName() != null) {
					list1.add(data.getName());
				}
				System.out.println(list1.toString());
			}
			weifsadapter = new WeiFsAdapter(list1, getActivity());
			listView4.setAdapter(weifsadapter);
		}else{
			list1.clear();

			weifsadapter.notifyDataSetChanged();
		}

	}

	/**
	 * 刷新主布局的数据
	 *
	 * @param position
	 */
	public void reFreshVisitYet(int position) {
		EventBus.getDefault().post(
				new MyEvent(entity.getVisityet().get(position), 1));

	}

	public void reFreshJryyEntity(int position) {
		EventBus.getDefault().post(
				new MyEvent(listVisitalreary.get(position), 3));
	}

	public void refreshData() {

		getYZFDate();
	}

	public void refreshWfsData(String name) {
		RuHuData ruhu = null;
		for (RuHuData data : list) {
			if (data.getName().equals(name)) {
				ruhu = data;
			}
		}
		if (ruhu != null) {
			EventBus.getDefault().post(new MyEvent(ruhu, 4));
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	private int list1type = 1;// 为走访的type
	private int list2type = 2;// 已走访的type
	private int list3type = 3;// 已完成的type
	private int list1page = 2;// 未走访的page页数
	private int list2page = 2;// 未走访的page页数
	private int list3page = 2;// 未走访的page页数

	private void LoadMoreData(int type, int page) {
		Map<String, String> map = new HashMap<String, String>();
		if (type == 1) {
			map.put("equip", "4");
			map.put("page", "" + page);
			map.put("type", "" + type);
			new NoHttpRequest(mActivity, sp).Request(map, Constants.DQCHLB,
					null, NoCode.NOHTTP_WHAT_RHDCLOADMORE);
		} else if (type == 2) {
			map.put("equip", "4");
			map.put("page", "" + page);
			map.put("type", "" + type);
			new NoHttpRequest(mActivity, sp).Request(map, Constants.DQCHLB,
					null, NoCode.NOHTTP_WHAT_RHDCLOADMORE);

		} else if (type == 3) {
			map.put("equip", "4");
			map.put("page", "" + page);
			map.put("type", "" + type);
			new NoHttpRequest(mActivity, sp).Request(map, Constants.DQCHLB,
					null, NoCode.NOHTTP_WHAT_RHDCLOADMORE);
		}

	}

	/**
	 * 刷新加载更多后的适配器
	 *
	 * @param result
	 */
	private void refrashAdapter(String result) {
		RuHuSurveyEntity loadmoreentity = null;
		if (result != null) {
			Gson gson = new Gson();
			loadmoreentity = gson.fromJson(result, RuHuSurveyEntity.class);
			// System.out.println(loadmoreentity.getVisitalready().size()+"loadmoreentity....."+loadmoreentity.getVisitalready());
			if (loadmoreentity.getVisitalready() != null
					&& loadmoreentity.getVisitalready().size() > 0) {
				for (RuHuSurveyEntity.VisitalrearyEntity it : loadmoreentity
						.getVisitalready()) {

					entity.getVisitalready().add(it);
				}
				YizoufAdapter = new VisitAlrearyAdapter(entity, getActivity());
				listView2.setAdapter(YizoufAdapter);
				listView2.loadComplete();
			} else if (loadmoreentity.getVisitfinished() != null
					&& loadmoreentity.getVisitfinished().size() > 0) {

				for (RuHuSurveyEntity.VisitalrearyEntity it : loadmoreentity
						.getVisitfinished()) {

					entity.getVisitfinished().add(it);
				}
				listVisitalreary = entity.getVisitfinished();

				Yiwancadapter = new JinRiYuYeAdapter(listVisitalreary,
						mActivity);
				listView3.setAdapter(Yiwancadapter);
				listView3.loadComplete();
			} else if (loadmoreentity.getVisityet() != null
					&& loadmoreentity.getVisityet().size() > 0) {
				// 未走访

				for (RuHuSurveyEntity.VisityetEntity it : loadmoreentity
						.getVisityet()) {
					entity.getVisityet().add(it);
				}
				listView1
						.setAdapter(new VisitYetAdapter(entity, getActivity()));
				listView1.loadComplete();

			} else {
				if (listView1.isLoading) {

					listView1.loadComplete();
					ToastUtil.showShort(mActivity, "未走访已经没有可加载的数据");
				}
				if (listView2.isLoading) {
					ToastUtil.showShort(mActivity, "已走访已经没有可加载的数据");
					listView2.loadComplete();
				}
				if (listView3.isLoading) {

					listView3.loadComplete();
					ToastUtil.showShort(mActivity, "已完成已经没有可加载的数据");
				}
			}

		} else {
			if (listView1.isLoading) {

				listView1.loadComplete();
			}
			if (listView2.isLoading) {

				listView2.loadComplete();
			}
			if (listView3.isLoading) {

				listView3.loadComplete();
			}

		}
	}

	@Override
	public void onLoad(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			// 未走访加载更多
			case R.id.listView1:
				ToastUtil.showShort(getActivity(), "未走访正在加载更多。。。");
				LoadMoreData(list1type, list1page);
				list1page++;
				break;
			// 已走访加载更多
			case R.id.listView2:
				//
				ToastUtil.showShort(getActivity(), "已走访正在加载更多。。。");
				LoadMoreData(list2type, list2page);
				list2page++;
				break;
			// 已完成
			case R.id.listView3:
				ToastUtil.showShort(getActivity(), "已完成正在加载更多。。。");
				LoadMoreData(list3type, list3page);
				list3page++;
				break;
			default:
				break;
		}

	}

}
