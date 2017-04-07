<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="templet/necessary.jsp" />
    <script type="text/javascript" src="js/wuya-personal.js" ></script>
    <link rel="stylesheet" href="css/wuya-personal.css" />
    <title>personal</title>
  </head>
<body>
	<<jsp:include page="templet/navbar.jsp" />
   
    
    <div class="section hottopic">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center">无涯搜索</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-offset-3 col-md-6">
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
          </div>
        </div>
      </div>
    </div>
    
     <!--
    	作者：1079276272@qq.com
    	时间：2017-02-15
    	描述：fengmian
    -->
    <div class="section top table hottopic" >
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            qwe 
          </div>
          
          <div class="col-md-4">
          	asdaa 
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
