package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 收藏实体
 * @author Cinyky
 * junliang mint
 * 10 Apr 2017 10:49:57
 */
public class StoreUp {
	private String storeId;
	private String uid;			//user id
	private int	storeType;		//1.question 2.answer
	private String id;			//收藏id
	private long shareTime;		//分享时间
	private int status;
	public StoreUp() {
	}
	public StoreUp(String shareId, String uid, int shareType, String id, int status) {
		super();
		this.storeId = UUID.randomUUID()+"";
		this.uid = uid;
		this.storeType = shareType;
		this.id = id;
		this.shareTime = System.currentTimeMillis();
		this.status = status;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getStoreType() {
		return storeType;
	}
	public void setStoreType(int storeType) {
		this.storeType = storeType;
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

		

	
}
