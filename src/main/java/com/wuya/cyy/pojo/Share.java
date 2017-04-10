package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 分享实体
 * Cinyky 
 *
 * 2017年3月26日下午9:03:03
 */
public class Share {
	private String shareId;
	private String uid;			//user id
	private int	shareType;		//1.answer 2.question
	private String id;				//分享id
	private long shareTime;		//分享时间
	private int status;
	public Share() {
	}
	public Share(String uid, int shareType, String id, int status) {
		super();
		this.shareId = UUID.randomUUID()+"";
		this.uid = uid;
		this.shareType = shareType;
		this.id = id;
		this.shareTime = System.currentTimeMillis();
		this.status = status;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getShareType() {
		return shareType;
	}
	public void setShareType(int shareType) {
		this.shareType = shareType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getShareTime() {
		return shareTime;
	}
	public void setShareTime(long shareTime) {
		this.shareTime = shareTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Share [shareId=" + shareId + ", uid=" + uid + ", shareType=" + shareType + ", id=" + id + ", shareTime="
				+ shareTime + ", status=" + status + "]";
	}



	
}
