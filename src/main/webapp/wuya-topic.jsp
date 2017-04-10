<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-topic.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-personal.css" />
    <title>topic</title>
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
          <div class="col-md-8">
          	<div class="panel panel-default">
          			<div class="panel-heading">
         				已关注的话题动态 <span class="pull-right">共关注${fn:length(myTopics)}个话题</span>
         			</div>
		              <div class="panel-body">
		              		<c:forEach items='${myTopics}' var='myTopic'>
		              		  <c:if test="${myTopic.topicId eq  topic.topicId}">
		              		 	 <a class="btn btn-primary active" style="margin:2px;border-radius:8px;" onclick="chooseTopic('${myTopic.topicId}')">${myTopic.topicName}</a>
		              		  </c:if>
		              		  <c:if test="${myTopic.topicId ne  topic.topicId}">
		              		  	<a class="btn btn-primary" style="margin:2px;border-radius:8px;" onclick="chooseTopic('${myTopic.topicId}')">${myTopic.topicName}</a>
		              		  </c:if>
							</c:forEach>
		              </div>
	        </div>
	        <div class="topic-bar" style="border-bottom:1px solid grey;">
         				 <a href="#" ><img class="img-rounded media-object" src="${pageContext.request.contextPath}/topicimg/${topic.topicPic}" height="42" width="42"></a>
         				 <span class="topic-name">${topic.topicName }</span> <a class="pull-right">热门排序</span><a class="pull-right">时间排序</span>
         	</div>
         	<div id="topicContent">
				<c:forEach items='${retList}' var='list'>
				 <c:set value='${list.user }' var='list_user'></c:set>
				 <c:set value='${list.answer }' var='list_answer'></c:set>
				 <c:set value='${list.question }' var='list_question'></c:set>
				 <div class="piece" id="piece${list_question.questionId }">
		            <ul class="media-list">
		              <li class="media">
		                <a href="#" class="pull-left"><img class="img-rounded media-object" src="${pageContext.request.contextPath}/topicimg/${topic.topicPic}" height="42" width="42"></a>
		                <div class="media-body">
		                  <button type="button" class="close pull-right ccc">×</button>
		                  <h4 class="media-heading">${list_question.questionInfo }</h4>
		                  <h6 class="media-heading">
		                    <span>${list_user.nickName }</span>&nbsp;：
		                    <span>${list_user.signature }</span>
		                  </h6>
		                  <p>
		                  	${list_answer.answerInfo }
		                  </p>
		                </div>
		              </li>
		              <li class="media">
		                <span class="pull-left">
		                  <a class="media-object badge alert-danger" style="width:64px;">${list_answer.upvoteCount }&nbsp;<i class="fa fa-thumbs-up"></i></a>
		                </span>
		               <div class="media-body">
		                	  <a>分享</a>
			                  <a class="shield" data-toggle="shield_tooltip" data-placement="top" title="不再显示在首页推荐中">屏蔽</a>
			                  <a class="" data-toggle="modal" data-target="#report">
								举报
							  </a>
		                </div>
		              </li>
		            </ul>
	            </div>  <!--推荐人体1结束-->
				</c:forEach>
          	</div>
          </div>
          
          <div class="col-md-4">
         		<div class="panel panel-default">
         			<div class="panel-heading">
         				<form class="navbar-form" role="search" style="display:inline-block;">
			              <div class="form-group">
			                <input type="text" class="form-control" placeholder="搜索你感兴趣的内容...">
			              </div>
			              <button type="submit" class="btn btn-default">
			                <i class="fa fa-fw fa-lg fa-search"></i>
			              </button>
			            </form>
			         </div>
         				
		              <div class="panel-body">
							来源：<span class="status">
								其他人关注  推荐
								<a onclick="changeTopics()">换一换</a>
							</span>			           
							<hr>
							<div id ="recommendTopics">
								<c:forEach items='${recommendTopics}' var='recTopics'>
									<div class="topic-item">
										<a href="#" ><img class="img-rounded media-object" src="${pageContext.request.contextPath}/topicimg/${recTopics.topicPic }" height="42" width="42"></a>
										<div style="display:inline-block;position:relative;top:10px;">
											<span>话题：${recTopics.topicName }</span><br>
											<span>关注人数</span><span id="focusNums${recTopics.topicId }">${recTopics.focusNums }</span>
										</div>
											<a class="btn btn-primary pull-right" style="position:relative;top:10px;" id="checkFocus${recTopics.topicId }" 
													onclick="changeFocus('${recTopics.topicId}')" >
											
												<c:if test="${recTopics.isFocused eq '2' }">
													关注
												</c:if>
												<c:if test="${recTopics.isFocused eq '1' }">
													取消关注
												</c:if>
											</a>
									
										
									</div>
								</c:forEach>
							</div>
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
