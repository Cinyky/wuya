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
	
	private int shareType;  //1.answer 2.question
	private int topicType;  //1.关注 2.创建
	private int friendType; //1.我关注的好友 2.关注我的好友
	
	public int getFriendType() {
		return friendType;
	}
	public void setFriendType(int friendType) {
		this.friendType = friendType;
	}
	public int getTopicType() {
		return topicType;
	}
	public void setTopicType(int topicType) {
		this.topicType = topicType;
	}
	public int getShareType() {
		return shareType;
	}
	public void setShareType(int shareType) {
		this.shareType = shareType;
	}
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
