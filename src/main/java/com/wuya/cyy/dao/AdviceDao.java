package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Admin;
import com.wuya.cyy.pojo.Advice;
import com.wuya.cyy.pojo.Question;

/**
 * advice dao
 * Cinyky 
 *
 * 2017年3月21日下午10:32:56
 */
public interface AdviceDao {
	/**
	 * 增加advice
	 * @param advice
	 * @return
	 */
	int addAdvice(Advice advice);
	
	/**
	 * 更新advice
	 * @param user
	 * @return
	 */
	int updateAdvice(Advice advice);
	
	/**
	 * 根据adviceID查询advice
	 * @return
	 */
	Advice selectAdviceByAdviceID(@Param("adviceId")String adviceId);
	
	/**
	 * 根据uid查询advice
	 * @return
	 */
	List<Advice> selectAdviceByUid(@Param("uid")String uid);
	
	/**
	 * 查询advice
	 * @return
	 */
	List<Advice> selectAdvice();
	
	/**
	 * total advice count
	 */
	String selectTotalAdviceCount();
	
	/**
	 * total advice count
	 */
	String selectTodayAdviceCount(@Param("startTime")Long startTime,@Param("endTime")Long endTime);
	
	/**
	 * 
	 * @param todayTime
	 * @return
	 */
	List<Advice> selectAdviceByPage(@Param("start")int start,@Param("pageSize")int pageSize);
	
}
