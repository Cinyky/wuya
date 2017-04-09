package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.SecretQuestion;


/**
 * secret question
 * Cinyky 
 *
 * 2017年4月9日下午4:43:04
 */
public interface SecretQuestionService {

	/**
	 * 新增 secretQuestion
	 * @param secretQuestion 密保问题
	 * @return
	 */
	boolean secretQuestionAdd(SecretQuestion secretQuestion);
	
	/**
	 * 
	 * @param secretQuestion
	 * @return
	 */
	boolean deleteQuestion(String questionId);
	
	/**
	 * 
	 * @param secretQuestion
	 * @return
	 */
	boolean deleteAllQuestion(String uid);
	
	/**
	 * 更新 secretQuestion
	 * @param secretQuestion 密保问题
	 * @return
	 */
	boolean secretQuestionUpdate(SecretQuestion secretQuestion);
	
	/**
	 * 根据uid 搜索 secretQuestion
	 * @param uid
	 * @return
	 */
	List<SecretQuestion> secretQuestionSelectByUid(String uid);
	
	/**
	 * 根据secretQuestionId搜索
	 * @param secretQuestionId
	 * @return
	 */
	List<SecretQuestion> secretQuestionSelectBySecretQuestionId(String secretQuestionId);

}
