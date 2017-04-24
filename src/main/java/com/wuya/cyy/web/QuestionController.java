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
import javax.servlet.ServletOutputStream;
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
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.HotQuestionAndAnswerAndTopic;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.FriendService;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.FriendServiceImpl;
import com.wuya.cyy.service.Impl.QuestionServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.TopicServiceImpl;
import com.wuya.cyy.service.Impl.UpvoteServiceImpl;
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
	@Resource  
    private AnswerServiceImpl answerService;
	@Resource  
    private UserServiceImpl userService;
	@Resource  
    private TopicServiceImpl topicService;
	@Resource  
    private UpvoteServiceImpl upvoteService;
	@Resource  
    private FriendServiceImpl friendService;
	
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
	 * @throws IOException 
	 */
    @RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public void  addQuestion(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo,
    		String topicId
    		) throws ParseException, IOException{  
    	User user = (User)request.getSession(true).getAttribute("user");
        logger.warn("-----question questionInfo==>"+questionInfo+"----");  
        Question question = new Question(user.getUid(), questionInfo, topicId, 1);
        boolean questionAdd = questionService.questionAdd(question);
        if(questionAdd){
        	HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
			String questionId = question.getQuestionId();
			String uid = question.getUid();
			Answer answer = answerService.answerOneSelectByQuestionId(questionId);
			if(answer!=null){
				String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
				answer.setUpvoteCount(upvoteCount);
			}
			User answer_user = userService.userSelectByUid(uid);
			Topic topic = topicService.selectTopicByTopicId(topicId);
			ret.setAnswer(answer);
			ret.setQuestion(question);
			ret.setTopic(topic);
			ret.setUser(answer_user);
        	new ObjectMapper().writeValue(response.getOutputStream(), ret); 
        }else{
        	response.getOutputStream().print("fail");
        }
         
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
        ModelAndView mav=new ModelAndView();  
        Question question = questionService.questionSelectByQuestionId(questionId);
        String uid = question.getUid();
        User user = userService.userSelectByUid(uid);
        String answerNums = answerService.answerCountSelectByUid(user.getUid());
        user.setAnswerNums(answerNums);
        String focusFriends = friendService.friendCountSelectByAnotherUid(user.getUid());
        user.setFocusedFriends(focusFriends);
        mav.addObject("question", question);
        mav.addObject("question_user", user);
        //TODO get question jsp topic
        Topic topic = topicService.selectTopicByTopicId(question.getTopicId());
        mav.addObject("question_topic", topic);
        mav.setViewName("forward:/wuya-answer.jsp");
        return mav;  
    }  
    
    @RequestMapping(value="/init/index",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public void  getQuestionIndex(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException, IOException{  
    	ServletOutputStream outputStream = response.getOutputStream();
    	List<Question> questions = questionService.selectQuestionByHot();
    	User myuser = (User)request.getSession(true).getAttribute("user");
    	if(questions==null || questions.isEmpty()){
    		outputStream.print("empty");
    	}else{
    		List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
    		for (Question question : questions) {
    			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
				String questionId = question.getQuestionId();
				String uid = question.getUid();
				String topicId = question.getTopicId();
				Answer answer = answerService.answerOneSelectByQuestionId(questionId);
				if(answer!=null){
					String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
					boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), myuser.getUid());
					answer.setUpvoteCount(upvoteCount);
					answer.setIsUpvoted(isUpvote?"1":"2");
				}else{
					continue;
				}
				User user = userService.userSelectByUid(uid);
				//TODO topic service
				Topic topic = topicService.selectTopicByTopicId(topicId);
				
				ret.setAnswer(answer);
				ret.setQuestion(question);
				ret.setTopic(topic);
				ret.setUser(user);
				retList.add(ret);
			}
    		if(!retList.isEmpty()){
    			ObjectMapper objectMapper = new ObjectMapper();
    			objectMapper.writeValue(outputStream, retList);
    		}else{
    			outputStream.print("empty");
    		}
    	}
    }  
    
    //分享问题
//    @RequestMapping(value="/{questionId}/share",method={RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public void  shareQuestion(HttpServletRequest request,HttpServletResponse response,
//    		@PathVariable("questionId")String questionId
//    		) throws ParseException{  
//        logger.warn("-----question share questionId==>"+questionId+"----");  
//    }
    //focus 问题
//    @RequestMapping(value="/{questionId}/focus",method={RequestMethod.GET,RequestMethod.POST}) 
//    @ResponseBody
//    public void  focusQuestoion(HttpServletRequest request,HttpServletResponse response,
//    		@PathVariable("questionId")String questionId
//    		) throws ParseException{  
//        logger.warn("-----question focus questionId==>"+questionId+"----");  
//    }  

}
