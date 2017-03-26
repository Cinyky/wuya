package com.wuya.cyy.pojo;
/**
 * 关注实体
 * Cinyky 
 *
 * 2017年3月26日下午8:37:35
 */
public class Focus {
	private String uid;				//user id
	private String questionId;		//问题id
	
	public Focus() {
	}

	public Focus(String uid, String questionId) {
		super();
		this.uid = uid;
		this.questionId = questionId;
	}
	
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Focus [uid=" + uid + ", questionId=" + questionId + "]";
	}


	
}
