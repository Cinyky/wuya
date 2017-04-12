<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-reg.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-login-reg-common.css" />
    <title>无涯reg</title>
</head>
<body>
	<div class="cover">
      <div class="cover-image" style="background-image: url(${pageContext.request.contextPath}/upload/headpic/bgimg.jpg);"></div>
      <div class="container">
        <div class="row">
          <div class="col-sm-offset-3 col-md-6 text-center">
            <h1 class="text-primary">无涯</h1>
            <p class="text-center text-primary">吾生也有涯，而知也无涯。</p>
        
            
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/register" method="post">
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <input type="text" class="form-control" id="userName" name="user_name" placeholder="请输入用户名" onfocus="showValidate();">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称" onfocus="showValidate();">
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
                  <input type="password" class="form-control" id="password" placeholder="请再次输入密码">
                  <input type="text" class="form-control" style="display: none;" id="passwordShow" placeholder="请输入密码">
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                		<input type="email" class="form-control" style="display: inline-block;" name="bind_email" placeholder="请输入163邮箱以激活账号">
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
                      <input id="showPwd" type="checkbox"/><span style="color: #D1EEFC;">显示密码</span>
                    </label>
                  </div>
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                	<div class="pull-left">
	                     <a style="color: #D1EEFC;cursor: pointer;margin-left: 10px;" href="${pageContext.request.contextPath}/user/login">已有账号？前往登录</span>
                     </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">
                  <button type="submit" class="btn btn-lg btn-primary btn-block">注册</button>
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
