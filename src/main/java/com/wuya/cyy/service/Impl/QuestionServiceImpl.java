package com.wuya.cyy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.QuestionDao;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.service.QuestionService;
/**
 * Question Service
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:47:58
 */
@Service
public class QuestionServiceImpl  implements QuestionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionDao questionDao;

	@Override
	public boolean questionAdd(Question question) {
		int addQuestion = questionDao.addQuestion(question);
		return addQuestion>0;
	}

	@Override
	public boolean questionUpdate(Question question) {
		int updateQuestion = questionDao.updateQuestion(question);
		return updateQuestion>0;
	}

	@Override
	public List<Question> questionSelectByInfo(String questionInfo) {
		List<Question> questions = new ArrayList<>();
		questions = questionDao.selectQuestionByInfo(questionInfo);
		return questions;
	}

	@Override
	public List<Question> questionSelectByUid(String uid) {
		List<Question> questions = new ArrayList<>();
		questions = questionDao.selectQuestionByUid(uid);
		return questions;
	}

	@Override
	public List<Question> questionSelectByTopicId(String topicId) {
		List<Question> questions = new ArrayList<>();
		questions = questionDao.selectQuestionByTopicId(topicId);
		return questions;
	}

	@Override
	public List<Question> questionSelectByUidAndTopicId(String uid, String topicId) {
		List<Question> questions = new ArrayList<>();
		questions = questionDao.selectQuestionByUidAndTopicId(uid, topicId);
		return questions;
	}

	@Override
	public Question questionSelectByQuestionId(String questionId) {
		return questionDao.selectQuestionByQuestionId(questionId);
	}

	@Override
	public List<Question> selectQuestionByHot() {
		List<Question> selectQuestionByHot = questionDao.selectQuestionByHot();
		return selectQuestionByHot;
	}
	
}
