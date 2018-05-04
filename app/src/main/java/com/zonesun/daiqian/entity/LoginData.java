package com.zonesun.daiqian.entity;

import java.util.ArrayList;
import java.util.List;

public class LoginData {

	
	private List<RoleList> roleList = new ArrayList<RoleList>();
	private String jobnum;
	private String brno;
	private String zoneno;
	private String orgnizationtype;
	private String islocked;
	private String usercode;
	private String bankuserid;
	private String organid;
	private String headimg;
	private String name;
	private String branchno;
	private RoleList role;
	private String sxfstatus;

	public String getSxfstatus() {
		return sxfstatus;
	}

	public void setSxfstatus(String sxfstatus) {
		this.sxfstatus = sxfstatus;
	}
	public List<RoleList> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleList> roleList) {
		this.roleList = roleList;
	}

	public String getJobnum() {
		return jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public String getBrno() {
		return brno;
	}

	public void setBrno(String brno) {
		this.brno = brno;
	}

	public String getZoneno() {
		return zoneno;
	}

	public void setZoneno(String zoneno) {
		this.zoneno = zoneno;
	}

	public String getOrgnizationtype() {
		return orgnizationtype;
	}

	public void setOrgnizationtype(String orgnizationtype) {
		this.orgnizationtype = orgnizationtype;
	}

	public String getIslocked() {
		return islocked;
	}

	public void setIslocked(String islocked) {
		this.islocked = islocked;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getBankuserid() {
		return bankuserid;
	}

	public void setBankuserid(String bankuserid) {
		this.bankuserid = bankuserid;
	}

	public String getOrganid() {
		return organid;
	}

	public void setOrganid(String organid) {
		this.organid = organid;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchno() {
		return branchno;
	}

	public void setBranchno(String branchno) {
		this.branchno = branchno;
	}

	public RoleList getRole() {
		return role;
	}

	public void setRole(RoleList role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginData [roleList=" + roleList + ", jobnum=" + jobnum
				+ ", brno=" + brno + ", zoneno=" + zoneno
				+ ", orgnizationtype=" + orgnizationtype + ", islocked="
				+ islocked + ", usercode=" + usercode + ", bankuserid="
				+ bankuserid + ", organid=" + organid + ", headimg=" + headimg
				+ ", name=" + name + ", branchno=" + branchno + ", role="
				+ role + "]";
	}

}
