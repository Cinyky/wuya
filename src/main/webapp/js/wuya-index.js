$(function() {
//	initQuestionIndex();
	<!--提示框组件-- >
	$("[data-toggle='share_tooltip']").tooltip();
	$("[data-toggle='showAll_tooltip']").tooltip();
	$("[data-toggle='shield_tooltip']").tooltip();
	<!--屏幕滚动条组件-- >
	//滚动到页面底部时，自动加载更多  
	$(window).scroll(function() {
		var scrollh = $(document).height(); //页面总高度
		var scrollTop = $(document).scrollTop();//滚动条距离顶部
		var viewH = window.innerHeight;//可视窗口大小
		console.debug((viewH + scrollTop) == scrollh);
		if((viewH + scrollTop) == scrollh) {
//			initQuestionIndex();
		}
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
			$('#questionInfo').val("");
		}else{
			wuya_messager('无涯提问','问题不可为空!','warn');
		}
	});
	
	$('#submitSuggestion').click(function(){
		var info =$('#suggestionInfo').val().trim();
		if(info.length>0){
			submitSuggestion(info);
		}else{
			wuya_messager('无涯意见反馈','问题不可为空!','warn');
		}
	})
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

function initQuestionIndex(myuid){
	mymyuid = myuid;
	console.debug("function initQuestionIndex ====");
	$.post(
			"http://localhost:8080/wuya/question/init/index",
			function(rs){
				console.debug("ajax:"+rs);
				var str = "";
				if(rs=="empty"){
					return;
				}else{
					var arrs = eval(rs);
					console.debug("empty=====");
					$('#wuya').empty();
					console.debug("共"+arrs.length+"个");
					for(var i = 0;i<arrs.length;i++){
						console.debug("第"+i+"次");
						var arr = arrs[i];
						var user = eval(arr.user);
						var question = eval(arr.question);
						var answer = eval(arr.answer);
						var topic = eval(arr.topic);
						var str = getIndexStr(user,question,answer,topic,myuid);
						$('#wuya').append(str);
					}
					
				}
			}
		)
}

function getIndexStr(user,question,answer,topic,myuid){
	var str = "<div class='piece' id='piece"+question.questionId+"'>";
	str	+="<ul class='media-list'>";
	str	+="	<li class='media'>";
	if(topic==null){
		str	+="		<a href='#' class='pull-left'><img class='img-rounded media-object' src='http://localhost:8080/wuya/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
	}else{
		str	+="		<a href='http://localhost:8080/wuya/topic/"+topic.topicId+"/detail' class='pull-left'><img class='img-rounded media-object' src='http://localhost:8080/wuya/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
	}
	str	+="		<div class='media-body'>";
	str	+="			<button type='button' class='close pull-right ccc' id='close"+question.questionId+"'>×</button>";
	if(topic==null){
		str	+="			<h7 class='media-heading'>来自话题：<a href='http://localhost:8080/wuya/topic/0/detail'>默认话题</a></h7>";
	}else{
		str	+="			<h7 class='media-heading'>来自话题：<a href='http://localhost:8080/wuya/topic/"+topic.topicId+"/detail'> "+topic.topicName+"</a></h7>";
	}
	str	+="			<a href='http://localhost:8080/wuya/question/"+question.questionId+"/detail'><h4 class='media-heading'>"+question.questionInfo+"</h4></a>";
	str	+="			<h6 class='media-heading'>";
	str	+="			<a href='http://localhost:8080/wuya/user/"+user.uid+"/personal'>"+user.nickName+"</a>&nbsp;";
	str	+="			<span>"+user.signature+"</span>";
	str	+="			</h6>";
	str +="			<p>";
	if(answer==null){
		str += "还没有回答,赶紧去回答吧！！";
	}else{
		console.debug("answer length:"+answer.answerInfo.length);
		
			str +=				answer.answerInfo;
		
	}
	str	+="			</p>";
	str	+="		</div>";
	str	+="	</li>";
	str	+=" <li class='media'>";
	str	+="		<span class='pull-left'>";
	/*str	+="   		<a class='media-object badge alert-danger' style='width:64px;'>"
	if(answer==null){
		str +=	"0";
	}else{
		str +=	answer.upvoteCount;
	}
	str += "&nbsp;<i class='fa fa-thumbs-up'></i></a>";*/
	if(answer!=null){
		if(answer.isUpvoted=="1"){
			str+="                 <a class='media-object badge alert-danger' id='upvoteBot"+answer.answerId+"' ";
		}else{
			str+="                 <a class='media-object badge alert-success' id='upvoteBot"+answer.answerId+"' ";
		}
		str+=		"style='width:64px;' onclick='upvote(\""+answer.answerId+"\")'>"+answer.upvoteCount;
		if(answer.isUpvoted=="1"){
			str+=					"&nbsp;<i class='fa fa-thumbs-down' id='upvoteIco"+answer.answerId+"'></i>";
		}else{
			str+=					"&nbsp;<i class='fa fa-thumbs-up' id='upvoteIco"+answer.answerId+"'></i>";
		}
		str+=		"</a>";
	
		
	
		str	+="  	</span>";
		str	+="  	<div class='media-body'>";
		str+="                 <a onclick='share(\""+answer.answerId+"\",\"1\")'>分享</a>";
		if(myuid==answer.uid){
			str +="<span>来自我自己的回答</span>"
		}else{
			str+="                 <a class='' data-toggle='modal' data-target='#report' onclick='report(\""+answer.answerId+"\",\"1\")'>举报</a>";
		}
		str	+=" 	 </div>";
		str	+=" </li>";
		str	+="</ul>";
		str	+="</div>";
	}
	str +="<script>$('#close"+question.questionId+"').click(function() {closePiece($(this));});</script>";
	return str;
}


function getMyDate(str){
	console.debug("=======date===="+str);
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

function submitQuestion(info,topicId){
	console.debug("function submitQuestion info :"+info+" topic："+topicId);
	$.post(
			"http://localhost:8080/wuya/question/add",
			{
				"questionInfo":info,
				"topicId"     :topicId
			},
			function(rs){
				console.debug("submoit question:"+rs);
				if(rs=="fail"){
					wuya_messager('无涯提问','提问失败!','error');
				}else{
					var arr = eval("("+rs+")");
					var user = eval(arr.user);
					var question = eval(arr.question);
					var answer = eval(arr.answer);
					var topic = eval(arr.topic);
					var str = getIndexStr(user,question,answer,topic,mymyuid);
					wuya_messager('无涯提问','提问成功!','info');
					$("#question").modal("hide");
					$('#wuya').prepend(str);
				}
			}
		);
}

function upvote(id){
	  console.debug("+++++++upvote id==>>"+id);
	  $.post(
				"http://localhost:8080/wuya/answer/"+id+"/upvote",
				{
					"answerId":id
				},
				function(rs){
					console.debug("upvote answer rs :"+rs);
					var strs = rs.split("|");
					var type = strs[0];
					var count = strs[1];
					$("#upvoteCountTop"+id).text(count);
					$("#upvoteBot"+id).text(count);
					var icoDown = "&nbsp;<i class='fa fa-thumbs-down' id='upvoteIco"+id+"'></i>";
					var icoUp = "&nbsp;<i class='fa fa-thumbs-up' id='upvoteIco"+id+"'></i>";
					if(type=="1"){
						$("#upvoteBot"+id).removeClass("alert-danger");
						$("#upvoteBot"+id).addClass("alert-success");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoUp);
						wuya_messager('无涯点赞','取消点赞成功!','info');
					}else{
						$("#upvoteBot"+id).removeClass("alert-success");
						$("#upvoteBot"+id).addClass("alert-danger");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoDown);
						wuya_messager('无涯点赞','点赞成功!','info');
					}
				}
			);
}

function submitSuggestion(info){
	console.debug("function submitSuggestion info :"+info);
	$.post(
			"http://localhost:8080/wuya/advice/"+info+"/add",
			function(rs){
				if(rs=="1"){
				
					wuya_messager('无涯意见反馈','反馈成功!','info');
					$("#suggestion").modal("hide");
				}else{
					wuya_messager('无涯意见反馈','反馈失败!','error');
				}
			}
	);
}


function wuya_messager(title,msg,type){
	$.messager.alert(title,msg,type);
	$(".messager-window").css("position","fixed");
	$(".window-shadow").css("position","fixed");
	$(".messager-window").css("top","300px");
	$(".window-shadow").css("top","300px");
}






