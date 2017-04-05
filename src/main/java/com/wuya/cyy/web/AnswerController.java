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
import com.wuya.cyy.pojo.Answer;
import com.wuya.cyy.service.Impl.AnswerServiceImpl;


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
     
    //分享问题
    @RequestMapping(value="/{questionId}/detail",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  shareQuestion(HttpServletRequest request,HttpServletResponse response,
    		@PathVariable("questionId")String questionId
    		) throws ParseException, JsonGenerationException, JsonMappingException, IOException{  
        logger.warn("-----answer questionId==>"+questionId+"----");  
        List<Answer> answers = answerService.answerSelectByQuestionId(questionId);
        ObjectMapper objectMapper = new ObjectMapper();
    	if(answers!=null && !answers.isEmpty()){
    		objectMapper.writeValue(response.getOutputStream(), answers);
    	}else{
    		response.getOutputStream().print("empty");
    	}
    }
    
}
