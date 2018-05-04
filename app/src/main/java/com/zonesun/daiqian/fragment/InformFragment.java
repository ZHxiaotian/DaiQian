package com.zonesun.daiqian.fragment;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.activity.R;
import com.zonesun.daiqian.base.BaseFragment;
import com.zonesun.daiqian.base.MyApplication;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.entity.InformEntity;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.JsonUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 公告左侧滑动栏
 * 
 * @author Administrator
 * 
 */
@SuppressLint("ViewHolder")
public class InformFragment extends BaseFragment {

	private View view;// 当前fragment返回的view对象
	private ImageView head_img;// 员工头像
	private TextView tv_number;// 员工编号
	private TextView tv_name;// 员工姓名

	private ListView lv_gglb;

	private ArrayList<NameValuePair> nameValuePairs;

	private List<InformEntity.RowsEntity> rowsEntity;

	// 获取的网络数据
	private String data;

	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {

				getData();
				setAdapter();

			}
		};
	};

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_inform, null);
		head_img = (ImageView) view.findViewById(R.id.head_imageview);
		tv_number = (TextView) view.findViewById(R.id.gh_tv);
		tv_name = (TextView) view.findViewById(R.id.name_tv);
		// 将调查员的信息设置到界面显示
		BitmapUtils utils = new BitmapUtils(mActivity);
		utils.display(head_img, Constants.GETIMGURL
				+ GLobleData.logindata.getData().getHeadimg());
		tv_number.setText("工号:" + GLobleData.logindata.getData().getOrganid());
		tv_name.setText("姓名:" + GLobleData.logindata.getData().getName());
		return view;
	}

	/**
	 * 设置适配器
	 */
	protected void setAdapter() {
		lv_gglb.setAdapter(new MyAdapter());
	}

	/**
	 * 获取转换的json数据
	 */
	protected void getData() {

		InformEntity entity = (InformEntity) JsonUtils.fromJSON(data,
				InformEntity.class);
		rowsEntity = entity.getRows();
	}

	/**
	 * 初始化数据
	 */
	@Override
	public void initData() {
		lv_gglb = (ListView) view.findViewById(R.id.lv_gglb);
		super.initData();
		getGGLBData();
	}

	/**
	 * 获取公告通知列表的数据
	 */
	private void getGGLBData() {

		postAddKHXX();
	}

	/**
	 * 
	 添加客户信息
	 */
	private void postAddKHXX() {
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.setHeader("Cookie", "JSESSIONID=" + MyApplication.mySession());
		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("equip", "4"));
		nameValuePairs.add(new BasicNameValuePair("type", "2"));
		params.addBodyParameter(nameValuePairs);
		httpUtils.send(HttpMethod.POST, Constants.POSTINFORM, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {

					}

					@Override
					public void onSuccess(ResponseInfo<String> arg0) {

					}
				});
	}

	private TextView tv_title;

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return rowsEntity.size();
		}

		@Override
		public Object getItem(int position) {
			return rowsEntity.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = View.inflate(mActivity, R.layout.item_listview, null);
			tv_title = (TextView) convertView.findViewById(R.id.tv_item);
			tv_title.setText(rowsEntity.get(position).getTitle());
			return convertView;
		}

	}

}
