package com.wuya.cyy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
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
	
	@RequestMapping(value="/ajax",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public String  ajaxVerifyUser(HttpServletRequest request,HttpServletResponse response,
    		String questionInfo
    		) throws ParseException{  
    	logger.warn("questionInfo:"+questionInfo);
        return "1";  
    } 
	
	@RequestMapping(value="/personal/info",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  completeUser(HttpServletRequest request,HttpServletResponse response
    		) throws ParseException{ 
		String method = request.getMethod();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/wuya-personal-info.jsp");
		return mav;
    } 

      
    @RequestMapping(value="/{action}",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  userReg(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("action")String action,
    		String user_name,
    		String pwd,
    		String bind_email,
    		String nickName
    		) throws ParseException{  
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
//	            mav.setViewName("register_success");  
	            mav.setViewName("redirect:/user/login");
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
    
//    @Target({ElementType.METHOD, ElementType.TYPE})
//    @Retention(RetentionPolicy.RUNTIME)
//    static @interface RequestHandler{
//    	String request() default "";
//    }
//    
//    static HashMap<String, Method> s_handlerMapping = new HashMap<String, Method>();
//    
//    static {
//    	for(Method method: UserController.class.getDeclaredMethods()){
//    		RequestHandler info = method.getAnnotation(RequestHandler.class);
//    		if(info != null){
//    			s_handlerMapping.put(info.request(), method);
//    		}
//    	}
//    }
    
//    @RequestHandler(request="1")
//    void handleQuest(User user, User targetUser, List<HotQuestionAndAnswerAndTopic> retList)
//    {
//    	List<Question> questions = questionService.questionSelectByUid(targetUser.getUid());
//		for (Question question : questions) {
//			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
//			String topicId = question.getTopicId();
//			Answer answer = answerService.answerOneSelectByQuestionId(questionId);
//			if(answer!=null){
//				String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());
//				answer.setUpvoteCount(upvoteCount);
//			}
//			Topic topic = topicService.selectTopicByTopicId(topicId);
////			ret.setAnswer(answer);
//			ret.setQuestion(question);
//			ret.setTopic(topic);
//			ret.setUser(user);
//			retList.add(ret);
//		}		
//    }
    
//    @RequestHandler(request="2")
//    void handleAnswer(User user, User targetUser, List<HotQuestionAndAnswerAndTopic> retList)
//    {
//    	List<Answer> answers = answerService.answerSelectByUid(targetUser.getUid());
//		for (Answer answer : answers) {
//			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
//			String answer_questionid = answer.getQuestionId();
//			Question question = questionService.questionSelectByQuestionId(answer_questionid);
//        	String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());   //点赞次数
//        	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), user.getUid());
//        	answer.setUser(user);
//        	answer.setUpvoteCount(upvoteCount);
//        	answer.setIsUpvoted(isUpvote?"1":"2");
//        	ret.setAnswer(answer);
//        	ret.setUser(user);
//        	ret.setQuestion(question);
//        	retList.add(ret);
//		}
//    }
//    
    
    @RequestMapping(value="/{type}/{uid}/personalcontent",method={RequestMethod.GET,RequestMethod.POST})  
    public void  userContent(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("type")String type,
    		@PathVariable("uid")String uid
    		) throws ParseException, IOException{
    	/*
    	 * 1.回答
           2.提问
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
    	
//    	Method method = s_handlerMapping.get(type);
//    	if(method!=null){
//    		try{
//    			method.invoke(this, myuser, user, retList);
//    			if(!retList.isEmpty()){
//	    			objectMapper.writeValue(outputStream, retList);
//	    		}else{
//	    			outputStream.print("empty");
//	    		}
//    			return;
//    		}catch(Exception ex){
//    			
//    		}
//    	}
    	switch (type) {
			
			case "1"://回答
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
				break;
			case "2": //questions
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
				break;
			case "3"://分享 type  1--》answer  2--》question
				List<Share> shares = shareService.shareSelectByUid(myuid);
				if(shares==null){
					retList =null;
					break;
				}
				for (Share share : shares) {
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					int shareType = share.getShareType();
					String shareId = share.getId();
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
						String topicId = question.getTopicId();
						Topic topic = topicService.selectTopicByTopicId(topicId);
						ret.setQuestion(question);
						ret.setTopic(topic);
						ret.setUser(user);
					}
					retList.add(ret);
				}
				break;
			case "4"://话题  关注  topic type 1. focus 2. create
				List<Focus> focuses  = focusService.focusSelectByUid(uid);
				if(focuses!=null && !focuses.isEmpty()){
					for(Focus focus : focuses){
						HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
						ret.setTopicType(1);
						String focusId = focus.getId();    //话题id
						long focusTime = focus.getFocusTime();	//关注话题时间
						Topic topic = topicService.selectTopicByTopicId(focusId);
						topic.setTopicTime(focusTime);      //改变为关注时间
						String topic_uid = topic.getUid();
						if("Cinyky".equals(topic_uid)){
							User u = new User();
							u.setUid(topic_uid);
							ret.setUser(u);
						}else{
							User userSelectByUid = userService.userSelectByUid(topic_uid);
							ret.setUser(userSelectByUid);
						}
						ret.setTopic(topic);
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
				break;

			case "5":
				List<Friend> focusFriends = friendService.friendSelectByUid(uid);   //关注的好友
				List<Friend> focused = friendService.friendSelectByUid(uid);   		//被关注的好友
				for(Friend friend :focusFriends){
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					ret.setFriendType(1);
					String anotherUid = friend.getAnotherUid();
					User userSelectByUid = userService.userSelectByUid(anotherUid);
					String answerNums = answerService.answerCountSelectByUid(userSelectByUid.getUid());
					userSelectByUid.setAnswerNums(answerNums);
			        String focusFriendsCount = friendService.friendCountSelectByAnotherUid(userSelectByUid.getUid());
			        userSelectByUid.setFocusedFriends(focusFriendsCount);
					ret.setUser(userSelectByUid);
					retList.add(ret);
				}
				for(Friend friend :focused){
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					ret.setFriendType(2);
					String anotherUid = friend.getAnotherUid();
					User userSelectByUid = userService.userSelectByUid(anotherUid);
					String answerNums = answerService.answerCountSelectByUid(userSelectByUid.getUid());
					userSelectByUid.setAnswerNums(answerNums);
			        String focusFriendsCount = friendService.friendCountSelectByAnotherUid(userSelectByUid.getUid());
			        userSelectByUid.setFocusedFriends(focusFriendsCount);
					ret.setUser(userSelectByUid);
					retList.add(ret);
				}
				break;
			default:
				break;
		}
    	
    	if(!retList.isEmpty()){
    		objectMapper.writeValue(System.out,retList);
			objectMapper.writeValue(outputStream, retList);
		}else{
			outputStream.print("empty");
		}
    	
    } 
    
    
    @RequestMapping(value="/{anotherUid}/friend",method={RequestMethod.GET,RequestMethod.POST})  
    @ResponseBody
    public void  changeFriends(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("anotherUid")String anotherUid
    		) throws IOException {
    	ObjectMapper mapper = new ObjectMapper();
    	ServletOutputStream outputStream = response.getOutputStream();
    	try{
        	User myuser = (User)request.getSession(true).getAttribute("user");
        	String uid = myuser.getUid();
        	boolean friendExsist = friendService.friendExsist(uid, anotherUid);
        	boolean isChanged = false;
        	if(friendExsist){
        		isChanged = friendService.friendDelete(uid, anotherUid);
        	}else{//remove friend relationship
        		Friend friend = new Friend(uid, anotherUid, 1);
        		isChanged = friendService.friendAdd(friend);
        	}
        	if(!isChanged){
        		mapper.writeValue(outputStream, "fail");
        	}else{
        		String rs = friendExsist ? "1":"2"; 
        		mapper.writeValue(outputStream, rs);
        	}
    	}catch(Exception ex){
    		mapper.writeValue(outputStream, "fail");
    	}
    }
    
    
    @RequestMapping(value="/info/{type}/update",method={RequestMethod.GET,RequestMethod.POST})  
    public void  userUpdate(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("type")String type,
    		String info
    		) throws ParseException, IOException{
//    	updateUserInfoTypes = ["headpic","signature","sex","profile","location","birth","all"];
    	HttpSession session = request.getSession(true);
    	ServletOutputStream outputStream = response.getOutputStream();
    	User user = (User)session.getAttribute("user");
    	logger.warn("type====>"+type+"  info===>"+info);
    	logger.warn("user before====>"+user.toString());
    	switch (type) {
			case "headpic":
				user.setHeadPic(info);
				break;
			case "signature":
				user.setSignature(info);		
				break;
			case "sex":
				user.setSex(Integer.parseInt(info));
				break;
			case "profile":
				user.setProfile(info);
				break;
			case "location":
				user.setLocation(info);
				break;
			case "birth":
				user.setBirth(new SimpleDateFormat("yyyy/MM/dd").parse(info).getTime());
				break;
			case "all":
				String[] infos = info.split("|");
				user.setHeadPic(infos[0]);
				user.setSignature(infos[1]);
				user.setSex(Integer.parseInt(infos[2]));
				user.setProfile(infos[3]);
				user.setLocation(infos[4]);
				user.setBirth(new SimpleDateFormat("yyyy/MM/dd").parse(infos[5]).getTime());
				break;
			default:
				break;
		}
    	boolean userUpdate = userService.userUpdate(user);
    	if(userUpdate){
    		session.removeAttribute("user");
    		session.setAttribute("user", user);
    		new ObjectMapper().writeValue(outputStream, user);
    	}else{
    		new ObjectMapper().writeValue(outputStream, "fail");
    	}
    	
    } 
    

}
