package com.zonesun.daiqian.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, "data.db", null, 1);
	}

	// 数据库创建时，此方法会调用
	@Override
	public void onCreate(SQLiteDatabase db) {

		String research_oder = "create table researchoder(_id integer primary key autoincrement,"
				+ " sqrxm     text  not null,"
				+ " sjhm     text  not null,"
				+ " zjlx     text  not null,"
				+ " zjhm     text  not null,"
				+ " lcjg     text,"
				+ " gcpp     text,"
				+ " jkcbz   text,"
				+ " cx       text," + " pql  text)";
		db.execSQL("create table saveJson(_id integer primary key autoincrement, json text)");
		db.execSQL(research_oder);

	}

	// 数据库升级时，此方法会调用
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("数据库升级了");
	}

}
