package com.wuya.cyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuya.cyy.pojo.Report;


/**
 * report dao
 * Cinyky 
 *
 * 2017年3月26日下午9:39:03
 */
public interface ReportDao {
	/**
	 * 增加report
	 * @param report
	 * @return
	 */
	int addReport(Report report);
	
	/**
	 * 更新report
	 * @param report
	 * @return
	 */
	int updateReport(Report report);
	
	
	/**
	 * 查询report 根据uid
	 * @return
	 */
	List<Report> selectReportByUid(String uid);
	
	/**
	 * 查询report 根据info模糊
	 * @return
	 */
	List<Report> selectReportByInfo(@Param("questionInfo")String questionInfo);
	
	/**
	 * 查询report 根据uid reportType
	 * @return
	 */
	List<Report> selectReportByTypeAndUid(@Param("uid")String uid,@Param("uid")int reportType);
	
}