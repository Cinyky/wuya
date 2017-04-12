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
    <title>无涯搜索</title>
  </head>
<body>
	<jsp:include page="templet/navbar.jsp" />
   
    <div class="section hottopic">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <h1 class="text-center">无涯搜索</h1>
            <form role="form">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="搜索你感兴趣的内容">
                  <span class="input-group-btn">
                    <a class="btn btn-success" type="submit">Go</a>
                  </span>
                </div>
              </div>
            </form>
            <div id="search_result">
            <c:if test="${search_rs ne 'noinfo' }">
				<c:if test="${not empty search_questions }">
					<h3>问题</h3>
					<c:forEach items="${search_questions}" var="list">
						<hr>
		                <div class="piece" id="piece1">
		                  <ul class="media-list">
		                    <li class="media">
		                      <a href="#" class="pull-left"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
		                      <div class="media-body">
		                        <h7 class="media-heading">来自话题：自然科学</h7>
		                        <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
		                        <h6 class="media-heading">
		                          <span>我是一个大帅哥</span>&nbsp;：
		                          <span>个性签名</span>
		                        </h6>
		                      </div>
		                    </li>
		                  </ul>
		                </div>
	                </c:forEach>
				</c:if>
            </c:if>
            	
               
               
               
                <h3>话题</h3>
                <div class="piece" id="piece1">
                  <h4>创立了话题</h4>
                  <ul class="media-list">
                    <li class="media">
                      <a href="#" class="pull-left"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
                      <div class="media-body">
                        <h7 class="media-heading">话题：自然科学</h7>
                        <h6 class="media-heading">
                          <span>话题作者:韦庆明</span>&nbsp;
                          <span>认真，你就赢了</span>
                        </h6>
                      </div>
                    </li>
                  </ul>
                </div> 
                
                
                <h3>回答</h3>
                <div class="piece" id="piece1">
                 <h3>学历究竟对于JAVA入行有多深的影响？</h3>
                  <img src="img/headpic2.jpg" class="navbarimg-responsive img-thumbnail " width="42px" height="42px">
                  <span>韦庆明</span><br>
                  <span>认真，你就赢了</span>
                  <div style="color: grey">25 人赞同该回答</div>
                     <p>
                      作为一名中专生，在软件编程行业工作6年经验的我，来答答这个问题吧。 中专时候的专业为Java软件编程与开发，课程有Java、也穿插了一些 .net，自认为已经非常努力的学习了，但是，实习出来工作，我发现我什么都没有学会，是真的，什么都没有学会！ 实习的时候，我发现我什么都不懂 我连在学校用的开发工具叫什么都不记得。 我不懂开发
                    </p>
                    <div>
                      <a class="media-object badge alert-danger" style="width:64px;">25&nbsp;<i class="fa fa-thumbs-up"></i></a>
                      <a>分享</a>
                      <a>收藏</a>
                      <a class="" data-toggle="modal" data-target="#report">举报</a>
                    </div>
                </div> 
                
                <h3>用户</h3>
                <div class="piece" id="piece1">
                     <img src="img/headpic3.jpg" class="navbarimg-responsive img-thumbnail " width="64px" height="64px">
                     <div style="display: inline-block;position: relative;top: 20px">
                       <span>神经猫</span><br>
                       <span>认真，你就赢了</span><br>
                       <span>6 回答</span>&nbsp;<span>165 关注者</span>
                     </div> 
                     
                     <a href="" class="btn btn-primary pull-right" style="margin-top: 30px">取关</a>
                </div>
                
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
          
        </div>
      </div>
    </div>
    
</body>
</html>
