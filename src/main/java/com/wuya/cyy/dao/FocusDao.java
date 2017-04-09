package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Focus;


/**
 * 关注问题dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface FocusDao {
	/**
	 * 增加focus
	 * @param focus
	 * @return
	 */
	int addFocus(Focus focus);
	
	/**
	 * 更新focus
	 * @param focus
	 * @return
	 */
	int updateFocus(Focus focus);
	
	/**
	 * delete
	 * @param focus
	 * @return
	 */
	int deleteFocus(Focus focus);
	
	/**
	 * 查询关注 根据uid
	 * @return
	 */
	List<Focus> selectFocusByUid(String uid);
	
	/**
	 * 根据uid type
	 * @return
	 */
	List<Focus> selectFocusByUidAndType(@Param("uid")String uid,@Param("focusType")int focusType);
	

	/**
	 * 根据uid focusId
	 * @return
	 */
	Focus selectFocusExsist(Focus focus);
	
	String selectFocusCount(@Param("id")String id);
	
}
