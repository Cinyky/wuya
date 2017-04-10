package com.wuya.cyy.web;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
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
import javax.servlet.jsp.tagext.TryCatchFinally;

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
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Upvote;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;
import com.wuya.cyy.service.Impl.UpvoteServiceImpl;
import com.wuya.cyy.service.Impl.UserServiceImpl;


/**
 * answer Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 11:08:03
 */

@Controller
@RequestMapping("/answer") // url:/模块/资源/{id}/细分 /seckill/list
public class AnswerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Resource  
    private AnswerServiceImpl answerService;
	@Resource  
    private UserServiceImpl userService;
	@Resource  
    private UpvoteServiceImpl upvoteService;
	
	/**
	 * 
	 *	新增问题
	 * @return
	 * @throws ParseException
	 * @throws IOException 
	 */
    @RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public void  addAnswer(HttpServletRequest request,HttpServletResponse response,
    		String answerInfo,
    		String questionId
    		) throws ParseException, IOException{  
    	User user = (User)request.getSession(true).getAttribute("user");
        logger.warn("-----addAnswer answerInfo==>"+answerInfo+"---questionId==>"+questionId);  
        Answer answer = new Answer(questionId, user.getUid(), answerInfo, 1);
        boolean answerAdd = answerService.answerAdd(answer);
        answer.setUser((User)request.getSession(true).getAttribute("user"));
        answer.setUpvoteCount("0");
        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        if(answerAdd){
        	 new ObjectMapper().writeValue(response.getOutputStream(), answer);
        }else{
        	response.getOutputStream().print("fail");
        }
       
    } 
	
  //问题详情
    @RequestMapping(value="/select",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  selectAnswers(HttpServletRequest request,HttpServletResponse response,
    		String questionId
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
        logger.warn("-----answer questionId==>"+questionId+"----");  
        User user = (User)request.getSession(true).getAttribute("user");
        List<Answer> answers = answerService.answerSelectByQuestionId(questionId);
        for (Answer answer : answers) {
        	User tempUser = userService.userSelectByUid(answer.getUid());
        	String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
        	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), user.getUid());
        	answer.setUser(tempUser);
        	answer.setUpvoteCount(upvoteCount);
        	answer.setIsUpvoted(isUpvote?"1":"2");
        	logger.warn(" answer user:"+tempUser.toString());
        	logger.warn("upvoteCount:"+upvoteCount);
		}
        ObjectMapper objectMapper = new ObjectMapper();
    	if(answers!=null && !answers.isEmpty()){
    		objectMapper.writeValue(response.getOutputStream(), answers);
    	}else{
    		response.getOutputStream().print("empty");
    	}
    }
    
    //问题nums
    @RequestMapping(value="/nums",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  selectAnswersNums(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
    	User user = (User)request.getSession(true).getAttribute("user");
        String answerCountSelectByUid = answerService.answerCountSelectByUid(user.getUid());
        logger.warn("answerCountSelectByUid:"+answerCountSelectByUid);
        response.getOutputStream().print(answerCountSelectByUid);
    }
	
	
    //问题详情
    @RequestMapping(value="/{questionId}/detail",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  showQuestionAnswers(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("questionId")String questionId
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
        logger.warn("-----answer questionId==>"+questionId+"----");  
        List<Answer> answers = answerService.answerSelectByQuestionId(questionId);
        for (Answer answer : answers) {
			
		}
        ObjectMapper objectMapper = new ObjectMapper();
    	if(answers!=null && !answers.isEmpty()){
    		objectMapper.writeValue(response.getOutputStream(), answers);
    	}else{
    		response.getOutputStream().print("empty");
    	}
    }
    
    
    //share  answer
    @RequestMapping(value="/{answerId}/share",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  shareAnswer(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("answerId")String answerId
    		) throws ParseException{  
        logger.warn("-----answer share answerId==>"+answerId+"----");  
    }
    
    @RequestMapping(value="/{answerId}/focus",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public void  focusAnswer(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("answerId")String answerId
    		) throws ParseException{  
    	logger.warn("-----answer share answerId==>"+answerId+"----");  
    }
    
    @RequestMapping(value="/{answerId}/upvote",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public void  upVoteAnswer(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("answerId")String answerId
    		) throws ParseException, IOException{  
    	logger.warn("-----answer upvote answerId==>"+answerId+"----");  
    	User user = (User)request.getSession(true).getAttribute("user");
    	String uid = user.getUid();
    	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answerId, uid);
    	if(isUpvote){
    		upvoteService.upvoteDelete(answerId, uid);
    	}else{
    		upvoteService.upvoteAdd(new Upvote(uid, answerId, 1));
    	}
    	String count = upvoteService.upvoteCountSelectByAnswerId(answerId);
    	String res = (isUpvote?"1":"2")+"|"+count;
    	response.getOutputStream().print(res);
    }
    
       
    
}
