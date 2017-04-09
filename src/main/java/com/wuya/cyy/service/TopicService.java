package com.wuya.cyy.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Topic;


/**
 * topic service
 * @author Cinyky
 * junliang mint
 * 7 Apr 2017 17:01:32
 */
public interface TopicService {

	/**
	 * 新增 topic
	 * @param topic 话题
	 * @return
	 */
	boolean topicAdd(Topic topic);
	
	/**
	 * 更新 topic
	 * @param topic 话题
	 * @return
	 */
	boolean topicUpdate(Topic topic);
	
	/**
	 * 查询topic 根据topicName模糊
	 * @return
	 */
	List<Topic> topicSelectByTopicName(@Param("topicName")String topicName);
	
	/**
	 * 查询topic 根据uid 
	 * @return
	 */
	List<Topic> topicSelectByUid(@Param("uid")String uid);
	

	/**
	 * 查询topic 根据topicId
	 * @return
	 */
	Topic selectTopicByTopicId(@Param("topicId")String topicId);
	/**
	 * 查询所有
	 * @return
	 */
	List<Topic> topicSelectAll();
	
}
