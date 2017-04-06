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
    <title>personal-info</title>
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
              			<img src="img/headpic2.jpg" class="navbarimg-responsive img-thumbnail " width="80px" height="80px">
              		</div>
                  <a href="" class="btn btn-primary pull-right">返回个人主页</a>
              		<div class="personal-info" 
                       style="position: relative;left: 100px;top: -50px;margin-left: 10px">
                    <span class="nickname" 
                          style="font-size: 26px;font-weight: bolder;">
                          韦庆明
                    </span><br>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">职业:</div>
                    <span class="profession">全栈工程师</span> <a class="btn btn-primary">添加</a><a class="btn btn-primary">修改</a>
                    <input type="text" />
                    <a class="btn btn-primary">保存</a><a class="btn btn-primary">取消</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">性别:</div>
                    <span class="sex">男</span><a class="btn btn-primary">添加</a><a class="btn btn-primary">修改</a>
                    <input type="radio" value="1" name="sex" checked/>男
                    <input type="radio" value="0" name="sex"/>女
                    <a class="btn btn-primary">保存</a><a class="btn btn-primary">取消</a>
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">一句话介绍:</div>
                    <span class="sign">认真，你就赢了</span><a class="btn btn-primary">添加</a><a class="btn btn-primary">修改</a>
                    <input type="text" /><a class="btn btn-primary">保存</a><a class="btn btn-primary">取消</a>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
                    <div class="info-type" style="min-width: 100px;display: inline-block;">居住地:</div>
                     <span class="sign">认真，你就赢了</span> <a class="btn btn-primary">添加</a><a class="btn btn-primary">修改</a>
                    <input type="text" />
                    <a class="btn btn-primary">保存</a><a class="btn btn-primary">取消</a>
                  
                    <br>
                    <hr class="line" style="width: 500px;margin-left: 2px;"/>
                    
					<div class="info-type" style="min-width: 100px;display: inline-block;">个人简介:</div>
					<input type="text" /><a class="btn btn-primary">保存</a><a class="btn btn-primary">取消</a>
                    <a class="btn btn-primary">添加</a>
                    <a class="btn btn-primary">修改</a>
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
