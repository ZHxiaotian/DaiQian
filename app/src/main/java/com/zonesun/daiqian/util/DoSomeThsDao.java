package com.zonesun.daiqian.util;

import java.util.ArrayList;
import java.util.List;

import com.zonesun.daiqian.entity.DsomeThings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DoSomeThsDao {

	Context context;
	private DoThingsHelper helper;

	public DoSomeThsDao(Context context) {
		super();
		helper = new DoThingsHelper(context, "dosome.db", null, 1);
	}

	// operator,operationtype,operation,operationtime,memo
	/**
	 * 添加数据
	 */

	public long addMessage(DsomeThings things) {

		SQLiteDatabase db = helper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("operator", things.getOperator());
		cv.put("operationtype", things.getOperationtype());
		cv.put("operation", things.getOperation());
		cv.put("operationtime", things.getOperationtime());
		cv.put("memo", things.getMemo());
		return db.insert("dosomething", null, cv);

	}

	/**
	 * 
	 * 查询全部查询
	 * 
	 */
	public void selectMsg() {
		List<DsomeThings> list = new ArrayList<DsomeThings>();
		SQLiteDatabase db = helper.getWritableDatabase();

		Cursor cs = db.query("dosomething", null, null, null, null, null, null,
				null);
		while (cs.moveToNext()) {
			list.add(new DsomeThings(
					cs.getString(cs.getColumnIndex("operator")), cs
							.getString(cs.getColumnIndex("operationtype")), cs
							.getString(cs.getColumnIndex("operation")), cs
							.getString(cs.getColumnIndex("operationtime")), cs
							.getString(cs.getColumnIndex("memo"))));
		}
		cs.close();
		System.out.println(list.toString());
	}

	/**
	 * 修改的方法
	 */

	public void updateMsg() {

		SQLiteDatabase db = helper.getWritableDatabase();

	}

	/**
	 * 删除的方法
	 */
	public void deleteMsg() {
		SQLiteDatabase db = helper.getWritableDatabase();

		System.out.println(db.delete("dosomething", null, null));

	}

}
