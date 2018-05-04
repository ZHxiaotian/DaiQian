package com.zonesun.daiqian.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.zonesun.daiqian.base.AppManager;

public class ShowImageActivity extends FragmentActivity {

	private String path;// 获取传递的路径
	private ImageView imageView;// 图片

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// No Titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getAppManager().addActivity(this);
		setContentView(R.layout.daiqian_image_item);
		// MyApplication.getInstance().addActivity(this);
		path = getIntent().getStringExtra("path");
		initView();

	}

	private void initView() {
		imageView = (ImageView) findViewById(R.id.imageView);
		Bitmap bitmap = BitmapFactory.decodeFile(path, null);
		imageView.setImageBitmap(bitmap);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		AppManager.getAppManager().finishActivity(this);

	}
}
