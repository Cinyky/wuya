package com.wuya.cyy.pojo;
/**
 * 话题实体类
 * Cinyky 
 *
 * 2017年3月26日下午5:37:19
 */
public class Topic {
	private String topicId;			//话题id
	private String uid;				//创建话题用户id
	private String topicName;		//话题名
	private String topicPic;		//话题图片
	private int status;				//状态
	private long topicTime;			//创建话题时间
	
	public Topic() {
	}

	public Topic(String topicId, String uid, String topicName, String topicPic, int status, long topicTime) {
		super();
		this.topicId = topicId;
		this.uid = uid;
		this.topicName = topicName;
		this.topicPic = topicPic;
		this.status = status;
		this.topicTime = topicTime;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicPic() {
		return topicPic;
	}

	public void setTopicPic(String topicPic) {
		this.topicPic = topicPic;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(long topicTime) {
		this.topicTime = topicTime;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", uid=" + uid + ", topicName=" + topicName + ", topicPic=" + topicPic
				+ ", status=" + status + ", topicTime=" + topicTime + "]";
	}

	
}
