package com.wuya.cyy.dao;

import java.util.List;

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
	List<Friend> selectFriendByUid(String uid);
	
	/**
	 * 查询friend 根据uid anotherUid
	 * @return
	 */
	List<Friend> selectFriendByAnotherUid(String anotherUid);
	
}
