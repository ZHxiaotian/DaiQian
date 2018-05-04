package com.zonesun.daiqian.entity;

import java.util.List;

public class ZhengXinEntity {

	private String result;

	private String msg;

	private String error;

	private String errormsg;

	private List<Data> data;

	public ZhengXinEntity(String result, String msg, String error,
			String errormsg, List<Data> data) {
		super();
		this.result = result;
		this.msg = msg;
		this.error = error;
		this.errormsg = errormsg;
		this.data = data;
	}

	public ZhengXinEntity() {
		super();
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public class Data {
		private String atype;
		private String customerid;
		private String authreqid;
		private String astatus;
		public Data(String atype, String customerid, String authreqid,
				String astatus) {
			super();
			this.atype = atype;
			this.customerid = customerid;
			this.authreqid = authreqid;
			this.astatus = astatus;
		}
		public Data() {
			super();
		}
		public String getAtype() {
			return atype;
		}
		public void setAtype(String atype) {
			this.atype = atype;
		}
		public String getCustomerid() {
			return customerid;
		}
		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}
		public String getAuthreqid() {
			return authreqid;
		}
		public void setAuthreqid(String authreqid) {
			this.authreqid = authreqid;
		}
		public String getAstatus() {
			return astatus;
		}
		public void setAstatus(String astatus) {
			this.astatus = astatus;
		}
		@Override
		public String toString() {
			return "Data [atype=" + atype + ", customerid=" + customerid
					+ ", authreqid=" + authreqid + ", astatus=" + astatus + "]";
		}
		
		

	}

}
