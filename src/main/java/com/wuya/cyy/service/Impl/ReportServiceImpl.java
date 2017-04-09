package com.wuya.cyy.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.cyy.dao.ReportDao;
import com.wuya.cyy.dao.UpvoteDao;
import com.wuya.cyy.pojo.Report;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.service.ReportService;
import com.wuya.cyy.service.UpvoteService;
/**
 * report
 * Cinyky 
 *
 * 2017年4月9日下午4:36:26
 */
@Service
public class ReportServiceImpl implements ReportService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReportDao reportDao;

	@Override
	public boolean reportAdd(Report report) {
		return reportDao.addReport(report)>0;
	}

	@Override
	public boolean reportUpdate(Report report) {
		return reportDao.updateReport(report)>0;
	}

	@Override
	public List<Report> reportSelectByUid(String uid) {
		return reportDao.selectReportByUid(uid);
	}

	@Override
	public Report reportSelectByReportId(String reportId) {
		return reportDao.selectReportByReportId(reportId);
	}

	@Override
	public List<Report> selectReportByInfo(String reportInfo) {
		return reportDao.selectReportByInfo(reportInfo);
	}

	@Override
	public List<Report> selectReportByTypeAndUid(String uid, int reportType) {
		return reportDao.selectReportByTypeAndUid(uid, reportType);
	}
	

}
