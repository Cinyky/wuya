package com.wuya.cyy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wuya.cyy.pojo.User;
import com.wuya.cyy.service.UserService;
import com.wuya.cyy.service.Impl.UserServiceImpl;

/**
 * Filter 过滤器
 * @author Cinyky
 * junliang mint
 * 30 Mar 2017 17:44:23
 */
public class UserFilter extends	OncePerRequestFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 不过滤的uri
        String[] notFilter = new String[] { 
        		"login", "reg" ,"verifycode",
        		".img",".jpg",".data",".png",".gif",
        		"/css","/emotions",
        		"/error",
        		"/fonts","ico","/images","/img","/topic", "/js" ,"/upload"
        		};
        String wuya = "/wuya/";
        // 请求的uri
        String uri = request.getRequestURI();
        /**
         *  
         */
        UserService userService = new UserServiceImpl(); 
        boolean doFilter = true;
        if(wuya.equals(uri)){
            	doFilter=false;
            	filterChain.doFilter(request, response);
            	return;
        }else{
            for (String s : notFilter) {
                   if (uri.indexOf(s) != -1) {
                         // 如果uri中包含不过滤的uri，则不进行过滤
                         doFilter = false;
                         break;
                   }
            }
        }
           
        if (doFilter) {
                // 执行过滤
                // 从session中获取登录者实体
                boolean isCookie = false;
//            	Cookie[] cookies = request.getCookies();
//            	if(cookies!=null&&cookies.length>0){
//            		for (Cookie cookie : cookies) {
//                		if("user".equalsIgnoreCase(cookie.getName())){
//                			String uid = cookie.getValue();
//                			User user = userService.userSelectByUid(uid);
//                			if(user!=null){
//                				isCookie = true;
//                				HttpSession session = request.getSession(true);
//                				if((User)session.getAttribute("user")!=null){
//                					session.removeAttribute("user");
//                				}
//                				session.setAttribute("user", user);
//                			}
//                		}
//            		}
//            	}
                User user = (User)request.getSession(true).getAttribute("user");
                isCookie = user!=null;
//            	isCookie = true;
                if (!isCookie) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    response.sendRedirect("http://localhost:8080/wuya/user/login");
//                    PrintWriter out = response.getWriter();
//                    String loginPage = "http://localhost:8080/wuya/user/login";
//                    StringBuilder builder = new StringBuilder();
//                    builder.append("<script type=\"text/javascript\">");
//                    builder.append("alert('网页过期，请重新登录！');");
//                    builder.append("window.top.location.href='");
//                    builder.append(loginPage);
//                    builder.append("';");
//                    builder.append("</script>");
//                    out.print(builder.toString());
                    return;
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                    return;
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
                return;
            }
	}

}
