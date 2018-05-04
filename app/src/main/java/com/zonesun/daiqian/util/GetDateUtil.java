package com.zonesun.daiqian.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateUtil {

	
	
	
	public static  String getCurrentTime(){
		
		
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy年MM月dd日    HH:mm:ss     ");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String str = formatter.format(curDate);
		return str;
		
		
	}
	
	
}
