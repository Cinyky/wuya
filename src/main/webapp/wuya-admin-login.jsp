<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-login.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-login-reg-common.css" />
    <title>无涯登录</title>
</head>
<body>
	<div class="cover">
	  <c:if test="${not empty txt }">
	  	<script>
	  	wuya_messager('无涯登录','${txt}','error');
	  	</script>
	  </c:if>
      <div class="cover-image" style="background-image: url(${pageContext.request.contextPath}/upload/headpic/bgimg.jpg);"></div>
      <div class="container">
        <div class="row">
          <div class="col-sm-offset-3 col-md-6 text-center">
            <h1 class="text-primary">无涯-后台管理系统</h1>
            <p class="text-center text-primary">吾生也有涯，而知也无涯。</p>
        
            
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/admin/login" method="POST">
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <input type="text" class="form-control" id="userName" name="loginName" placeholder="请输入用户名/昵称/邮箱" />
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                 <input type="password" class="form-control" id="password" name="pwd" placeholder="请输入密码">
                  <input type="text" class="form-control" style="display: none;" id="passwordShow" placeholder="请输入密码">
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                		<input type="text" class="form-control" style="display: inline-block;" name="verifycode" placeholder="请输入验证码" autocomplete="off"> 
                		<div class="pull-left">
                			<a href='#' onclick="javascript:changeImg('${pageContext.request.contextPath}')">
                				<img id="img" src="${pageContext.request.contextPath}/verifycode/generateImg" />
                			</a>
							<a href='#' onclick="javascript:changeImg('${pageContext.request.contextPath}')" class="btn btn-primary">看不清</a>
                		</div>
                </div>
              </div>
              <!--
              	作者：1079276272@qq.com
              	时间：2017-02-25
              	描述：http://localhost:8080/wuya/verifycode/generateImg
              -->
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <div class="checkbox pull-left">
             <!--        <label>
                      <input type="checkbox" checked name="max_age"><span style="color: #D1EEFC;">下次自动登录</span>
                    </label> -->
                    <label>
                      <input id="showPwd" type="checkbox"/><span style="color: #D1EEFC;">显示密码</span>
                    </label>
                  </div>
                </div>
              </div>
              
             <%--  <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                	<div class="pull-left">
	                     <a style="color: #D1EEFC;cursor: pointer;" href="${pageContext.request.contextPath}/user/forgetpwd">忘记密码</a>
	                     <a style="color: #D1EEFC;cursor: pointer;margin-left: 10px;" href="${pageContext.request.contextPath}/user/register">没有账号？前往注册</a>
                     </div>
                </div>
              </div> --%>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <button type="submit" class="btn btn-lg btn-primary btn-block" id="loginSubmit">登录</button>
                </div>
              </div>
            </form>
            <br>
            <br>
          </div>
        </div>
      </div>
    </div>
	
</body>
</html>
