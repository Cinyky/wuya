package com.wuya.cyy.pojo;
/**
 * 广场使用
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 19:52:05
 */
public class HotQuestionAndAnswerAndTopic {
	private User user;
	private Question question;
	private Answer answer;
	private Topic topic;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "HotQuestionAndAnswerAndTopic [user={" + user + "}, question={" + question + "}, answer={" + answer
				+ "}, topic={" + topic + "}]";
	}
	
}
