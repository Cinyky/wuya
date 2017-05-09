<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<%@ page import="com.wuya.cyy.pojo.Question" %>
<!DOCTYPE html>
<head>
	<title>无涯wuya问题统计</title>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<jsp:include page="templet/necessary.jsp" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-admin-media.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-admin-style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-admin.js" ></script>
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
		  <h3>欢迎管理员，${admin.loginName }  <a href="${pageContext.request.contextPath}/admin/login">退出</a></h3>	
    	 <h1 id="showInfo">问题统计</h1>
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
            <h5>问题统计</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>问题名</th>
                  <th>话题名</th>
                  <th>提出问题用户名</th>
                  <th>问题时间</th>
                </tr>
              </thead>
              <tbody>
              	<c:choose>
              		<c:when test="${not empty questions }">
              			<c:forEach items="${questions }" var="question">
              				<c:set value="${question }" var="question" scope="page"></c:set>
              				<c:set value="${question.user }" var="user" scope="page"></c:set>
              				<c:set value="${question.topic }" var="topic" scope="page"></c:set>
              				<tr class="gradeX">
			                  <td>${question.questionInfo }</td>
			                  <td>${topic.topicName }</td>
			                  <td>${user.nickName }</td>
			                  <td>
			                  	<%
			                  		Question q = (Question)pageContext.getAttribute("question");
			                  		Long questionTime = q.getQuestionTime();
			                  		Date date = new Date(questionTime);
			                  	%>
			                  		<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
			                  </td>
			                </tr>
              			</c:forEach>
              		</c:when>
              		
              		<c:otherwise>
	              		<tr class="gradeX">
	              			<td>
	              				没有查询到问题信息
	              			</td>
				        </tr>
              		</c:otherwise>
              	</c:choose>
                
                <tr class="gradeA" >
                  <td colspan="4" class="text-center">
                  	总数 <span id="pages">${questionpage.totalCount }</span>
                  	总页数 <span id="pages">${questionpage.totalPageCount }</span>
                  	当前页 <span id="currentPage">${questionpage.pageNow}</span>
                  	<c:if test="${questionpage.pageNow ne 1}">
                  		<a href="${pageContext.request.contextPath}/admin/question/statistics?currentpage=${questionpage.pageNow-1}">上一页</a><span id="prePage"></span>
                  	</c:if>
                  	<c:if test="${questionpage.pageNow ne questionpage.totalPageCount}">
                  		<a href="${pageContext.request.contextPath}/admin/question/statistics?currentpage=${questionpage.pageNow+1}">下一页</a><span id="nextPage"></span>
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




<!--Footer-part-->
<div class="row-fluid">

  <div id="footer" class="span12"> 2017 &copy; 无涯wuya Admin </div>

</div>
<!-- Footer-part -->
</body>

</html>

