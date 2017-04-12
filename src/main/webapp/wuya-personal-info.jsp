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
                    <div class="info-type" style="min-width: 100px;display: inline-block;">个性签名:</div>
                    <input type="text" name="update_signature" placeholder="${user.signature }"/>
                    <a class="btn btn-primary" onclick="submitUserInfo('1','${user.signature}')">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">性别:</div>
                    <c:if test="${user.sex eq 1 }">
	                    <input type="radio" value="1" name="update_sex" checked/>男
	                    <input type="radio" value="0" name="update_sex"/>女
                    </c:if>
                    <c:if test="${user.sex eq 0 }">
                    	<input type="radio" value="1" name="update_sex" />男
	                    <input type="radio" value="0" name="update_sex" checked/>女
                    </c:if>
                    <a class="btn btn-primary" onclick="submitUserInfo('2','${user.sex}')">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">一句话介绍:</div>
                    <input type="text" name="update_profile" placeholder="${user.profile }"/>
                    <a class="btn btn-primary" onclick="submitUserInfo('3','${user.profile}')">保存</a>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">居住地:</div>
                    <input type="text" name="update_location" placeholder="${user.location}"/>
                    <a class="btn btn-primary" onclick="submitUserInfo('4','${user.location}')">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
					<div class="info-type" style="min-width: 100px;display: inline-block;">修改生日:</div>
						<c:if test="${user.birth eq 0 }">
							<input type="text" name="update_birth" placeholder="形如2017/4/10"  />
						</c:if>
						<c:if test="${user.birth ne 0 }">
							<%
							User uu = (User)session.getAttribute("user");
							Date date = new Date(uu.getBirth());
							%>
							<input type="text" name="update_birth" 
							placeholder="<%= new SimpleDateFormat("yyyy/MM/dd").format(date) %>"  />
						</c:if>
						<a class="btn btn-primary" onclick="submitUserInfo('5','${user.birth}')">保存</a>
					<br/>
                   
                    <br>    
                    <a class="btn btn-primary" onclick="submitUserInfo('6','${user.headPic}|${user.signature}|${user.sex}|${user.profile}|${user.location}|${user.birth}')">提交全部</a>             
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
      style="position:absolute;left: 4%;bottom: 40%;display: inline-block;"
    -->
    <div class="fade modal" id="question">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-提出你的疑惑</h4>
          </div>
          <div class="modal-body">
                <h4>提问步骤</h4>
                <ol>
                  <li>搜索是否已有相似问题</li>
                  <li>查看是否解决</li>
                  <li>坚持提问</li>
                </ol>
              <form class="form  text-center" role="search">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="搜索你感兴趣的内容...">
                  <div><span class="pull-left">问题说明</span></div>
                  <input type="submit" class="btn btn-block btn-primary" value="query" />
                </div>
              </form>
          </div>
        </div>
      </div>
    </div>
     <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框2 unused
    -->
    <div class="fade modal" id="report">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-举报系统</h4>
          </div>
          <div class="modal-body">
                <h4>举报步骤</h4>
                <ol>
                  <li>搜索是否已有相似问题</li>
                  <li>查看是否解决</li>
                  <li>坚持提问</li>
                </ol>
              <form class="form  text-center" role="search">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="搜索你感兴趣的内容...">
                </div>
              </form>
          </div>
          <div class="modal-footer">
            <a class="btn btn-primary" data-dismiss="modal">关闭</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
