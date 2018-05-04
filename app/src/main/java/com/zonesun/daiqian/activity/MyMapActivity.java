package com.zonesun.daiqian.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.zonesun.daiqian.base.AppManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class MyMapActivity extends Activity implements OnClickListener {
	public MapView mapView = null;
	public BaiduMap baiduMap = null;

	// 定位相关声明
	public LocationClient locationClient = null;
	// 自定义图标
	BitmapDescriptor mCurrentMarker = null;
	boolean isFirstLoc = true;// 是否首次定位
	private LatLng ll;
	private Button btn_jietu;

	public BDLocationListener myListener = new BDLocationListener() {
		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mapView == null)
				return;
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(100).latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			baiduMap.setMyLocationData(locData);// 设置定位数据
			if (isFirstLoc) {
				isFirstLoc = false;
				ll = new LatLng(location.getLatitude(), location.getLongitude());
				System.out.println("@@@@@@" + location.getLatitude()
						+ "6666666" + "@@@@@@@" + location.getLongitude() + "");
				MapStatusUpdate u = MapStatusUpdateFactory
						.newLatLngZoom(ll, 20); // 设置地图中心点以及缩放级别
				// MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				baiduMap.animateMapStatus(u);
			}
		}


	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// MyApplication.getInstance().addActivity(this);
		// 在使用SDK各组件之前初始化context信息，传入ApplicationContext
		// 注意该方法要再setContentView方法之前实现
		AppManager.getAppManager().addActivity(this);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_my_mapd);

		mapView = (MapView) this.findViewById(R.id.bmapView); // 获取地图控件引用
		baiduMap = mapView.getMap();
		btn_jietu = (Button) this.findViewById(R.id.btn_jietu);
		btn_jietu.setOnClickListener(this);
		// 3. 设置地图中心点为黑马
		MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(ll);
		baiduMap.setMapStatus(mapStatusUpdate);
		// 4. 设置地图缩放为15
		mapStatusUpdate = MapStatusUpdateFactory.zoomTo(15);
		baiduMap.setMapStatus(mapStatusUpdate);
		// 开启定位图层
		baiduMap.setMyLocationEnabled(true);

		locationClient = new LocationClient(getApplicationContext()); // 实例化LocationClient类
		locationClient.registerLocationListener(myListener); // 注册监听函数

		this.setLocationOption(); // 设置定位参数
		// 获取地图控件引用
		mapView = (MapView) findViewById(R.id.bmapView);
		baiduMap = mapView.getMap(); // 获取地图控制器

		locationClient.start(); // 开始定位
		// baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL); // 设置为一般地图
		// baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE); //设置为卫星地图
		// baiduMap.setTrafficEnabled(true); //开启交通图
		
	}

	/**
	 * 设置定位参数
	 */
	private void setLocationOption() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll");// 可选，默认gcj02，设置返回的定位结果坐标系
		int span = 1000;
		option.setScanSpan(span);// 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
		option.setIsNeedAddress(true);// 可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);// 可选，默认false,设置是否使用gps
		option.setLocationNotify(true);// 可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
		option.setIsNeedLocationDescribe(true);// 可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);// 可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
		option.setIgnoreKillProcess(false);// 可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
		option.SetIgnoreCacheException(false);// 可选，默认false，设置是否收集CRASH信息，默认收集
		option.setEnableSimulateGps(false);// 可选，默认false，设置是否需要过滤gps仿真结果，默认需要
		locationClient.setLocOption(option);
	}

	// 三个状态实现地图生命周期管理
	@Override
	protected void onDestroy() {
		// 退出时销毁定位
		locationClient.stop();
		baiduMap.setMyLocationEnabled(false);
		super.onDestroy();
		mapView.onDestroy();
		mapView = null;
		AppManager.getAppManager().finishActivity(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mapView.onPause();
	}

	private String picName;
	private File filepath;
	private String path = null;

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_jietu:
			jietu();
			break;

		default:
			break;
		}

	}
	
	/**
	 * 实现截图
	 */
	private void jietu() {
		
		mapView.getMap().snapshot(new SnapshotReadyCallback() {
			@Override
			public void onSnapshotReady(Bitmap bitmap) {
				String state = Environment.getExternalStorageState();
				if (state.equals(Environment.MEDIA_MOUNTED)) {
					File dir = new File(Environment
							.getExternalStorageDirectory() + "/" + "dq");
					if (!dir.exists())
						dir.mkdirs();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-ddHHmmss");
					picName = sdf.format(new Date()) + ".jpg";
					filepath = new File(dir, picName);
					
					path = filepath.toString();
					try {
						dir.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					FileOutputStream fout = null;
					try {
						fout = new FileOutputStream(filepath);
						bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
						fout.flush();
						fout.close();
						Intent intent = new Intent();
						intent.putExtra("path", path);
						setResult(1, intent);
						finish();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			Intent intent = new Intent();
			intent.putExtra("path", path);
			setResult(1, intent);
			finish();

		}

		return false;

	}

}
