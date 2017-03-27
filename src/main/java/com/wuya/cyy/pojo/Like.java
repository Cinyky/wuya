package com.wuya.cyy.pojo;
/**
 * 点赞
 * Cinyky 
 *
 * 2017年3月26日下午5:39:34
 */
public class Like {
	private String likeId;
	private String uid;				//用户id
	private String answerId;		//回答id
	private long likeTime;			//点赞时间
	private int status;				//状态
	
	
	public Like() {
	}


	public Like(String likeId, String uid, String answerId, long likeTime, int status) {
		super();
		this.likeId = likeId;
		this.uid = uid;
		this.answerId = answerId;
		this.likeTime = likeTime;
		this.status = status;
	}


	public String getLikeId() {
		return likeId;
	}


	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getAnswerId() {
		return answerId;
	}


	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}


	public long getLikeTime() {
		return likeTime;
	}


	public void setLikeTime(long likeTime) {
		this.likeTime = likeTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", uid=" + uid + ", answerId=" + answerId + ", likeTime=" + likeTime
				+ ", status=" + status + "]";
	}

}
