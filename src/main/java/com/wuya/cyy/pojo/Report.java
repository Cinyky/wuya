package com.wuya.cyy.pojo;
/**
 * 举报实体
 * Cinyky 
 *
 * 2017年3月26日下午8:37:35
 */
public class Report {
	private String uid;				//用户id
	private int reportType;			//类型1.question 2.answer 3.user
	private int id;			//分享id			
	
	public Report() {
	}

	public Report(String uid, int reportType, int id) {
		super();
		this.uid = uid;
		this.reportType = reportType;
		this.id = id;
	}
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Report [uid=" + uid + ", reportType=" + reportType + ", id=" + id + "]";
	}

	
}
