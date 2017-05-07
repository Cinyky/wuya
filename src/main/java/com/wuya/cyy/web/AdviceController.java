package com.wuya.cyy.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuya.cyy.dao.AdviceDao;
import com.wuya.cyy.pojo.Advice;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.AdviceServiceImpl;

/**
 * 
 * adminDao
 * Cinyky 
 *
 * 2017年5月6日下午2:43:42
 */
@Controller
@RequestMapping("/advice") // url:/模块/资源/{id}/细分 /seckill/list
public class AdviceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdviceServiceImpl adviceService;
	
	@RequestMapping(value="/{adviceInfo}/add",method={RequestMethod.GET,RequestMethod.POST})  
	@ResponseBody
    public void  emailVerify(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("adviceInfo")String adviceInfo
    		) throws ParseException, IOException{ 
		logger.warn("advice add------"+adviceInfo);
		ServletOutputStream outputStream = response.getOutputStream();
		User myuser = (User)request.getSession(true).getAttribute("user");
		boolean adviceAdd = adviceService.adviceAdd(new Advice(myuser.getUid(), adviceInfo, 1));
		outputStream.print(adviceAdd?"1":"2");
    }
	
}
