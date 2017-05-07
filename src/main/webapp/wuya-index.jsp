<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wuya-index.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wuya-index.css" />
    <title>${nickname }的首页</title>
  </head>
<body onload="initQuestionIndex('${user.uid}')">
    <jsp:include page="templet/navbar.jsp" />
    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：推荐问题信息
    -->
    <div class="section top table hottopic" >
      <div class="container">
        <div class="row">
          <div class="col-md-8" id="wuya">
          	<!--
              	作者：1079276272@qq.com
              	时间：2017-02-20
              	描述：推荐问题1
              -->
           
            <!--
            	......
            	在这里append查询到的问题
            	
            -->
          </div>
          
          <!--
          	作者：1079276272@qq.com
          	时间：2017-02-20
          	描述：右侧菜单栏
          -->
          <div class="col-md-4" style="padding-top: 30px;">
           <!--  <div class="panel panel-default">
              <div class="panel-body">
                <table class="table table-hover table-condensed table-responsive">
					<tbody>
						<tr>
							<td><i class="fa fa-fw -square-o fa-bookmark"></i>我收藏的问题</td>
						</tr>
						<tr>
							<td><i class="fa fa-fw fa-check-square-o"></i>我关注的话题</td>
						</tr>
						<tr>
							<td><i class="fa fa-fw fa-folder"></i>我回答的问题</td>
						</tr>
					</tbody>
				</table>
              </div>
            </div> -->
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
    	时间：2017-02-20
    	描述：加载动画
    -->
    <div id="loading" style="position:fixed;bottom:0;left:0;width:80%;line-height:20px;font-size:16px;color:#fff;text-align:center;">
		<img src="${pageContext.request.contextPath}/images/waiting.gif" width="20px" height="20px"/>
	</div>  

    <!--暂时不要分页
	    <div class="section">
	      <div class="container">
	        <div class="row">
	          <div class="col-md-8 text-center">
	            <ul class="pagination">
	              <li>
	                <a href="#">Prev</a>
	              </li>
	              <li>
	                <a href="#">1</a>
	              </li>
	              <li>
	                <a href="#">2</a>
	              </li>
	              <li>
	                <a href="#">3</a>
	              </li>
	              <li>
	                <a href="#">...</a>
	              </li>
	              <li>
	                <a href="#">8</a>
	              </li>
	              <li>
	                <a href="#">9</a>
	              </li>
	              <li>
	                <a href="#">10</a>
	              </li>
	              <li>
	                <a href="#">Next</a>
	              </li>
	            </ul>
	          </div>
	        </div>
	      </div>
	    </div>
    -->
    
    <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框1 提问
    -->
    <jsp:include page="templet/showQuestion.jsp" />
    
      <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：模态框2 report
    -->
    <jsp:include page="templet/showReport.jsp" />
    <jsp:include page="templet/showSuggestion.jsp" />
</body>
</html>
