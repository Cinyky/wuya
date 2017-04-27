<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.wuya.cyy.pojo.User" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-personal-info.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-personal.css" />

    <title>${user.nickName }的个人信息</title>
  </head>
<body>
	 <jsp:include page="templet/navbar.jsp" />
    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：fengmian
    -->
    <div class="section top table hottopic" >
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            	<div style="width: 100%;height:12.3%;background-color: grey;border: 1px solid transparent; border-radius: 4px;">
              </div>
            	<div style="width: 100%; background-color: #fff;
                          border: 1px solid grey;border-radius: 4px;">
              		<div class="headpic" style="display: inline-block;margin-left: 20px;margin-top: -20px">
              				<img id="myPic" src="${pageContext.request.contextPath}/upload/headpic/${user.headPic}" class="navbarimg-responsive img-thumbnail " width="80px" height="80px">
              		</div>
              		
                    <a href="${pageContext.request.contextPath}/user/${user.uid}/personal" class="btn btn-primary pull-right">返回个人主页</a>
              		<div class="personal-info" 
                       style="position: relative;left: 100px;top: -50px;margin-left: 10px">
                    <span class="nickname" 
                          style="font-size: 26px;font-weight: bolder;">
                         	${user.nickName }
                    </span>
                    <br>
                    <div id="imgPre">
                    	
                    </div>
                    <label for="changeHeadPic"> <img id="prePic" src="${pageContext.request.contextPath}/upload/headpic/${user.headPic}" class="navbarimg-responsive img-thumbnail " width="80px" height="80px"></label>
                    <input type="file" style="display:none" id="changeHeadPic"/>
                    <input type="hidden"  name="update_headpic" value="${user.headPic}"/>
                    <a class="btn btn-primary" onclick="submitUserInfo('0','${user.headPic}')">保存</a>
                    <br>
                     
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <!-- 个性签名 -->
                    <div class="info-type" style="min-width: 100px;display: inline-block;">个性签名:</div>
                    <span id="show1">
                    	<span id="signature_show">${user.signature }</span> <a class="btn btn-primary" onclick="changeShow('1')">修改</a>
                    </span>
                    <span id="change1" style="display:none">
                    	 <input type="text" name="update_signature" placeholder="${user.signature }"/>
                    	 <a class="btn btn-primary" onclick="changeShow('1')">取消</a>
                    	 <a class="btn btn-primary" onclick="submitUserInfo('1','${user.signature}')">保存</a>
                    </span>
                   
                    <br>
                    <!-- 性别 -->
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">性别:</div>
                    <c:if test="${user.sex eq 1 }">
	                     <span id="show2">
	                    	<span id="sex_show">男</span> <a class="btn btn-primary" onclick="changeShow('2')">修改</a>
	                    </span>
	                    <span id="change2" style="display:none">
	                    	 <input type="radio" value="1" name="update_sex" checked/>男
	                    	 <input type="radio" value="0" name="update_sex"/>女
	                    	 <a class="btn btn-primary" onclick="changeShow('2')">取消</a>
	                    	 <a class="btn btn-primary" onclick="submitUserInfo('2','${user.sex}')">保存</a>
                   		</span>
	                    
                    </c:if>
                    <c:if test="${user.sex eq 0 }">
                    	 <span id="show2">
	                    	<span id="sex_show">女</span> <a class="btn btn-primary" onclick="changeShow('2')">修改</a>
	                    </span>
	                    <span id="change2" style="display:none">
	                    	 <input type="radio" value="1" name="update_sex" />男
	                    	 <input type="radio" value="0" name="update_sex" checked/>女
	                    	 <a class="btn btn-primary" onclick="changeShow('2')">取消</a>
	                    	 <a class="btn btn-primary" onclick="submitUserInfo('2','${user.sex}')">保存</a>
                   		</span>
                    </c:if>
                    <br>
                    <!-- 一句话介绍 -->
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">一句话介绍:</div>
                   		<span id="show3">
	                    	<span id="profile_show">${user.profile }</span> <a class="btn btn-primary" onclick="changeShow('3')">修改</a>
	                    </span>
	                    <span id="change3" style="display:none">
							 <input type="text" name="update_profile" placeholder="${user.profile }"/>
							 <a class="btn btn-primary" onclick="changeShow('3')">取消</a>
                   			 <a class="btn btn-primary" onclick="submitUserInfo('3','${user.profile}')">保存</a>
                   		</span>
                    <br>
                    <!-- 居住地 -->
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">居住地:</div>
                    	<span id="show4">
	                    	<span id="location_show">${user.location }</span> <a class="btn btn-primary" onclick="changeShow('4')">修改</a>
	                    </span>
	                    <span id="change4" style="display:none">
							 <input type="text" name="update_location" placeholder="${user.location}"/>
							 <a class="btn btn-primary" onclick="changeShow('4')">取消</a>
                   			 <a class="btn btn-primary" onclick="submitUserInfo('4','${user.location}')">保存</a>
                   		</span>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
					<div class="info-type" style="min-width: 100px;display: inline-block;">修改生日:</div>
						<c:if test="${user.birth eq 0 }">
							<!-- <input type="text" name="update_birth" placeholder="形如2017/4/10"  /> -->
							<span id="show5">
	                    		<span id="birth_show"></span><a class="btn btn-primary" onclick="changeShow('5')">修改</a>
	                    	</span>
	                    	<span id="change5" style="display:none">
		                    	<input class="easyui-datebox" name="update_birth"  data-options="formatter:myformatter,parser:myparser">
								 <a class="btn btn-primary" onclick="changeShow('5')">取消</a>
	                   			 <a class="btn btn-primary" onclick="submitUserInfo('5','${user.birth}')">保存</a>
	                    	</span>
							
						</c:if>
						<c:if test="${user.birth ne 0 }">
							<%
							User uu = (User)session.getAttribute("user");
							Date date = new Date(uu.getBirth());
							%>
							<span id="show5">
	                    		<span id="birth_show"><%= new SimpleDateFormat("yyyy-MM-dd").format(date) %></span> <a class="btn btn-primary" onclick="changeShow('5')">修改</a>
	                    	</span>
	                    	<span id="change5" style="display:none">
							 <input class="easyui-datebox" name="update_birth" data-options="formatter:myformatter,parser:myparser"> 
							 <a class="btn btn-primary" onclick="changeShow('5')">取消</a>
                   			 <a class="btn btn-primary" onclick="submitUserInfo('5','${user.birth}')">保存</a>
                   			</span>
							<!-- <input class="easyui-datebox" name="update_birth" data-options="formatter:myformatter,parser:myparser"> -->
							<%-- <input type="text" name="update_birth" 
							placeholder="<%= new SimpleDateFormat("yyyy/MM/dd").format(date) %>"  /> --%>
						</c:if>
						<%-- <a class="btn btn-primary" onclick="submitUserInfo('5','${user.birth}')">保存</a> --%>
					<br/>
					<hr class="line" style="width: 500px;margin-left: 2px;"/>
					
					<div class="info-type" style="min-width: 100px;display: inline-block;">修改密码:</div>
					 <a class="btn btn-primary btn-sm navbar-btn" data-toggle="modal" data-target="#password">修改密码</a>

                  </div>
                  
                  
            	</div>
          </div>

     
          


        </div>
      </div>
    </div>

    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框1 提问
    -->
    <jsp:include page="templet/showQuestion.jsp" />
    
    <!-- 修改密码 -->
    <div class="fade modal" id="password">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-修改密码</h4>
          </div>
          <div class="modal-body">
                <h4>修改密码步骤</h4>
                <ol>
                  <li>验证密码</li>
                  <li>输入新密码</li>
                  <li>输入两次密码一致</li>
                  <li>修改密码成功</li>
                </ol>
                <div class="form-group">
                	<input type="password" class="form-control" id="oldPwd" placeholder="验证旧密码" onkeyup="verifyOldPwd()">
                	<div id="oldstatus" class="alert alert-success">请输入验证密码</div>
                </div>
                
                <div class="form-group">
                	<input type="password" class="form-control" id="newPwd" readonly="readonly" placeholder="输入新密码" onkeyup="verifyNewPwd()">
                	<div id="newstatus" class="alert alert-success">请输入新密码</div>
                </div>
                <div class="form-group">
                 	<input type="password" class="form-control"  id="newPwd2" readonly="readonly" placeholder="再次输入密码" onkeyup="verifyNewPwdAgain()">
                 	<div id="newstatus2" class="alert alert-success">请再一次输入密码</div>
                </div>
                <!-- disabled="disabled " -->
                <button type="button" class="btn btn-lg btn-primary btn-block" id="submitPwd"  disabled="disabled" onclick="modifyPwd()">确认修改</button>
          </div>
        </div>
      </div>
</div>
    
</body>
</html>
