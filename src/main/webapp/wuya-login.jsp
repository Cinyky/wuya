<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-login.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-login-reg-common.css" />
    <title>无涯登录</title>
</head>
<body>
	<div class="cover">
      <div class="cover-image" style="background-image: url(${pageContext.request.contextPath}/img/bgimg.jpg);"></div>
      <div class="container">
        <div class="row">
          <div class="col-sm-offset-3 col-md-6 text-center">
            <h1 class="text-primary">无涯</h1>
            <p class="text-center text-primary">吾生也有涯，而知也无涯。</p>
        
            
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/login" method="POST">
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <input type="text" class="form-control" id="userName" name="loginCondition" placeholder="请输入用户名/昵称/邮箱" onfocus="showValidate();">
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
                		<input type="text" class="form-control" style="display: inline-block;" name="verifycode" placeholder="请输入验证码">
                		<div class="pull-left">
                			<a href='#' onclick="javascript:changeImg()">
                				<img id="img" src="http://localhost:8080/wuya/verifycode/generateImg" />
                			</a>
							<a href='#' onclick="javascript:changeImg()" class="btn btn-primary">看不清</a>
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
                    <label>
                      <input type="checkbox" checked><span style="color: #D1EEFC;">下次自动登录</span>
                    </label>
                    <label>
                      <input id="showPwd" type="checkbox"/><span style="color: #D1EEFC;">显示密码</span>
                    </label>
                  </div>
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                	<div class="pull-left">
	                     <a style="color: #D1EEFC;cursor: pointer;">忘记密码</span>
	                     <a style="color: #D1EEFC;cursor: pointer;margin-left: 10px;" href="wuya-reg.jsp">没有账号？前往注册</span>
                     </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
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
