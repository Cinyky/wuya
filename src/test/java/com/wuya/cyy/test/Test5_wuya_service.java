package com.wuya.cyy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;
import com.wuya.cyy.service.Impl.QuestionServiceImpl;
import com.wuya.cyy.service.Impl.UpvoteServiceImpl;
import com.wuya.cyy.service.Impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test5_wuya_service {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/* ===================== 
	 * user service test
	 * =====================
	 **/
	@Autowired
	private UserServiceImpl userService;

	@Test
	public void testSecretQuestion_Add() throws Exception {
	}

	@Test
	public void testUser_SelectByNickName() throws Exception {
		List<User> userSelect = userService.userSelect("C");
		for (User user : userSelect) {
			logger.warn(user + "\n");
		}
	}

	@Test
	public void testUser_Add() throws Exception {
//		boolean userReg = userService.userReg("cyy2013142202", "12312322", "cyy1079276272@163.com", "Cinyky1234");
		boolean userReg = userService.userReg("1079276272", "276272", "cyy1079276272@163.com", "Cinyky1234");
		logger.warn(userReg ? "true" : "false");
	}
	
	@Test
	public void testUser_Login() throws Exception {
		User userLogin = userService.userLogin("cyy2013142202", "12312322");
		logger.warn(userLogin.toString());
	}
	
	/* ===================== 
	 * answer service test
	 * =====================
	 **/
	@Autowired
	private AnswerServiceImpl answerService;
	
	@Test
	public void testAnswer_Add() throws Exception {
		boolean answerAdd = answerService.answerAdd(new Answer("2791bb3c-8f89-420c-84d1-836d710c9a3f", "7d9db1cf-cc01-461a-af7b-be98e9aea0c0", "testInfo", 1));
		logger.warn("testAnswer_Add :"+(answerAdd? "true" : "false"));
	}
	
	@Test
	public void testAnswer_Select_info() throws Exception {
		List<Answer> answerSelectByInfo = answerService.answerSelectByInfo("test");
		if(answerSelectByInfo!=null && !answerSelectByInfo.isEmpty()){
			for (Answer answer : answerSelectByInfo) {
				logger.warn(answer.toString());
			}
			
		}
	
	}
	
	@Test
	public void testAnswer_Select_QuestionId() throws Exception {
		List<Answer> answerSelectByInfo = answerService.answerSelectByQuestionId("2791bb3c-8f89-420c-84d1-836d710c9a3f");
		if(answerSelectByInfo!=null && !answerSelectByInfo.isEmpty()){
			for (Answer answer : answerSelectByInfo) {
				logger.warn(answer.toString());
			}
		}
	
	}
	
	/* ===================== 
	 * upvote service test
	 * =====================
	 **/
	@Autowired
	private UpvoteServiceImpl upvoteService;
	
	@Test
	public void testLike_Add() throws Exception {
	    boolean upvoteAdd = upvoteService.upvoteAdd(new Upvote("7d9db1cf-cc01-461a-af7b-be98e9aea0c0", "d2852c7f-1e21-41e5-ad81-1c5538c7b6b3", 1));
		logger.warn("testLike_Add :"+(upvoteAdd? "true" : "false"));
	}
	
	@Test
	public void testLike_Select_answerId() throws Exception {
		String upvoteCountSelectByAnswerId = "";
			upvoteCountSelectByAnswerId = upvoteService.upvoteCountSelectByAnswerId("d2852c7f-1e21-41e5-ad81-1c5538c7b6b3");
			logger.warn(upvoteCountSelectByAnswerId==""?"null":upvoteCountSelectByAnswerId);
		
		
	}
	
	/* ===================== 
	 * question service test
	 * =====================
	 **/
	@Autowired
	private QuestionServiceImpl questionService;
	
	@Test
	public void testQuestion_Select_answerId() throws Exception {
		List<Question> selectQuestionByHot = questionService.selectQuestionByHot();
		logger.warn(selectQuestionByHot.size()+"");
	}


}
