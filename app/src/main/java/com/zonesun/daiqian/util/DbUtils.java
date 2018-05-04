package com.zonesun.daiqian.util;

import java.util.ArrayList;

import com.zonesun.daiqian.entity.Report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbUtils {
	private DBHelper dbHelper;
	private Context context;
	private SQLiteDatabase sqLiteDatabase;

	private final static String REPORT_Table = "report"; // 表名

	public DbUtils(Context context) {
		this.context = context;
	}

	/**
	 * 打开数据库
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void open() {
		dbHelper = new DBHelper(context);
		sqLiteDatabase = dbHelper.getWritableDatabase();
	}

	/**
	 * 关闭数据库
	 */
	public void close() {
		dbHelper.close();
	}

	public long saveReport(Report report) {
		long result = 0;
		Cursor cursor = sqLiteDatabase.rawQuery(
				"select * from report where seqno='" + report.getSeqno()
						+ "' ", null);

		if (cursor.moveToNext()) {
			// 记录已存在，进行修改工作
			result = updateReport(report);
		} else {
			// 记录不存在，添加新的记录
			result = addReport(report);
		}

		cursor.close();
		return result;
	}
	
	
	/**
	 * 按照指定条件查询数据
	 * @param params
	 * @return
	 */
	public ArrayList<Report> queryReport(String params) {
		ArrayList<Report> ReportList = new ArrayList<Report>();
		
		Cursor cursor = sqLiteDatabase.rawQuery(
				"select * from  report where 1=1 " +params, null);

		while(cursor.moveToNext()) {
			Report  report = new Report();
			report.setId(cursor.getInt(cursor.getColumnIndex("_id")));
			report.setSeqno(cursor.getString(cursor.getColumnIndex("seqno")));			
			report.setZwxm(cursor.getString(cursor.getColumnIndex("zwxm")));
			report.setZjlx(cursor.getString(cursor.getColumnIndex("zjlx")));
			report.setZjhm(cursor.getString(cursor.getColumnIndex("zjhm")));
			report.setHyzk(cursor.getString(cursor.getColumnIndex("hyzk")));
			report.setSfysc(cursor.getString(cursor.getColumnIndex("sfysc")));
			report.setSfzzmUrl(cursor.getString(cursor.getColumnIndex("sfzzm_url")));
			report.setSfzfmUrl(cursor.getString(cursor.getColumnIndex("sfzfm_url")));
			report.setScsfzUrl(cursor.getString(cursor.getColumnIndex("scsfz_url")));
			report.setYdcyhyUrl(cursor.getString(cursor.getColumnIndex("ydcyhy_url")));
			ReportList.add(report);
		}
		cursor.close();
		return ReportList;
	}
	
	
	/**
	 * 修改报告
	 * @param report
	 * @return 
	 */
	public long updateReport(Report report) {
		long result = 0; // 执行结果处理标志
		ContentValues map = new ContentValues();
		map.put("zwxm", report.getZwxm());
		map.put("zjlx", report.getZjlx());
		map.put("zjhm", report.getZjhm());
		map.put("hyzk", report.getHyzk());
		map.put("sfysc", report.getSfysc());
		map.put("sfzzm_url", report.getSfzzmUrl());
		map.put("sfzfm_url", report.getSfzfmUrl());
		map.put("scsfz_url", report.getScsfzUrl());
		map.put("ydcyhy_url", report.getYdcyhyUrl());

		result = sqLiteDatabase.update(REPORT_Table, map, "seqno=?",new String[]{report.getSeqno()} );
		return result;
	}
	
	/**
	 * 添加报告
	 * @param report
	 * @return 
	 */
	public long addReport(Report report) {
		
		long result = 0; // 执行结果处理标志
		ContentValues map = new ContentValues();
		map.put("seqno", report.getSeqno());
		map.put("zwxm", report.getZwxm());
		map.put("zjlx", report.getZjlx());
		map.put("zjhm", report.getZjhm());
		map.put("hyzk", report.getHyzk());
		map.put("sfysc", report.getSfysc());
		map.put("sfzzm_url", report.getSfzzmUrl());
		map.put("sfzfm_url", report.getSfzfmUrl());
		map.put("scsfz_url", report.getScsfzUrl());
		map.put("ydcyhy_url", report.getYdcyhyUrl());

		result = sqLiteDatabase.insert(REPORT_Table, null, map );
		return result;
	}
	

}
