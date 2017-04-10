package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * delete answer
	 * @param answerId
	 * @param uid
	 * @return
	 */
	int deleteUpvote(@Param("answerId")String answerId,@Param("uid")String uid);
	
	
	/**
	 * 查询upvote 根据uid
	 * @return
	 */
	List<Upvote> selectUpvoteByUid(@Param("uid")String uid);
	
	/**
	 * 查询upvote 根据upvoteId
	 * @return
	 */
	Upvote selectUpvoteByUpvoteId(@Param("upvoteId")String upvoteId);
	/**
	 * 查询upvote 根据answerId
	 * @return
	 */
	List<Upvote> selectUpvoteByAnswerId(@Param("answerId")String answerId);
	
	/**
	 * 查询upvote count 根据answerId
	 * @return
	 */
	String selectUpvoteCountByAnswerId(@Param("answerId")String answerId);
	
	/**
	 * 查询upvote count 根据answerId uid
	 * @return
	 */
	Upvote selectUpvoteByAnswerIdAndUid(@Param("answerId")String answerId,@Param("uid")String uid);
}
