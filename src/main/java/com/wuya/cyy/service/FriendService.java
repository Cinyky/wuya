package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Friend;


/**
 * friend Service
 * Cinyky 
 *
 * 2017年4月9日下午4:18:03
 */
public interface FriendService {

	/**
	 * 新增 friend
	 * @param friend 好友
	 * @return
	 */
	boolean friendAdd(Friend friend);
	
	/**
	 * 更新 friend
	 * @param friend 好友
	 * @return
	 */
	boolean friendUpdate(Friend friend);
	
	/**
	 * 根据uid 搜索 friend
	 * @param uid
	 * @return
	 */
	List<Friend> friendSelectByUid(String uid);
	
	/**
	 * 根据friendId搜索
	 * @param anotherUid
	 * @return
	 */
	List<Friend> friendSelectByAnotherUid(String anotherUid);
	
	
}
