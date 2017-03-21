package com.wuya.cyy.pojo;
/**
 * 密保问题实体类
 * Cinyky
 *
 * 2017年3月21日下午7:15:09
 */
public class SecretQuestion {
	private String questionId;
	private String uid;
	private String questionInfo;
	private String answerInfo;
	private int status;
	
	
	
	public SecretQuestion() {
	}
	
	
	public SecretQuestion(String questionId, String uid, String questionInfo, String answerInfo, int status) {
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
	@Override
	public String toString() {
		return "SecretQuestion [questionId=" + questionId + ", uid=" + uid + ", questionInfo=" + questionInfo
				+ ", answerInfo=" + answerInfo + "]";
	}
	
	
	
	
}
