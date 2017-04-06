package com.wuya.cyy.pojo;

import java.util.UUID;

/**
 * 答案实体类
 * Cinyky 
 *
 * 2017年3月26日下午5:10:50
 */
public class Answer {
	private String answerId;		//回答id
	private String questionId;		//问题id
	private String uid;				//回答问题用户id
	private String answerInfo;		//回答详情
	private long answerTime;		//提出问题时间
	private int status;				//状态  默认 1 删除0
	//++++++++++++++ 另外封装
	private User user;				//发表回答的user
	private String likeCount;		//点赞次数
	
	
	public Answer() {
	}



	public Answer(String questionId, String uid, String answerInfo, int status) {
		super();
		this.answerId = UUID.randomUUID()+"";
		this.questionId = questionId;
		this.uid = uid;
		this.answerInfo = answerInfo;
		this.answerTime = System.currentTimeMillis();
		this.status = status;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getAnswerId() {
		return answerId;
	}



	public void setAnswerId(String answerId) {
		this.answerId = answerId;
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



	public String getAnswerInfo() {
		return answerInfo;
	}



	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}



	public long getAnswerTime() {
		return answerTime;
	}



	public void setAnswerTime(long answerTime) {
		this.answerTime = answerTime;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", uid=" + uid + ", answerInfo="
				+ answerInfo + ", answerTime=" + answerTime + ", status=" + status + "]";
	}
	
	
	
	
}
