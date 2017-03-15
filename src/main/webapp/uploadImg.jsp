<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/wangEditor.js"></script>
    <script type="text/javascript" src="js/wuya-answer.js" ></script>
    <link rel="stylesheet" href="css/font-awesome.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/wuya-answer.css" />
     <link rel="stylesheet" type="text/css" href="css/wangEditor.min.css">
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
							<img src="img/headpic.jpg" class="navbarimg-responsive img-rounded " width="20px" height="20px">
							你干嘛
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
        <div class="row question" style="background-color:#ffe;">
          <div class="col-md-12">
                <a class="btn btn-primary">php</a>
                  <h1>php程序员2017年就业前景如何</h1>
                  <p>2016年也就是今年培训机构出来的同学太多了，那么多新手对就业的竞争程度是否会产生很大的影响呢。互联网发展的程序员红利还能坚持多久？</p>
                  <div class="pull-right">
                  		<a class="btn btn-primary">分享问题</a>
                  	    <a class="btn btn-primary">收藏问题</a>
                  		<a class="btn btn-primary" data-toggle="modal" data-target="#answer" >写回答</a>
                  </div>
              
          </div>
        </div>
        
        <div class="row answer" style="margin-top:10px;">
          <div class="col-md-8">
          		<div class="answer" id="answer1">
		                <div class="panel panel-default">
			                  <div class="panel-heading">
			                  	<img src="img/headpic6.jpg" width="60px" height="60px"/>
				              	<div class="author-info" style="display:inline-block;">
				              		<span class="nickname">Dean.Lee</span><br/>
				              		<span class="sign">过不去的坎永远只是暂时的...</span>
				              	</div>
				              	<div style="color: grey">25 人赞同该回答</div>
			                  </div>
				              <div class="panel-body">
					               <p class="answer-info">
					               		我以前当过两年的培训老师，几百号人中现在依然从事编程的已经不足三层了，这并非是我教的不好，而是这行业并不是所有人都可以做的。这不是歧视，作为一个成年人最关键的就是要找到自己的定位。被培训班忽悠后草率进来的人，肯定不会有深爱编程的自学者混的好。我面试过也带过很多三年经验内的技术员，我不是老板不能控制工资，我只能说跟着我，我会给你大量学习时间和历练机会，直到会了全栈、懂了架构，再去谋求更高档位。然而任我苦口婆心也没卵用，可能只是为了哪怕多500块工资，他们也会毅然决然选择跳槽。凡事都有起伏波动，有低潮自然也会迎来高潮。技术在日新月异，只有那些深爱编程的人，才会不断完善自我，走到最后。
					               </p>
					               <hr>
					               <span class="answer-date">发布于 昨天 14:33</span>
					               <div>
					                      <a class="media-object badge alert-danger" style="width:64px;">25&nbsp;<i class="fa fa-thumbs-up"></i></a>
					                      <a>分享</a>
					                      <a>收藏</a>
					                      <a class="" data-toggle="modal" data-target="#report">举报</a>
				                    </div>
				              	
				              </div>
		                </div>
                </div>
                
                <div class="answer" id="answer2">
		                <div class="panel panel-default">
		                  <div class="panel-heading">
		                  	<img src="img/headpic7.jpg" width="60px" height="60px"/>
			              	<div class="author-info" style="display:inline-block;">
			              		<span class="nickname">老猫</span><br/>
			              		<span class="sign">...</span>
			              	</div>
			              	<div style="color: grey">12 人赞同该回答</div>
		                  </div>
			              <div class="panel-body">
			               <p class="answer-info">
								
          		
          	<p>
          	<img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/wabi_thumb.gif"></p><p><br></p>其实咱从另一个维度看——市场，本人亦是六年PHP ，并且在三线！要问我工作这么多年有什么感想，我只能说：无奈！复制粘贴手：深有感触，每个程序员不是为挣钱就是为学东西，怎奈何，上边要求要快，赶紧做出来缴上去哪有鬼时间给你研究，要研究滚回去研究（针对小公司，外包公司之类！），快点做好上头还觉得你牛逼，慢了你就是菜B。基本功扎实：鸟，自己慢慢熬底层文档吧，熬出来再说，为什么？去大公司，你底层咋样？不熟？滚！去小公司，你会做那个那样的网站吗？这个类型的网站也会？牛，明天来上班！……在生存面前，你没得选择，事实证明这个阶段的技术员基本功好，不去背点高大上的技术名词，研究几个高大上的开源站！反而更容易拿offer !算法高手：唉！与基本功何异？全栈：这你可就问对头了，基本功一般的，算法没玩过的，大并发没斗过的，再不会点前端、不会点切图、不会点基本服务器搭建，吃啥？出路：上面几点看到没，一句话：自己努力吧，除了自己谁也帮不了你！别指望队友，更别指望上头，别指责行业，别抱怨环境，更别去迷茫，因为能帮你的只有自己！有时候，我把自己想成一个公司，日积寸功，月有所进！………………如果真迷茫了，别急，还有一线希望：深吸一口气，眼神要萎靡，仰望45度角，爆发出尖叫："PHP是最好的语言！！！"最后，就业环境，这个要分层说，分老手、熟手、新手，为什么，我当面试官也有两三年经验了，只能说：新手不想要！熟手看看有没有合适他的项目他能做，老手……直接喊兄弟！！！！这就是各层的就业前景了！
			               </p>
			               <hr>
			               <span class="answer-date">发布于 昨天 14:33</span>
			               <div>
		                      <a class="media-object badge alert-danger" style="width:64px;">5&nbsp;<i class="fa fa-thumbs-up"></i></a>
		                      <a>分享</a>
		                      <a>收藏</a>
		                      <a class="" data-toggle="modal" data-target="#report">举报</a>
		                    </div>
			              	
			              </div>
		                </div>
                </div>





                <!--editor-->
                   <!--<div  id="answer-editor" >
                   </div>-->
          </div>
          
          
          
          
          <div class="col-md-4">
                <div class="panel panel-default">
                  <div class="panel-heading">
                  	关于作者
                  </div>
	              <div class="panel-body">
	              	<img src="img/headpic6.jpg" width="60px" height="60px"/>
	              	<div class="author-info" style="display:inline-block;">
	              		<span class="nickname">Dean.Lee</span><br/>
	              		<span class="sign">过不去的坎永远只是暂时的...</span>
	              	</div>
	              	<hr/>
	              	<a style="display:inline-block;margin-left:60px;" >
	              		<div class="NumberBoard-item" style="width:42px;">回答</div>
	              		<div class="NumberBoard-item" style="width:42px;">213</div>
	              	</a>
	              	
	              	<a style="display:inline-block;margin-left:40px;">
	              		<div class="NumberBoard-item" style="width:42px;">关注者</div>
	              		<div class="NumberBoard-item" style="width:42px;">145</div>
	              	</a>
	              	<hr/>
	              	<a class="btn btn-primary btn-block">关注他</a>
	              	
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
	<!--
    	作者：1079276272@qq.com
    	时间：2017-03-13
    	描述：
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
            <a class="btn btn-primary" data-dismiss="modal">关闭</a>
          </div>

        </div>
      </div>
    </div>
    
</body>
</html>