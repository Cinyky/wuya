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
import com.mysql.fabric.xmlrpc.base.Array;
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.Focus;
import com.wuya.cyy.pojo.HotQuestionAndAnswerAndTopic;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.TopicService;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.FocusServiceImpl;
import com.wuya.cyy.service.Impl.QuestionServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.TopicServiceImpl;
import com.wuya.cyy.service.Impl.UpvoteServiceImpl;
import com.wuya.cyy.service.Impl.UserServiceImpl;
import com.wuya.cyy.utils.RandomUtils;
import com.wuya.cyy.utils.ServiceException;
/**
 * 话题 Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 16:07:02
 */
@Controller
@RequestMapping("/topic") // url:/模块/资源/{id}/细分 /seckill/list
public class TopicController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<Topic> recommendedTopics;  
	
	@Resource  
    private TopicServiceImpl topicService;
	@Resource  
    private QuestionServiceImpl questionService;
	@Resource  
    private AnswerServiceImpl answerService;
	@Resource  
    private UpvoteServiceImpl upvoteService;
	@Resource  
    private UserServiceImpl userService;
	@Resource  
    private FocusServiceImpl focusService;
	
    @RequestMapping(value="/ajax",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public String  ajaxVerifyQuestion(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo
    		) throws ParseException{  
    	logger.warn("questionInfo:"+questionInfo);
        return "1";  
    } 
	
    @RequestMapping(value="/add",method={RequestMethod.GET,RequestMethod.POST})  
    public void  addQuestion(HttpServletRequest request,HttpServletResponse response,
    		String topicName
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
    	User user = (User)request.getSession(true).getAttribute("user");
        logger.warn("-----topic add topicName==>"+topicName+"----");  
        Topic topic = new Topic(user.getUid(), topicName);
        boolean topicAdd = topicService.topicAdd(topic);
        new ObjectMapper().writeValue(response.getOutputStream(), topic);
    } 
	
	/**
	 * 
	 *	topic 
	 * @return
	 * @throws ParseException
	 */
    @RequestMapping(value="/{topicId}/detail",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  getQuestionDetail(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("topicId")String topicId
    		) throws ParseException{  
        logger.warn("-----topic topicId==>"+topicId+"----");  
        ModelAndView mav=new ModelAndView();  
        User user = (User)request.getSession(true).getAttribute("user");
        List<Focus> focusSelectByUid = focusService.focusSelectByUid(user.getUid());
        List<Topic> myTopics = new ArrayList<>();
        if(focusSelectByUid!=null && !focusSelectByUid.isEmpty()){
        	for (Focus focus : focusSelectByUid) {
				String id = focus.getId();
				Topic selectTopicByTopicId = topicService.selectTopicByTopicId(id);
				myTopics.add(selectTopicByTopicId);
			}
        }
        mav.addObject("myTopics", myTopics);
        Topic topic = topicService.selectTopicByTopicId(topicId);
        mav.addObject("topic", topic);
        if(recommendedTopics==null || recommendedTopics.isEmpty()){
        	recommendedTopics = new ArrayList<>();
        	recommendedTopics = topicService.topicSelectAll();
        }
        List<Topic> randomRecommendTopics = RandomUtils.randomRecommendTopics(recommendedTopics);
        for (Topic temp_topic : randomRecommendTopics) {
			boolean focusExsist = focusService.focusExsist(user.getUid(),temp_topic.getTopicId());
			temp_topic.setIsFocused(focusExsist?"1":"2");
			String focusCount = focusService.focusCount(temp_topic.getTopicId());
			temp_topic.setFocusNums(focusCount);
		}
        mav.addObject("recommendTopics", randomRecommendTopics);
    	List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>(); //每个话题的 answerQuestion 
        List<Question> questions = questionService.questionSelectByTopicId(topicId);
       for (Question question : questions) {
    	   HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
    	   String questionId = question.getQuestionId();
		    String uid = question.getUid();
			Answer question_answer = answerService.answerOneSelectByQuestionId(questionId);
			if(question_answer!=null){
				String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(question_answer.getAnswerId());
				question_answer.setUpvoteCount(upvoteCount);
				boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(question_answer.getAnswerId(), user.getUid());
				question_answer.setIsUpvoted(isUpvote?"1":"2");
			}
			User question_user = userService.userSelectByUid(uid);
			ret.setAnswer(question_answer);
			ret.setQuestion(question);
			ret.setUser(question_user);
			retList.add(ret);
       }
        mav.addObject("retList", retList);
        mav.setViewName("forward:/wuya-topic.jsp");
        return mav;  
    }  
    
    //recommend topic
    @RequestMapping(value="/recommend",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  shareQuestion(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
    	 User user = (User)request.getSession(true).getAttribute("user");
    	 if(recommendedTopics==null || recommendedTopics.isEmpty()){
         	recommendedTopics = new ArrayList<>();
         	recommendedTopics = topicService.topicSelectAll();
         }
         List<Topic> randomRecommendTopics = RandomUtils.randomRecommendTopics(recommendedTopics);
         for (Topic temp_topic : randomRecommendTopics) {
 			boolean focusExsist = focusService.focusExsist(user.getUid(),temp_topic.getTopicId());
 			temp_topic.setIsFocused(focusExsist?"1":"2");
 			String focusCount = focusService.focusCount(temp_topic.getTopicId());
 			temp_topic.setFocusNums(focusCount);
 		}
         new ObjectMapper().writeValue(response.getOutputStream(), randomRecommendTopics);
    }
    
    @RequestMapping(value="/{topicId}/focus",method={RequestMethod.GET,RequestMethod.POST}) 
    @ResponseBody
    public void  focusQuestoion(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("topicId")String topicId
    		) throws ParseException, IOException{  
        logger.warn("-----topic topicId==>"+topicId+"----"); 
        User user = (User)request.getSession(true).getAttribute("user");
        Focus focus = new Focus(user.getUid(), topicId);
        boolean focusExsist = focusService.focusExsist(user.getUid(),topicId);
        boolean isSuccess;
        String method = "2";   //不存在  关准
        if(focusExsist){
        	method = "1"; //存在 剔除关注
        	isSuccess = focusService.focusDelete(focus);
        }else{
        	isSuccess = focusService.focusAdd(focus);
        }
        String count = focusService.focusCount(topicId);
//        String success = isSuccess?"true":"flase";
        String res = method+"|"+count;
        response.getOutputStream().print(res);
    }  

}
