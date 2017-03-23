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
 * 测试controller
 * Cinyky 
 *
 * 2017年3月21日上午8:49:57
 */

@Controller
@RequestMapping("/test") // url:/模块/资源/{id}/细分 /seckill/list
public class TestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookServiceImpl bookService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private ModelAndView list(ModelAndView model,HttpServletRequest request) {
		List<Book> books = bookService.getList();
//		model.addAttribute("list", list.get(0));
//		model.addAttribute("hello", "hello world list");
		// list.jsp + model = ModelAndView
		logger.warn("------books:"+books.size());
		String servletContext = request.getSession().getServletContext().getRealPath("");
		model.getModel().put("books", books);
		model.setViewName("list");
		return model;// WEB-INF/jsp/"list".jsp
	}

	// ajax json
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	@ResponseBody
	private ModelAndView detail(@PathVariable("bookId") Long bookId, ModelAndView model) {
		if (bookId == null) {
			model.setViewName("redirect:/book/list");
			return model;
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			model.setViewName("forward:/book/list");
			return model;
		}
		logger.warn("bookId:"+bookId+" ,book:"+book.toString());
//		model.addAttribute("book", book);
//		model.addAttribute("hello", "hello world");
		model.setViewName("detail");
		model.getModel().put("book", book);
		return model;
	}
	
	// ajax json
		@RequestMapping(value = "/json", method = RequestMethod.GET)
		@ResponseBody
		private void outputjson(HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
			List<Book> books = new ArrayList<>();
			books.add(new Book(1, "1", 1));
			books.add(new Book(2, "2", 2));
			books.add(new Book(3, "3", 3));
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(response.getOutputStream(), books);
		}
	
	@RequestMapping(value = "/upload")
	private void upload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	
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
    	
    	  
    	  
    	 
//    	 response.setContentType("textml;charset=UTF-8");
//         request.setCharacterEncoding("UTF-8");
//         Part part = multiRequest.getPart("myFileName");// myFileName是文件域的name属性值
//         logger.warn("upload start. ......");
//         System.out.println("upload start. ......");
//         // 文件类型限制
//         String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
//         boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
//         if (!allowed) {
//             response.getWriter().write("error|不支持的类型");
//             logger.warn("upload error|不支持的类型");
//             return;
//         }
//         // 图片大小限制
//         if (part.getSize() > 5 * 1024 * 1024) {
//             response.getWriter().write("error|图片大小不能超过5M");
//             logger.warn("upload error|图片大小不能超过5M");
//             return;
//         }
//         // 包含原始文件名的字符串
//         String fi = part.getHeader("content-disposition");
//         // 提取文件拓展名
//         String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
//         // 生成实际存储的真实文件名
//         String realName = UUID.randomUUID().toString() + fileNameExtension;
//         // 图片存放的真实路径
//         String realPath = request.getServletContext().getRealPath("/upload") + "/" + realName;
//         // 将文件写入指定路径下
//         logger.warn("upload fileNameExtension:"+fileNameExtension+" realName:"+realName+" realPath:"+realPath);
//         part.write(realPath);
//         logger.warn("return url"+request.getContextPath() + "/upload/" + realName);
//
//         // 返回图片的URL地址
//         response.getWriter().write(request.getContextPath() + "/upload/" + realName);
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
	
	@Resource  
    private RegisterValidateService service;  
      
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
