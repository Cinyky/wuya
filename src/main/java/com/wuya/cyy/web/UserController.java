package com.wuya.cyy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.UserServiceImpl;
import com.wuya.cyy.utils.ServiceException;
/**
 * 用户controller
 * Cinyky 
 *
 * 2017年3月21日上午8:50:13
 */

@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Resource  
    private RegisterValidateService service;
	@Resource  
    private UserServiceImpl userService;
	
	

      
    @RequestMapping(value="/{action}",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userReg(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("action")String action,
    		String user_name,
    		String pwd,
    		String bind_email,
    		String nickName
    		) throws ParseException{  
    	String contextPath = request.getContextPath();
        logger.warn("-----user action=="+action+"----");  
        ModelAndView mav=new ModelAndView();  
        String email = "";
        if("register".equals(action)) { 
        	String method = request.getMethod();
	       	 logger.warn("-----userLogin---- method:"+method); 
	       	if("get".equalsIgnoreCase(method)){
	       		mav.setViewName("forward:../wuya-reg.jsp");
	       	}else{
	       		logger.warn("-----user_name----"+user_name); 
	        	logger.warn("-----user_name----"+pwd);
	        	logger.warn("-----user_name----"+bind_email);
	        	logger.warn("-----user_name----"+nickName);
	            boolean isReg = userService.userReg(user_name, pwd, bind_email, nickName);
	            logger.warn("-----reg isSuccess----"+isReg);  
	            if(isReg){
	            	mav.addObject("text","注册成功");
	            }else{
	            	mav.addObject("text","注册失败");
	            }
	            
	            mav.addObject("user_name", user_name);
	            mav.setViewName("register_success");  
	       	}
        	
        }   
        else if("activate".equals(action)) {  
            //激活  
            email = request.getParameter("email");//获取email  
            String validateCode = request.getParameter("validateCode");//激活码  
            logger.warn("-----reg----"+email);  
            logger.warn("-----reg----"+validateCode);
            try {  
                service.processActivate(email , validateCode);//调用激活方法  
                mav.setViewName("activate_success");  
            } catch (ServiceException e) {  
                request.setAttribute("message" , e.getMessage());  
                mav.setViewName("activate_failure");  
            }  
              
        }  
        return mav;  
    }  
    
    @RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userLogin(HttpServletRequest request,HttpServletResponse response,
    		String loginCondition,
    		String pwd,
    		String verifycode
    		) throws ParseException{
    	ModelAndView mav=new ModelAndView();
    	HttpSession session = request.getSession(true);
    	String method = request.getMethod();
    	 logger.warn("-----userLogin---- method:"+method); 
    	if("get".equalsIgnoreCase(method)){
    		mav.setViewName("forward:../wuya-login.jsp");
    	}else{
    	        User userLogin = userService.userLogin(loginCondition, pwd);
    	        if(userLogin!=null){
    	        	session.setAttribute("user", userLogin);
    	        	
    	        	String code = (String) session.getAttribute("verifyCode");
    	        	if(code.equals(verifycode)){
    	        		mav.addObject("txt","success");
    	        	}else{
    	        		mav.addObject("txt","success but code null");
    	        	}
    	            logger.warn("-----login----");
    	            mav.setViewName("redirect:/user/u/"+userLogin.getNickName()+"/home");
    	           
    	        }else{
    	        	mav.addObject("txt","fail");
    	        	mav.setViewName("redirect:login");
    	        }
    	       
    	}
        return mav;  
    }  
    
    
    @RequestMapping(value="/u/{nickname}/home",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userHome(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("nickname")String nickname
    		) throws ParseException{
    	ModelAndView mav=new ModelAndView();
    	HttpSession session = request.getSession(true);
    	String method = request.getMethod();
    	 logger.warn("-----userLogin---- method:"+method); 
    	if("get".equalsIgnoreCase(method)){
    		mav.addObject("nickname", nickname);
    		mav.setViewName("forward:/wuya-index.jsp");
    	}
        return mav;  
    }  

}
