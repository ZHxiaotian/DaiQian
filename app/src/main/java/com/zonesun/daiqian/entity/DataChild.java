package com.zonesun.daiqian.entity;

public class DataChild {

	// "zoneno": "0402",
	// "rate": "3.34%",
	// "typeno": "0",
	// "status": "1",
	// "typename": "购车",
	// "periodnum": "12",
	// "period": "12期",
	// "zonename": "石家庄"

	private String zoneno;
	private String rate;
	private String typeno;
	private String status;
	private String typename;
	private String periodnum;
	private String period;
	private String zonename;


	@Override
	public String toString() {
		return "DataChild [zoneno=" + zoneno + ", rate=" + rate + ", typeno="
				+ typeno + ", status=" + status + ", typename=" + typename
				+ ", periodnum=" + periodnum + ", period=" + period
				+ ", zonename=" + zonename + "]";
	}

	public DataChild(String zoneno, String rate, String typeno, String status,
			String typename, String periodnum, String period, String zonename) {
		super();
		this.zoneno = zoneno;
		this.rate = rate;
		this.typeno = typeno;
		this.status = status;
		this.typename = typename;
		this.periodnum = periodnum;
		this.period = period;
		this.zonename = zonename;
	}

	public DataChild() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getZoneno() {
		return zoneno;
	}

	public void setZoneno(String zoneno) {
		this.zoneno = zoneno;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getPeriodnum() {
		return periodnum;
	}

	public void setPeriodnum(String periodnum) {
		this.periodnum = periodnum;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

}
