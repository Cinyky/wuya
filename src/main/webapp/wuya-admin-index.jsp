<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<head>
	<title>无涯wuya管理员</title>
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
    <li class="active"><a href="${pageContext.request.contextPath}/admin/home"><i class="icon icon-home"></i> <span>主页</span></a> </li>
    <li class="submenu"> 
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
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>网站数据实时统计</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span3">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong>${totalUserCount }</strong> <small>总用户</small></li>
                <li class="bg_lh"><i class="icon-plus"></i> <strong>${todayUserCount }</strong> <small>今天新注册用户 </small></li>
                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>${totalQuestionCount }</strong> <small>总问题数</small></li>
                <li class="bg_lh"><i class="icon-tag"></i> <strong>${todayQuestionCount }</strong> <small>今日问题数</small></li>
                <li class="bg_lh"><i class="icon-repeat"></i> <strong>${totalAnswerCount }</strong> <small>总回答数</small></li>
                <li class="bg_lh"><i class="icon-globe"></i> <strong>${todayAnswerCount }</strong> <small>今日回答数</small></li>
              </ul>
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

