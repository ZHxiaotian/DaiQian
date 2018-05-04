package com.zonesun.daiqian.base;




import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.zonesun.daiqian.activity.LoginActivity;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.view.HttpServceUtil;
import org.xutils.x;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

	private static MyApplication instance;

	HttpServceUtil httpservce;

	@Override
	public void onCreate() {
		super.onCreate();
		SDKInitializer.initialize(getApplicationContext());//百度地图初始化
		httpservce = new HttpServceUtil();
		// 初始化NoHttp的网络请求
		x.Ext.init(this);
		NoHttp.initialize(this);
		NoHttp.setEnableCookie(false);//设置取消NoHttp的Cookie持久化

		Logger.setTag("NoHtttpSample");
		Logger.setDebug(true);// 开始NoHttp的调试模式, 这样就能看到请求过程和日志
	
		//友盟推送的Application配置
		PushAgent mPushAgent = PushAgent.getInstance(this);
		mPushAgent.setDebugMode(false);
		//注册推送服务，每次调用register方法都会回调该接口
		mPushAgent.register(new IUmengRegisterCallback() {

		    @Override
		    public void onSuccess(String deviceToken) {
		        //注册成功会返回device token
		    	System.out.println("deviceToken......."+deviceToken);
		    }

		    @Override
		    public void onFailure(String s, String s1) {

		    }
		});
//		WilddogOptions options = new WilddogOptions.Builder().setSyncUrl("https://"+ Constants.WILDDOG_VIDEO_ID+".wilddogio.com").build();
//		WilddogApp.initializeApp(this,options);


	}

	public static String mySession() {
		String id = LoginActivity.MYCOOKIES;
		return id;
	}

	
	public synchronized static MyApplication getInstance() {
		if (null == instance) {
			instance = new MyApplication();
		}
		return instance;
	}


}
