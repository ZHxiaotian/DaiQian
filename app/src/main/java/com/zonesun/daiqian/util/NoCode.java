package com.zonesun.daiqian.util;

/**
 * 
 * @author Administrator
 * 
 */
public class NoCode {

	// 登陆的队列请求码
	public static final int NOHTTP_WHAT_LOGIN = 0x01;

	// 上传单张图片

	public static final int NOHTTP_WHAT_UPSINGLEJPG = 0x02;

	// 上传多张图片
	public static final int NOHTTP_WHAT_UPMOREJPG = 0x03;

	// 征信查询单个查询
	public static final int NOHTTP_WHAT_SEARCHZX = 0x04;
	// 征信查询查询进度全部查询
	public static final int NOHTTP_WHAT_ZXCXJD = 0x05;

	// 入户调查 显示策划列表请求数据
	public static final int NOHTTP_WHAT_RHDCCEDATA = 0x06;
    //入户调查显示分期付款期数的网络请求在MainActivity完成
	public static final int NOHTTP_WHAT_RHDCFQFKQS=0x07;
	//更新通知友盟推送的状态码
	public static final int NOHTTP_WHAT_UPDATEUMMSGPUSH=0x08;
	public static final int NOHTTP_WHAT_RHDCLOADMORE=0x09;
	//获取开卡申请卡bin数据
	public static final int NOHTTP_WHAT_GETCARDBINS=0x10;
	public static final int NOHTTP_WHAT_GETCARDBINSMSG=0x11;
	//调用京东万象金融接口获取身份证信息
	public static final int NOHTTP_WHAT_GETIDCARDINFO=0x12;
    //开卡申请添加的接口
	public static final int NOHTTP_WHAT_POSTOPENCARD=0x13;
}
