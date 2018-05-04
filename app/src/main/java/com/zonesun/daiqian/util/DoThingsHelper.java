package com.zonesun.daiqian.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 用来记录平板都有那些操作的数据库
 */
public class DoThingsHelper extends SQLiteOpenHelper {

	/*
	 * 构造方法用来创建数据库
	 */
	public DoThingsHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 此方法中创建数据表
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table dosomething(id integer primary key autoincrement,operator varchar(10),operationtype varchar(5),operation varchar(30),operationtime varchar(20),memo varchar(10))";
	    db.execSQL(sql);//至此数据库创建成功
	    
	}

	/**
	 * 此方法是当数据库的版本升级时此方法就会被调用
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
