package com.zonesun.daiqian.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.zonesun.daiqian.entity.EventT;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * 本类是对一些网络请求操作的简单封装用的是NoHttp库封装的。
 *
 * @author Administrator
 */
public class NoHttpRequest {

    private JSONObject obj;
    // 用NoHttp自己管理cookie
    // CookieStore cookiestore=new CookieStore();

    /**
     * 请求队列
     */
    private RequestQueue requestQueue;
    private Context context;
    private SharedPreferences sp;// 用来获取获得的cookie

    public NoHttpRequest(Context context, SharedPreferences sp) {
        super();
        this.context = context;
        this.sp = sp;
    }

    /*
     * 一般的网络请求
     */
    public void Request(Map<String, String> map, String url, Object obj,
                        int QueueCode) {

        // sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        // 创建请求队列, 默认并发3个请求, 传入数字改变并发数量: NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue(1);
        // 创建请求对象

        Request<String> request = NoHttp.createStringRequest(url,
                RequestMethod.POST);
        if (url != Constants.LOGINURL&&url!= Constants.GETCARDINFO) {

            request.setHeader("Cookie",
                    "JSESSIONID=" + sp.getString("MYCOOKIES", null));
        }
        // 便利集合取出 请求参数
        for (String key : map.keySet()) {
            request.add(key, map.get(key));
            // System.out.println(map.get(key));
        }
         System.out.println(request);
        /**
         * 回调对象，接受请求结果
         *
         */
        /*
		 * what: 当多个请求同时使用同一个OnResponseListener时用来区分请求, 类似handler的what一样
		 * request: 请求对象 onResponseListener 回调对象，接受请求结果
		 */
        requestQueue.add(QueueCode, request, onResponseListener);

    }




    // 此部是为了方便当然应该按照单一原则将只放到别的类中这里只是为了让自己更加易了解一些
    OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @SuppressWarnings("unused")
        @Override
        public void onSucceed(int what, Response<String> response) {
            String result = response.get();// 响应结果

            if (what == NoCode.NOHTTP_WHAT_UPMOREJPG) {

                postEvent(what, result, null);// 利用eventBus替换接口回调用来将请求结果返回主线程
            } else if (what == NoCode.NOHTTP_WHAT_SEARCHZX) {

                postEvent(what, result, null);

            } else if (what == NoCode.NOHTTP_WHAT_LOGIN) {// 判断what是否是刚才指定的请求
                // 请求成功
                // CookieManager cookieManager = (CookieManager) NoHttp
                // .getDefaultCookieManager();
                // List<HttpCookie> cookies = cookieManager.getCookieStore()
                // .getCookies();
                List<HttpCookie> cookies = response.getHeaders().getCookies();
                System.out.println(cookies.toString() + "....NoHttp.Cookies");

                postEvent(what, result, cookies);

            } else if (what == NoCode.NOHTTP_WHAT_ZXCXJD) {

                postEvent(what, result, null);

            } else if (what == NoCode.NOHTTP_WHAT_RHDCCEDATA) {// 入户调查数据请求
                System.out.println("................+++"+result);
//                if (response.get().contains("Visitalreary")) {
//                    ToastUtil.showShort(context, "收到了");
//                }
                postEvent(what, result, null);
//                 RuHuSurveyEntity    entity = JSON.parseObject(result, RuHuSurveyEntity.class);
//                 System.out.println(entity.getVisitalreary());

            } else if (what == NoCode.NOHTTP_WHAT_RHDCLOADMORE) {

                postEvent(what, result, null);

            } else if (what == NoCode.NOHTTP_WHAT_RHDCFQFKQS) {// 入户调查分期付款期数

                postEvent(what, result, null);

            } else if (what == NoCode.NOHTTP_WHAT_UPDATEUMMSGPUSH) {// 更新通知友盟推送掉的相关请求
                System.out.println("更新通知友盟推送掉的相关请求");
                System.out.println(result);
                postEvent(what, result, null);
            }else if(what==NoCode.NOHTTP_WHAT_GETCARDBINS){//获取cardbin

                System.out.println(result);
                postEvent(what, result, null);
            }else if(what==NoCode.NOHTTP_WHAT_GETCARDBINSMSG){//获取catdbin所对应的卡种类等信息
                EventBus.getDefault().post(new MyEvent(result,what));

            }else if(what==NoCode.NOHTTP_WHAT_GETIDCARDINFO){//获取身份信息
                EventBus.getDefault().post(new MyEvent(result,what));
            }else if(what==NoCode.NOHTTP_WHAT_POSTOPENCARD){
                EventBus.getDefault().post(new MyEvent(result,what));
                    System.out.println(result);
            }
            // 请求完毕后释放NoHttp用作网络请求时开启的线程。

        }

        private void postEvent(int what, String result, List<HttpCookie> list) {
            try {
                obj = new JSONObject(result);
                EventBus.getDefault().post(new EventT(what, obj, list));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void onStart(int what) {
            // 请求开始，显示dialog

        }

        @Override
        public void onFinish(int what) {
            // 请求结束，关闭dialog

        }

        @Override
        public void onFailed(int what, Response<String> response) {
            // TODO Auto-generated method stub

            System.out.println("失败了" + response.toString());
            if (what == NoCode.NOHTTP_WHAT_RHDCCEDATA) {// 入户调查策划数据请求
                //System.out.println(result);

                ToastUtil.showShort(context, "请求数据失败");

                EventBus.getDefault().post(new EventT(false));

            }else if(what == NoCode.NOHTTP_WHAT_GETCARDBINS){
                System.out.println("获取卡bin效果" +
                        "失败了" + response.toString());
            }else if(what==NoCode.NOHTTP_WHAT_GETIDCARDINFO){
                System.out.println("获取身份信息失败" +
                        "失败了" + response.toString());

            }else if(what==NoCode.NOHTTP_WHAT_POSTOPENCARD){

                System.out.println( response.toString());
            }
        }

    };

	/*
	 * 图片上传
	 */

    public void upLoad() {

        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(Constants.POSTIMG,
                RequestMethod.POST);

    }


    /**
     * ocr身份证识别调用接口
     * @param bitmap
     * @param card_type
     * @param callback
     */
    public static void uploadIdCard(String bitmap, String card_type, final SimpleCallBack callback) {

        StringBuffer mySign = new StringBuffer("");
        YoutuSign.appSign(Constant.AppID, Constant.SecretID, Constant.SecretKey,
                System.currentTimeMillis() / 1000 + Constant.EXPIRED_SECONDS,
                Constant.QQNumber, mySign);
        RequestParams params = new RequestParams("http://api.youtu.qq.com/youtu/ocrapi/idcardocr");
        params.setAsJsonContent(true);
        params.addHeader("accept", "*/*");
        params.addHeader("Host", "api.youtu.qq.com");
        params.addHeader("user-agent", "youtu-java-sdk");
        params.addHeader("Authorization", mySign.toString());
        params.addHeader("Content-Type", "text/json");
        params.addParameter("card_type", Integer.valueOf(card_type));
        params.addBodyParameter("image", bitmap);
        params.addBodyParameter("app_id", Constant.AppID);

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("onSuccess",result);
                System.out.println(result);
                callback.Succ(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("onError",ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("onCancelled", cex.getMessage());
            }

            @Override
            public void onFinished() {

            }
        });

    }

    public interface SimpleCallBack {
        void Succ(String result);

        void error();
    }






}
