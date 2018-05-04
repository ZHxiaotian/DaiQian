package com.zonesun.daiqian.util;

import java.io.File;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json与Object转换类
 * 
 * @author guoyanlu
 * 
 */

public class JsonUtils {
	/**
	 * Json转换成对象
	 * 
	 * @param json字符串
	 * @param 对象类型
	 * @return 对象
	 */
	public static Object fromJSON(String jsonString, Type targetType) {
		Object object = null;
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		Gson gson = builder.create();
		object = gson.fromJson(jsonString, targetType);
		return object;

	}

	/**
	 * 对象转换成json
	 * 
	 * @param 对象
	 * @return json字符串
	 */
	public static String toJSON(Object objectVal) {
		// GsonBuilder builder = new GsonBuilder();
		// builder.serializeNulls();
		// Gson gson = builder.create();
		Gson gson = new Gson();
		return gson.toJson(objectVal);

	}

	public static String toResult(String str) {

		if ("1-公务员".equals(str)) {

			str = "1";
		} else if ("2-事业单位员工".equals(str)) {
			str = "2";
		} else if ("3-其它行业职员".equals(str)) {
			str = "3";
		} else if ("4-军人".equals(str)) {
			str = "4";
		} else if ("5-自由职业者".equals(str)) {
			str = "5";
		} else if ("6-工人".equals(str)) {
			str = "6";
		} else if ("7-农民".equals(str)) {
			str = "7";
		} else if ("8-其它".equals(str)) {
			str = "8";
		} else if ("10-邮电通讯行业员".equals(str)) {
			str = "10";
		} else if ("11-房地产行业职员".equals(str)) {
			str = "11";
		} else if ("12-交通运输行业职员".equals(str)) {
			str = "12";
		} else if ("13-法律/司法行业职员".equals(str)) {
			str = "13";
		} else if ("14-文化/娱乐/体育行业职员".equals(str)) {
			str = "14";
		} else if ("15-媒介/广告行业职员".equals(str)) {
			str = "15";
		} else if ("16-科研/教育行业职员".equals(str)) {
			str = "16";
		} else if ("17-学生".equals(str)) {
			str = "17";
		} else if ("18-计算机/网络行业职员".equals(str)) {
			str = "18";
		} else if ("19-商业贸易行业职员".equals(str)) {
			str = "19";
		} else if ("20-银行/金融/证券/投资行业职员".equals(str)) {
			str = "20";
		} else if ("21-税务行业职员".equals(str)) {
			str = "21";
		} else if ("22-咨询行业职员".equals(str)) {
			str = "22";
		} else if ("23-社会服务行业职员".equals(str)) {
			str = "23";
		} else if ("24-旅游/饭店行业职员".equals(str)) {
			str = "24";
		} else if ("25-健康/医疗服务行业职员".equals(str)) {
			str = "25";
		} else if ("26-管理人员".equals(str)) {
			str = "26";
		} else if ("27-技术人员".equals(str)) {
			str = "27";
		} else if ("28-文体明星".equals(str)) {
			str = "28";
		} else if ("29-无职业".equals(str)) {
			str = "29";
		} else if ("30-私人业主".equals(str)) {
			str = "30";
		} else if ("31-制造业职员".equals(str)) {
			str = "31";
		} else {
			str = "";
		}

		return str;

	}

	public static String toRquest(String str) {

		if ("1".equals(str)) {

			str = "1-公务员";
		} else if ("2".equals(str)) {
			str = "2-事业单位员工";
		} else if ("3".equals(str)) {
			str = "3-其它行业职员";
		} else if ("4".equals(str)) {
			str = "4-军人";
		} else if ("5".equals(str)) {
			str = "5-自由职业者";
		} else if ("6".equals(str)) {
			str = "6-工人";
		} else if ("7".equals(str)) {
			str = "7-农民";
		} else if ("8".equals(str)) {
			str = "8-其它";
		} else if ("10".equals(str)) {
			str = "10-邮电通讯行业员";
		} else if ("11".equals(str)) {
			str = "11-房地产行业职员";
		} else if ("12".equals(str)) {
			str = "12-交通运输行业职员";
		} else if ("13".equals(str)) {
			str = "13-法律/司法行业职员";
		} else if ("14".equals(str)) {
			str = "14-文化/娱乐/体育行业职员";
		} else if ("15".equals(str)) {
			str = "15-媒介/广告行业职员";
		} else if ("16".equals(str)) {
			str = "16-科研/教育行业职员";
		} else if ("17".equals(str)) {
			str = "17-学生";
		} else if ("18".equals(str)) {
			str = "18-计算机/网络行业职员";
		} else if ("19".equals(str)) {
			str = "19-商业贸易行业职员";
		} else if ("20".equals(str)) {
			str = "20-银行/金融/证券/投资行业职员";
		} else if ("21".equals(str)) {
			str = "21-税务行业职员";
		} else if ("22".equals(str)) {
			str = "22-咨询行业职员";
		} else if ("23".equals(str)) {
			str = "23-社会服务行业职员";
		} else if ("24".equals(str)) {
			str = "24-旅游/饭店行业职员";
		} else if ("25".equals(str)) {
			str = "25-健康/医疗服务行业职员";
		} else if ("26".equals(str)) {
			str = "26-管理人员";
		} else if ("27".equals(str)) {
			str = "27-技术人员";
		} else if ("28".equals(str)) {
			str = "28-文体明星";
		} else if ("29".equals(str)) {
			str = "29-无职业";
		} else if ("30".equals(str)) {
			str = "30-私人业主";
		} else if ("31".equals(str)) {
			str = "31-制造业职员";
		} else {
			str = "";
		}

		return str;

	}

	/**
	 * 开卡人申请补充与开卡人的关系
	 * 
	 * @param str
	 * @return
	 */
	public static String toResultGc(String str) {

		if ("1-父子".equals(str)) {

			str = "1";
		} else if ("2-母子".equals(str)) {
			str = "2";
		} else if ("3-兄弟姐妹".equals(str)) {
			str = "3";
		} else if ("4-亲属".equals(str)) {
			str = "4";
		} else if ("5-夫妻".equals(str)) {
			str = "5";
		} else if ("6-同学".equals(str)) {
			str = "6";
		} else if ("7-同乡".equals(str)) {
			str = "7";
		} else if ("8-朋友".equals(str)) {
			str = "8";
		} else if ("9-同事".equals(str)) {
			str = "9";
		} else {
			str = "";
		}

		return str;

	}

	/**
	 * 开卡人申请补充与开卡人的关系
	 * 
	 * @param str
	 * @return
	 */
	public static String toRquestGc(String str) {

		if ("1".equals(str)) {

			str = "1-父子";
		} else if ("2".equals(str)) {
			str = "2-母子";
		} else if ("3".equals(str)) {
			str = "3-兄弟姐妹";
		} else if ("4".equals(str)) {
			str = "4-亲属";
		} else if ("5".equals(str)) {
			str = "5-夫妻";
		} else if ("6".equals(str)) {
			str = "6-同学";
		} else if ("7".equals(str)) {
			str = "7-同乡";
		} else if ("8".equals(str)) {
			str = "8-朋友";
		} else if ("9".equals(str)) {
			str = "9-同事";
		} else {
			str = "";
		}

		return str;

	}

	/**
	 * 删除文件的方法
	 * 
	 * @param file
	 */
	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			// if (file.isFile()) { // 判断是否是文件
			// file.delete();
			// } else if (file.isDirectory()) {
			// File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
			// for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
			// this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
			// }
			// }
			file.delete();
		} else {
			System.out.println("文件不存在！" + "\n");
		}
	}

	public static String Education(String str) {

		if (str.equals("1")) {
			str = "国家机关";
		} else if (str.equals("2")) {
			str = "国有企业";
		} else if (str.equals("3")) {
			str = "股份制企业";
		} else if (str.equals("4")) {
			str = "事业单位";
		} else if (str.equals("5")) {
			str = "集体企业";
		} else if (str.equals("6")) {
			str = "私营企业";
		} else if (str.equals("7")) {
			str = "外资企业";
		} else if (str.equals("8")) {
			str = "其它";
		} else {
			str = "请选择";
		}

		return str;
	}

	public static String Toemployer(String str) {

		if (str.equals("1")) {
			str = "国家机关";
		} else if (str.equals("2")) {
			str = "国有企业";
		} else if (str.equals("3")) {
			str = "股份制企业";
		} else if (str.equals("4")) {
			str = "事业单位";
		} else if (str.equals("5")) {
			str = "集体企业";
		} else if (str.equals("6")) {
			str = "私营企业";
		} else if (str.equals("7")) {
			str = "外资企业";
		} else if (str.equals("8")) {
			str = "其它";
		} else {
			str = "请选择";
		}

		return str;
	}

	public static String Sqkpz(String str) {

		if (str.equals("1-VISA")) {
			str = "1";
		} else if (str.equals("2-MASTER")) {
			str = "2";
		} else if (str.equals("3-运通")) {
			str = "3";
		} else if (str.equals("4-银联")) {
			str = "4";
		} else if (str.equals("5-JCB")) {
			str = "5";
		} else if (str.equals("6-大来")) {
			str = "6";
		}  else {
			str = "";
		}

		return str;
	}

	public static String Sqkclass(String str) {

		if (str.equals("0-金卡")) {
			str = "0";
		} else if (str.equals("1-普卡")) {
			str = "1";
		} else if (str.equals("2-白金卡")) {
			str = "2";
		} else if (str.equals("5-黑金卡")) {
			str = "5";
		}  else {
			str = "";
		}

		return str;
	}
	public static String Sqkpjz(String str) {

		if (str.equals("0-磁条")) {
			str = "0";
		} else if (str.equals("1-磁条+IC")) {
			str = "1";
		} else if (str.equals("3-磁条+非接触+IC")) {
			str = "3";
		} else if (str.equals("4-IC")) {
			str = "4";
		} else if (str.equals("6-IC+非接触")) {
			str = "6";
		}  else {
			str = "";
		}

		return str;
	}
	public static String SqrZw(String str) {

		if (str.equals("0-未知")) {
			str = "0";
		} else if (str.equals("1-国家主席、副主席、总理级副总理、国务委员级")) {
			str = "1";
		} else if (str.equals("2-部、省级、副部、副省级")) {
			str = "2";
		} else if (str.equals("3-董事/司、局、地、厅级")) {
			str = "3";
		} else if (str.equals("4-总经理/县处级")) {
			str = "4";
		} else if (str.equals("5-科级/部门经理")) {
			str = "5";
		} else if (str.equals("6-职员/科员级")) {
			str = "6";
		}  else {
			str = "";
		}

		return str;
	}
}
