package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Answer;


/**
 * answer Service
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 19:19:08
 */
public interface AnswerService {

	/**
	 * 新增 answer
	 * @param answer 回答
	 * @return
	 */
	boolean answerAdd(Answer answer);
	
	/**
	 * 更新 answer
	 * @param answer 回答
	 * @return
	 */
	boolean answerUpdate(Answer answer);
	
	/**
	 * 根据answerId搜索
	 * @param answerId
	 * @return
	 */
	Answer answerSelectByAnswerId(String answerId);

	/**
	 * 根据昵称模糊搜索
	 * @param nickName
	 * @return
	 */
	List<Answer> answerSelectByInfo(String answerInfo);
	
	/**
	 * 根据uid 搜索 answer
	 * @param uid
	 * @return
	 */
	List<Answer> answerSelectByUid(String uid);
	
	/**
	 * 根据uid 搜索 answer
	 * @param uid
	 * @return
	 */
	String answerCountSelectByUid(String uid);
	
	/**
	 * 根据questionId搜索
	 * @param questionId
	 * @return
	 */
	List<Answer> answerSelectByQuestionId(String questionId);
	
	/**
	 * one answer
	 * @param questionId
	 * @return
	 */
	Answer answerOneSelectByQuestionId(String questionId);
	
	
	/**
	 * 根据questionId&uid搜索
	 * @param questionId
	 * @return
	 */
	List<Answer> answerSelectByQuestionId(String questionId,String uid);
	
	
}
