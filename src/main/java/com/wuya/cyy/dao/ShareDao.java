package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Share;



/**
 * share dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface ShareDao {
	/**
	 * 增加share
	 * @param share
	 * @return
	 */
	int addShare(Share share);
	
	/**
	 * 更新share
	 * @param share
	 * @return
	 */
	int updateShare(Share share);
	
	
	/**
	 * 查询share 根据uid
	 * @return
	 */
	List<Share> selectShareByUid(String uid);
	

	/**
	 * 查询share 根据shareId
	 * @return
	 */
	List<Share> selectShareByShareId(String shareId);
	
	/**
	 * 查询share 根据type
	 * @return
	 */
	List<Share> selectShareByType(@Param("shareType")int shareType);
	
	/**
	 * 查询share 根据type
	 * @return
	 */
	List<Share> selectShareByTypeAndUid(@Param("shareType")int shareType,@Param("shareType")String uid);
	
	
}
