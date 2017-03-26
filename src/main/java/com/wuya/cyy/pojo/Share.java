package com.wuya.cyy.pojo;
/**
 * 分享实体
 * Cinyky 
 *
 * 2017年3月26日下午9:03:03
 */
public class Share {
	private String uid;			//user id
	private int	shareType;		//1.question 2.answer
	private int id;				//分享id
	
	public Share() {
	}

	public Share(String uid, int shareType, int id) {
		super();
		this.uid = uid;
		this.shareType = shareType;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Share [uid=" + uid + ", shareType=" + shareType + ", id=" + id + "]";
	}


	

	
}
