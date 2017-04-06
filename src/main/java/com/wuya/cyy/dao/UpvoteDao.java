package com.wuya.cyy.dao;

import java.util.List;

import com.wuya.cyy.pojo.Upvote;


/**
 * upvote dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface UpvoteDao {
	/**
	 * 增加upvote
	 * @param upvote
	 * @return
	 */
	int addUpvote(Upvote upvote);
	
	/**
	 * 更新upvote
	 * @param upvote
	 * @return
	 */
	int updateUpvote(Upvote upvote);
	
	
	/**
	 * 查询upvote 根据uid
	 * @return
	 */
	List<Upvote> selectUpvoteByUid(String uid);
	
	/**
	 * 查询upvote 根据upvoteId
	 * @return
	 */
	Upvote selectUpvoteByUpvoteId(String upvoteId);
	/**
	 * 查询upvote 根据answerId
	 * @return
	 */
	List<Upvote> selectUpvoteByAnswerId(String answerId);
	
	/**
	 * 查询upvote count 根据answerId
	 * @return
	 */
	String selectUpvoteCountByAnswerId(String answerId);
	
	/**
	 * 查询upvote count 根据answerId uid
	 * @return
	 */
	Upvote selectUpvoteByAnswerIdAndUid(String answerId,String uid);
}
