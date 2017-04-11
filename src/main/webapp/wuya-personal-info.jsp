<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
              				<img src="${pageContext.request.contextPath}/upload/headpic/${user.headPic}" class="navbarimg-responsive img-thumbnail " width="80px" height="80px">
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
                    <a class="btn btn-primary">保存</a>
                    <br>
                     <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">个性签名:</div>
                    <input type="text" placeholder="${user.signature }"/><a class="btn btn-primary">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">性别:</div>
                    <c:if test="${user.sex eq 1 }">
	                    <input type="radio" value="1" name="sex" checked/>男
	                    <input type="radio" value="0" name="sex"/>女
                    </c:if>
                    <c:if test="${user.sex eq 0 }">
                    	<input type="radio" value="1" name="sex" />男
	                    <input type="radio" value="0" name="sex" checked/>女
                    </c:if>
                    <a class="btn btn-primary">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">一句话介绍:</div>
                    <input type="text" placeholder="${user.profile }"/>
                    <a class="btn btn-primary">保存</a>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    <div class="info-type" style="min-width: 100px;display: inline-block;">居住地:</div>
                    <input type="text" placeholder="${user.location}"/>
                    <a class="btn btn-primary">保存</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
					<div class="info-type" style="min-width: 100px;display: inline-block;">修改生日:</div>
						<c:if test="${user.birth eq 0 }">
							<input type="text" placeholder="形如2017-4-10"  />
						</c:if>
						<a class="btn btn-primary">保存</a>
					<br/>
                   
                    <br>                 
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
