package com.zonesun.daiqian.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zonesun.daiqian.base.AppManager;
import com.zonesun.daiqian.entity.GLobleData;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.ToastUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 个人设置类
 * 
 * @author Administrator
 * 
 */
public class PersonalSettingActivity extends Activity implements
		OnClickListener {
	private TextView tv_titleText;
	private Button offLineMapAdd = null;
	private ImageView iv_touxiang;
	private String picName;
	String path;
	private Bitmap bitmap;
	SharedPreferences sp;
	String MYCOOKIES;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.activity_personal_setting);
		// MyApplication.getInstance().addActivity(this);
		init();
		
	}

	private void init() {
		// 设置标题文字
		sp = getSharedPreferences("login", Context.MODE_PRIVATE);
		MYCOOKIES = sp.getString("MYCOOKIES", null);
		tv_titleText = (TextView) findViewById(R.id.tv_title_text);
		tv_titleText.setText("贷前管理系统》个人设置");// 改变标题文字-->个人设置
		iv_touxiang = (ImageView) findViewById(R.id.iv_touxiang);
		BitmapUtils utils = new BitmapUtils(this);
		System.out.println(GLobleData.logindata.getData().getHeadimg()
				+ "......................");
		utils.display(iv_touxiang, Constants.GETIMGURL
				+ GLobleData.logindata.getData().getHeadimg());
		iv_touxiang.setOnClickListener(this);
		offLineMapAdd = (Button) findViewById(R.id.btn_offlineMap);

		offLineMapAdd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btn_offlineMap:
			Intent intent = new Intent(this, OffLineMapActivity.class);
			startActivity(intent);

			break;
		case R.id.iv_touxiang:
			// Intent ivintent=new
			camera(1);
			break;
		default:
			break;
		}

	}

	/**
	 * 调用照相机拍照
	 */
	private void camera(int requestCode) {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			try {
				picName = new Date().getTime() + ".jpg";
				System.out.println("picName=====" + picName);

				File dir = new File(Environment.getExternalStorageDirectory()
						+ "/" + "dq" + "/");
				if (!dir.exists())
					dir.mkdirs();
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File f = new File(dir, picName);// ImageFileName是自己定义的名字
				Uri u = Uri.fromFile(f);
				System.out.println("+++++" + u);
				intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
				startActivityForResult(intent, requestCode);
			} catch (ActivityNotFoundException e) {
				Toast.makeText(this, "没有找到储存目录", Toast.LENGTH_LONG).show();
			}
		} else {
			Toast.makeText(this, "没有储存卡", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		Bitmap zitmap = null;
		FileOutputStream fout1 = null;
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case 1:

				path = Environment.getExternalStorageDirectory() + "/" + "dq"
						+ "/" + picName;
				System.out.println("path==" + path);
				File file = new File(path);
				Uri uri = Uri.fromFile(file);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 8;
				options.inJustDecodeBounds = false;
				try {
					bitmap = BitmapFactory.decodeStream(getContentResolver()
							.openInputStream(uri), null, options);
					zitmap = Bitmap.createBitmap(bitmap.getWidth(),
							bitmap.getHeight(), Bitmap.Config.ARGB_8888);
					Canvas canvas = new Canvas(zitmap);

					Paint paint = new Paint();
					canvas.drawBitmap(bitmap, 0, 0, paint);
					fout1 = new FileOutputStream(file);
					zitmap.compress(CompressFormat.JPEG, 100, fout1);
					fout1.flush();
					fout1.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				iv_touxiang.setImageBitmap(zitmap);
				upLoad(path);
				break;
			default:
				break;
			}

		}

	}

	/**
	 * 上传头像照片
	 * 
	 * @param path2
	 */
	private void upLoad(String path2) {
		// TODO Auto-generated method stub

		HttpUtils utils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.addBodyParameter("extra", "1");
		params.addBodyParameter("files", new File(path2));

		// util.send(HttpRequest.HttpMethod.POST, Constants.POSTIMG, params,
		utils.send(HttpMethod.POST, Constants.POSTIMG, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ResponseInfo<String> arg0) {
						// TODO Auto-generated method stub
						ToastUtil.showShort(getApplication(), arg0.result);
						// String str= arg0.result.r;
						List<String> list = new Gson().fromJson(arg0.result,
								new TypeToken<List<String>>() {
								}.getType());

						System.out.println(GLobleData.logindata.getData()
								.toString());
						// 修改头像的方法

						updataheadimg(list.get(0));
					}

				});
	}

	private void updataheadimg(String str) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add(str);
		HttpUtils utils = new HttpUtils();
		RequestParams params = new RequestParams();

		params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);
		params.addBodyParameter("usercode", GLobleData.logindata.getData()
				.getUsercode());
		params.addBodyParameter("equip", "4");
		params.addBodyParameter("headimg", str);
		utils.send(HttpMethod.POST, Constants.UPDATEHEADIMG, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ResponseInfo<String> arg0) {
						// TODO Auto-generated method stub
						ToastUtil.showShort(getApplication(), arg0.result);
					}
				});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (isShouldHideInput(v, ev)) {
				hideSoftInput(v.getWindowToken());
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 18 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏 19 * 20 * @param
	 * v 21 * @param event 22 * @return 23
	 */
	private boolean isShouldHideInput(View v, MotionEvent event) {
		if (v != null && (v instanceof EditText)) {
			int[] l = { 0, 0 };
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (event.getX() > left && event.getX() < right
					&& event.getY() > top && event.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}

	/**
	 * 多种隐藏软件盘方法的其中一种
	 * 
	 * @param token
	 */
	private void hideSoftInput(IBinder token) {
		if (token != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(token,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);
	}

}
