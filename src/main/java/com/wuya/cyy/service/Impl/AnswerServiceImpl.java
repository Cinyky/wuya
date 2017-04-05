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
		return answerDao.addAnswer(answer)>0;
	}

	@Override
	public boolean answerUpdate(Answer answer) {
		return answerDao.updateAnswer(answer)>0;
	}

	@Override
	public Answer answerSelectByAnswerId(String answerId) {
		return answerDao.selectAnswerByAnswerId(answerId);
	}

	@Override
	public List<Answer> answerSelectByInfo(String answerInfo) {
		return answerDao.selectAnswerByInfo(answerInfo);
	}

	@Override
	public List<Answer> answerSelectByUid(String uid) {
		return answerDao.selectAnswerByUid(uid);
	}

	@Override
	public List<Answer> answerSelectByQuestionId(String questionId) {
		return answerDao.selectAnswerByQuestionId(questionId);
	}

	@Override
	public List<Answer> answerSelectByQuestionId(String uid, String questionId) {
		return answerDao.selectAnswerByUidAndQuestionId(uid, questionId);
	}

}
