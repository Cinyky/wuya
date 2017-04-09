package com.wuya.cyy.service;

import java.util.*;

import com.wuya.cyy.pojo.Report;


/**
 * report service
 * Cinyky 
 *
 * 2017年4月9日下午4:29:42
 */
public interface ReportService {

	/**
	 * 新增 report
	 * @param report 举报
	 * @return
	 */
	boolean reportAdd(Report report);
	
	/**
	 * 更新 report
	 * @param report 举报
	 * @return
	 */
	boolean reportUpdate(Report report);
	
	/**
	 * 根据uid 搜索 report
	 * @param uid
	 * @return
	 */
	List<Report> reportSelectByUid(String uid);
	
	/**
	 * 根据reportId搜索
	 * @param reportId
	 * @return
	 */
	Report reportSelectByReportId(String reportId);
	

	
	/**
	 * 根据answerId搜索
	 * @param answerId
	 * @return
	 */
	List<Report> selectReportByInfo(String reportInfo);
	
	/**
	 * 查询report count 根据answerId uid 查看这个举报 是否点赞
	 * @return
	 */
	List<Report> selectReportByTypeAndUid(String uid,int reportType);
	
}
