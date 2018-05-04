package com.zonesun.daiqian.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.widget.Toast;

import com.zonesun.daiqian.entity.ResearchOderEntity;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MyReceiver extends BroadcastReceiver {

    private List<ResearchOderEntity> list;
    private ArrayList<NameValuePair> nameValuePairs;
    private Context context;
    private ConnectivityManager manager;
    private SharedPreferences sp;
    int i = 0;

    private String id;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;

        checkNetWorkState();

    }

    public boolean checkNetWorkState() {

        boolean flag = false;
        manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();

        }

        if (!flag) {
            // setNetWork();
        } else {
            isNetworkAvailable();
        }
        return flag;
    }

    /**
     * 网络已经连接，然后去判断是wifi连接还是GPRS连接 设置一些自己的逻辑调用
     */
    private void isNetworkAvailable() {
        State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        // 判断为wifi状态下才加载广告，如果是GPRS手机网络则不加载！
        if (wifi == State.CONNECTED || wifi == State.CONNECTING) {
            Toast.makeText(context, "wifi is open! wifi", Toast.LENGTH_SHORT)
                    .show();


////			System.out.println("------list---" + list.toString());
//
//			if (list != null && list.size() != 0) {
//				for (i = 0; i < list.size(); i++) {
//
//					// 申请人姓名
//					String sqrxm = list.get(i).getSqrxm();
//					if (sqrxm.equals("")) {
//
//						return;
//					}
//
//					// 证件类型
//					String zjlx = list.get(i).getZjlx();
//					if (zjlx.equals("")) {
//
//						return;
//					}
//
//					// 证件号码
//					String zjhm = list.get(i).getZjhm();
//					if (zjhm.equals("")) {
//
//						return;
//					}
//
//					// 手机号码
//					String sjhm = list.get(i).getSjhm();
//
//					if (sjhm.equals("")) {
//
//						return;
//					}
//
//					id = list.get(i).getId() + "";
//					System.out.println("==============id" + id);
//
//					nameValuePairs = new ArrayList<NameValuePair>();
//					nameValuePairs.add(new BasicNameValuePair("equip", "4"));
//					// 申请人姓名
//					nameValuePairs.add(new BasicNameValuePair("name", sqrxm));
//					// 申请人证件类型
//					nameValuePairs
//							.add(new BasicNameValuePair("certtype", zjlx));
//					// 申请人证件号码
//					nameValuePairs.add(new BasicNameValuePair("certnum", zjhm));
//					// 手机号码
//					nameValuePairs.add(new BasicNameValuePair("phone", sjhm));
//					// 裸车价格
//					nameValuePairs.add(new BasicNameValuePair("onlycar", list
//							.get(i).getLcjg()));
//					// 购车品牌
//					nameValuePairs.add(new BasicNameValuePair("pp", list.get(i)
//							.getGcpp()));
//					// 进口车标志
//					nameValuePairs.add(new BasicNameValuePair("isjk", list.get(
//							i).getJkcbz()));
//					// 车型
//					nameValuePairs.add(new BasicNameValuePair("cartype", list
//							.get(i).getCx()));
//					// 排气量
//					nameValuePairs.add(new BasicNameValuePair("pql", list
//							.get(i).getPql()));
//					sp = context.getSharedPreferences("login",
//							context.MODE_PRIVATE);
//					String MYCOOKIES = sp.getString("MYCOOKIES", null);
//					HttpUtils httpUtils = new HttpUtils();
//					RequestParams params = new RequestParams();
//					params.addBodyParameter(nameValuePairs);
//					params.setHeader("Cookie", "JSESSIONID=" + MYCOOKIES);
//					httpUtils.send(HttpMethod.POST, Constants.DQYWADD, params,
//							new RequestCallBack<String>() {
//								@Override
//								public void onFailure(HttpException arg0,
//										String arg1) {
//									Toast.makeText(context, "网络访问失败",
//											Toast.LENGTH_SHORT).show();
//								}
//
//								@Override
//								public void onSuccess(ResponseInfo<String> arg0) {
//									Toast.makeText(context,
//											"网络访问成功" + arg0.result,
//											Toast.LENGTH_SHORT).show();
//									/*
//									 * List<ResearchOderEntity>
//									 * deleteResearchOderById = sqliteUtils
//									 * .DeleteResearchOderById(id);
//									 */
//
//									/*
//									 * System.out.println("-------------剩余的数据是"
//									 * + deleteResearchOderById.toString());
//									 */
//
//								}
//							});
//
//				}
//
////				if (i >= list.size()) {
////
////
////				}
//
//			}

        }

    }

}
