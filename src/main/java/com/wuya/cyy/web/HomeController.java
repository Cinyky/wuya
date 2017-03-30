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
import javax.servlet.http.Cookie;
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
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource  
    private UserServiceImpl userService;
    @RequestMapping(value="/",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userLogin(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException{  
    	boolean isCookie = false;
    	Cookie[] cookies = request.getCookies();
    	if(cookies!=null&&cookies.length>0){
    		for (Cookie cookie : cookies) {
        		if("user".equalsIgnoreCase(cookie.getName())){
        			String uid = cookie.getValue();
        			User user = userService.userSelectByUid(uid);
        			if(user!=null){
        				isCookie = true;
        				HttpSession session = request.getSession(true);
        				if((User)session.getAttribute("user")!=null){
        					session.removeAttribute("user");
        				}
        				session.setAttribute("user", user);
        			}
        		}
    		}
    	}
    	
    	
        ModelAndView mav=new ModelAndView();
        if(isCookie){
            mav.setViewName("redirect:/wuya-index.jsp");
        }else{
        	mav.setViewName("forward:/wuya-login.jsp");
        }
        return mav;  
    }  

}
