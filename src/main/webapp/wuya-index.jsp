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
<body>
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
    	描述：模态框2 举报
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
    <!-- 页脚改到右侧菜单栏
    	<footer class="section section-info">
	      <div class="container">
	        <div class="row">
	          <div class="col-sm-6">
	            <h1>无涯网wuya</h1>
	            <p>书山有路勤为径,学海无涯苦作舟。 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
	              <br>吾生也有涯，而知也无涯。&nbsp;
	              <br>与别人分享你的知识。</p>
	          </div>
	          <div class="col-sm-6">
	            <p class="text-info text-right">
	              <br>
	              <br>
	            </p>
	            <div class="row">
	              <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
	                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
	              </div>
	            </div>
	            <div class="row">
	              <div class="col-md-12 hidden-xs text-right">
	                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
	                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </footer>
    -->
</body>
</html>
