package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Answer;


/**
 * 关注问题dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface FocusDao {
	/**
	 * 增加answer
	 * @param user
	 * @return
	 */
	int addAnswer(Answer answer);
	
	/**
	 * 更新用户
	 * @param user
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
