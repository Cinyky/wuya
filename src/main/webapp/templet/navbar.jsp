<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
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
		                <a href="#">搜索<i class="fa fa-fw fa-eye"></i></a>
		              </li>
		              <li class="">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<img src="${pageContext.request.contextPath}/img/${user.headPic}" class="navbarimg-responsive img-rounded " width="20px" height="20px">
									${user.nickName}
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/user/${user.uid}/personal">我的主页</a></li>
									<li><a href="${pageContext.request.contextPath}/user/logout">注销</a></li>
								</ul>
					</li>
		            </ul>
		            <a class="btn btn-primary btn-sm navbar-btn" data-toggle="modal" data-target="#question">提问</a>
		          </div>
	        </div>
      </div>
</div>
