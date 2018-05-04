package com.zonesun.daiqian.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ImagePathEntity implements Serializable {

	private String sfzzm;
	private String sfzfm;
	private String scsfz;
	private String ydcyhy;
	private String zzzm;
	private String sqrxq;
	private String sqrszlh;
	private String sqrszdy;
	private String sqrszmph;
	private String dw;

	public ImagePathEntity(String sfzzm, String sfzfm, String scsfz, String ydcyhy, String zzzm, String sqrxq,
			String sqrszlh, String sqrszdy, String sqrszmph, String dw) {
		super();
		this.sfzzm = sfzzm;
		this.sfzfm = sfzfm;
		this.scsfz = scsfz;
		this.ydcyhy = ydcyhy;
		this.zzzm = zzzm;
		this.sqrxq = sqrxq;
		this.sqrszlh = sqrszlh;
		this.sqrszdy = sqrszdy;
		this.sqrszmph = sqrszmph;
		this.dw = dw;
	}

	public ImagePathEntity() {
		super();
	}

	public String getSfzzm() {
		return sfzzm;
	}

	public void setSfzzm(String sfzzm) {
		this.sfzzm = sfzzm;
	}

	public String getSfzfm() {
		return sfzfm;
	}

	public void setSfzfm(String sfzfm) {
		this.sfzfm = sfzfm;
	}

	public String getScsfz() {
		return scsfz;
	}

	public void setScsfz(String scsfz) {
		this.scsfz = scsfz;
	}

	public String getYdcyhy() {
		return ydcyhy;
	}

	public void setYdcyhy(String ydcyhy) {
		this.ydcyhy = ydcyhy;
	}

	public String getZzzm() {
		return zzzm;
	}

	public void setZzzm(String zzzm) {
		this.zzzm = zzzm;
	}

	public String getSqrxq() {
		return sqrxq;
	}

	public void setSqrxq(String sqrxq) {
		this.sqrxq = sqrxq;
	}

	public String getSqrszlh() {
		return sqrszlh;
	}

	public void setSqrszlh(String sqrszlh) {
		this.sqrszlh = sqrszlh;
	}

	public String getSqrszdy() {
		return sqrszdy;
	}

	public void setSqrszdy(String sqrszdy) {
		this.sqrszdy = sqrszdy;
	}

	public String getSqrszmph() {
		return sqrszmph;
	}

	public void setSqrszmph(String sqrszmph) {
		this.sqrszmph = sqrszmph;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	@Override
	public String toString() {
		return "ImagePathEntity [sfzzm=" + sfzzm + ", sfzfm=" + sfzfm + ", scsfz=" + scsfz + ", ydcyhy=" + ydcyhy
				+ ", zzzm=" + zzzm + ", sqrxq=" + sqrxq + ", sqrszlh=" + sqrszlh + ", sqrszdy=" + sqrszdy
				+ ", sqrszmph=" + sqrszmph + ", dw=" + dw + "]";
	}

}
