package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Advice;


/**
 * advice Service
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 19:19:08
 */
public interface AdviceService {

	/**
	 * 新增 advice
	 * @param advice 意见反馈
	 * @return
	 */
	boolean adviceAdd(Advice advice);
	
	/**
	 * 更新 advice
	 * @param advice 意见反馈
	 * @return
	 */
	boolean adviceUpdate(Advice advice);
	
	/**
	 * 根据adviceId搜索
	 * @param adviceId
	 * @return
	 */
	Advice adviceSelectByAdviceId(String adviceId);

	/**
	 * 根据uid 搜索 advice
	 * @param uid
	 * @return
	 */
	List<Advice> adviceSelectByUid(String uid);
	
	/**
	 * 
	 * @param questionId
	 * @return
	 */
	List<Advice> adviceSelect();
	
	
}
