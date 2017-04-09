package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.TopicDao;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.service.TopicService;
/**
 * Topic service Impl
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 17:14:34
 */
@Service
public class TopicServiceImpl implements TopicService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TopicDao topicDao;

	@Override
	public boolean topicAdd(Topic topic) {
		return topicDao.addTopic(topic)>0;
	}

	@Override
	public boolean topicUpdate(Topic topic) {
		return topicDao.updateTopic(topic)>0;
	}

	@Override
	public List<Topic> topicSelectByTopicName(String topicName) {
		return topicDao.selectTopicByTopicName(topicName);
	}

	@Override
	public List<Topic> topicSelectByUid(String uid) {
		return topicDao.selectTopicByUid(uid);
	}

	@Override
	public Topic selectTopicByTopicId(String topicId) {
		return topicDao.selectTopicByTopicId(topicId);
	}

	@Override
	public List<Topic> topicSelectAll() {
		return topicDao.selectTopicByRecommend() ;
	}
	

}
