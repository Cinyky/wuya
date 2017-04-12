package com.wuya.cyy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;
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
import org.junit.runners.Parameterized.Parameter;
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

import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.pojo.HotQuestionAndAnswerAndTopic;
import com.wuya.cyy.pojo.Question;
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
 * search Controller
 * @author Cinyky
 * junliang mint
 * 5 Apr 2017 10:53:48
 */

@Controller
@RequestMapping("/search") // url:/模块/资源/{id}/细分 /seckill/list
public class SearchController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
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
     
    
    //分享问题
    @RequestMapping(value="/detail",method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView  shareQuestion(HttpServletRequest request,HttpServletResponse response,
    		String searchInfo
    		) throws ParseException, UnsupportedEncodingException{  
    	String method = request.getMethod();
        ModelAndView mav=new ModelAndView();
        response.setContentType("text/html;charset=UTF-8");// 设置服务器发送给浏览器的编码方式
		request.setCharacterEncoding("UTF-8"); // 客户端向服务器提交的数据的解码方式
       logger.warn("search info ==============="+searchInfo);
        if("post".equalsIgnoreCase(method)){
        	 String rs="";
             User myuser = (User)request.getSession(true).getAttribute("user");
             String myuid = myuser.getUid();
             boolean hasResults = false;
        	 List<User> users = userService.userSelect(searchInfo);
        	if(users!=null&&!users.isEmpty()){
        		List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
        		for(User user: users){
            		HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
        			String uid = user.getUid();
        			if(uid== myuid){
        				continue;
        			}
        			String answerNums = answerService.answerCountSelectByUid(user.getUid());
        			user.setAnswerNums(answerNums);
    		        String focusFriendsCount = friendService.friendCountSelectByAnotherUid(user.getUid());
    		        user.setFocusedFriends(focusFriendsCount);
    		        boolean friendExsist = friendService.friendExsist(myuid, uid);
    		        user.setIsFocused(friendExsist?"1":"2"); // 1  我关注了 显示取关
    				ret.setUser(user);
    				retList.add(ret);
        		}
        		mav.addObject("search_users", retList);
        	}
        	
        	List<Answer> answers = answerService.answerSelectByInfo(searchInfo);
        	if(answers!=null&&!answers.isEmpty()){
        		List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
        		for (Answer answer : answers) {
					HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					String answer_questionid = answer.getQuestionId();
					String answer_uid = answer.getUid();
					Question question = questionService.questionSelectByQuestionId(answer_questionid);
		        	String upvoteCount = upvoteService.upvoteCountSelectByAnswerId(answer.getAnswerId());   //点赞次数
		        	boolean isUpvote = upvoteService.upvoteSelectByAnswerIdAndUid(answer.getAnswerId(), myuid);
		        	User answer_user =userService.userSelectByUid(answer_uid);
		        	answer.setUser(answer_user);
		        	answer.setUpvoteCount(upvoteCount);
		        	answer.setIsUpvoted(isUpvote?"1":"2");
		        	ret.setAnswer(answer);
		        	ret.setUser(answer_user);
		        	ret.setQuestion(question);
		        	retList.add(ret);
				}
        		mav.addObject("search_answers", retList);
        	}
        	
        	//问题
        	List<Question> questions = questionService.questionSelectByInfo(searchInfo);
        	if(questions!=null&&!questions.isEmpty()){
        		List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
        		for (Question question : questions) {
	    			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
					String topicId = question.getTopicId();
					String uid = question.getUid();
					Topic topic = topicService.selectTopicByTopicId(topicId);
					User userSelectByUid = userService.userSelectByUid(uid);
					ret.setQuestion(question);
					ret.setTopic(topic);
					ret.setUser(userSelectByUid);
					retList.add(ret);
				}
        		mav.addObject("search_questions", retList);
        	}
        	List<Topic> topics = topicService.topicSelectByTopicName(searchInfo);
        	if(topics!=null&&!topics.isEmpty()){
        		List<HotQuestionAndAnswerAndTopic> retList = new ArrayList<>();
        		for (Topic topic : topics) {
	    			HotQuestionAndAnswerAndTopic ret = new HotQuestionAndAnswerAndTopic();
	    			String uid = topic.getUid();
	    			if("Cinyky".equals(uid)){
	    				User user = new User();
	    				user.setUid(uid);
	    				ret.setUser(user);
	    			}else{
	    				User user = userService.userSelectByUid(uid);
	    				ret.setUser(user);
	    			}
	    			String topicId = topic.getTopicId();
	    			boolean focusExsist = focusService.focusExsist(myuid,topicId);
	    			topic.setIsFocused(focusExsist?"1":"2");
	    			
	    			ret.setTopic(topic);
	    			
	    			retList.add(ret);
				}
        		mav.addObject("search_topics", retList);
        	}
        	hasResults = (users!=null&&!users.isEmpty())
        			&&	 (answers!=null&&!answers.isEmpty()) 
        			&&   (questions!=null&&!questions.isEmpty())
        			&&   (topics!=null&&!topics.isEmpty());
        	 rs = hasResults?"full":"nodata";
        	 mav.addObject("search_rs", rs);
        }else{
        	mav.addObject("search_rs", "noinfo");
        }
        mav.setViewName("forward:/wuya-search.jsp");
        return mav;  
    }
    
}
