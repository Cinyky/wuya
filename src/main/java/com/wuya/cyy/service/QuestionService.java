package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.User;



/**
 * QuestionService
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:31:53
 */
public interface QuestionService {

	/**
	 * 新增 question
	 * @param question 问题
	 * @return
	 */
	boolean questionAdd(Question question);
	
	/**
	 * 更新 question
	 * @param question 问题
	 * @return
	 */
	boolean questionUpdate(Question question);
	
	/**
	 * 根据questionId搜索
	 * @param questionId
	 * @return
	 */
	Question questionSelectByQuestionId(String questionId);

	/**
	 * 根据昵称模糊搜索
	 * @param nickName
	 * @return
	 */
	List<Question> questionSelectByInfo(String questionInfo);
	
	/**
	 * 根据uid 搜索 question
	 * @param uid
	 * @return
	 */
	List<Question> questionSelectByUid(String uid);
	
	/**
	 * 根据昵称模糊搜索
	 * @param nickName
	 * @return
	 */
	List<Question> questionSelectByTopicId(String topicId);
	
	/**
	 * 根据昵称模糊搜索
	 * @param nickName
	 * @return
	 */
	List<Question> questionSelectByUidAndTopicId(String topicId,String uid);
	
	

}
