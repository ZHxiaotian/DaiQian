package com.zonesun.daiqian.entity;

import java.util.ArrayList;

public class Data {

	// V"data"
	// "error": 0,
	// "msg": "成功",
	// "result": 1
	private ArrayList<DataChild> data;
	private String error;
	private String msg;
	private String result;

	public Data(ArrayList<DataChild> data, String error, String msg,
			String result) {
		super();
		this.data = data;
		this.error = error;
		this.msg = msg;
		this.result = result;
	}

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DataChild> getData() {
		return data;
	}

	public void setData(ArrayList<DataChild> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + ", error=" + error + ", msg=" + msg
				+ ", result=" + result + "]";
	}
    
}
