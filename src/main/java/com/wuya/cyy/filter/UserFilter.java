package com.wuya.cyy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filter
 * @author Cinyky
 * junliang mint
 * 30 Mar 2017 17:44:23
 */
public class UserFilter extends	OncePerRequestFilter{

//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//	       // 请求的uri
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		HttpServletRequest httpServletResponse = (HttpServletRequest)response;
//	    String uri = httpServletRequest.getRequestURI();
//		String[] notFilter = new String[] { "login", "reg" };
//	 
//	            boolean doFilter = true;
//	            for (String s : notFilter) {
//	                if (uri.indexOf(s) != -1) {
//	                    // 如果uri中包含不过滤的uri，则不进行过滤
//	                    doFilter = false;
//	                    break;
//	                }
//	            }
//	            if (doFilter) {
//	                // 执行过滤
//	                // 从session中获取登录者实体
//	                Object obj = httpServletRequest.getSession().getAttribute("user");
//	                if (null == obj) {
//	                    // 如果session中不存在登录者实体，则弹出框提示重新登录
//	                    // 设置request和response的字符集，防止乱码
//	                    request.setCharacterEncoding("UTF-8");
//	                    response.setCharacterEncoding("UTF-8");
//	                    PrintWriter out = response.getWriter();
//	                    String loginPage = "http://localhost:8080/wuya/";
//	                    StringBuilder builder = new StringBuilder();
//	                    builder.append("<script type=\"text/javascript\">");
//	                    builder.append("alert('网页过期，请重新登录！');");
//	                    builder.append("window.top.location.href='");
//	                    builder.append(loginPage);
//	                    builder.append("';");
//	                    builder.append("</script>");
//	                    out.print(builder.toString());
//	                } else {
//	                    // 如果session中存在登录者实体，则继续
//	                	chain.doFilter(request, response);
//	                }
//	            } else {
//	                // 如果不执行过滤，则继续
//	            	chain.doFilter(request, response);
//	            }
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 不过滤的uri
        String[] notFilter = new String[] { "login", "reg" };
  
        // 请求的uri
        String uri = request.getRequestURI();
  
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1) {
                    // 如果uri中包含不过滤的uri，则不进行过滤
                    doFilter = false;
                    break;
                }
            }
            if (doFilter) {
                // 执行过滤
                // 从session中获取登录者实体
                Object obj = request.getSession().getAttribute("user");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    String loginPage = "http://localhost:8080/wuya/";
                    StringBuilder builder = new StringBuilder();
                    builder.append("<script type=\"text/javascript\">");
                    builder.append("alert('网页过期，请重新登录！');");
                    builder.append("window.top.location.href='");
                    builder.append(loginPage);
                    builder.append("';");
                    builder.append("</script>");
                    out.print(builder.toString());
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }
	}

}
