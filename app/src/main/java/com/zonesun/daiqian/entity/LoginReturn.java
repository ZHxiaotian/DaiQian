package com.zonesun.daiqian.entity;

public class LoginReturn {

	

	private String error;
	private LoginData data;
	private String result;
	private String msg;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public LoginData getData() {
		return data;
	}

	public void setData(LoginData data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "LoginReturn [error=" + error + ", data=" + data + ", result="
				+ result + ", msg=" + msg + "]";
	}

}
