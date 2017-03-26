package com.wuya.cyy.pojo;
/**
 * 关注实体
 * Cinyky 
 *
 * 2017年3月26日下午8:37:35
 */
public class Focus {
	private String uid;				//user id
	private int focusType;			// type 1.question 2.topic
	private String id;				//id
	private long focusTime;			//提出问题时间
	private int status;				//状态
	
	public Focus() {
	}
	
	public Focus(String uid, int focusType, String id, long focusTime, int status) {
		super();
		this.uid = uid;
		this.focusType = focusType;
		this.id = id;
		this.focusTime = focusTime;
		this.status = status;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getFocusType() {
		return focusType;
	}
	public void setFocusType(int focusType) {
		this.focusType = focusType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getFocusTime() {
		return focusTime;
	}
	public void setFocusTime(long focusTime) {
		this.focusTime = focusTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Focus [uid=" + uid + ", focusType=" + focusType + ", id=" + id + ", focusTime=" + focusTime
				+ ", status=" + status + "]";
	}
	
	

	

	


	
}
