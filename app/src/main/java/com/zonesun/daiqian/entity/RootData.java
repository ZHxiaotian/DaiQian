package com.zonesun.daiqian.entity;

import java.util.List;

public class RootData {

	public int total;

	public int page;

	public int totalSize;

	public List<Rows> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<Rows> getRows() {
		return rows;
	}

	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "RootData [total=" + total + ", page=" + page + ", totalSize="
				+ totalSize + ", rows=" + rows + "]";
	}

}
