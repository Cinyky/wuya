<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>answer</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-answer.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-answer.css" />
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wangEditor.min.css">
</head>
<body onload="initAnswers('${question.questionId}','${user.uid }')">
	<jsp:include page="templet/navbar.jsp" />
    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：fengmian
    -->
    <div class="section top table hottopic" >
      <div class="container">
        <div class="row question" style="background-color:#ffe;">
          <div class="col-md-12">
                <a class="btn btn-primary">${question_topic.topicName }</a>
                  <h1>${question.questionInfo}</h1>
                  <div class="pull-right">
                  		<a class="btn btn-primary" onclick="share('${question.questionId}','2')">分享问题</a>
                  	    <a class="btn btn-primary" data-toggle='modal' data-target='#report' onclick="report('${question.questionId}','2')">举报问题</a>
                  		<a class="btn btn-primary" data-toggle="modal" data-target="#answer" >写回答</a>
                  </div>
              
          </div>
        </div>
        
        <div class="row answer" style="margin-top:10px;">
          <div class="col-md-8" id="answers">

          </div>
          
          <div class="col-md-4">
                <div class="panel panel-default">
                  <div class="panel-heading">
                  	关于作者
                  </div>
	              <div class="panel-body">
	              	<img src="${pageContext.request.contextPath}/upload/headpic/${question_user.headPic}" width="60px" height="60px"/>
	              	<div class="author-info" style="display:inline-block;">
	              		<span class="nickname">${question_user.nickName}</span><br/>
	              		<span class="sign">${question_user.signature }</span>
	              	</div>
	              	<hr/>
	              	<a style="display:inline-block;margin-left:60px;" >
	              		<div class="NumberBoard-item" style="width:42px;">回答</div>
	              		<div class="NumberBoard-item" style="width:42px;" id="answerNum">${question_user.answerNums }</div>
	              	</a>
	              	
	              	<a style="display:inline-block;margin-left:40px;">
	              		<div class="NumberBoard-item" style="width:42px;">关注者</div>
	              		<div class="NumberBoard-item" style="width:42px;" id="focusNum">${question_user.focusedFriends }</div>
	              	</a>
	              	<hr/>
	              	<c:if test="${question_user.uid ne user.uid }">
		              	<a class="btn btn-primary btn-block" onclick="changeFriend('${question_user.uid}')">
		              		关注他
		              	</a>
	              	</c:if>
	              </div>
                </div>
                
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
    <!--
    	作者：1079276272@qq.com
    	时间：2017-03-13
    	描述：模态框3 answer
    -->
    <div id="answer" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-提出你的疑惑</h4>
          </div>
    
          <div class="editor-container">
              <div id="answer-editor">
                  <p>请输入内容...</p>
              </div>
          </div>

           <div class="modal-footer">
            <a class="btn btn-primary" onclick="submitAnswer('${question.questionId}')" >提交</a>
            <a class="btn btn-primary" data-dismiss="modal">关闭</a>
          </div>
        </div>
      </div>
    </div>
    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框3 share
    -->
    <div class="fade modal" id="share">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-举报系统</h4>
          </div>
          <div class="modal-body">
                <h4>举报</h4>
                <input type="hidden" id='shareId' val=''/>
                <select id="shareType">
                	<option value="1">分享回答</option>
                	<option value="2">分享问题</option>
                </select>
          </div>
          <div class="modal-footer">
          	<a class="btn btn-primary" onclick="submitShare()">举报</a>
            <a class="btn btn-primary" data-dismiss="modal">关闭</a>
          </div>
        </div>
      </div>
    </div>
	
    
</body>
</html>