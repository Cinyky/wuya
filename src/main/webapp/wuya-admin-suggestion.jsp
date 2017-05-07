<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<%@ page import="com.wuya.cyy.pojo.Advice" %>
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
    <li class="submenu"> 
      <a class="showmenu" href="#"><i class="icon icon-th-list"></i> <span>统计</span> <span class="label label-important">3</span></a>
	      <ul>
	        <li><a href="${pageContext.request.contextPath}/admin/user/statistics">用户</a></li>
	        <li><a href="${pageContext.request.contextPath}/admin/question/statistics">问题</a></li>
	        <li><a href="${pageContext.request.contextPath}/admin/answer/statistics">回答</a></li>
	      </ul>
    </li>
    <li class="active"> <a href="${pageContext.request.contextPath}/admin/suggestion"><i class="icon icon-inbox"></i> <span>意见反馈</span></a> </li>
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
    
    <div class="row-fluid">
    	<c:choose>
        	<c:when test="${not empty advices }">
            	<c:forEach items="${advices }" var="advice">
              		<c:set value="${advice.user }" var="uu" scope="page"></c:set>
					<div class="span6">
				        <div class="widget-box">
				          <div class="widget-title bg_ly" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
				            <h5>意见反馈</h5>
				          </div>
				          <div class="widget-content nopadding collapse in" id="collapseG2">
				            <ul class="recent-posts">
				              <li>
				                <div class="user-thumb"> <img width="40" height="40" alt="User" src="${pageContext.request.contextPath}/upload/headpic/${uu.headPic}"> </div>
				                <div class="article-post"> 
					                <span class="user-info"> By: <span id="userName">${uu.nickName }</span> / Date:
					                	<span id="reportTime">
					                			<%
							                  		Advice advice = (Advice)pageContext.getAttribute("advice");
					                				Long adviceTime = advice.getAdviceTime();
					                				Date date = new Date(adviceTime);
							                  	%>
							                  	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
					                	</span> 
				               		 </span>
				                 	 <p>${advice.adviceInfo }</p>
				                </div>
				              </li>
				            </ul>
				          </div>
				        </div>
					</div>
					</c:forEach>
              		</c:when>
              		<c:otherwise>
	              		<tr class="gradeX">
	              			<td>
	              				没有查询到反馈信息
	              			</td>
				        </tr>
              		</c:otherwise>
              	</c:choose>
		<div class="span6 text-center">	
			总数 <span id="pages">${advicepage.totalCount }</span>
                                总页数 <span id="pages">${advicepage.totalPageCount }</span>
                               当前页 <span id="currentPage">${advicepage.pageNow}</span>
            <c:if test="${advicepage.pageNow ne 1}">
	      		<a href="${pageContext.request.contextPath}/admin/suggestion?currentpage=${advicepage.pageNow-1}">上一页</a><span id="prePage"></span>
           </c:if>
           <c:if test="${advicepage.pageNow ne advicepage.totalPageCount}">
           		<a href="${pageContext.request.contextPath}/admin/suggestion?currentpage=${advicepage.pageNow+1}">下一页</a><span id="nextPage"></span>
           </c:if>
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

