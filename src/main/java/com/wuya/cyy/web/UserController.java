package com.wuya.cyy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.Focus;
import com.wuya.cyy.pojo.Friend;
import com.wuya.cyy.pojo.HotQuestionAndAnswerAndTopic;
import com.wuya.cyy.pojo.Question;
import com.wuya.cyy.pojo.Share;
import com.wuya.cyy.pojo.Topic;
import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.FocusServiceImpl;
import com.wuya.cyy.service.Impl.FriendServiceImpl;
import com.wuya.cyy.service.Impl.QuestionServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.service.Impl.ShareServiceImpl;
import com.wuya.cyy.service.Impl.TopicServiceImpl;
import com.wuya.cyy.service.Impl.UpvoteServiceImpl;
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
	@Resource  
    private AnswerServiceImpl answerService;
	@Resource  
    private QuestionServiceImpl questionService;
	@Resource 
	private UpvoteServiceImpl upvoteService;
	@Resource
	private FriendServiceImpl friendService;
	@Resource
	private TopicServiceImpl topicService;
	@Resource
	private FocusServiceImpl focusService;
	@Resource
	private ShareServiceImpl shareService;
	@Resource
	
	@RequestMapping(value="/ajax",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public String  ajaxVerifyUser(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo
    		) throws ParseException{  
    	logger.warn("questionInfo:"+questionInfo);
        return "1";  
    } 

      
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
            //TODO 
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
    	session.setMaxInactiveInterval(10*60);
    	String method = request.getMethod();
    	 logger.warn("-----userLogin---- method:"+method); 
    	if("get".equalsIgnoreCase(method)){
    		mav.setViewName("forward:../wuya-login.jsp");
    	}else{
    	        User userLogin = userService.userLogin(loginCondition, pwd);
    	        if(userLogin!=null){
    	        	String code = (String) session.getAttribute("verifyCode");
    	        	if(code != null){
	    	        	if(verifycode.equals(code)){
	    	        		session.setAttribute("user", userLogin);
	    	        		mav.setViewName("redirect:/user/"+userLogin.getNickName()+"/home");
	    	        	}else{
	    	        		mav.addObject("txt","success but code null");
	    	        		mav.setViewName("redirect:login");
	    	        	}
	    	            logger.warn("-----login----");
    	        	}else{
    	        		mav.addObject("txt","code null");
        	        	mav.setViewName("redirect:login");
    	        	}
    	        }else{
    	        	mav.addObject("txt","user fail");
    	        	mav.setViewName("redirect:login");
    	        }
    	       
    	}
        return mav;  
    }  
    
    @RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userLogOut(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException{
    	ModelAndView mav=new ModelAndView();
    	HttpSession session = request.getSession(false);
    	if(session!=null)
    		session.removeAttribute("user");;
    	mav.setViewName("redirect:login");
        return mav;  
    }  
    
    
    @RequestMapping(value="/{nickname}/home",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userHome(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("nickname")String nickname
    		) throws ParseException{
    	ModelAndView mav=new ModelAndView();
    	String method = request.getMethod();
    	 logger.warn("-----userLogin---- method:"+method); 
    	if("get".equalsIgnoreCase(method)){
    		mav.addObject("nickname", nickname);
    		mav.setViewName("forward:/wuya-index.jsp");
    	}
        return mav;  
    } 
    
    
    @RequestMapping(value="/{uid}/personal",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userPersonal(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("uid")String uid
    		) throws ParseException{
    	ModelAndView mav=new ModelAndView();
    	List<Answer> answers = answerService.answerSelectByUid(uid);
    	List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
    	User user = userService.userSelectByUid(uid);
    	 String answerNums = answerService.answerCountSelectByUid(user.getUid());
         user.setAnswerNums(answerNums);
         String focusFriends = friendService.friendCountSelectByAnotherUid(user.getUid());
         user.setFocusedFriends(focusFriends);
         String friendCountSelectByUid = friendService.friendCountSelectByUid(uid);
         user.setFocusFriends(friendCountSelectByUid);
         mav.addObject("personal_user", user);
		for (Answer answer : answers) {
			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
			String questionId = answer.getQuestionId(); //问题
			Question question = questionService.questionSelectByQuestionId(questionId);
			if(answer!=null){
				String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
				answer.setUpvoteCount(upvoteCount);
			}
			ret.setAnswer(answer);
			ret.setQuestion(question);
			ret.setUser(user);
			retList.add(ret);
		}
		mav.addObject("personal_answers", retList);
        mav.setViewName("forward:/wuya-personal.jsp");
        return mav;  
    } 
    
    @RequestMapping(value="/{type}/{uid}/personal",method={RequestMethod.GET,RequestMethod.POST})  
    public void  userContent(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("type")String type,
    		@PathVariable("uid")String uid
    		) throws ParseException, IOException{
    	/*
    	 * 1.提问
           2.回答
           3.分享
           4.创建的话题
           5.好友
    	 */
    	ObjectMapper objectMapper = new ObjectMapper();
    	ServletOutputStream outputStream = response.getOutputStream();
    	User myuser = (User)request.getSession(true).getAttribute("user");
    	User user = userService.userSelectByUid(uid);
    	String myuid = myuser.getUid();
    	List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
    	switch (type) {
			case "1": //questions
				List<Question> questions = questionService.questionSelectByUid(uid);
				for (Question question : questions) {
	    			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					String topicId = question.getTopicId();
//					Answer answer = answerService.answerOneSelectByQuestionId(questionId);
//					if(answer!=null){
//						String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
//						answer.setUpvoteCount(upvoteCount);
//					}
					Topic topic = topicService.selectTopicByTopicId(topicId);
//					ret.setAnswer(answer);
					ret.setQuestion(question);
					ret.setTopic(topic);
					ret.setUser(user);
					retList.add(ret);
				}
				if(!retList.isEmpty()){
	    			objectMapper.writeValue(outputStream, retList);
	    		}else{
	    			outputStream.print("empty");
	    		}
				break;
			case "2"://回答
				List<Answer> answers = answerService.answerSelectByUid(uid);
				for (Answer answer : answers) {
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					String answer_questionid = answer.getQuestionId();
					Question question = questionService.questionSelectByQuestionId(answer_questionid);
		        	String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());   //点赞次数
		        	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), myuid);
		        	answer.setUser(user);
		        	answer.setUpvoteCount(upvoteCount);
		        	answer.setIsUpvoted(isUpvote?"1":"2");
		        	ret.setAnswer(answer);
		        	ret.setUser(user);
		        	ret.setQuestion(question);
		        	retList.add(ret);
				}
				if(!retList.isEmpty()){
	    			objectMapper.writeValue(outputStream, retList);
	    		}else{
	    			outputStream.print("empty");
	    		}
				break;

			case "3"://分享 type  1--》answer  2--》question
				List<Share> shares = shareService.shareSelectByUid(myuid);
				for (Share share : shares) {
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					int shareType = share.getShareType();
					String shareId = share.getShareId();
					ret.setShareType(shareType);
					if(shareType==1){
						Answer answer = answerService.answerSelectByAnswerId(shareId);
						String answer_questionid = answer.getQuestionId();
						Question question = questionService.questionSelectByQuestionId(answer_questionid);
			        	String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());   //点赞次数
			        	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), myuid);
			        	answer.setUser(user);
			        	answer.setUpvoteCount(upvoteCount);
			        	answer.setIsUpvoted(isUpvote?"1":"2");
			        	ret.setAnswer(answer);
			        	ret.setUser(user);
			        	ret.setQuestion(question);
					}else{
						Question question = questionService.questionSelectByQuestionId(shareId);
						String questionId = question.getQuestionId();
						String topicId = question.getTopicId();
						Topic topic = topicService.selectTopicByTopicId(topicId);
						ret.setQuestion(question);
						ret.setTopic(topic);
						ret.setUser(user);
					}
					retList.add(ret);
				}
				if(!retList.isEmpty()){
	    			objectMapper.writeValue(outputStream, retList);
	    		}else{
	    			outputStream.print("empty");
	    		}
				break;

			case "4"://话题  关注  topic type 1. focus 2. create
				List<Focus> focuses  = focusService.focusSelectByUid(uid);
				if(focuses!=null && !focuses.isEmpty()){
					for(Focus focus : focuses){
						HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
						ret.setTopicType(1);
						String focusId = focus.getFocusId();    //话题id
						long focusTime = focus.getFocusTime();	//关注话题时间
						Topic topic = topicService.selectTopicByTopicId(focusId);
						topic.setTopicTime(focusTime);      //改变为关注时间
						String topic_uid = topic.getUid();
						User userSelectByUid = userService.userSelectByUid(topic_uid);
						ret.setTopic(topic);
						ret.setUser(userSelectByUid);
						retList.add(ret);
					}
				}
				List<Topic> topics = topicService.topicSelectByUid(uid);
				if(topics!=null && !topics.isEmpty()){
					for(Topic topic:topics){
						HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
						ret.setTopicType(2);
						ret.setTopic(topic);
						ret.setUser(user);
						retList.add(ret);
					}
				}
				if(!retList.isEmpty()){
	    			objectMapper.writeValue(outputStream, retList);
	    		}else{
	    			outputStream.print("empty");
	    		}
				break;

			case "5":
				List<Friend> focusFriends = friendService.friendSelectByUid(uid);   //关注的好友
				List<Friend> focused = friendService.friendSelectByUid(uid);   		//被关注的好友
				break;
			default:
				break;
		}
    	
    } 
    

}
