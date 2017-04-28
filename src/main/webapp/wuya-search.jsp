<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-search.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-personal.css" />
    <title>无涯搜索</title>
  </head>
<body>
	<jsp:include page="templet/navbar.jsp" />
   
    <div class="section hottopic">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <h1 class="text-center">无涯搜索</h1>
            <form role="form" action="${pageContext.request.contextPath}/search/detail" method="POST">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" name="searchInfo" placeholder="搜索你感兴趣的内容">
                  <span class="input-group-btn">
                    <input type="submit" style="display:none;" id="submitSearch"/>
                    <label for="submitSearch"><a class="btn btn-success" type="submit">搜索</a></label>
                  </span>
                </div>
              </div>
            </form>
            <div id="search_result">
            <c:if test="${search_rs ne 'noinfo' }">
				<c:if test="${not empty search_questions }">
					<h3>问题</h3>
					<c:forEach items="${search_questions}" var="list">
						<c:set value="${list.user }" var="list_user"></c:set>
	                	<c:set value="${list.question }" var="list_question"></c:set>
	                	<c:set value="${list.topic }" var="list_topic"></c:set>
						<hr>
		                <div class="piece" id="piece${list_question.questionId }">
		                  <ul class="media-list">
		                    <li class="media">
		                      <a href="${pageContext.request.contextPath}/topic/${list_topic.topicId}/detail" class="pull-left">
		                      <img class="img-rounded media-object" src="${pageContext.request.contextPath}/upload/topicimg/${list_topic.topicPic}" height="42" width="42">
		                      </a>
		                      <div class="media-body">
		                        <h7 class="media-heading">来自话题：<a href="${pageContext.request.contextPath}/topic/${list_topic.topicId}/detail">${list_topic.topicName }</a></h7>
		                        <h4 class="media-heading"><a href="${pageContext.request.contextPath}/question/${list_question.questionId}/detail">${list.question.questionInfo }</a></h4>
		                        <h6 class="media-heading">
		                          <span><a href="${pageContext.request.contextPath}/user/${list_user.uid}/personal">${list_user.nickName }</a></span>&nbsp;：
		                          <span>${list_user.signature }</span>
		                        </h6>
		                      </div>
		                    </li>
		                  </ul>
		                </div>
	                </c:forEach>
				</c:if>
				
				<c:if test="${not empty search_users }">
               		 <h3>用户</h3>
               		 <c:forEach items="${search_users}" var="list">
	               		 <c:set value="${list.user }" var="list_user"></c:set>
		                 <div class="piece" id="piece${list_user.uid }">
		                     <a href="${pageContext.request.contextPath}/user/${list_user.uid }/personal">
		                     	<img src="${pageContext.request.contextPath}/upload/headpic/${list_user.headPic}" class="navbarimg-responsive img-thumbnail " width="64px" height="64px">
		                     </a>
		                     <div style="display: inline-block;position: relative;top: 20px">
		                       <span>${list_user.nickName }</span><br>
		                       <span>${list_user.signature }</span><br>
		                       <span>${list_user.answerNums }&nbsp; 回答</span>&nbsp;<span>${list_user.focusFriends }&nbsp; 关注者</span>
		                     </div> 
		                     <c:if test="${list_user.isFocused eq '1'}">
		                     		<a  class="btn btn-primary pull-right" style="margin-top: 30px" id="checkFriend${list_user.uid }" onclick="changeFriend('${list_user.uid}')">
		                     		取关
		                    		 </a>
		                     </c:if>
		                     <c:if test="${list_user.isFocused eq '2'}">
		                     	<a  class="btn btn-primary pull-right" style="margin-top: 30px" id="checkFriend${list_user.uid }" onclick="changeFriend('${list_user.uid}')">
		                     		关注
		                    	</a>
		                     </c:if>
		                </div>
               		 </c:forEach>
                
				</c:if>
				
				<c:if test="${not empty search_answers }">
					  <h3>回答</h3>
					   <c:forEach items="${search_answers}" var="list">
						 <c:set value="${list.user }" var="list_user"></c:set>
		                 <c:set value="${list.question }" var="list_question"></c:set>
		                 <c:set value="${list.answer }" var="list_answer"></c:set>
			                <div class="piece" id="piece${list_answer.answerId }">
			                  <h3>
			                  	<a href="${pageContext.request.contextPath}/question/${list_question.questionId}/detail">
			                  		${list_question.questionInfo }
			                  	</a>
			                  </h3>
			                  <img src="${pageContext.request.contextPath}/upload/headpic/${list_user.headPic}" class="navbarimg-responsive img-thumbnail " width="42px" height="42px">
			                  <span>${list_user.nickName }</span><br>
			                  <span>${list_user.signature }</span>
			                  <div style="color: grey">
			                  	<span id="upvoteCountTop${list_answer.answerId }">
			                  		${list_answer.upvoteCount } 
			                  	</span>
			                  	人赞同该回答
			                  </div>
			                  <p>
			                     	${list_answer.answerInfo } 
			                  </p>
			                  <div>
			                      <a class="media-object badge alert-danger" style="width:64px;" id="upvoteBot${list_answer.answerId }">	
				                      ${list_answer.upvoteCount } &nbsp;
				                      <i class="fa fa-thumbs-up" id="upvoteIco${list_answer.answerId }"></i>
			                      </a>
			                      <a onclick="share('${list_answer.answerId}','1')">分享</a>
			                      <a class="" data-toggle="modal" data-target="#report" onclick="report('${list_answer.answerId}','1')">举报</a>
			                  </div>
			               </div> 
					  </c:forEach>
		              
				</c:if>
				
				<c:if test="${not empty search_topics }">
					<h3>话题</h3>
					 <c:forEach items="${search_topics}" var="list">
					 	 <c:set value="${list.topic }" var="list_topic"></c:set>
					 	 <c:set value="${list.user }" var="list_user"></c:set>
						 <div class="piece" id="piece${list_topic.topicId }">
		                  <ul class="media-list">
		                    <li class="media">
		                      <a href="#" class="pull-left">
		                      	<img class="img-rounded media-object" src="${pageContext.request.contextPath}/upload/topicimg/${list_topic.topicPic }" height="42" width="42">
		                      </a>
		                      <div class="media-body">
		                        <h7 class="media-heading">话题：${list_topic.topicName }</h7>
		                        <h6 class="media-heading">
		                          <c:if test="${list_user eq 'Cinyky' }">
		                          	<span>话题作者:系统默认</span>&nbsp;
		                          </c:if>
		                           <c:if test="${list_user eq 'Cinyky' }">
		                          	<span>
		                          		话题作者:
		                          		<a href="${pageContext.request.contextPath}/user/${list_user,uid}/personal">
		                          			${list_user.nickName }
		                          		</a>
		                          	</span>&nbsp;
		                          <span>${list_user.signature }</span>
		                          </c:if>
		                          
		                        </h6>
		                      </div>
		                    </li>
		                  </ul>
		                </div> 
					 </c:forEach>
	                
				</c:if>
            </c:if>
            	
               
                
            </div>
          </div>
          
           <div class="col-md-4" style="padding-top: 30px;">
            <div class="panel panel-default">
              <div class="panel-body">
							<h1>无涯网wuya</h1>
				            <p>书山有路勤为径,学海无涯苦作舟<br />
				              	吾生也有涯，而知也无涯。       <br />
				             	 与别人分享你的知识。	  <br />
				             	 &copy; 2017 无涯
				             </p>
              </div>
            </div>
          </div>
          
          <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框1 question
	    -->
	    <jsp:include page="templet/showQuestion.jsp" />
	     <!--
	    	作者：1079276272@qq.com
	    	时间：2017-02-15
	    	描述：模态框2 report
	    -->
	    
	    <jsp:include page="templet/showReport.jsp" />
	          
        </div>
      </div>
    </div>
    
</body>
</html>
