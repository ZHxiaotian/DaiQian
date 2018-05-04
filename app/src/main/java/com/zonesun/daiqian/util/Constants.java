package com.zonesun.daiqian.util;

/**
 * 所有的接口类
 *
 * @author Administrator
 */
public class Constants {

    //	http://139.129.233.52:8888/DQZF/index.do 管理后台数据接口
//	 public static String IP = "192.168.2.145:8888";// 内网地址
    public static String IP = "139.129.233.52:8888"; // 外网地址 正试使用的外网地址
//    public static  String IP="121.28.85.150:8888";
    // 登录的网址
    public static final String LOGINURL = "http://" + IP + "/DQZF/doLogin.do";
    // 获取巡检商户内容
    public static final String GETXJSHNR = "http://" + IP
            + "/DQZF/o/getmerchantAll.do";
    // 获取巡检内容
    public static final String GETRCXJNR = "http://" + IP
            + "/DQZF/o/getposxj.do";
    // /DQZF/o/doSelectAuth.do
    // 贷钱 入户客户信息
    public static final String DQADDKHXX = "http://" + IP//
            + "/DQZF/dq/savedqyw.do";
    // 贷钱获取商户档案 客户户案
    public static final String DQKHHA = "http://" + IP
            + "/DQZF/o/getcustomerfile.do";
    // 获取选中的【客户信息】数据接口:
    public static final String DQKHXX = "http://" + IP
            + "/DQZF/o/getcustomerfile2.do";
    // 获取【贷前业务】数据接口
    public static final String DQYW = "http://" + IP + "/DQZF/dq/getdqyw.do";
    // 2添加【贷前业务】接口
    public static final String DQYWADD = "http://" + IP + "/DQZF/dq/adddqyw.do";
    // 获取侧滑数据
    public static final String DQCHLB = "http://" + IP
            + "/DQZF/dq/getdqywPersonal.do";
    // 【调研报告管理查询】数据接口
    public static final String DQDYBGADD = "http://" + IP
            + "/DQZF/dq/adddqReport.do";
    // 个人信息接口
    public static final String DQPERSONNAL = "http://" + IP
            + "/DQZF/o/getSelf.do";
    // 公告通知
    public static final String POSTINFORM = "http://" + IP
            + "/DQZF/o/getnoticeAll.do";
    // 上传图片的接口
    public static final String POSTIMG = "http://" + IP + "/DQZF/doUpload.do";
    // 上传视频的接口
    public static final String POSTVIDEO = "http://" + IP
            + "/DQZF/doUploadVideo.do";
    // 调研报告
    public static final String DYBG = "http://" + IP
            + "/DQZF/dq/getdqywById.do?applyid=";
    // 身份证验证
    public static final String SFZYZURL = "http://" + IP
            + "/DQZF/o/doCheckIdCard.do";

    // 征信认证 http://123.56.180.246:9999/DQZF/o/doSelectAuth.do?customerid=1
    public static final String ZXURL = "http://" + IP
            + "/DQZF/o/doSelectAuth.do";
    // http://123.56.180.246:9999/DQZF/o/doSelectAuth.do
    // 银行卡消费分析
    public static final String YHKXFFXURL = "http://" + IP
            + "/DQZF/o/doCheckCardSpend.do";

    // 获取网络图片网址
    public static final String GETIMGURL = "http://" + IP + "/DQZF/upload/img";
    // 获取调研报告接口
    public static final String GETDYBGURL = "http://" + IP
            + "/DQZF/dq/dq/getdqywByIdpage.do";
    // 人脸识别数据上传
    public static final String POSTRLSBURL = "http://" + IP
            + "/DQZF/o/doInsertAuthStatus.do";
    // 获取费率
    public static final String GETPERIODURL = "http://" + IP
            + "/DQZF/dq/doGetRate.do";
    // 银行获取查询列表
    public static final String POSTBankInquireForm = "http://" + IP
            + "/DQZF/dq/doSelectAuthByUser.do";
    // 银行添加信查询
    public static final String POSTBankAddInquire = "http://" + IP
            + "/DQZF/dq/doInsertAuth.do";
    // http://localhost:8888/DQZF/dq/doInsertAuth.do
    // 征信查询担任查询
    public static final String POSTBankPersonSerach = "http://" + IP
            + "/DQZF/dq/doSelectAuthByUser.do";
    // 获取头像
    // public static final String HEADIMGURL = "http://" + IP + "/DQZF";
    // 修改头像
    public static final String UPDATEHEADIMG = "http://" + IP
            + "/DQZF/o/editUserByUsercode.do";
    // 登陆后更新通知的推送接口。。。。
    public static final String UPDATEMSGPUSH = "http://" + IP
            + "/DQZF/o/doUpdateToken.do";
    //获取kabin数据
    public static final String CARDBINURL = "http://" + IP + "/DQZF/dq/getCardBinList.do";
    //根据卡bin获取对应的卡种类 类别  品种等信息
    public static final String CARDMESSAGEURL = "http://" + IP + "/DQZF/dq/getCardBin.do";


    //获取身份证信息的的接口
    public static final String GETCARDINFO="https://way.jd.com/VerifyIdcard/J84";
    //野狗视频通话的videoid
    public static final String WILDDOG_VIDEO_ID = "wd3101954701gypjgb";

    public static final String  POSTOPENCARD="http://"+IP+"/DQZF/dq/addKkss.do";

    //先放款后抵押提交数据接口
    public static final String POSTFIRSTLENDING="http://"+IP+"/DQZF/dq/savedqywxfk.do";

}
