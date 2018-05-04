package com.zonesun.daiqian.entity;

public class DsomeThings {

	// operator,operationtype,operation,operationtime,memo

	private String operator;//操作人
	private String operationtype;//操作类型
	private String operation;//具体的操作动作
	private String operationtime;//操作时间
	private String memo;//备注

	public DsomeThings() {
		super();
	}

	public DsomeThings(String operator, String operationtype, String operation,
			String operationtime, String memo) {
		super();
		this.operator = operator;
		this.operationtype = operationtype;
		this.operation = operation;
		this.operationtime = operationtime;
		this.memo = memo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperationtype() {
		return operationtype;
	}

	public void setOperationtype(String operationtype) {
		this.operationtype = operationtype;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperationtime() {
		return operationtime;
	}

	public void setOperationtime(String operationtime) {
		this.operationtime = operationtime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "DsomeThings [operator=" + operator + ", operationtype="
				+ operationtype + ", operation=" + operation
				+ ", operationtime=" + operationtime + ", memo=" + memo + "]";
	}

}
