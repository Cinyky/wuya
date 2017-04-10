package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Share;


/**
 * share service
 * @author Cinyky
 * junliang mint
 * 6 Apr 2017 17:07:47
 */
public interface ShareService {

	/**
	 * 新增 share
	 * @param share 分享
	 * @return
	 */
	boolean shareAdd(Share share);
	
	/**
	 * 更新 share
	 * @param share 分享
	 * @return
	 */
	boolean shareUpdate(Share share);
	
	/**
	 * 根据uid 搜索 share
	 * @param uid
	 * @return
	 */
	List<Share> shareSelectByUid(String uid);
	
	/**
	 * 根据answerId搜索
	 * @param answerId
	 * @return
	 */
	List<Share> shareSelectByType(int shareType);
	/**
	 * 查询share count 根据answerId uid 查看这个分享 是否点赞
	 * @return
	 */
	List<Share> shareSelectByTypeAndUid(int shareType,String uid);
	
}
