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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.QuestionServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.UserServiceImpl;
import com.wuya.cyy.utils.ServiceException;
/**
 * question Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:00:36
 */
@Controller
@RequestMapping("/question") // url:/模块/资源/{id}/细分 /seckill/list
public class QuestionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource  
    private QuestionServiceImpl questionService;
	
    @RequestMapping(value="/ajax",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public void  ajaxVerifyQuestion(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
    	logger.warn("questionInfo:"+questionInfo);
    	List<Question> questions = questionService.questionSelectByInfo(questionInfo);
    	ObjectMapper objectMapper = new ObjectMapper();
    	if(questions!=null && !questions.isEmpty()){
    		objectMapper.writeValue(response.getOutputStream(), questions);
    	}else{
    		response.getOutputStream().print("empty");
    	}
    	
    } 
	
	/**
	 * 
	 *	新增问题
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST})  
    public String  addQuestion(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo,
    		String topicId
    		) throws ParseException{  
    	String contextPath = request.getContextPath();
    	User user = (User)request.getSession(true).getAttribute("user");
        logger.warn("-----question questionInfo==>"+questionInfo+"----");  
        Question question = new Question(user.getUid(), questionInfo, topicId, 1);
        boolean questionAdd = questionService.questionAdd(question);
        return questionAdd?"1":"0";  
    } 
	
	/**
	 * 
	 *	问题详情
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value="/{questionId}/detail",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  getQuestionDetail(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("questionId")String questionId
    		) throws ParseException{  
        logger.warn("-----question questionId==>"+questionId+"----");  
        Question question = questionService.questionSelectByQuestionId(questionId);
//        Topic topic = 
        ModelAndView mav=new ModelAndView();  
        mav.addObject("question", question);
        mav.setViewName("forward:/wuya-answer.jsp");
        return mav;  
    }  
    
    //分享问题
    @RequestMapping(value="/{questionId}/share",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ModelAndView  shareQuestion(HttpServletRequest request,HttpServletResponse response,
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
    
    @RequestMapping(value="/{questionId}/focus",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public ModelAndView  focusQuestoion(HttpServletRequest request,HttpServletResponse response,
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
    
    @RequestMapping(value="/{questionId}/like",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public ModelAndView  likeQuestoion(HttpServletRequest request,HttpServletResponse response,
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