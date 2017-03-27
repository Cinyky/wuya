package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Question;


/**
 * question dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface QuestionDao {
	/**
	 * 增加question
	 * @param question
	 * @return
	 */
	int addQuestion(Question question);
	
	/**
	 * 更新question
	 * @param question
	 * @return
	 */
	int updateQuestion(Question question);
	
	
	/**
	 * 查询question 根据uid
	 * @return
	 */
	List<Question> selectQuestionByUid(String uid);
	
	/**
	 * 查询question 根据info模糊
	 * @return
	 */
	List<Question> selectQuestionByInfo(@Param("questionInfo")String questionInfo);
	
	/**
	 * 查询question 根据topicId
	 * @return
	 */
	List<Question> selectQuestionByTopicId(@Param("topicId")String topicId);
	
	/**
	 * 查询question 根据questionId
	 * @return
	 */
	Question selectQuestionByQuestionId(String questionId);
	
}