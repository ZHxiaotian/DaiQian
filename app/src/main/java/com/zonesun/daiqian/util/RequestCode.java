package com.zonesun.daiqian.util;

public class RequestCode {

	// 请求识别码，让请求回调的接口识别是哪个网络请求例如 一个类的图片上传和数据提交就需要不同的求情识别码
	public static final int newinquire_photoupload_relizecode = 011;
	public static final int newinquire_datacommit_relizecode = 012;
	// 查询进度识别码
	public static final int zhengxinresh_datareq_relizecode = 013;
	// 所有请求结果的请求码
	// 图片上传
	public static final int newinquire_photoupload_onFailure = 001;
	public static final int newinquire_photoupload_onsuccess = 002;
	// 数据提交
	public static final int newinquire_datacommit_onFailure = 003;
	public static final int newinquire_datacommit_onsuccess = 004;
	// 查询进度结果请求码
	public static final int zhengxinresh_datareq_onFailure = 005;
	public static final int zhenxinresh_datareq_onsuccess = 006;

}
