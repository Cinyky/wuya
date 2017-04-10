package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Friend;


/**
 * 好友dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface FriendDao {
	/**
	 * 增加friend
	 * @param friend
	 * @return
	 */
	int addFriend(Friend friend);
	
	/**
	 * 更新friend
	 * @param friend
	 * @return
	 */
	int updateFriend(Friend friend);
	
	
	/**
	 * 查询friend 根据uid anotherUid
	 * @return
	 */
	List<Friend> selectFriendByUid(@Param("uid")String uid);
	
	/**
	 * 查询friend 根据uid anotherUid
	 * @return
	 */
	List<Friend> selectFriendByAnotherUid(@Param("anotherUid")String anotherUid);
	
	/**
	 * 查询friend 根据uid 关注的人数
	 * @return
	 */
	String selectFriendCountByUid(@Param("uid")String uid);
	
	/**
	 * 查询friend 根据uid anotherUid
	 * @return
	 */
	String selectFriendCountByAnotherUid(@Param("anotherUid")String anotherUid);
	
}
