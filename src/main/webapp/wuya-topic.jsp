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
         				已关注的话题动态 <span class="pull-right">共关注86个话题</span>
         			</div>
		              <div class="panel-body">
							<a class="btn btn-primary active" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
							<a class="btn btn-primary" style="margin:2px;border-radius:8px;">Mac</a>
		              </div>
	        </div>
	        <div class="topic-bar" style="border-bottom:1px solid grey;">
         				 <a href="#" ><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
         				 <span class="topic-name">Mac</span> <a class="pull-right">热门排序</span><a class="pull-right">时间排序</span>
         	</div>
    	    <div class="piece" id="piece1">
	            <ul class="media-list">
	              <li class="media">
	                <a href="#" class="pull-left"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
	                <div class="media-body">
	                  <button type="button" class="close pull-right">×</button>
	                  <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
	                  <h6 class="media-heading">
	                    <span>我是一个大帅哥</span>&nbsp;：
	                    <span>个性签名</span>
	                  </h6>
	                  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为一只生物科研，这是再正常不过的了。实验做不出来是很正常的事情，谁都有不会的时候，对吧，谁怕谁？
	                                                            当一个人明白着一些的时候按时记得哈开始打哈卡仕达看卡收到货卡仕达卡还是的卡号多少卡号的卡号卡按时打卡hk...
	                  </p>
	                </div>
	              </li>
	              <li class="media">
	                <span class="pull-left">
	                  <a class="media-object badge alert-danger" style="width:64px;">5&nbsp;<i class="fa fa-thumbs-up"></i></a>
	                </span>
	               <div class="media-body">
	                	  <a>分享</a>
		                  <a>收藏</a>
		                  <a class="shield" data-toggle="shield_tooltip" data-placement="top" title="不再显示在首页推荐中">屏蔽</a>
		                  <a class="" data-toggle="modal" data-target="#report">
							举报
						  </a>
	                </div>
	              </li>
	            </ul>
            </div>  <!--推荐人体1结束-->
            
            <!--
            	作者：1079276272@qq.com
            	时间：2017-02-20
            	描述：推荐问题2
            -->
            <div class="piece" id="piece2">
	            <ul class="media-list">
	              <li class="media">
	                <a class="pull-left" href="#"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
	                <div class="media-body">
	                  <button type="button" class="close pull-right">×</button>
	                  <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
	                  <h6 class="media-heading">
	                    <span>我是一个大帅哥</span>&nbsp;：
	                    <span>个性签名</span>
	                  </h6>
	                  <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
	                    ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
	                    tempus viverra turpis tempus viverra turpis ante sollicitudin commodo.
	                    Cras purus odio, vestibulum in vulputate at, ante sollicitudin commodo.
	                    Cras purus odio, vestibulum in vulputate at,...
	                    <a data-toggle="showAll_tooltip" data-placement="bottom" title="点击查看详细">显示全部</a>
	                  </p>
	                </div>
	              </li>
	              <li class="media">
	                <span class="pull-left">
	                  <a class="media-object badge alert-success" style="width:64px;" draggable="true">2K&nbsp;<i class="fa fa-thumbs-up"></i></a>
	                </span>
	               <div class="media-body">
	                	  <a data-toggle="share_tooltip" data-placement="top" title="点击申请转载权利">作者保留权利</a>
		                  <a>收藏</a>
		                  <a class="shield" data-toggle="shield_tooltip" data-placement="top" title="不再显示在首页推荐中">屏蔽</a>
		                  <a class="" data-toggle="modal" data-target="#report">
							举报
						  </a>
	                </div>
	              </li>
	            </ul>
            </div><!--推荐问题2结束-->
            <!--
            	作者：1079276272@qq.com
            	时间：2017-02-20
            	描述：推荐问题3 
            -->
            <div class="piece" id="piece3">
	            <ul class="media-list">
	              <li class="media">
	                <a href="#" class="pull-left"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
	                <div class="media-body">
	                	<button type="button" class="close pull-right">×</button>
	                  <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
	                  <h6 class="media-heading">
	                    <span>我是一个大帅哥</span>&nbsp;：
	                    <span>个性签名</span>
	                  </h6>
	                  <p></p>
	                  <div class="col-md-3">
	                    <img src="img/question.jpg" class="img-responsive img-rounded">
	                  </div>
	                  <div class="col-md-9">
	                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
	                      ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis
	                      dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies
	                      ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis
	                      dis parturient montes, nascetur ridiculus mus. Donec quam...
	                      <a data-toggle="showAll_tooltip" data-placement="bottom" title="点击查看详细">显示全部</a>
	                    </p>
	                  </div>
	                  <p></p>
	                </div>
	              </li>
	              <li class="media">
	                <span class="pull-left">
	                  <a class="media-object badge alert-danger" style="width:64px;">1w&nbsp;<i class="fa fa-thumbs-up"></i></a>
	                </span>
	                <div class="media-body">
	                	  <a>分享</a>
		                  <a>收藏</a>
		                  <a class="shield" data-toggle="shield_tooltip" data-placement="top" title="不再显示在首页推荐中">屏蔽</a>
		                  <a class="" data-toggle="modal" data-target="#report">
							举报
						  </a>
	                </div>
	              </li>
	            </ul>
            </div><!--推荐问题3-->
            
            <!--
              	作者：1079276272@qq.com
              	时间：2017-02-20
              	描述：推荐问题4
              -->
            <div class="piece" id="piece4">
	            <ul class="media-list">
	              <li class="media">
	                <a href="#" class="pull-left"><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
	                <div class="media-body">
	                  <button type="button" class="close pull-right">×</button>
	                  <h4 class="media-heading">实验做不出结果是一种怎样的体验</h4>
	                  <h6 class="media-heading">
	                    <span>我是一个大帅哥</span>&nbsp;：
	                    <span>个性签名</span>
	                  </h6>
	                  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为一只生物科研，这是再正常不过的了。实验做不出来是很正常的事情，谁都有不会的时候，对吧，谁怕谁？
	                                                            当一个人明白着一些的时候按时记得哈开始打哈卡仕达看卡收到货卡仕达卡还是的卡号多少卡号的卡号卡按时打卡hk...
	                    <a data-toggle="showAll_tooltip" data-placement="bottom" title="点击查看详细">显示全部</a>
	                  </p>
	                </div>
	              </li>
	              <li class="media">
	                <span class="pull-left">
	                  <a class="media-object badge alert-danger" style="width:64px;">5&nbsp;<i class="fa fa-thumbs-up"></i></a>
	                </span>
	               <div class="media-body">
	                	  <a>分享</a>
		                  <a>收藏</a>
		                  <a class="shield" data-toggle="shield_tooltip" data-placement="top" title="不再显示在首页推荐中">屏蔽</a>
		                  <a class="" data-toggle="modal" data-target="#report">
							举报
						  </a>
	                </div>
	              </li>
	            </ul>
            </div>  <!--推荐人体4结束-->
	        
	        
          	
          	
          	
          	
          	
          	
          	
          	
          	
          	
          	
          
          
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
								<a >换一换</a>
							</span>			           
							<hr>
							<div class="topic-item">
								<a href="#" ><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
								<div style="display:inline-block;position:relative;top:10px;">
									<span>话题：自然科学</span><br>
									<span>关注人数</span><span>111</span>
								</div>
								
								<a class="btn btn-primary pull-right" style="position:relative;top:10px;">关注</a>
							</div>
							
							<div>
								<a href="#" ><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
								<div style="display:inline-block;position:relative;top:10px;">
									<span>话题：自然科学</span><br>
									<span>关注人数</span><span>111</span>
								</div>
								
								<a class="btn btn-primary pull-right" style="position:relative;top:10px;">关注</a>
							</div>
							
							<div>
								<a href="#" ><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
								<div style="display:inline-block;position:relative;top:10px;">
									<span>话题：自然科学</span><br>
									<span>关注人数</span><span>111</span>
								</div>
								
								<a class="btn btn-primary pull-right" style="position:relative;top:10px;">关注</a>
							</div>
							
							<div>
								<a href="#" ><img class="img-rounded media-object" src="topic/topic_1.jpg" height="42" width="42"></a>
								<div style="display:inline-block;position:relative;top:10px;">
									<span>话题：自然科学</span><br>
									<span>关注人数</span><span>111</span>
								</div>
								
								<a class="btn btn-primary pull-right" style="position:relative;top:10px;">关注</a>
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
