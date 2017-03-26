package com.wuya.cyy.pojo;
/**
 * 答案实体类
 * Cinyky 
 *
 * 2017年3月26日下午5:10:50
 */
public class Answer {
	private String questionId;
	private String uid;
	private String questionInfo;
	private String answerInfo;
	private int status;
	
	
	
	public Answer() {
	}
	
	
	public Answer(String questionId, String uid, String questionInfo, String answerInfo, int status) {
		super();
		this.questionId = questionId;
		this.uid = uid;
		this.questionInfo = questionInfo;
		this.answerInfo = answerInfo;
		this.status = status;
	}


	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionInfo() {
		return questionInfo;
	}
	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}
	public String getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}
	
	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SecretQuestion [questionId=" + questionId + ", uid=" + uid + ", questionInfo=" + questionInfo
				+ ", answerInfo=" + answerInfo + "]";
	}
	
	
	
	
}
