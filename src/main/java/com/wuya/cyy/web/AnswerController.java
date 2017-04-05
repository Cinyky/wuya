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
 * answer Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:08:03
 */

@Controller
@RequestMapping("/search") // url:/模块/资源/{id}/细分 /seckill/list
public class AnswerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Resource  
    private RegisterValidateService service;
	@Resource  
    private UserServiceImpl userService;
     
	/**
	 * 
	 * 综合查询 用户 && 问题 && answer
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value="/multiple",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  getQuestionDetail(HttpServletRequest request,HttpServletResponse response,
    		String searchInfo
    		) throws ParseException{  
    	String contextPath = request.getContextPath();
        ModelAndView mav=new ModelAndView();  
        String email = "";
        String method = request.getMethod();
        return mav;  
    }  
    
    //分享问题
    @RequestMapping(value="/{searchMethod}/detail",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView  shareQuestion(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("searchMethod")String searchMethod,
    		String searchInfo
    		) throws ParseException{  
    	String contextPath = request.getContextPath();
        logger.warn("-----search searchMethod==>"+searchMethod+"----");  
        ModelAndView mav=new ModelAndView();  
        String method = request.getMethod();
        return mav;  
    }
    
}
