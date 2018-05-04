package com.zonesun.daiqian.entity;

public class RoleList {

	private String rolecode;
	private String sys;
	private String rolename;
	private String parentrolecode;

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getParentrolecode() {
		return parentrolecode;
	}

	public void setParentrolecode(String parentrolecode) {
		this.parentrolecode = parentrolecode;
	}

	@Override
	public String toString() {
		return "RoleList [rolecode=" + rolecode + ", sys=" + sys
				+ ", rolename=" + rolename + ", parentrolecode="
				+ parentrolecode + "]";
	}

}
