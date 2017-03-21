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
import com.wuya.cyy.service.Impl.BookServiceImpl;
import com.wuya.cyy.service.Impl.RegisterValidateService;
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
	
	@RequestMapping(value = "/upload")
	private void upload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	
		 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	                request.getSession().getServletContext());
		 if(multipartResolver.isMultipart(request)){

			 MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			  Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
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
			                   String realPath = request.getServletContext().getRealPath("/upload") + "/" + realName;
			                   String absolutePath = request.getServletContext().getRealPath("/upload") + "/" + realName;
			                   // 将文件写入指定路径下
			                   System.out.println("upload fileNameExtension:"+fileNameExtension+" realName:"+realName
			                		   +" realPath:"+realPath+" absolutePath:"+absolutePath);
			                   file.transferTo(new File(realPath));
			                   System.out.println("return url:"+request.getContextPath() + "/upload/" + realName);
			          
			                   // 返回图片的URL地址
			                   response.getWriter().write(request.getContextPath() + "/upload/" + realName);
					  	}
				  }
	    	  }else{
	 			 response.getWriter().write("error|rrrrrrr");
	    	  }
		 }
	}
	
	@RequestMapping(value="/springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException{
         long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        logger.warn("springUpload");
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {	
                	logger.warn("getOriginalFilename:"+file.getOriginalFilename());
                    String path="E:/springUpload/"+file.getOriginalFilename();
                	logger.warn("path:"+path);
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }

      
    @RequestMapping(value="/register",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView  load(HttpServletRequest request,HttpServletResponse response) throws ParseException{  
        String action = request.getParameter("action");  
        logger.warn("-----reg----"+action);  
        ModelAndView mav=new ModelAndView();  
        String email = "";
        if("register".equals(action)) {  
            //注册  
            email = request.getParameter("email");  
            logger.warn("-----reg----"+email);  
            service.processregister(email);//发邮箱激活  
            mav.addObject("text","注册成功");  
            mav.setViewName("register_success");  
        }   
        else if("activate".equals(action)) {  
            //激活  
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
    
    


}
