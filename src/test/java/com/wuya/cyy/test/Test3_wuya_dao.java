package com.wuya.cyy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuya.cyy.dao.SecretQuestionDao;
import com.wuya.cyy.dao.UserDao;
import com.wuya.cyy.pojo.SecretQuestion;import com.wuya.cyy.pojo.User;
import com.wuya.cyy.utils.MD5Util;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test3_wuya_dao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SecretQuestionDao questionDao;
	@Autowired
	private UserDao userDao;

	
	@Test
	public void testSecretQuestion_Add() throws Exception {
		int addQuestion = questionDao.addQuestion(new SecretQuestion("tt2", "tt", "测试2", "无题2",11));
		System.out.println(addQuestion);
	}
	
	
	@Test
	public void testSecretQuestion_QueryById() throws Exception {
		List<SecretQuestion> questions=questionDao.queryByUid("tt");
		for (SecretQuestion secretQuestion : questions) {
			System.out.println(secretQuestion.toString());
		}
	}

	@Test
	public void testUser_Add() throws Exception {
//		long ss =0;
//		User user = new User("2013142202", "cyy", "cyy10208023cy", "1079276272@qq.com", 
//				"123123", "Cinyky", 1, "i'm a boy", "haha", "China", "asd", ss, ss, ss, 1);
		long ss =0;
		String pwd =MD5Util.encode2hex("cyy10208023cy");
		User user = new User("2013142204", "cyy3",pwd, "1079276272@qq.com", 
				"123123", "Cinyky", 1, "i'm a boy", "haha", "China", "asd", ss, ss, ss, 1);
		int addUser = userDao.addUser(user);
		System.out.println(addUser);
	}
	
	@Test
	public void testUser_QueryById() throws Exception {
		User user  = userDao.selectUserByUid("2013142204");
			System.out.println(user.toString());
	}
	
	
	@Test
	public void testUser_login() throws Exception {
		String pwd =MD5Util.encode2hex("cyy10208023cy");
		User user  = userDao.selectUserByUidAndPwd("2013142204", pwd);
			System.out.println(user.toString());
	}
}
