<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-personal.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-personal.css" />
    <title>${personal_user.nickName }的主页</title>
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
            	<div style="width: 100%;height:12.3%;background-color: grey;border: 1px solid transparent; border-radius: 4px;"></div>
            	<div style="width: 100%;height:15.8%; background-color: #fff;
                          border: 1px solid grey;border-radius: 4px;">
              		<div class="headpic" style="display: inline-block;margin-left: 20px;margin-top: -20px">
              			<img src="${pageContext.request.contextPath}/upload/headpic/${personal_user.headPic}" class="navbarimg-responsive img-thumbnail " width="80px" height="80px">
              		</div>
              		<div class="personal-info" 
                       style="position: relative;left: 100px;top: -50px;margin-left: 10px">
                    <span class="nickname" 
                          style="font-size: 26px;font-weight: bolder;">
                          ${personal_user.nickName }
                    </span>
                    &nbsp;
                    <span class="profession">${personal_user.signature }</span><br>
                    <label>
                    	<c:if test="${personal_user.sex eq 1}">
                    		<i class="fa fa-fw fa-male"></i>
                    	</c:if>
                    	<c:if test="${personal_user.sex ne 1}">
                    		<i class="fa fa-fw fa-female"></i>
                    	</c:if>
                    </label><br>
                    <span>${personal_user.profile }</span>
                 	<c:if test="${personal_user.uid ne user.uid }">
                 		 <a href="" class="btn btn-primary" onclick="changeFriend('${personal_user.uid}')">关注他</a>
                 	</c:if>
                 	<c:if test="${personal_user.uid eq user.uid }">
                 		 <a href="${pageContext.request.contextPath }/user/personal/info">修改个人界面</a>
                 	</c:if>
                 	
                  </div>
                  
            	</div>
    	 </div>
   	   </div>
   	  </div>
   	 </div>

     <div class="section top table hottopic" >
      <div class="container">
        <div class="row">
          <div class="col-md-8 panel">
            <div style="padding-left: 20px;">
              <a href="#" class="btn" onclick="changeType('1','${personal_user.uid}','${user.uid}')">回答</a>
              <a href="#" class="btn" onclick="changeType('2','${personal_user.uid}','${user.uid}')">提问</a>
              <a href="#" class="btn" onclick="changeType('3','${personal_user.uid}','${user.uid}')">分享</a>
              <a href="#" class="btn" onclick="changeType('4','${personal_user.uid}','${user.uid}')">话题</a>
              <a href="#" class="btn" onclick="changeType('5','${personal_user.uid}','${user.uid}')">好友</a>
            </div>
              <h3>
                	<c:if test="${personal_user.uid ne user.uid }">他</c:if>
                	<c:if test="${personal_user.uid eq user.uid }">我</c:if>
                	的<span id="type">回答</span>
              </h3>
               <hr>
            <div class="what" id="whatContent">
            
                <c:forEach items="${personal_answers }" var="list">
                	<c:set value="${list.user }" var="list_user"></c:set>
                	<c:set value="${list.question }" var="list_question"></c:set>
                	<c:set value="${list.answer }" var="list_answer"></c:set>
                	<div class="piece" id="piece${list_answer.answerId }">
                	  <h3><a href="${pageContext.request.contextPath}/question/${list_question.questionId}/detail">${list_question.questionInfo }</a></h3>
	                  <div style="color: grey"><span id="upvoteCountTop${list_answer.answerId }">${list_answer.upvoteCount}</span> 人赞同该回答</div>
	                     <p>
	                     ${list_answer.answerInfo }
	                    </p>
	                    <div>
	                    <c:choose>
	                    	<c:when test="${list_answer.isUpvoted eq 1 }">
	                    		<a class="media-object badge alert-danger" style="width:64px;"  onclick="upvote('${list_answer.answerId}')" id="upvoteBot${list_answer.answerId }">
			                      	${list_answer.upvoteCount }&nbsp;
			                      	<i class="fa fa-thumbs-down"></i>
	                     		</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a class="media-object badge alert-success" style="width:64px;"  onclick="upvote('${list_answer.answerId}')" id="upvoteBot${list_answer.answerId }">
				                    ${list_answer.upvoteCount }&nbsp;
				                    <i class="fa fa-thumbs-up"></i>
			                    </a>
	                    	</c:otherwise>
	                    </c:choose>
	                    <a>分享</a>
	                    <c:if test="${personal_user.uid ne user.uid }">
							<a data-toggle="modal" data-target="#report">举报</a>
						</c:if>
	                      
	                    </div>
	                </div>
                </c:forEach>
            </div>        

          </div>
          
          
          <div class="col-md-4">
                <div class="panel panel-default">
                	<div class="panel-heading text-center">
                		 <a style="display:inline-block;" >
			              		<div class="NumberBoard-item" style="width:42px;">关注了</div>
			              		<div class="NumberBoard-item" style="width:42px;">${personal_user.focusFriends }</div>
			            </a>
			              	
			            <a style="display:inline-block;margin-left:40px;">
			              		<div class="NumberBoard-item" style="width:42px;">关注者</div>
			              		<div class="NumberBoard-item" style="width:42px;">${personal_user.focusedFriends }</div>
			             </a>
                	</div>
                  <div class="panel-body text-center">
	                  <h1>无涯网wuya</h1>
	                  <p>书山有路勤为径,学海无涯苦作舟<br />
	                                          吾生也有涯，而知也无涯。       <br />
	                                          与别人分享你的知识。   <br />
	                      &copy; 2017 无涯
	                   </p>
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
    <jsp:include page="templet/showQuestion.jsp" />
     <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框2 意见反馈
    -->
     <jsp:include page="templet/showSuggestion.jsp" />
    
</body>
</html>
