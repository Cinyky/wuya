package com.wuya.cyy.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.xmlrpc.base.Array;
import com.wuya.cyy.dao.AdminDao;
import com.wuya.cyy.dao.AdviceDao;
import com.wuya.cyy.dao.AnswerDao;
import com.wuya.cyy.dao.QuestionDao;
import com.wuya.cyy.dao.ReportDao;
import com.wuya.cyy.dao.TopicDao;
import com.wuya.cyy.dao.UserDao;
import com.wuya.cyy.pojo.Admin;
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Page;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Report;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.utils.DateUtil;
import com.wuya.cyy.utils.MD5Util;

/**
 * 
 * adminDao
 * Cinyky 
 *
 * 2017年5月6日下午2:43:42
 */
@Controller
@RequestMapping("/admin") // url:/模块/资源/{id}/细分 /seckill/list
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminDao adminDao;
	@Resource  
    private UserDao userDao;
	@Resource  
    private QuestionDao questionDao;
	@Resource  
    private AnswerDao answerDao;
	@Resource  
    private AdviceDao adviceDao;
	@Resource
	private ReportDao reportDao;
	
	@Resource
	private TopicDao topicDao;
	
	@RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  userLogin(HttpServletRequest request,HttpServletResponse response,
	    		String loginName,
	    		String pwd,
	    		String verifycode
	    		) throws ParseException{
	    	ModelAndView mav=new ModelAndView();
	    	HttpSession session = request.getSession(true);
	    	String method = request.getMethod();
	    	logger.warn("-----adminLogin login---- method:"+method); 
	    	if("get".equalsIgnoreCase(method)){
	    		String info = (String) request.getParameter("txt");
	    		if( info!=null && !info.isEmpty() ){
	    			mav.addObject("txt", info);
	    		}
	    		mav.setViewName("forward:../wuya-admin-login.jsp");
	    	}else{
	    		Admin adminLogin = adminDao.selectUserByUidAndPwd(loginName, MD5Util.encode2hex(pwd));
	    		if(adminLogin!=null){
	    	        	String code = (String) session.getAttribute("verifyCode");
	    	        	if(code != null){
		    	        	if(verifycode.equals(code)){
		    	        		session.setAttribute("admin", adminLogin);
		    	        		mav.setViewName("redirect:/admin/home");
		    	        	}else{
		    	        		mav.addObject("txt","验证码错误");
		    	        		mav.setViewName("redirect:login");
		    	        	}
	    	        	}else{
	    	        		mav.addObject("txt","验证码错误");
	        	        	mav.setViewName("redirect:login");
	    	        	}
	    	        }else{
	    	        	mav.addObject("txt","账号密码错误");
	    	        	mav.setViewName("redirect:login");
	    	        }
	    	       
	    	}
	        return mav;  
	    }  
	@RequestMapping(value="/home",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  userIndex(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:../wuya-admin-index.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		//user count
		Integer totalUserCount = Integer.parseInt(userDao.selectAllUserCount());
		Integer todayUserCount  = Integer.parseInt(userDao.selectTodayUserCount(startTime,endTime));
		mav.addObject("totalUserCount", totalUserCount);
		mav.addObject("todayUserCount", todayUserCount);
		//question count
		Integer totalQuestionCount = Integer.parseInt(questionDao.selectQuestionCountByHot());
		Integer todayQuestionCount = Integer.parseInt(questionDao.selectTodayQuestionCount(startTime, endTime));
		mav.addObject("totalQuestionCount", totalQuestionCount);
		mav.addObject("todayQuestionCount", todayQuestionCount);
		//answer count
		Integer totalAnswerCount = Integer.parseInt(answerDao.selectTotalAnswerCount());
		Integer todayAnswerCount = Integer.parseInt(answerDao.selectTodayAnswerCount(startTime, endTime));
		mav.addObject("totalAnswerCount", totalAnswerCount);
		mav.addObject("todayAnswerCount", todayAnswerCount);
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		
		//report
		Integer	todayReportCount = Integer.parseInt(reportDao.selectTodayReportCount(startTime, endTime));
		mav.addObject("todayReportCount", todayReportCount);
		return mav;
	}
	
	@RequestMapping(value="/user/statistics",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  useStatistics(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/wuya-admin-user-statistics.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		//report
		Integer	todayReportCount = Integer.parseInt(reportDao.selectTodayReportCount(startTime, endTime));
		mav.addObject("todayReportCount", todayReportCount);
		
		String currentPage = (String)request.getParameter("currentpage");
		Page page = null;
		Integer totalCount = Integer.parseInt(userDao.selectAllUserCount());
		Integer pageNow = 1;
		if(currentPage != null && !currentPage.isEmpty()){
			pageNow = Integer.parseInt(currentPage);
		}
		page = new Page(totalCount, pageNow);
		List<User> users = userDao.selectUserByPage(page.getStartPos(), page.getPageSize());
		mav.addObject("users", users);
		mav.addObject("userpage", page);
		return mav;
	}
	
	@RequestMapping(value="/question/statistics",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  questionStatistics(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/wuya-admin-question-statistics.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		//report
		Integer	todayReportCount = Integer.parseInt(reportDao.selectTodayReportCount(startTime, endTime));
		mav.addObject("todayReportCount", todayReportCount);
		
		String currentPage = (String)request.getParameter("currentpage");
		Page page = null;
		Integer totalCount = Integer.parseInt(questionDao.selectQuestionCountByHot());
		Integer pageNow = 1;
		if(currentPage != null && !currentPage.isEmpty()){
			pageNow = Integer.parseInt(currentPage);
		}
		page = new Page(totalCount, pageNow);
		List<Question> questions = questionDao.selectQuestionByPage(page.getStartPos(), page.getPageSize());
		for (Question question : questions) {
			User uu = userDao.selectUserByUid(question.getUid());
			question.setUser(uu);
			Topic tt = topicDao.selectTopicByTopicId(question.getTopicId());
			question.setTopic(tt);
		}
		mav.addObject("questions", questions);
		mav.addObject("questionpage", page);
		return mav;
	}
	
	@RequestMapping(value="/answer/statistics",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  answerStatistics(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/wuya-admin-answer-statistics.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		//report
		Integer	todayReportCount = Integer.parseInt(reportDao.selectTodayReportCount(startTime, endTime));
		mav.addObject("todayReportCount", todayReportCount);
		
		String currentPage = (String)request.getParameter("currentpage");
		Page page = null;
		Integer totalCount = Integer.parseInt(answerDao.selectTotalAnswerCount());
		Integer pageNow = 1;
		if(currentPage != null && !currentPage.isEmpty()){
			pageNow = Integer.parseInt(currentPage);
		}
		page = new Page(totalCount, pageNow);
		List<Answer> answers = answerDao.selectAnswerByPage(page.getStartPos(), page.getPageSize());
		for (Answer answer : answers) {
			User uu = userDao.selectUserByUid(answer.getUid());
			answer.setUser(uu);
			Question qq = questionDao.selectQuestionByQuestionId(answer.getQuestionId());
			answer.setQuestion(qq);
		}
		mav.addObject("answers", answers);
		mav.addObject("answerpage", page);
		return mav;
	}
	
	@RequestMapping(value="/suggestion",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  suggestion(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/wuya-admin-suggestion.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		
		String currentPage = (String)request.getParameter("currentpage");
		Page page = null;
		Integer totalCount = Integer.parseInt(adviceDao.selectTotalAdviceCount());
		Integer pageNow = 1;
		if(currentPage != null && !currentPage.isEmpty()){
			pageNow = Integer.parseInt(currentPage);
		}
		page = new Page(totalCount, pageNow);
		List<com.wuya.cyy.pojo.Advice> advices = adviceDao.selectAdviceByPage(page.getStartPos(), page.getPageSize());
		for (com.wuya.cyy.pojo.Advice advice : advices) {
			User selectUserByUid = userDao.selectUserByUid(advice.getUid());
			advice.setUser(selectUserByUid);
		}
		mav.addObject("advices", advices);
		mav.addObject("advicepage", page);
		
		return mav;
	}
	
	
	@RequestMapping(value="/report",method={RequestMethod.GET,RequestMethod.POST})  
	public ModelAndView  report(HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/wuya-admin-report.jsp");
		Long startTime = DateUtil.getStartTime();
		Long endTime = DateUtil.getEndTime();
		
		//advice
		Integer todayAdviceCount = Integer.parseInt(adviceDao.selectTodayAdviceCount(startTime, endTime));
		mav.addObject("todayAdviceCount", todayAdviceCount);
		
		String currentPage = (String)request.getParameter("currentpage");
		Page page = null;
		Integer totalCount = Integer.parseInt(reportDao.selectTotalReportCount());
		Integer pageNow = 1;
		if(currentPage != null && !currentPage.isEmpty()){
			pageNow = Integer.parseInt(currentPage);
		}
		page = new Page(totalCount, pageNow);
		List<Report> reports = reportDao.selectReportByPage(page.getStartPos(), page.getPageSize());
		List<Report> retReports = new ArrayList<>();
		for (Report report : reports) {
			User uu = userDao.selectUserByUid(report.getUid());
			report.setUser(uu);
			int reportType = report.getReportType();
			String id = report.getId();
			if(reportType==1){
				Answer answer = answerDao.selectAnswerByAnswerId(id);
				if(answer==null)
					continue;
				User user = userDao.selectUserByUid(answer.getUid());
				if(user==null){
					continue;
				}
				answer.setUser(user);
				report.setAnswer(answer);
			}else if(reportType==2){
				Question question = questionDao.selectQuestionByQuestionId(id);
				if(question == null) 
					continue;
				User user = userDao.selectUserByUid(question.getUid());
				if(user==null){
					continue;
				}
				question.setUser(user);
				report.setQuestion(question);
			}
			retReports.add(report);
		}
		mav.addObject("reports", retReports);
		mav.addObject("reportpage", page);
		return mav;
	}
	
	//封号
	@RequestMapping(value="/user/{uid}/{dayAmount}/ban",method={RequestMethod.GET,RequestMethod.POST})  
	@ResponseBody
    public void  userBan(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("uid")String uid,
    		@PathVariable("dayAmount")String dayAmount
    		) throws ParseException, IOException{ 
		logger.warn("ban user uid ------"+uid+"dayAmount:"+dayAmount);
		ServletOutputStream outputStream = response.getOutputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		boolean banSuccess = false;
		String result = "";
		if(uid == null || uid == "") {
			result="error|数据异常";
		}else{
			User user = userDao.selectUserByUid(uid);
			if(user == null) 
				result="error|数据异常";
			else{
				Long days= Long.parseLong(dayAmount);
				Long currentTime = System.currentTimeMillis();
				Long spendTime = (long) (24*60*60*1000*days);
				Long banTime = currentTime+spendTime;
				user.setBanTime(banTime);
				int updateUser = userDao.updateUser(user);
				banSuccess = updateUser>0;
				if(banSuccess){
					objectMapper.writeValue(outputStream, user);
					return;
				}else{
					result ="error|封号失败";
				}
			}
		}
		objectMapper.writeValue(outputStream, result);
		
    }
	
	//解禁
	@RequestMapping(value="/user/{uid}/cancel/ban",method={RequestMethod.GET,RequestMethod.POST})  
	@ResponseBody
    public void  userCancel(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("uid")String uid
    		) throws ParseException, IOException{ 
		logger.warn("ban user uid ------"+uid);
		ServletOutputStream outputStream = response.getOutputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		boolean banSuccess = false;
		String result = "";
		if(uid == null || uid == "") {
			result="error|数据异常";
		}else{
			User user = userDao.selectUserByUid(uid);
			if(user == null) 
				result="error|数据异常";
			else{
				Long banTime = 0L;
				user.setBanTime(banTime);
				int updateUser = userDao.updateUser(user);
				banSuccess = updateUser>0;
				if(banSuccess){
					objectMapper.writeValue(outputStream, user);
					return;
				}else{
					result ="error|解禁失败";
				}
			}
		}
		objectMapper.writeValue(outputStream, result);
    }
	
	
}
	
