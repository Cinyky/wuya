<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-pwd.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-login-reg-common.css" />
    <title>无涯登录</title>
</head>
<body>
	<div class="cover">
      <div class="cover-image" style="background-image: url(${pageContext.request.contextPath}/upload/headpic/bgimg.jpg);"></div>
      <div class="container">
        <div class="row">
          <div class="col-sm-offset-3 col-md-6 text-center">
            <h1 class="text-primary">无涯</h1>
        	 <div class="panel panel-success">
        		<div class="panel-heading">
        			 <h3 class="panel-title" style="color:white;">密码找回 （目前只支持163邮箱）</h3>
  				</div>
             	<div class="panel-body" style="min-height:300px;" id="content">
             		<div id="content1" style="margin-top:10%;">
             			<div class="form-group">
				        	<div class="col-sm-offset-3 col-sm-6">
				            	<input type="text" class="form-control" id="bind_email" onkeyup="verifyEmail()" autocomplete="off"  placeholder="请输入绑定163邮箱" />
				            	<div id="emailStatus" class="alert alert-success">请输入绑定163邮箱</div>
				            </div>
				            <div class="col-sm-offset-3 col-sm-6" style="margin-top:10px;">
				               <button type="submit" class="btn btn-lg btn-primary btn-block" id="sendEmail" disabled="disabled" onclick="sendEmailCode()">发送</button>
				            </div>
			            </div>
             		
             		</div>
             		
             		<div id="content2" style="margin-top:10%;display:none;">
             			<div class="form-group">
				        	<div class="col-sm-offset-3 col-sm-6">
				            	<input type="text" class="form-control" id="email_code_input" readonly="readonly" placeholder="请输入邮箱验证码" />
				            </div>
				            
				             <div class="col-sm-offset-3 col-sm-6" style="margin-top:10px;">
				               <button type="submit" class="btn btn-lg btn-primary btn-block" id="verifyEmail" onclick="verifyCode()">验证</button>
				            </div>
			            </div>
			               
				           
             		
             		</div>
             		
             		<div id="content3" style="margin-top:10%;display:none;">
			            <div class="form-group">
				            <div class="col-sm-offset-3 col-sm-6">
				            	<input type="password" class="form-control" id="newPwd" readonly="readonly" placeholder="输入新密码" onkeyup="verifyNewPwd()">
			                	<div id="newstatus" class="alert alert-success">请输入新密码</div>
				            </div>
				            <div class="col-sm-offset-3 col-sm-6">
			                 	<input type="password" class="form-control"  id="newPwd2" readonly="readonly" placeholder="再次输入密码" onkeyup="verifyNewPwdAgain()">
			                 	<div id="newstatus2" class="alert alert-success">请再一次输入密码</div>
		               		 </div>
		               		 <div class="col-sm-offset-3 col-sm-6">
				               <button type="submit" class="btn btn-lg btn-primary btn-block" id="submitPwd" onclick="modifyCode()">修改</button>
				             </div>
		                </div>
             		</div>
                	
               </div>
               
               <div class="panel-footer">
               	<span id="step1" style="color:orange">1.发送邮箱验证码</span>  》》	<span id="step2">2.校验验证码</span>  》》	<span id="step1">3.重置密码</span>
               </div>
             </div>
        	
          </div>
        </div>
      </div>
    </div>
	
</body>
</html>
