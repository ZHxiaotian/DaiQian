package com.zonesun.daiqian.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResearchOderEntity  implements Serializable{

	private int id;
	private String sqrxm;
	private String sjhm;
	private String zjlx;
	private String zjhm;
	private String lcjg;
	private String gcpp;
	private String jkcbz;
	private String cx;
	private String pql;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSqrxm() {
		return sqrxm;
	}
	public void setSqrxm(String sqrxm) {
		this.sqrxm = sqrxm;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getLcjg() {
		return lcjg;
	}
	public void setLcjg(String lcjg) {
		this.lcjg = lcjg;
	}
	public String getGcpp() {
		return gcpp;
	}
	public void setGcpp(String gcpp) {
		this.gcpp = gcpp;
	}
	public String getJkcbz() {
		return jkcbz;
	}
	public void setJkcbz(String jkcbz) {
		this.jkcbz = jkcbz;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getPql() {
		return pql;
	}
	public void setPql(String pql) {
		this.pql = pql;
	}
	@Override
	public String toString() {
		return "ResearchOderEntity [id=" + id + ", sqrxm=" + sqrxm + ", sjhm="
				+ sjhm + ", zjlx=" + zjlx + ", zjhm=" + zjhm + ", lcjg=" + lcjg
				+ ", gcpp=" + gcpp + ", jkcbz=" + jkcbz + ", cx=" + cx
				+ ", pql=" + pql + "]";
	}
	
	
	
	
}
