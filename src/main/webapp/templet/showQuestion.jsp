<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<!-- show question modal -->
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
              <form class="form  text-center" role="search" action="${pageContext.request.contextPath}/question/add">
                <div class="form-group">
                  <input type="text" class="form-control" name="questionInfo" id="questionInfo" placeholder="输入你想询问的问题">
                 
                  <span class="pull-left">问题说明</span>
                  <div class="panel panel-default">
	                  <div class="panel-body"  id="searchQuestion" >
	                  </div>
                  
                  </div>
                </div>
                
                <div class="form-group">
                 <span>选择一个话题</span>
                 <select name="topicId" id="topicId">
					  <option value ="0">默认话题</option>
					  <option value ="1">科技</option>
					  <option value ="2">游戏</option>
					  <option value ="3">运动</option>
					  <option value ="4">美食</option>
					  <option value ="5">汽车</option>
					  <option value ="6">动漫</option>
					  <option value ="7">电影</option>
					  <option value ="8">科学</option>
					  <option value ="9">历史</option>
					  <option value ="10">旅游</option>
				 </select>
                </div>
                <!-- disabled="disabled " -->
                <button type="button" class="btn btn-lg btn-primary btn-block" id="submitQuestion">提问</button>
              </form>
          </div>
        </div>
      </div>
</div>