<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<%@ page import="com.wuya.cyy.pojo.Answer" %>
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
    	 <h1 id="showInfo">回答统计</h1>
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
            <h5>回答统计</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
 				  <th>问题名</th>
                  <th>回答详情</th>
                  <th>回答人</th>
                  <th>回答时间</th>
                </tr>
              </thead>
              <tbody>
              	<c:choose>
              		<c:when test="${not empty answers }">
              			<c:forEach items="${answers }" var="answer">
              				<c:set value="${answer }" var="answer" scope="page"></c:set>
              				<c:set value="${answer.question }" var="question" scope="page"></c:set>
              				<c:set value="${answer.user }" var="user" scope="page"></c:set>
              				<tr class="gradeX">
			                  <td>${question.questionInfo }</td>
			                  <td>${answer.answerInfo }</td>
			                  <td>${user.nickName }</td>
			                  <td>
			                  	<%
			                  		Answer answer = (Answer)pageContext.getAttribute("answer");
			                  		Long answerTime = answer.getAnswerTime();
			                  		Date date = new Date(answerTime);
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
                  	总数 <span id="pages">${answerpage.totalCount }</span>
                  	总页数 <span id="pages">${answerpage.totalPageCount }</span>
                  	当前页 <span id="currentPage">${answerpage.pageNow}</span>
                  	<c:if test="${answerpage.pageNow ne 1}">
                  		<a href="${pageContext.request.contextPath}/admin/answer/statistics?currentpage=${answerpage.pageNow-1}">上一页</a><span id="prePage"></span>
                  	</c:if>
                  	<c:if test="${answerpage.pageNow ne questionpage.totalPageCount}">
                  		<a href="${pageContext.request.contextPath}/admin/answer/statistics?currentpage=${answerpage.pageNow+1}">下一页</a><span id="nextPage"></span>
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
            <h4 class="modal-title">无涯-提出你的疑惑</h4>
          </div>
          <div class="modal-body">
              <form class="form  text-center" role="search" action="${pageContext.request.contextPath}/question/add">
                <div class="form-group">
                  <input type="text" class="form-control" name="questionInfo" id="questionInfo" placeholder="输入你想询问的问题">
                 
                  <div class="panel panel-default">
	                  <div class="panel-body"  id="searchQuestion" >
	                  </div>
                  
                  </div>
                </div>
                <button type="button" class="btn btn-lg btn-primary btn-block" id="submitQuestion">提问</button>
              </form>
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

