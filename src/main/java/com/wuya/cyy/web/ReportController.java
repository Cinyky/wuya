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
import com.wuya.cyy.pojo.Report;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.ReportServiceImpl;
import com.wuya.cyy.service.Impl.UserServiceImpl;
import com.wuya.cyy.utils.ServiceException;
/**
 * report Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:12:05
 */
@Controller
@RequestMapping("/report") // url:/模块/资源/{id}/细分 /seckill/list
public class ReportController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Resource  
    private ReportServiceImpl reportService;
     
	
	
	/**
	 * 
	 *	新增Report
	 * @return
	 * @throws ParseException
	 * @throws IOException 
	 */
    @RequestMapping(value="/{reportType}/add",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public void  addQuestion(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("reportType")String reportType,
    		String reportId,
    		String reportInfo
    		) throws ParseException, IOException{  
//    	type 1 answer  type 2 question
    	User user = (User)request.getSession(true).getAttribute("user");
        logger.warn("-----report reportType==>"+reportType+"---reportId==>"+reportId+"---reportInfo==>"+reportInfo);  
        Report report = new Report(user.getUid(), Integer.parseInt(reportType), reportId, reportInfo);
        boolean reportAdd = reportService.reportAdd(report);
        // 1 举报成功 2.举报失败
        response.getOutputStream().print(reportAdd?"1":"2");
    } 
	
	/**
	 * 
	 *	问题详情
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value="/{questionId}/detail",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  getQuestionDetail(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("questionId")String questionId,
    		String user_name,
    		String pwd,
    		String bind_email,
    		String nickName
    		) throws ParseException{  
    	String contextPath = request.getContextPath();
        logger.warn("-----question questionId==>"+questionId+"----");  
        ModelAndView mav=new ModelAndView();  
        String email = "";
        String method = request.getMethod();
        return mav;  
    }  
    
    

}
