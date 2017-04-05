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
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
import com.wuya.cyy.utils.ServiceException;
/**
 * 上传 controller
 * Cinyky 
 *
 * 2017年3月21日上午8:49:57
 */

@Controller
public class UploadController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/upload/{action}")
	private void upload(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("action")String action
			) throws ServletException, IOException{
    	
//    	response.setHeader("Access-Control-Allow-Origin", "http://localhost:8011");  // 第二个参数填写允许跨域的域名称，不建议直接写 "*"
//    	response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
//    	response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
//
//    	// 接收跨域的cookie
//    	response.setHeader("Access-Control-Allow-Credentials", "true");
		
		 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	                request.getSession().getServletContext());
		 if(multipartResolver.isMultipart(request)){

			 MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			  Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
//	    	  while(fileNames.hasNext()){
			  if(!fileMap.isEmpty()){
				  for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
					  	System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue().getSize());
					  	MultipartFile file = entry.getValue();
					  	if(file!=null){
			                   String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
			                   boolean allowed = Arrays.asList(allowedType).contains(file.getContentType());
					  		 if (!allowed) {
			                       response.getWriter().write("error|不支持的类型");
			                       logger.warn("upload error|不支持的类型");
			                       return;
			                   }
					  		 String fi = file.getOriginalFilename();
			                   // 提取文件拓展名
			                   String fileNameExtension = fi.substring(fi.indexOf("."), fi.length());
			                   // 生成实际存储的真实文件名
			                   String realName = UUID.randomUUID().toString() + fileNameExtension;
			                   // 图片存放的真实路径
			                   String realPath = request.getServletContext().getRealPath("/upload") + "/" + action+"/"+realName;
			                   String absolutePath = request.getServletContext().getRealPath("/upload") + "/" +action+"/"+ realName;
			                   // 将文件写入指定路径下
			                   System.out.println("upload fileNameExtension:"+fileNameExtension+" realName:"+realName
			                		   +" realPath:"+realPath+" absolutePath:"+absolutePath);
			                   File realFile = new File(realPath);
			                   if(realFile == null){
			                	   response.getWriter().write("error|file path not exsist");
			                   }else{
			                	   file.transferTo(new File(realPath));
				                   System.out.println("return url:"+request.getContextPath() + "/upload/" + action+"/" + realName);
				          
				                   // 返回图片的URL地址
				                   response.getWriter().write(request.getContextPath() + "/upload/" + action+"/" + realName);
			                   }
			                 
					  	}
				  }
	    	  }else{
	 			 response.getWriter().write("error|no file");
	    	  }
			  
		 }
	}
    


}
