package com.zonesun.daiqian.view;

import android.os.Handler;

import com.lidroid.xutils.HttpUtils;
import com.zonesun.daiqian.util.Constants;
import com.zonesun.daiqian.util.NetRequestCallBack;

import org.xutils.x;

import java.io.File;
import java.util.Map;

/**
 * @author Administrator
 */
public class HttpServceUtil {

    public static HttpUtils util;
    private int code;

    public HttpServceUtil() {
        super();
        util = new HttpUtils();

    }

//    // 单张图片上传图片
//    public static void upload(String path, Map<String, String> map,
//                              Handler handler, int relizecode) {
//        // // keySet遍历key和value
//        RequestParams params = new RequestParams();
//        for (String key : map.keySet()) {
//
//            params.addBodyParameter(key, map.get(key));
//
//        }
//
//        params.addBodyParameter("files", new File(path));
//
//        util.send(HttpMethod.POST, Constants.POSTIMG, params,
//                new NetRequestCallBack(handler, relizecode));
//
//    }

    /*
     * 一般的网络请求接口的方法
     */
    public static void Httprequest(Map<String, String> map, String path,
                                   final Handler handler, int relizecode) {
        org.xutils.http.RequestParams params = new org.xutils.http.RequestParams(path);
//        RequestParams params = new RequestParams();
        // 循环便利Map集合取出所有的请求参数
        for (String key : map.keySet()) {

            // 取出session保持
            if (key.equals("Cookie")) {
                params.setHeader(key, map.get(key));
            }
            params.addBodyParameter(key, map.get(key));
        }
//        // 进行网络请求
//        util.send(HttpMethod.POST, path, params,
//                new NetRequestCallBack(handler, relizecode));

        x.http().post(params, new NetRequestCallBack(handler, relizecode));//执行网络请求
    }

    /**
     * Xutils3.0
     */
    public static void UpLoad(String path, Map<String, String> map,
                              Handler handler, int relizecode) {
        //Xiutls 3的网络请求方式
        org.xutils.http.RequestParams params = new org.xutils.http.RequestParams(Constants.POSTIMG);

        params.addBodyParameter("files", new File(path));
        for (String key : map.keySet()) {

            params.addBodyParameter(key, map.get(key));

        }
        x.http().post(params, new NetRequestCallBack(handler, relizecode));//执行网络请求

    }

}
