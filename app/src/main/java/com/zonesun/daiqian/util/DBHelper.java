package com.zonesun.daiqian.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //18034561623
	private final static String DATABASE_NAME = "dq.db"; // 数据库
	private final static int DATABASE_VERSION = 1; // 数据库版本
	
	private final static String Report_Table = "create table report(_id integer primary key autoincrement,"
			+ " seqno    text  not null," 
			+ " zwxm     text  not null,"
			+ " zjlx     text  not null,"
			+ " zjhm     text  not null,"
			+ " hyzk     text  not null,"
			+ " sfysc     text  not null,"
			+ " sfzzm_url     text  ,"
			+ " sfzfm_url     text  ,"
			+ " scsfz_url     text  ,"
			+ " ydcyhy_url    text  )";
	

	/**
	 * Helper的构造函数
	 * 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Report_Table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS Report_Table");
		onCreate(db);
	}

}
