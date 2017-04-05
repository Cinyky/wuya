package com.wuya.cyy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.AnswerDao;
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.service.AnswerService;
/**
 * Question Service
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:47:58
 */
@Service
public class AnswerServiceImpl  implements AnswerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AnswerDao answerDao;

	@Override
	public boolean answerAdd(Answer answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean answerUpdate(Answer answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Answer answerSelectByAnswerId(String answerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> answerSelectByInfo(String answerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> answerSelectByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> answerSelectByTopicId(String topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> answerSelectByUidAndTopicId(String topicId, String uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
