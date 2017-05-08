<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<!DOCTYPE html>
<head>
	<title>无涯wuya管理员</title>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<jsp:include page="templet/necessary.jsp" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-admin-media.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-admin-style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-admin.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-admin-user-statistics.js" ></script>
</head>
<body>
<!--Header-part-->
<div id="header">
  <h1><a >wuya Admin</a></h1>
</div>
<!--close-Header-part--> 
<div id="sidebar"><a class="toggleall" href="#" class="visible-phone"><i class="icon icon-home"></i> wuya管理员</a>
  <ul>
    <li><a href="${pageContext.request.contextPath}/admin/home"><i class="icon icon-home"></i> <span>主页</span></a> </li>
    <li class="submenu active"> 
      <a class="showmenu" href="#"><i class="icon icon-th-list"></i> <span>统计</span> <span class="label label-important">3</span></a>
	      <ul>
	        <li><a href="${pageContext.request.contextPath}/admin/user/statistics">用户</a></li>
	        <li><a href="${pageContext.request.contextPath}/admin/question/statistics">问题</a></li>
	        <li><a href="${pageContext.request.contextPath}/admin/answer/statistics">回答</a></li>
	      </ul>
    </li>
    <li> <a href="${pageContext.request.contextPath}/admin/suggestion"><i class="icon icon-inbox"></i> <span>意见反馈</span></a> </li>
    <li> <a href="${pageContext.request.contextPath}/admin/report"><i class="icon icon-th-list"></i> <span>举报处理</span></a>
  </ul>
</div>

<div id="content">
   
	<div id="content-header">
		 <h3>欢迎管理员，${admin.loginName }</h3>	
    	 <h1 id="showInfo">主页</h1>
	</div>
  
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a> <i class="icon-dashboard"></i> 主页 </a> </li>

        <li class="bg_lg span3"> <a> <i class="icon-signal"></i> 统计</a> </li>

        <li class="bg_ly"> <a > <i class="icon-inbox"></i>
        	<c:if test="${not empty todayAdviceCount }">
        		<c:if test="${ todayAdviceCount ne 0 }">
        				<span class="label label-success">${ todayAdviceCount }</span> 
        		</c:if>
        	</c:if>
        	意见反馈 </a> 
        </li>

        <li class="bg_lo span3"> <a > <i class="icon-th"></i> 
        <c:if test="${not empty todayReportCount }">
        		<c:if test="${ todayReportCount ne 0 }">
        				<span class="label label-success">${ todayReportCount }</span> 
        		</c:if>
        	</c:if>
        	举报处理 </a> </li>

      </ul>
    </div>
    
    <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>用户统计</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>登录名</th>
                  <th>昵称</th>
                  <th>绑定邮箱</th>
                  <th>账号状态</th>
                  <th>注册时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:choose>
              		<c:when test="${not empty users }">
              			<c:forEach items="${users }" var="user">
              				<c:set value="${user }" var="uu" scope="page"></c:set>
              				<tr class="gradeX">
			                  <td>${user.loginName }</td>
			                  <td>${user.nickName }</td>
			                  <td>
			                  	<c:choose>
			                  		<c:when test="${not empty user.bindEmail }">
			                  			${ user.bindEmail }
			                  		</c:when>
			                  		
			                  		<c:otherwise>
			                  			未绑定邮箱
			                  		</c:otherwise>
			                  		
			                  	</c:choose>
			                  
			                  </td>
			                  
			                  <td id="banstate${uu.uid }">
			                  	<%
			                  		User u = (User)pageContext.getAttribute("uu");
			                  		Long banTime = u.getBanTime();
			                  	%>
			                  	<% 
			                  		if(banTime>System.currentTimeMillis()){
			                  			Date date = new Date(banTime);
			                  	%>
			                  		<%=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(date) %>
			                  	<% 
			                  		}else{
			                  	%>
			                  		正常
			                  	<%
			                  		}
			                  	%>
			                  </td>
			                   <td>
			                   	<%
			                   		Date date = new Date(u.getRegTime());
			                   	%>
			                   	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
			                   </td>
			                   <td>
			                   		<a class="btn btn-primary" id="handle${ uu.uid }" onclick="handle('${ uu.uid }','${ uu.nickName }','${ uu.banTime }')">处理</a>
			                   </td>
			                </tr>
              			</c:forEach>
              		</c:when>
              		
              		<c:otherwise>
	              		<tr class="gradeX">
	              			<td>
	              				没有查询到用户信息
	              			</td>
				        </tr>
              		</c:otherwise>
              	</c:choose>
                
                <tr class="gradeA" >
                  <td colspan="5" class="text-center">
                  	总数 <span id="pages">${userpage.totalCount }</span>
                  	总页数 <span id="pages">${userpage.totalPageCount }</span>
                  	当前页 <span id="currentPage">${userpage.pageNow}</span>
                  	<c:if test="${userpage.pageNow ne 1}">
                  		<a href="${pageContext.request.contextPath}/admin/user/statistics?currentpage=${userpage.pageNow-1}">上一页</a><span id="prePage"></span>
                  	</c:if>
                  	<c:if test="${userpage.pageNow ne userpage.totalPageCount}">
                  		<a href="${pageContext.request.contextPath}/admin/user/statistics?currentpage=${userpage.pageNow+1}">下一页</a><span id="nextPage"></span>
                  	</c:if>
                  	
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
    
  </div>
</div>


<div class="fade modal" id="ban" style="z-index:999999999999;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-封号系统</h4>
          </div>
          <div class="modal-body text-center" id="handleContent">
               	 	<h4 id="nickName">Cinyky1234</h4>
               	 	状态:<span id="state">封号</span>
               	 	<br>
               	 	<div id="showdays">
		             	<label><input name="days" type="radio" value="1" checked/> 1 天 </label> 
						<label><input name="days" type="radio" value="2" /> 2 天 </label> 
						<label><input name="days" type="radio" value="3" /> 3 天 </label> 
						<label><input name="days" type="radio" value="7" /> 1 周 </label> 
						<label><input name="days" type="radio" value="30" />1 月 </label> 
						<label><input name="days" type="radio" value="365" /> 1 年 </label> 
					</div>
          </div>
          
          <div class="modal-footer">
          	<a class="btn btn-primary btn-block" id="handleUser">封号</a> 
          </div>
        </div>
      </div>
</div>

<!--Footer-part-->
<div class="row-fluid">

  <div id="footer" class="span12"> 2017 &copy; 无涯wuya Admin </div>

</div>
<!-- Footer-part -->
</body>

</html>

