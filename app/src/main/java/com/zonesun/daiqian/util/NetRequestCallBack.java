package com.zonesun.daiqian.util;

import android.os.Handler;
import android.os.Message;
import android.webkit.MimeTypeMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.zonesun.daiqian.fragment.FirstLendingFragment;
import com.zonesun.daiqian.fragment.RuhuSurveyFragment;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xutils.common.Callback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 网络请求后的回调接口
 * 
 * @author Administrator
 * 
 */
public class NetRequestCallBack implements Callback.CommonCallback<String> {

	// 定义一个handler用来将网络请求结果发送到主线程
	Handler handler;
	Message message;
	private int relizecode;
    public NetRequestCallBack(){}
	public NetRequestCallBack(Handler handler, int relizecode) {
		super();
		this.handler = handler;
		this.relizecode = relizecode;
		message = Message.obtain();

	}

	@Override
	public void onSuccess(String result) {
		switch (relizecode) {
			// 图片上传的
			case RequestCode.newinquire_photoupload_relizecode:
				message.arg1 = RequestCode.newinquire_photoupload_onsuccess;
				message.obj = result;
				handler.sendMessage(message);
				break;
			// 数据提交的
			case RequestCode.newinquire_datacommit_relizecode:
				message.arg1 = RequestCode.newinquire_datacommit_onsuccess;
				message.obj =result;
				handler.sendMessage(message);

				break;
			case RequestCode.zhengxinresh_datareq_relizecode:
				message.arg1 = RequestCode.zhenxinresh_datareq_onsuccess;
				message.obj = result;

				handler.sendMessage(message);
			default:
				break;
		}
	}

	@Override
	public void onError(Throwable ex, boolean isOnCallback) {
		switch (relizecode) {
			// 图片上传的
			case RequestCode.newinquire_photoupload_relizecode:
				message.arg1 = RequestCode.newinquire_photoupload_onFailure;
				message.obj = ex.toString();
				handler.sendMessage(message);
				break;
			// 数据提交的
			case RequestCode.newinquire_datacommit_relizecode:
				System.out.println(ex.toString());
				message.arg1 = RequestCode.newinquire_datacommit_onFailure;
				message.obj = ex.toString();
				handler.sendMessage(message);
				break;
			case RequestCode.zhengxinresh_datareq_relizecode:
				message.arg1 = RequestCode.zhengxinresh_datareq_onFailure;
				message.obj = ex.toString();

				handler.sendMessage(message);

				break;
			default:
				break;
		}
	}

	@Override
	public void onCancelled(CancelledException cex) {

	}

	@Override
	public void onFinished() {

	}

	/**
	 * 上传图片
	 */
	public void upload(List<String> list, final RuhuSurveyFragment fragment) {
		RequestParams params = new RequestParams();

		String mime = MimeTypeMap.getSingleton()
				.getMimeTypeFromExtension("png");

		String extra = list.get(list.size() - 1);

		params.addBodyParameter("extra", extra);

		for (int i = 0; i < list.size() - 1; i++) {
			params.addBodyParameter("files[" + i + "]", new File(list.get(i)),
					mime);
		}
		fragment.nameValuePairs1 = new ArrayList<NameValuePair>();
		fragment. nameValuePairs1.add(new BasicNameValuePair("jd", fragment.latitude + ""));
		fragment .nameValuePairs1.add(new BasicNameValuePair("wd",fragment. longitude + ""));
		params.addBodyParameter(fragment.nameValuePairs1);
		HttpUtils httpUtils = new HttpUtils();
		// httpUtils.configCurrentHttpCacheExpiry(1000 * 10); // 设置超时时间 10s
		// httpUtils.configTimeout(1000 * 10);// 设置连接超时时间
		// httpUtils.configSoTimeout(1000 * 10);// 设置连接超时时间
		httpUtils.send(HttpRequest.HttpMethod.POST, Constants.POSTIMG, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException e, String msg) {

						ToastUtil.showShort(fragment.getActivity(), "图片上传失败，检查一下服务器地址是否正确");
						fragment.mIndex += 1;
						if (fragment.mIndex == fragment.allImgList.size()) {
							fragment.alertDialog.dismiss();

							handler.sendEmptyMessage(0);
						}
					}

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {

						if (responseInfo.result != null) {
							fragment.mIndex += 1;
							String result = responseInfo.result;
							List<String> list = new Gson().fromJson(result,
									new TypeToken<List<String>>() {
									}.getType());
							System.out.println(result);
							String replace = result.replace("[", "")
									.replace("]", "").replace("\"", "");
							String[] split = replace.split(",");
							String num = split[split.length - 1];
							int k = Integer.parseInt(num);
							switch (k) {
								case 0:
									list.remove("0");
									if (fragment.sfzlList != null && fragment.sfzlList.size() > 0) {
										System.out.println(fragment.sfzlList.toString()
												+ ".....");
										for (String url : fragment.sfzlList) {
											list.add(url);
										}
									}

									// getsfzzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									fragment.getsfzzmList = new Gson().toJson(list);
									if (fragment.sfzlbnv != null
											&& fragment.nameValuePairs.contains(fragment.sfzlbnv)) {
										fragment.nameValuePairs.remove(fragment.sfzlbnv);
										fragment.sfzlbnv = new BasicNameValuePair(
												"cert1_url", fragment.getsfzzmList);
										fragment.nameValuePairs.add(fragment.sfzlbnv);

									} else {

										fragment.sfzlbnv = new BasicNameValuePair(
												"cert1_url", fragment.getsfzzmList);
										fragment.nameValuePairs.add(fragment.sfzlbnv);
									}
									System.out.println(fragment.getsfzzmList + "......jip");

									break;

								case 1:
									list.remove("1");

									if (fragment.dzxqList != null && fragment.dzxqList.size() > 0) {

										for (String url : fragment.dzxqList) {
											list.add(url);
										}
									}
									fragment.getsfzfmList = new Gson().toJson(list);
									// getsfzfmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									if (fragment.dzxqbnv != null
											&& fragment.nameValuePairs.contains(fragment.dzxqbnv)) {
										fragment.nameValuePairs.remove(fragment.dzxqbnv);
										fragment.dzxqbnv = new BasicNameValuePair(
												"cert2_url", fragment.getsfzfmList);
										fragment.nameValuePairs.add(fragment.dzxqbnv);
									} else {
										fragment.dzxqbnv = new BasicNameValuePair(
												"cert2_url", fragment.getsfzfmList);
										fragment.nameValuePairs.add(fragment.dzxqbnv);
									}

									break;
								case 2:
									list.remove("2");
									if (fragment.dzdwList != null && fragment.dzdwList.size() > 0) {

										for (String url : fragment.dzdwList) {
											list.add(url);
										}
									}
									fragment.getscsfzmList = new Gson().toJson(list);
									// getscsfzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.dtdwbnv != null
											&& fragment.nameValuePairs.contains(fragment.dtdwbnv)) {
										fragment.nameValuePairs.remove(fragment.dtdwbnv);
										fragment.dtdwbnv = new BasicNameValuePair(
												"cert3_url", fragment.getscsfzmList);
										fragment.nameValuePairs.add(fragment.dtdwbnv);
									} else {
										fragment.dtdwbnv = new BasicNameValuePair(
												"cert3_url",fragment. getscsfzmList);
										fragment.nameValuePairs.add(fragment.dtdwbnv);
									}
									System.out.println("))))))))))))"
											+ fragment.getscsfzmList + "=====" + k);

									break;
								case 3:

									list.remove("3");
									if (fragment.srwjzmList != null && fragment.srwjzmList.size() > 0) {

										for (String url : fragment.srwjzmList) {
											list.add(url);
										}
									}
									fragment.getydcyhyList = new Gson().toJson(list);
									// getydcyhyList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.srwjzmbnv != null
											&& fragment.nameValuePairs.contains(fragment.srwjzmbnv)) {
										fragment.nameValuePairs.remove(fragment.srwjzmbnv);
										fragment.srwjzmbnv = new BasicNameValuePair(
												"togather_url", fragment.getydcyhyList);
										fragment.nameValuePairs.add(fragment.srwjzmbnv);
									} else {
										fragment.srwjzmbnv = new BasicNameValuePair(
												"togather_url", fragment.getydcyhyList);
										fragment.nameValuePairs.add(fragment.srwjzmbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getydcyhyList + "=====" + k);

									break;

								case 4:

									list.remove("4");
									if (fragment.gcfpwjzmList != null
											&& fragment.gcfpwjzmList.size() > 0) {

										for (String url : fragment.gcfpwjzmList) {
											list.add(url);
										}
									}

									fragment.getzzzmList = new Gson().toJson(list);
									// getzzzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.gcfpwjbnv != null
											&&fragment. nameValuePairs.contains(fragment.gcfpwjbnv)) {
										fragment.nameValuePairs.remove(fragment.gcfpwjbnv);
										fragment.gcfpwjbnv = new BasicNameValuePair(
												"zzzm_url", fragment.getzzzmList);
										fragment.nameValuePairs.add(fragment.gcfpwjbnv);
									} else {
										fragment.gcfpwjbnv = new BasicNameValuePair(
												"zzzm_url", fragment.getzzzmList);
										fragment.nameValuePairs.add(fragment.gcfpwjbnv);
									}

									System.out.println("))))))))))))" + fragment.getzzzmList
											+ "=====" + k);

									break;
								case 5:
									list.remove("5");
									if (fragment.sfkwjzmList != null
											&& fragment.sfkwjzmList.size() > 0) {

										for (String url : fragment.sfkwjzmList) {
											list.add(url);
										}
									}

									fragment.getsqrxqList = new Gson().toJson(list);
									// getsqrxqList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.sfkzmwjbnv != null
											&& fragment.nameValuePairs.contains(fragment.sfkzmwjbnv)) {
										fragment.nameValuePairs.remove(fragment.sfkzmwjbnv);
										fragment.sfkzmwjbnv = new BasicNameValuePair(
												"xq_url", fragment.getsqrxqList);
										fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
									} else {
										fragment.sfkzmwjbnv = new BasicNameValuePair(
												"xq_url", fragment.getsqrxqList);
										fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
									}
									System.out.println("))))))))))))"
											+ fragment.getsqrxqList + "=====" + k);

									break;

								case 6:
									list.remove("6");
									if (fragment.cldiwjzmList != null
											&& fragment.cldiwjzmList.size() > 0) {

										for (String url : fragment.cldiwjzmList) {
											list.add(url);
										}
									}
									fragment.getsqrszlhList = new Gson().toJson(list);
									// getsqrszlhList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.cldiwjzmbnv != null
											&&fragment. nameValuePairs.contains(fragment.cldiwjzmbnv)) {
										fragment.nameValuePairs.remove(fragment.cldiwjzmbnv);
										fragment.cldiwjzmbnv = new BasicNameValuePair(
												"lh_url", fragment.getsqrszlhList);
										fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
									} else {
										fragment.cldiwjzmbnv = new BasicNameValuePair(
												"lh_url", fragment.getsqrszlhList);
										fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszlhList + "=====" + k);

									break;

								case 7:
									list.remove("7");
									if (fragment.clbxdwjList != null
											&& fragment.clbxdwjList.size() > 0) {

										for (String url : fragment.clbxdwjList) {
											list.add(url);
										}
									}
									fragment.getsqrszdyList = new Gson().toJson(list);
									// getsqrszdyList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.clbxdwjbnv != null
											&& fragment.nameValuePairs.contains(fragment.clbxdwjbnv)) {
										fragment.nameValuePairs.remove(fragment.clbxdwjbnv);
										fragment.clbxdwjbnv = new BasicNameValuePair(
												"dy_url", fragment.getsqrszdyList);
										fragment.nameValuePairs.add(fragment.clbxdwjbnv);
									} else {
										fragment.clbxdwjbnv = new BasicNameValuePair(
												"dy_url", fragment.getsqrszdyList);
										fragment.nameValuePairs.add(fragment.clbxdwjbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszdyList + "=====" + k);

									break;

								case 8:
									list.remove("8");
									if (fragment.gchewjzmList != null
											&&fragment. gchewjzmList.size() > 0) {

										for (String url :fragment. gchewjzmList) {
											list.add(url);
										}
									}
									fragment.getsqrszmphList = new Gson().toJson(list);
									// getsqrszmphList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.gchtbnv != null
											&&fragment. nameValuePairs.contains(fragment.gchtbnv)) {
										fragment.nameValuePairs.remove(fragment.gchtbnv);
										fragment.gchtbnv = new BasicNameValuePair("mph_url",
												fragment.getsqrszmphList);
										fragment.nameValuePairs.add(fragment.gchtbnv);
									} else {
										fragment.gchtbnv = new BasicNameValuePair("mph_url",
												fragment.getsqrszmphList);
										fragment.nameValuePairs.add(fragment.gchtbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszmphList + "=====" + k);

									break;

								case 9:
									list.remove("9");
									if (fragment.zxbgwjzmList != null
											&& fragment.zxbgwjzmList.size() > 0) {

										for (String url : fragment.zxbgwjzmList) {
											list.add(url);
										}
									}
									fragment.getdwList = new Gson().toJson(list);
									// getdwList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									if (fragment.zxbgbnv != null
											&&fragment. nameValuePairs.contains(fragment.zxbgbnv)) {
										fragment.nameValuePairs.remove(fragment.zxbgbnv);
										fragment.	zxbgbnv = new BasicNameValuePair("dw_url",
												fragment.getdwList);
										fragment.nameValuePairs.add(fragment.zxbgbnv);
									} else {
										fragment.zxbgbnv = new BasicNameValuePair("dw_url",
												fragment.getdwList);
										fragment.nameValuePairs.add(fragment.zxbgbnv);
									}

									System.out.println("))))))))))))" +fragment. getdwList
											+ "=====" + k);

									break;

								default:
									break;
							}

							if (fragment.mIndex == fragment.allImgList.size()) {

								fragment.alertDialog.dismiss();
								fragment.handler.sendEmptyMessage(0);
							}
						}

					}
				});
	}



	/**
	 * 上传图片
	 */
	public void upload(List<String> list, final FirstLendingFragment fragment) {
		RequestParams params = new RequestParams();

		String mime = MimeTypeMap.getSingleton()
				.getMimeTypeFromExtension("png");

		String extra = list.get(list.size() - 1);

		params.addBodyParameter("extra", extra);

		for (int i = 0; i < list.size() - 1; i++) {
			params.addBodyParameter("files[" + i + "]", new File(list.get(i)),
					mime);
		}
		fragment.nameValuePairs1 = new ArrayList<NameValuePair>();
		fragment. nameValuePairs1.add(new BasicNameValuePair("jd", fragment.latitude + ""));
		fragment .nameValuePairs1.add(new BasicNameValuePair("wd",fragment. longitude + ""));
		params.addBodyParameter(fragment.nameValuePairs1);
		HttpUtils httpUtils = new HttpUtils();
		// httpUtils.configCurrentHttpCacheExpiry(1000 * 10); // 设置超时时间 10s
		// httpUtils.configTimeout(1000 * 10);// 设置连接超时时间
		// httpUtils.configSoTimeout(1000 * 10);// 设置连接超时时间
		httpUtils.send(HttpRequest.HttpMethod.POST, Constants.POSTIMG, params,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException e, String msg) {

						ToastUtil.showShort(fragment.getActivity(), "图片上传失败，检查一下服务器地址是否正确");
						fragment.mIndex += 1;
						if (fragment.mIndex == fragment.allImgList.size()) {
							fragment.alertDialog.dismiss();

                            fragment.handler.sendEmptyMessage(0);
						}
					}

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {

						if (responseInfo.result != null) {
							fragment.mIndex += 1;
							String result = responseInfo.result;
							List<String> list = new Gson().fromJson(result,
									new TypeToken<List<String>>() {
									}.getType());
							System.out.println(result);
							String replace = result.replace("[", "")
									.replace("]", "").replace("\"", "");
							String[] split = replace.split(",");
							String num = split[split.length - 1];
							int k = Integer.parseInt(num);
							switch (k) {
								case 0:
									list.remove("0");
									if (fragment.sfzlList != null && fragment.sfzlList.size() > 0) {
										System.out.println(fragment.sfzlList.toString()
												+ ".....");
										for (String url : fragment.sfzlList) {
											list.add(url);
										}
									}

									// getsfzzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									fragment.getsfzzmList = new Gson().toJson(list);
									if (fragment.sfzlbnv != null
											&& fragment.nameValuePairs.contains(fragment.sfzlbnv)) {
										fragment.nameValuePairs.remove(fragment.sfzlbnv);
										fragment.sfzlbnv = new BasicNameValuePair(
												"cert1_url", fragment.getsfzzmList);
										fragment.nameValuePairs.add(fragment.sfzlbnv);

									} else {

										fragment.sfzlbnv = new BasicNameValuePair(
												"cert1_url", fragment.getsfzzmList);
										fragment.nameValuePairs.add(fragment.sfzlbnv);
									}
									System.out.println(fragment.getsfzzmList + "......jip");

									break;

								case 1:
									list.remove("1");

									if (fragment.dzxqList != null && fragment.dzxqList.size() > 0) {

										for (String url : fragment.dzxqList) {
											list.add(url);
										}
									}
									fragment.getsfzfmList = new Gson().toJson(list);
									// getsfzfmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									if (fragment.dzxqbnv != null
											&& fragment.nameValuePairs.contains(fragment.dzxqbnv)) {
										fragment.nameValuePairs.remove(fragment.dzxqbnv);
										fragment.dzxqbnv = new BasicNameValuePair(
												"cert2_url", fragment.getsfzfmList);
										fragment.nameValuePairs.add(fragment.dzxqbnv);
									} else {
										fragment.dzxqbnv = new BasicNameValuePair(
												"cert2_url", fragment.getsfzfmList);
										fragment.nameValuePairs.add(fragment.dzxqbnv);
									}

									break;
								case 2:
									list.remove("2");
									if (fragment.dzdwList != null && fragment.dzdwList.size() > 0) {

										for (String url : fragment.dzdwList) {
											list.add(url);
										}
									}
									fragment.getscsfzmList = new Gson().toJson(list);
									// getscsfzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.dtdwbnv != null
											&& fragment.nameValuePairs.contains(fragment.dtdwbnv)) {
										fragment.nameValuePairs.remove(fragment.dtdwbnv);
										fragment.dtdwbnv = new BasicNameValuePair(
												"cert3_url", fragment.getscsfzmList);
										fragment.nameValuePairs.add(fragment.dtdwbnv);
									} else {
										fragment.dtdwbnv = new BasicNameValuePair(
												"cert3_url",fragment. getscsfzmList);
										fragment.nameValuePairs.add(fragment.dtdwbnv);
									}
									System.out.println("))))))))))))"
											+ fragment.getscsfzmList + "=====" + k);

									break;
								case 3:

									list.remove("3");
									if (fragment.srwjzmList != null && fragment.srwjzmList.size() > 0) {

										for (String url : fragment.srwjzmList) {
											list.add(url);
										}
									}
									fragment.getydcyhyList = new Gson().toJson(list);
									// getydcyhyList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.srwjzmbnv != null
											&& fragment.nameValuePairs.contains(fragment.srwjzmbnv)) {
										fragment.nameValuePairs.remove(fragment.srwjzmbnv);
										fragment.srwjzmbnv = new BasicNameValuePair(
												"togather_url", fragment.getydcyhyList);
										fragment.nameValuePairs.add(fragment.srwjzmbnv);
									} else {
										fragment.srwjzmbnv = new BasicNameValuePair(
												"togather_url", fragment.getydcyhyList);
										fragment.nameValuePairs.add(fragment.srwjzmbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getydcyhyList + "=====" + k);

									break;

								case 4:

									list.remove("4");
									if (fragment.gcfpwjzmList != null
											&& fragment.gcfpwjzmList.size() > 0) {

										for (String url : fragment.gcfpwjzmList) {
											list.add(url);
										}
									}

									fragment.getzzzmList = new Gson().toJson(list);
									// getzzzmList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.gcfpwjbnv != null
											&&fragment. nameValuePairs.contains(fragment.gcfpwjbnv)) {
										fragment.nameValuePairs.remove(fragment.gcfpwjbnv);
										fragment.gcfpwjbnv = new BasicNameValuePair(
												"zzzm_url", fragment.getzzzmList);
										fragment.nameValuePairs.add(fragment.gcfpwjbnv);
									} else {
										fragment.gcfpwjbnv = new BasicNameValuePair(
												"zzzm_url", fragment.getzzzmList);
										fragment.nameValuePairs.add(fragment.gcfpwjbnv);
									}

									System.out.println("))))))))))))" + fragment.getzzzmList
											+ "=====" + k);

									break;
								case 5:
									list.remove("5");
									if (fragment.sfkwjzmList != null
											&& fragment.sfkwjzmList.size() > 0) {

										for (String url : fragment.sfkwjzmList) {
											list.add(url);
										}
									}

									fragment.getsqrxqList = new Gson().toJson(list);
									// getsqrxqList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.sfkzmwjbnv != null
											&& fragment.nameValuePairs.contains(fragment.sfkzmwjbnv)) {
										fragment.nameValuePairs.remove(fragment.sfkzmwjbnv);
										fragment.sfkzmwjbnv = new BasicNameValuePair(
												"xq_url", fragment.getsqrxqList);
										fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
									} else {
										fragment.sfkzmwjbnv = new BasicNameValuePair(
												"xq_url", fragment.getsqrxqList);
										fragment.nameValuePairs.add(fragment.sfkzmwjbnv);
									}
									System.out.println("))))))))))))"
											+ fragment.getsqrxqList + "=====" + k);

									break;

								case 6:
									list.remove("6");
									if (fragment.cldiwjzmList != null
											&& fragment.cldiwjzmList.size() > 0) {

										for (String url : fragment.cldiwjzmList) {
											list.add(url);
										}
									}
									fragment.getsqrszlhList = new Gson().toJson(list);
									// getsqrszlhList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.cldiwjzmbnv != null
											&&fragment. nameValuePairs.contains(fragment.cldiwjzmbnv)) {
										fragment.nameValuePairs.remove(fragment.cldiwjzmbnv);
										fragment.cldiwjzmbnv = new BasicNameValuePair(
												"lh_url", fragment.getsqrszlhList);
										fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
									} else {
										fragment.cldiwjzmbnv = new BasicNameValuePair(
												"lh_url", fragment.getsqrszlhList);
										fragment.nameValuePairs.add(fragment.cldiwjzmbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszlhList + "=====" + k);

									break;

								case 7:
									list.remove("7");
									if (fragment.clbxdwjList != null
											&& fragment.clbxdwjList.size() > 0) {

										for (String url : fragment.clbxdwjList) {
											list.add(url);
										}
									}
									fragment.getsqrszdyList = new Gson().toJson(list);
									// getsqrszdyList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.clbxdwjbnv != null
											&& fragment.nameValuePairs.contains(fragment.clbxdwjbnv)) {
										fragment.nameValuePairs.remove(fragment.clbxdwjbnv);
										fragment.clbxdwjbnv = new BasicNameValuePair(
												"dy_url", fragment.getsqrszdyList);
										fragment.nameValuePairs.add(fragment.clbxdwjbnv);
									} else {
										fragment.clbxdwjbnv = new BasicNameValuePair(
												"dy_url", fragment.getsqrszdyList);
										fragment.nameValuePairs.add(fragment.clbxdwjbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszdyList + "=====" + k);

									break;

								case 8:
									list.remove("8");
									if (fragment.gchewjzmList != null
											&&fragment. gchewjzmList.size() > 0) {

										for (String url :fragment. gchewjzmList) {
											list.add(url);
										}
									}
									fragment.getsqrszmphList = new Gson().toJson(list);
									// getsqrszmphList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";

									if (fragment.gchtbnv != null
											&&fragment. nameValuePairs.contains(fragment.gchtbnv)) {
										fragment.nameValuePairs.remove(fragment.gchtbnv);
										fragment.gchtbnv = new BasicNameValuePair("mph_url",
												fragment.getsqrszmphList);
										fragment.nameValuePairs.add(fragment.gchtbnv);
									} else {
										fragment.gchtbnv = new BasicNameValuePair("mph_url",
												fragment.getsqrszmphList);
										fragment.nameValuePairs.add(fragment.gchtbnv);
									}

									System.out.println("))))))))))))"
											+ fragment.getsqrszmphList + "=====" + k);

									break;

								case 9:
									list.remove("9");
									if (fragment.zxbgwjzmList != null
											&& fragment.zxbgwjzmList.size() > 0) {

										for (String url : fragment.zxbgwjzmList) {
											list.add(url);
										}
									}
									fragment.getdwList = new Gson().toJson(list);
									// getdwList = result.substring(0,
									// result.lastIndexOf(","))
									// + "]";
									if (fragment.zxbgbnv != null
											&&fragment. nameValuePairs.contains(fragment.zxbgbnv)) {
										fragment.nameValuePairs.remove(fragment.zxbgbnv);
										fragment.	zxbgbnv = new BasicNameValuePair("dw_url",
												fragment.getdwList);
										fragment.nameValuePairs.add(fragment.zxbgbnv);
									} else {
										fragment.zxbgbnv = new BasicNameValuePair("dw_url",
												fragment.getdwList);
										fragment.nameValuePairs.add(fragment.zxbgbnv);
									}

									System.out.println("))))))))))))" +fragment. getdwList
											+ "=====" + k);

									break;

								default:
									break;
							}

							if (fragment.mIndex == fragment.allImgList.size()) {

								fragment.alertDialog.dismiss();
								fragment.handler.sendEmptyMessage(0);
							}
						}

					}
				});
	}




}
