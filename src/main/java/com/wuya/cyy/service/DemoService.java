package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Upvote;


/**
 * upvote service
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 17:07:47
 */
public interface DemoService {

	/**
	 * 新增 upvote
	 * @param upvote 回答
	 * @return
	 */
	boolean upvoteAdd(Upvote upvote);
	
	/**
	 * 更新 upvote
	 * @param upvote 回答
	 * @return
	 */
	boolean upvoteUpdate(Upvote upvote);
	
	/**
	 * 根据uid 搜索 upvote
	 * @param uid
	 * @return
	 */
	List<Upvote> upvoteSelectByUid(String uid);
	
	/**
	 * 根据upvoteId搜索
	 * @param upvoteId
	 * @return
	 */
	Upvote upvoteSelectByUpvoteId(String upvoteId);
	

	
	/**
	 * 根据answerId搜索
	 * @param answerId
	 * @return
	 */
	List<Upvote> upvoteSelectByAnswerId(String answerId);
	
	/**
	 * 根据answerId搜索
	 * @param answerId
	 * @return
	 */
	String upvoteCountSelectByAnswerId(String answerId);
	/**
	 * 查询upvote count 根据answerId uid 查看这个回答 是否点赞
	 * @return
	 */
	boolean upvoteSelectByAnswerIdAndUid(String answerId,String uid);
	
}
