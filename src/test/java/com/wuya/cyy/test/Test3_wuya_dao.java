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
import com.wuya.cyy.pojo.SecretQuestion;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test3_wuya_dao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SecretQuestionDao questionDao;

	@Test
	public void testQueryById() throws Exception {
		List<SecretQuestion> questions=questionDao.queryByUid("tt");
		for (SecretQuestion secretQuestion : questions) {
			System.out.println(secretQuestion.toString());
		}
	}
	
	@Test
	public void testAdd() throws Exception {
		int addQuestion = questionDao.addQuestion(new SecretQuestion("tt2", "tt", "测试2", "无题2",11));
		System.out.println(addQuestion);
	}
}
