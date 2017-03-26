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
	private String id;				//分享id	
	private String	reportInfo;		//举报理由	
	private long reportTime;		//举报时间
	private int status;				//状态
	public Report() {
	}
	public Report(String uid, int reportType, String id, String reportInfo, long reportTime, int status) {
		super();
		this.uid = uid;
		this.reportType = reportType;
		this.id = id;
		this.reportInfo = reportInfo;
		this.reportTime = reportTime;
		this.status = status;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReportInfo() {
		return reportInfo;
	}
	public void setReportInfo(String reportInfo) {
		this.reportInfo = reportInfo;
	}
	public long getReportTime() {
		return reportTime;
	}
	public void setReportTime(long reportTime) {
		this.reportTime = reportTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Report [uid=" + uid + ", reportType=" + reportType + ", id=" + id + ", reportInfo=" + reportInfo
				+ ", reportTime=" + reportTime + ", status=" + status + "]";
	}
	


	
}
