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
import com.wuya.cyy.pojo.SecretQuestion;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.UserServiceImpl;
import com.wuya.cyy.utils.MD5Util;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test5_wuya_service {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
		boolean userReg = userService.userReg("cyy2013142202", "12312322", "cyy1079276272@163.com", "Cinyky1234");
		logger.warn(userReg ? "true" : "false");
	}
	
	@Test
	public void testUser_Login() throws Exception {
		User userLogin = userService.userLogin("cyy2013142202", "12312322");
		logger.warn(userLogin.toString());
	}

}
