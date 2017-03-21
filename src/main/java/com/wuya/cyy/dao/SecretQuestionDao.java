package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.SecretQuestion;

/**
 * 密保问题dao
 * Cinyky
 *
 * 2017年3月21日下午7:18:24
 */
public interface SecretQuestionDao {
	
	/**
	 * 增加密保问题
	 * @param secretQuestion
	 * @return
	 */
	int addQuestion(SecretQuestion secretQuestion);
	
	/**
	 * 删除密保问题
	 * @param questionId
	 * @return
	 */
	int deleteQuestion(String questionId);
	
	/**
	 * 删除密保问题 重置密保问题
	 * @param uid
	 * @return
	 */
	int deleteAllQuestion(String uid);

	/**
	 * 更新
	 * @param secretQuestion
	 * @return
	 */
	int updateQuestion(SecretQuestion secretQuestion);
	

	/**
	 * 更新 修改问题的答案
	 * @param secretQuestion
	 * @return
	 */
	int updateQuestionByQid(String questionId);
	
	/**
	 * 通过userId查询所有密保问题
	 * @return SecretQuestion
	 */
	List<SecretQuestion> queryByUid(@Param("uid")String uid);
	
	

	
}
