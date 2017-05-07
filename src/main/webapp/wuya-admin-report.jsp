<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<%@ page import="com.wuya.cyy.pojo.Answer" %>
<%@ page import="com.wuya.cyy.pojo.Question" %>
<%@ page import="com.wuya.cyy.pojo.Report" %>
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
    <li> <a href="${pageContext.request.contextPath}/admin/suggestion"><i class="icon icon-inbox"></i> <span>意见反馈</span></a> </li>
    <li  class="active"> <a href="${pageContext.request.contextPath}/admin/report"><i class="icon icon-th-list"></i> <span>举报处理</span></a>
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
        	<c:when test="${not empty reports }">
            <c:forEach items="${reports }" var="report">
            	<c:set value="${report.user }" var="reportuser" scope="page"></c:set>
              		<c:choose>
              			<c:when test="${report.reportType eq '1' }">
              				<c:set value="${report.answer }" var="answer" scope="page"></c:set>
              				<c:set value="${answer.user }" var="answeruser" scope="page"></c:set>
              					<div class="widget-box">
							          <div class="widget-title bg_ly" id="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
							            <h5>举报信息</h5>
							          </div>
							          <div class="widget-content nopadding collapse in" id="collapseG2">
							            <ul class="recent-posts">
							              <li>
							                <div class="user-thumb"> <img width="40" height="40" alt="User" src="${pageContext.request.contextPath}/upload/headpic/${reportuser.headPic}"> </div>
							                <div class="article-post"> <span class="user-info"> By: <span id="userName">${reportuser.nickName }</span> / Date:
								                <span id="reportTime">
								                	<%
							                  		Report report = (Report)pageContext.getAttribute("report");
					                				Long reportTime = report.getReportTime();
					                				Date date = new Date(reportTime);
							                  		%>
							                  	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
								                </span> 
							                </span>
							                  <p>${report.reportInfo }</p>
							                </div>
							                <div class="answer" id="answer1">
									                <div class="panel panel-default">
										                  <div class="panel-heading">
										                  	<img src="${pageContext.request.contextPath}/upload/headpic/${answeruser.headPic}" width="60px" height="60px"/>
											              	<div class="author-info" style="display:inline-block;">
											              		<span class="nickname">${answeruser.nickName }</span><br/>
											              		<span class="sign">${answeruser.signature }</span>
											              	</div>
										                  </div>
											              <div class="panel-body">
												               <p class="answer-info">
												               ${answeruser.answerInfo }
												               </p>
												               <hr>
												               <span class="answer-date">发布于 
												               	<%
											                  		Answer answer = (Answer)pageContext.getAttribute("answer");
												               		Long answerTime = 0l;
												               		if(answer!=null){
												               			answerTime = answer.getAnswerTime();
												               		}
									                				if(answerTime==0){
									                					date = new Date();
									                				}else{
									                					date = new Date(answerTime);
									                				}
									                				
											                  	%>
											                  	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
												               </span>
											              </div>
									                </div>
							                </div>
							              </li>
							              <li>
							                <button class="btn btn-warning btn-mini">处理</button>
							              </li>
							            </ul>
							          </div>
							        </div>
              			</c:when>
              			
              			<c:otherwise>
              				<c:set value="${report.question }" var="question" scope="page"></c:set>
              				<c:set value="${question.user }" var="questionuser" scope="page"></c:set>
              				<div class="widget-box">
					          <div class="widget-title bg_ly" id="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
					            <h5>举报信息</h5>
					          </div>
					          <div class="widget-content nopadding collapse in" id="collapseG2">
					            <ul class="recent-posts">
					              <li>
					                <div class="user-thumb"> <img width="40" height="40" alt="User" src="${pageContext.request.contextPath}/upload/headpic/${reportuser.headPic}"> </div>
					                <div class="article-post"> <span class="user-info"> By: <span id="userName">${reportuser.nickName }</span> / Date:
						               	 <span id="reportTime">
									                	<%
								                  		Report report = (Report)pageContext.getAttribute("report");
						                				Long reportTime = report.getReportTime();
						                				Date date = new Date(reportTime);
								                  		%>
								                  	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
									      </span> 
					                </span>
					                  <p>${report.reportInfo }</p>
					                </div>
					                <div class="piece" id="piece1">
						            <ul class="media-list">
						              <li class="media">
						                <a href="#" class="pull-left">
						                	<span>${questionuser.nickName }</span>
						                	<img class="img-rounded media-object" src="${pageContext.request.contextPath}/upload/headpic/${questionuser.headPic}" height="42" width="42">
						                </a>
						                <div class="media-body">
						                  <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
						                </div>
						              </li>
						            </ul>
					            </div> 
					              </li>
					              <li>
					                <button class="btn btn-warning btn-mini">处理</button>
					              </li>
					            </ul>
					          </div>
					        </div>
              			</c:otherwise>
              		</c:choose>
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
			总数 <span id="pages">${reportpage.totalCount }</span>
                                总页数 <span id="pages">${reportpage.totalPageCount }</span>
                               当前页 <span id="currentPage">${reportpage.pageNow}</span>
            <c:if test="${reportpage.pageNow ne 1}">
	      		<a href="${pageContext.request.contextPath}/admin/report?currentpage=${reportpage.pageNow-1}">上一页</a><span id="prePage"></span>
           </c:if>
           <c:if test="${reportpage.pageNow ne reportpage.totalPageCount}">
           		<a href="${pageContext.request.contextPath}/admin/report?currentpage=${reportpage.pageNow+1}">下一页</a><span id="nextPage"></span>
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

