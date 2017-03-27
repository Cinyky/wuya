package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Topic;





/**
 * topic dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface TopicDao {
	/**
	 * 增加topic
	 * @param topic
	 * @return
	 */
	int addTopic(Topic topic);
	
	/**
	 * 更新topic
	 * @param topic
	 * @return
	 */
	int updateTopic(Topic topic);
	
	
	/**
	 * 查询topic 根据topicName模糊
	 * @return
	 */
	List<Topic> selectTopicByTopicName(String topicName);
	
	/**
	 * 查询topic 根据uid
	 * @return
	 */
	List<Topic> selectTopicByUid(@Param("uid")String uid);
	

	/**
	 * 查询topic 根据topicId
	 * @return
	 */
	Topic selectTopicByTopicId(@Param("topicId")String topicId);
	
}
