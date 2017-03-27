package com.wuya.cyy.dao;

import java.util.List;

import com.wuya.cyy.pojo.Like;


/**
 * like dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface LikeDao {
	/**
	 * 增加like
	 * @param like
	 * @return
	 */
	int addFriend(Like like);
	
	/**
	 * 更新like
	 * @param like
	 * @return
	 */
	int updateFriend(Like like);
	
	
	/**
	 * 查询like 根据uid
	 * @return
	 */
	List<Like> selectLikeByUid(String uid);
	
	/**
	 * 查询like 根据uanswerId
	 * @return
	 */
	List<Like> selectLikeByAnswerId(String answerId);
	
}
