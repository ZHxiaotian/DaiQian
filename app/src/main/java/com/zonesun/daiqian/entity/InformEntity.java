package com.zonesun.daiqian.entity;

import java.util.List;

/**
 * Created by yll on 2016/5/4.
 */
public class InformEntity {

	/**
	 * emptyIdentifier : 1 page : 52625 rows :
	 * [{"content":"测试内容643i","noticeid":
	 * "测试内容y1f3","receiver":"测试内容1wf0","sender"
	 * :"测试内容hr8q","sendtime":"测试内容ajla"
	 * ,"status":"测试内容bz34","title":"测试内容p112","viewtime"
	 * :"测试内容e5ly"},{"content":
	 * "测试内容643i","noticeid":"测试内容y1f3","receiver":"测试内容1wf0"
	 * ,"sender":"测试内容hr8q"
	 * ,"sendtime":"测试内容ajla","status":"测试内容bz34","title":"测试内容p112"
	 * ,"viewtime":"测试内容e5ly"}] total : 34375 totalSize : 32831
	 */

	private int emptyIdentifier;
	private int page;
	private int total;
	private int totalSize;
	/**
	 * content : 测试内容643i noticeid : 测试内容y1f3 receiver : 测试内容1wf0 sender :
	 * 测试内容hr8q sendtime : 测试内容ajla status : 测试内容bz34 title : 测试内容p112 viewtime
	 * : 测试内容e5ly
	 */

	private List<RowsEntity> rows;

	public void setEmptyIdentifier(int emptyIdentifier) {
		this.emptyIdentifier = emptyIdentifier;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public void setRows(List<RowsEntity> rows) {
		this.rows = rows;
	}

	public int getEmptyIdentifier() {
		return emptyIdentifier;
	}

	public int getPage() {
		return page;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public List<RowsEntity> getRows() {
		return rows;
	}

	public static class RowsEntity {
		private String content;
		private String noticeid;
		private String receiver;
		private String sender;
		private String sendtime;
		private String status;
		private String title;
		private String viewtime;

		public void setContent(String content) {
			this.content = content;
		}

		public void setNoticeid(String noticeid) {
			this.noticeid = noticeid;
		}

		public void setReceiver(String receiver) {
			this.receiver = receiver;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public void setSendtime(String sendtime) {
			this.sendtime = sendtime;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setViewtime(String viewtime) {
			this.viewtime = viewtime;
		}

		public String getContent() {
			return content;
		}

		public String getNoticeid() {
			return noticeid;
		}

		public String getReceiver() {
			return receiver;
		}

		public String getSender() {
			return sender;
		}

		public String getSendtime() {
			return sendtime;
		}

		public String getStatus() {
			return status;
		}

		public String getTitle() {
			return title;
		}

		public String getViewtime() {
			return viewtime;
		}
	}

	@Override
	public String toString() {
		return "InformEntity [emptyIdentifier=" + emptyIdentifier + ", page="
				+ page + ", total=" + total + ", totalSize=" + totalSize
				+ ", rows=" + rows + "]";
	}
	
	
}
