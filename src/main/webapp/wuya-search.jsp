<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/wuya-personal.js" ></script>
    <link rel="stylesheet" href="css/font-awesome.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/wuya-personal.css" />
    <title>personal</title>
  </head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" style="height: 50px;">
      <div class="container" >
        <div class="navbar-header">
          <a class="navbar-brand" contenteditable="true"><span>无涯wuya</span><i class="fa fa-fw fa-ship"></i></a>
        </div>
        <div class="form-group">
          <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="搜索你感兴趣的内容...">
              </div>
              <button type="submit" class="btn btn-default">
                <i class="fa fa-fw fa-lg fa-search"></i>
              </button>
            </form>
            <ul class="nav navbar-nav">
              <li class="active">
                <a href="#">首页<i class="fa fa-fw fa-home"></i></a>
              </li>
              <li class="">
                <a href="#">话题<i class="fa fa-fw fa-comments"></i></a>
              </li>
              <li class="">
                <a href="#">发现<i class="fa fa-fw fa-eye"></i></a>
              </li>
              <li class="">
                <a href="#">消息<i class="fa fa-bell fa-fw"></i><span class="badge">42</span></a>
              </li>
              <li class="">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="${pageContext.request.contextPath}/img/${user.headPic}" class="navbarimg-responsive img-rounded " width="20px" height="20px">
							${user.nickName}
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">我的主页</a></li>
							<li class="divider"></li>
							<li><a href="#">设置</a></li>
							<li class="divider"></li>
							<li><a href="#">注销</a></li>
						</ul>
			</li>
            </ul>
            <a class="btn btn-primary btn-sm navbar-btn" data-toggle="modal" data-target="#question">提问</a>
          </div>
        </div>
      </div>
    </div>
   
    
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
