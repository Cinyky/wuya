package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 点赞
 * Cinyky 
 *
 * 2017年3月26日下午5:39:34
 */
public class Upvote {
	private String upvoteId;
	private String uid;				//用户id
	private String answerId;		//回答id
	private long upvoteTime;			//点赞时间
	private int status;				//状态
	
	
	public Upvote() {
	}


	public Upvote(String uid, String answerId, int status) {
		super();
		this.upvoteId = UUID.randomUUID()+"";
		this.uid = uid;
		this.answerId = answerId;
		this.upvoteTime = System.currentTimeMillis();
		this.status = status;
	}


	public String getUpvoteId() {
		return upvoteId;
	}


	public void setUpvoteId(String upvoteId) {
		this.upvoteId = upvoteId;
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


	public long getUpvoteTime() {
		return upvoteTime;
	}


	public void setUpvoteTime(long upvoteTime) {
		this.upvoteTime = upvoteTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Upvote [upvoteId=" + upvoteId + ", uid=" + uid + ", answerId=" + answerId + ", upvoteTime=" + upvoteTime
				+ ", status=" + status + "]";
	}

}
