package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Question;


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
	List<Answer> selectAnswerByQuestionId(@Param("questionId")String questionId);
	
	
	/**
	 * 根据questionId查询一个回答
	 * @return
	 */
	Answer selectOneAnswerByQuestionId(@Param("questionId")String questionId);
	
	/**
	 * 根据uid查询回答
	 * @return
	 */
	List<Answer> selectAnswerByUid(@Param("uid")String uid);
	
	/**
	 * 根据uid查询回答
	 * @return
	 */
	String selectAnswerCountByUid(@Param("uid")String uid);
	
	/**
	 * 根据uid查询回答
	 * @return
	 */
	List<Answer> selectAnswerByUidAndQuestionId(@Param("uid")String uid,@Param("questionId")String questionId);
	
	/**
	 * 根据questionId查询回答
	 * @return
	 */
	Answer selectAnswerByAnswerId(@Param("answerId")String answerId);
	
	/**
	 * 根据info 模糊查询回答
	 * @return
	 */
	List<Answer> selectAnswerByInfo(@Param("answerInfo")String answerInfo);
	
	/**
	 * 根据answer count
	 * @return
	 */
	String selectTotalAnswerCount();
	
	/**
	 * 根据questionId查询回答
	 * @return
	 */
	String selectTodayAnswerCount(@Param("startTime")Long startTime,@Param("endTime")Long endTime);
	
	/**
	 * 
	 * @param todayTime
	 * @return
	 */
	List<Answer> selectAnswerByPage(@Param("start")int start,@Param("pageSize")int pageSize);
}
