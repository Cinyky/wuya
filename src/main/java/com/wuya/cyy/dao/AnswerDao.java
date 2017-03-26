package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Answer;


/**
 * 回答 dao
 * Cinyky 
 *
 * 2017年3月26日下午9:38:48
 */
public interface AnswerDao {
	/**
	 * 增加answer
	 * @param answer
	 * @return
	 */
	int addAnswer(Answer answer);
	
	/**
	 * 更新用户
	 * @param answer
	 * @return
	 */
	int updateAnswer(Answer answer);
	
	
	/**
	 * 根据questionId查询回答
	 * @return
	 */
	Answer selectAnswerByQuestionId(String questionId);
	
	/**
	 * 根据uid查询回答
	 * @return
	 */
	List<Answer> selectAnswerByUid(String uid);
	
	
	/**
	 * 根据info 模糊查询回答
	 * @return
	 */
	List<Answer> selectAnswerByInfo(String answerInfo);
	
	
}
