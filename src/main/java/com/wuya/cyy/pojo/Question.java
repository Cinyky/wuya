package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 问题实体类
 * Cinyky 
 *
 * 2017年3月26日下午4:05:17
 */
public class Question {
	private String questionId;		//问题id
	private String uid;				//用户id
	private String questionInfo;	//问题详情
	private String topicId;			//话题id
	private long questionTime;		//提出问题时间
	private int status;				//状态
	
	
	
	public Question() {
	}



	public Question(String uid, String questionInfo, String topicId, long questionTime, int status) {
		super();
		this.questionId = UUID.randomUUID()+"";
		this.uid = uid;
		this.questionInfo = questionInfo;
		this.topicId = topicId;
		this.questionTime = questionTime;
		this.status = status;
	}



	public String getQuestionId() {
		return questionId;
	}



	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getQuestionInfo() {
		return questionInfo;
	}



	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}



	public String getTopicId() {
		return topicId;
	}



	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}



	public long getQuestionTime() {
		return questionTime;
	}



	public void setQuestionTime(long questionTime) {
		this.questionTime = questionTime;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", uid=" + uid + ", questionInfo=" + questionInfo + ", topicId="
				+ topicId + ", questionTime=" + questionTime + ", status=" + status + "]";
	}
	
}
