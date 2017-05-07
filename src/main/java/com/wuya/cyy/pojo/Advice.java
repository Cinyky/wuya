package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 意见反馈实体
 * @author Cinyky
 *
 */
public class Advice {
	private String  adviceId;		//意见反馈ID
	private String  uid;			//用户唯一id
	private String  adviceInfo;		//意见反馈信息
	private long    adviceTime;		//意见反馈时间
	private int status;				//状态   1 可用 0 不可用
	
	private User user;
	
	
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Advice() {
		super();
	}
	public Advice(String uid, String adviceInfo, int status) {
		super();
		this.adviceId = UUID.randomUUID()+"";
		this.uid = uid;
		this.adviceInfo = adviceInfo;
		this.adviceTime = System.currentTimeMillis();
		this.status = 1;							
	}
	public String getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAdviceInfo() {
		return adviceInfo;
	}
	public void setAdviceInfo(String adviceInfo) {
		this.adviceInfo = adviceInfo;
	}
	public long getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(long adviceTime) {
		this.adviceTime = adviceTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Advice [adviceId=" + adviceId + ", uid=" + uid + ", adviceInfo=" + adviceInfo + ", adviceTime="
				+ adviceTime + ", status=" + status + "]";
	}
	
	
}
