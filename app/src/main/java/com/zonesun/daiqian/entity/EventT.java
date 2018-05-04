package com.zonesun.daiqian.entity;

import java.net.HttpCookie;
import java.util.List;

import org.json.JSONObject;

public class EventT {

	private boolean isrefreshl=false;
	private int NoCode;
	private JSONObject obj;
	private List<HttpCookie> cookies;

	public boolean isIsrefreshl() {
		return isrefreshl;
	}

	public void setIsrefreshl(boolean isrefreshl) {
		this.isrefreshl = isrefreshl;
	}

	public EventT(boolean isrefreshl) {
		super();
		this.isrefreshl = isrefreshl;
	}

	public EventT(int noCode, JSONObject obj, List<HttpCookie> cookies) {
		super();
		NoCode = noCode;
		this.obj = obj;
		this.cookies = cookies;
	}

	public int getNoCode() {
		return NoCode;
	}

	public void setNoCode(int noCode) {
		NoCode = noCode;
	}

	public JSONObject getObj() {
		return obj;
	}

	public void setObj(JSONObject obj) {
		this.obj = obj;
	}

	public List<HttpCookie> getCookies() {
		return cookies;
	}

	public void setCookies(List<HttpCookie> cookies) {
		this.cookies = cookies;
	}

	@Override
	public String toString() {
		return "EventT [NoCode=" + NoCode + ", obj=" + obj + ", cookies="
				+ cookies + "]";
	}

}
