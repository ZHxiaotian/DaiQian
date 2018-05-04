package com.zonesun.daiqian.entity;

import java.io.Serializable;

public class Report implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;  //自增序列
	private String seqno; //唯一标识
	private String zwxm ; //中文姓名
	private String zjlx;  //证件类型
	private String zjhm;  //证件号码
	private String hyzk;  //婚姻状况
	private String sfysc; //是否已上传
	private String sfzzmUrl;//身份证正面
	private String sfzfmUrl;//身份证反面
	private String scsfzUrl;//手持身份证
	private String ydcyhyUrl;//与调查员合影
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getZwxm() {
		return zwxm;
	}
	public void setZwxm(String zwxm) {
		this.zwxm = zwxm;
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
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getSfysc() {
		return sfysc;
	}
	public void setSfysc(String sfysc) {
		this.sfysc = sfysc;
	}
	public String getSfzzmUrl() {
		return sfzzmUrl;
	}
	public void setSfzzmUrl(String sfzzmUrl) {
		this.sfzzmUrl = sfzzmUrl;
	}
	public String getSfzfmUrl() {
		return sfzfmUrl;
	}
	public void setSfzfmUrl(String sfzfmUrl) {
		this.sfzfmUrl = sfzfmUrl;
	}
	public String getScsfzUrl() {
		return scsfzUrl;
	}
	public void setScsfzUrl(String scsfzUrl) {
		this.scsfzUrl = scsfzUrl;
	}
	public String getYdcyhyUrl() {
		return ydcyhyUrl;
	}
	public void setYdcyhyUrl(String ydcyhyUrl) {
		this.ydcyhyUrl = ydcyhyUrl;
	}
	
	
}
