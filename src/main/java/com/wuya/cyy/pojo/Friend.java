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
	private long friendTime;		//加好友时间
	private int status;				//1.生效 2.失效
	
	public Friend() {
	}

	public Friend(String uid, String anotherUid, long friendTime, int status) {
		super();
		this.uid = uid;
		this.anotherUid = anotherUid;
		this.friendTime = friendTime;
		this.status = status;
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

	public long getFriendTime() {
		return friendTime;
	}

	public void setFriendTime(long friendTime) {
		this.friendTime = friendTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Friend [uid=" + uid + ", anotherUid=" + anotherUid + ", friendTime=" + friendTime + ", status=" + status
				+ "]";
	}

	
}
