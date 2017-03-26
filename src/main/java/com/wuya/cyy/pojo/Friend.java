package com.wuya.cyy.pojo;
/**
 * 好友实体
 * Cinyky 
 *
 * 2017年3月26日下午8:37:35
 */
public class Friend {
	private String uid;				//id
	private String anotherUid;		//创建话题用户id
	
	public Friend() {
	}

	public Friend(String uid, String anotherUid) {
		super();
		this.uid = uid;
		this.anotherUid = anotherUid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAnotherUid() {
		return anotherUid;
	}

	public void setAnotherUid(String anotherUid) {
		this.anotherUid = anotherUid;
	}

	@Override
	public String toString() {
		return "Friend [uid=" + uid + ", anotherUid=" + anotherUid + "]";
	}
	
	
	
}
