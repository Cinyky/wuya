package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Focus;


/**
 * focus service
 * Cinyky 
 *
 * 2017年4月9日下午4:00:48
 */
public interface FocusService {

	/**
	 * 新增 focus
	 * @param focus 关注
	 * @return
	 */
	boolean focusAdd(Focus focus);
	
	/**
	 * 更新 focus
	 * @param focus 关注
	 * @return
	 */
	boolean focusUpdate(Focus focus);
	
	/**
	 * 根据uid 搜索 focus
	 * @param uid
	 * @return
	 */
	List<Focus> focusSelectByUid(String uid);
	
	/**
	 * 查询focus count 根据answerId uid 查看这个关注 是否点赞
	 * @return
	 */
	List<Focus> focusSelectByUidAndType(String uid,int focusType);
	
	boolean focusExsist(Focus focus);

	boolean focusDelete(Focus focus);

	String focusCount(String id);
	
}
