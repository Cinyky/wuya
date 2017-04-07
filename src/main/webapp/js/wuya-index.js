$(function() {
	initQuestionIndex();
	<!--提示框组件-- >
	$("[data-toggle='share_tooltip']").tooltip();
	$("[data-toggle='showAll_tooltip']").tooltip();
	$("[data-toggle='shield_tooltip']").tooltip();
	<!--屏幕滚动条组件-- >
//	num = 9;
	//滚动到页面底部时，自动加载更多  
	$(window).scroll(function() {
//		var scrollh = $(document).height(); //页面总高度
//		var scrollTop = $(document).scrollTop();//滚动条距离顶部
//		var viewH = window.innerHeight;//可视窗口大小
//		console.debug((viewH + scrollTop) == scrollh);
//		if((viewH + scrollTop) == scrollh) {
//			for(var i =1 ;i<=10;i++){
//				num += 1;
//				console.debug(num);
//				var str = "<div class='piece' id='piece"+(num)+"'>";
//				str	+="<ul class='media-list'>";
//				str	+="	<li class='media'>";
//				str	+="		<a href='#' class='pull-left'><img class='img-rounded media-object' src='http://localhost:8080/wuya/topic/topic_1.jpg' height='42' width='42'></a>";
//				str	+="		<div class='media-body'>";
//				str	+="			<button type='button' class='close pull-right' id='close"+num+"'>×</button>";
//				str	+="			<h7 class='media-heading'>来自话题：自然科学</h7>";
//				str	+="			<h4 class='media-heading'>实验做不出结果是一种怎样的体验</h4>";
//				str	+="			<h6 class='media-heading'>";
//				str	+="			<span>我是一个大帅哥</span>&nbsp;";
//				str	+="			<span>个性签名</span>";
//				str	+="			</h6>";
//				str	+="			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为一只生物科研，这是再正常不过的了。实验做不出来是很正常的事情，谁都有不会的时候，对吧，谁怕谁？";
//				str	+="				当一个人明白着一些的时候按时记得哈开始打哈卡仕达看卡收到货卡仕达卡还是的卡号多少卡号的卡号卡按时打卡hk...";
//				str	+="				<a data-toggle='showAll_tooltip' data-placement='bottom' title='点击查看详细'>显示全部</a>";
//				str	+="			</p>";
//				str	+="		</div>";
//				str	+="	</li>";
//				str	+=" <li class='media'>";
//				str	+="		<span class='pull-left'>";
//				str	+="   		<a class='media-object badge alert-danger' style='width:64px;'>5&nbsp;<i class='fa fa-thumbs-up'></i></a>";
//				str	+="  	</span>";
//				str	+="  	<div class='media-body'>";
//				str	+="  	  <a>分享</a>";
//				str	+="       <a>收藏</a>";
//				str	+="       <a class='shield' data-toggle='shield_tooltip' data-placement='top' title='不再显示在首页推荐中'>屏蔽</a>";
//				str	+="       <a class='' data-toggle='modal' data-target='#report'>";
//				str	+="			举报";
//				str	+="	  	  </a>";
//				str	+=" 	 </div>";
//				str	+=" </li>";
//				str	+="</ul>";
//				str	+="</div>";
//				str +="<script>$('#close"+num+"').click(function() {closePiece($(this));});</script>";
//				console.debug("第"+i+"次");
//			$('#wuya').append(str);
//			}
//			console.debug(scrollTop);
//			$(document).scrollTop(scrollTop);	
//			
//		}
	});
	<!--屏蔽组件-- >
	$('.close').click(function() {
		closePiece($(this));
	});
	$('.shield').click(function() {
		closePiece($(this));
	});
	
	//动态显示
	$('#questionInfo').keyup(function(){
		var info =  $(this).val().trim();
		$("#searchQuestion").empty();
		if(info!=""){
		showQuestion(info);
		}
	});
	
	$('#submitQuestion').click(function(){
		var info =  $('#questionInfo').val().trim();
		var topicId = $('#topicId').val();
		if(info!=""){
			submitQuestion(info,topicId);
		}else{
			alert("问题不可为空");
		}
	});
});

function showReport() {
	$('#report').modal('toggle');
}

function closePiece(piece) {
	var id = piece.closest('.piece').attr('id');
	console.debug(id);
	piece.closest('.media-list').fadeOut(1000);
	var str  = "<div class='undo'>此内容将不会在动态中再次显示 "
		str += "<a onclick='openPiece(\"";
		str += id;
		str += "\")'>撤销</a></div>";
	console.debug(str);
	piece.closest('.piece').append(str);
}

function openPiece(id) {
	console.debug("open before id ===>"+id);
	id ='#'+id;
	console.debug("open after id ===>"+id);
	$(id).children('.media-list').fadeIn(1000);
	$(id).children('.undo').remove();
}
function showQuestion(info){
	console.debug("function showQuestion info :"+info);
	$.post(
			"http://localhost:8080/wuya/question/ajax",
			{
				"questionInfo":info
			},
			function(rs){
				console.debug("ajax:"+rs);
				var str = "";
				if(rs=="empty"){
					$("#searchQuestion").append("<span>该问题还没有被提问！！<span>")
					return;
				}else{
					var questions = eval(rs);
					str +="<table class='table table-hover table-condensed table-responsive'>";
					str +="<thead>";
					str +="<td>";
					str +="问题详情";
					str +="</td>";
					str +="<td>";
					str +="提问时间";
					str +="</td>";
					str +="</thead>";
					str +="<tbody>";
					for(var i=0;i<questions.length;i++){
						var question = questions[i];
						str +="<tr>";
						str +=" <td>";
						str +="  <a target='_blank' href='http://localhost:8080/wuya/question/"+question.questionId+"/detail'>";
						str +=    question.questionInfo;
						str +="  </a>";
						str +=" </td>";
						str +=" <td>";
						str +=   getMyDate(question.questionTime);
						str +=" </td>";
						str +="</tr>";
					}
					str +="		</tbody>";
					str +="</table>";
				}
				$("#searchQuestion").append(str);
			}
		)
}

function initQuestionIndex(){
	console.debug("function initQuestionIndex ====");
	$.post(
			"http://localhost:8080/wuya/question/init/index",
			{
				"method":"1"
			},
			function(rs){
				console.debug("ajax:"+rs);
				var str = "";
				if(rs=="empty"){
					return;
				}else{
					var arrs = eval(rs);
					console.debug("empty=====");
					$('#wuya').empty();
					for(var i = 0;i<arrs.length;i++){
						console.debug("第"+i+"次");
						var arr = arrs[i];
						var user = eval(arr.user);
						var question = eval(arr.question);
						var answer = eval(arr.answer);
						var topic = eval(arr.topic);
						var str = getIndexStr(user,question,answer,topic);
						$('#wuya').append(str);
					}
					
				}
			}
		)
}

function getIndexStr(user,question,answer,topic){
	var str = "<div class='piece' id='piece"+question.questionId+"'>";
	str	+="<ul class='media-list'>";
	str	+="	<li class='media'>";
	if(topic==null){
		str	+="		<a href='#' class='pull-left'><img class='img-rounded media-object' src='http://localhost:8080/wuya/topic/topic_1.jpg' height='42' width='42'></a>";
	}else{
		str	+="		<a href='#' class='pull-left'><img class='img-rounded media-object' src='http://localhost:8080/wuya/topic/"+topic.topicPic+"' height='42' width='42'></a>";
	}
	str	+="		<div class='media-body'>";
	str	+="			<button type='button' class='close pull-right ccc' id='close"+question.questionId+"'>×</button>";
	if(topic==null){
		str	+="			<h7 class='media-heading'>来自话题：默认话题</h7>";
	}else{
		str	+="			<h7 class='media-heading'>"+topic.topicName+"</h7>";
	}
	str	+="			<h4 class='media-heading'>"+question.questionInfo+"</h4>";
	str	+="			<h6 class='media-heading'>";
	str	+="			<span>"+user.nickName+"</span>&nbsp;";
	str	+="			<span>"+user.signature+"</span>";
	str	+="			</h6>";
	str +="			<p>";
	if(answer==null){
		str += "还没有回答 赶集去回答吧！！";
	}else{
		console.debug("answer length:"+answer.answerInfo.length);
		if(answer.answerInfo.length>200){
			
		}else{
			str +=				answer.answerInfo;
		}
	}
//	str	+="			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为一只生物科研，这是再正常不过的了。实验做不出来是很正常的事情，谁都有不会的时候，对吧，谁怕谁？";
//	str	+="				当一个人明白着一些的时候按时记得哈开始打哈卡仕达看卡收到货卡仕达卡还是的卡号多少卡号的卡号卡按时打卡hk...";
//	str	+="				<a data-toggle='showAll_tooltip' data-placement='bottom' title='点击查看详细'>显示全部</a>";
	str	+="			</p>";
	str	+="		</div>";
	str	+="	</li>";
	str	+=" <li class='media'>";
	str	+="		<span class='pull-left'>";
	str	+="   		<a class='media-object badge alert-danger' style='width:64px;'>5&nbsp;<i class='fa fa-thumbs-up'></i></a>";
	str	+="  	</span>";
	str	+="  	<div class='media-body'>";
	str	+="  	  <a>分享</a>";
	str	+="       <a>收藏</a>";
	str	+="       <a class='shield' data-toggle='shield_tooltip' data-placement='top' title='不再显示在首页推荐中'>屏蔽</a>";
	str	+="       <a class='' data-toggle='modal' data-target='#report'>";
	str	+="			举报";
	str	+="	  	  </a>";
	str	+=" 	 </div>";
	str	+=" </li>";
	str	+="</ul>";
	str	+="</div>";
	str +="<script>$('#close"+question.questionId+"').click(function() {closePiece($(this));});</script>";
	return str;
}


function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime;  
};  
//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
} 

function submitQuestion(info,topicId){
	console.debug("function submitQuestion info :"+info+" topic："+topicId);
	$.post(
			"http://localhost:8080/wuya/question/add",
			{
				"questionInfo":info,
				"topicId"     :topicId
			},
			function(rs){
				console.debug("rsrsrsrs:"+rs);
			}
		);
}



