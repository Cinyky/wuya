package com.wuya.cyy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuya.cyy.utils.VerifyCodeUtils;


@Controller
@RequestMapping("/verifycode")
public class VerifyCodeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final int IMGWIDTH = 100;    //img width
	private static final int IMGHEIGHT = 34;	//img height
	
	@RequestMapping("/generateImg")
	public void generateImg(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
    	response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
        
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession(true);  
        //删除以前的
        session.removeAttribute("verifyCode");
        session.setAttribute("verifyCode", verifyCode.toLowerCase());  
        //生成图片  
        logger.warn("verifyCode:"+verifyCode);
        VerifyCodeUtils.outputImage(IMGWIDTH, IMGHEIGHT, response.getOutputStream(), verifyCode);  
	}
}
