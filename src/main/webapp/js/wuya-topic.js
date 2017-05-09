
$(function(){
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
	});
});
function report(id,reportType){
	  console.debug("+++++++report id==>>"+id);
	  console.debug("+++++++report reportType==>>"+reportType);
	  $("#reportId").val(id);
	  $("#reportType").val(reportType);
}

function submitReport(){
	  var reportId = $("#reportId").val();
	  var reportType = $("#reportType").val();
	  var reportInfo = $("#reportInfo").val().trim();
	  console.debug("+++submitReport()  reportId==>>"+reportId+"  reportType==>>"+reportType+"reportInfo==>>"+reportInfo);
	  $.post(
				"http://localhost/wuya/report/"+reportType+"/add",
				{
					"reportId" :reportId,
					"reportInfo":reportInfo
				},
				function(rs){
					console.debug("report  rs :"+rs);
					if(rs=="1"){
						wuya_messager("无涯举报系统","举报成功","success");
						$("#reportInfo").val("");
						$('#report').modal('hide');
					}else{
						wuya_messager("无涯举报系统","举报失败","error");
					}
				}
			);
}


function changeFocus(topicId){
	$.post(
			"http://localhost/wuya/topic/"+topicId+"/focus",
			{
				"topicId":topicId
			},
			function(rs){
				console.debug("changeFocus rs :"+rs)
				var arr = rs.split("|");
				var method = arr[0];
				var count = arr[1];
				var str ="";
				var msg =""
				if(method=="1"){//cunzai 
					str = "关注";
					msg = "取消关注";
				}else{
					str = "取消关注";
					msg = "关注";
				}
				$("#checkFocus"+topicId).html(str);
				$("#focusNums"+topicId).html(count);
				wuya_messager('无涯话题',msg+'成功!','info');
			}
		);
}

//换话题 切换
function changeTopics(){
	$.getJSON(
			"http://localhost/wuya/topic/recommend",
			function(rs){
				console.debug("changeFocus rs :"+rs);
//				var arr = eval("("+rs+")");
//				console.debug(rs.lenth);
//				console.debug(arr.lenth);
				$("#recommendTopics").empty();
				for(var i=0;i<rs.length;i++){
					var topic = rs[i];
					var str = "";
					str +="<div class='topic-item'>";
					str +="<a href='#' ><img class='img-rounded media-object' src='http://localhost/wuya/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
					str +="	<div style='display:inline-block;position:relative;top:10px;'>";
					str +="		<span>话题："+topic.topicName+"</span><br>";
					str +="		<span>关注人数</span><span id='focusNums"+topic.topicId+"'>"+topic.focusNums+"</span>";
					str +="		</div>";
					str +="			<a class='btn btn-primary pull-right' style='position:relative;top:10px;' id='checkFocus"+topic.topicId+"'"; 
					str +="					onclick='changeFocus('"+topic.topicId+"')' >";
					if(topic.isFocused=="2"){
						str +="				关注";
					}else {
						str +="				取消关注";
					}
					str +="		</a>";
					str +="	</div>";
					$("#recommendTopics").append(str);
				}
			}
		);
}


function upvote(id){
	  console.debug("+++++++upvote id==>>"+id);
	  $.post(
				"http://localhost/wuya/answer/"+id+"/upvote",
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
						wuya_messager("无涯点赞系统","取消点赞成功","info");
					}else{
						$("#upvoteBot"+id).removeClass("alert-success");
						$("#upvoteBot"+id).addClass("alert-danger");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoDown);
						wuya_messager("无涯点赞系统","点赞成功","info");
					}
				}
			);
}


//分享
function share(id,shareType){
	  console.debug("+++++++share id==>>"+id);
	  console.debug("+++++++share shareType==>>"+shareType);
	  $.post(
				"http://localhost/wuya/share/"+shareType+"/add",
				{
					"shareId" :id
				},
				function(rs){
					console.debug("report  rs :"+rs);
					if(rs=="1"){
						wuya_messager("无涯点赞系统","分享成功","info");
					}else{
						wuya_messager("无涯点赞系统","分享失败","info");
					}
				}
			);
}

function showQuestion(info){
	console.debug("function showQuestion info :"+info);
	$.post(
			"http://localhost/wuya/question/ajax",
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
						str +="  <a target='_blank' href='http://localhost/wuya/question/"+question.questionId+"/detail'>";
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
			"http://localhost/wuya/question/add",
			{
				"questionInfo":info,
				"topicId"     :topicId
			},
			function(rs){
				console.debug("submoit question:"+rs);
				if(rs=="fail"){
					wuya_messager('无涯提问','提问失败!','error');
				}else{
					var arrs = eval("("+rs+")");
					var question = arrs.question;
					$("#question").modal("hide");
					location.href="http://localhost/wuya/question/"+question.questionId+"/detail";
				}
			}
		);
}

function submitSuggestion(info){
	console.debug("function submitSuggestion info :"+info);
	$.post(
			"http://localhost/wuya/advice/"+info+"/add",
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

function getMyDate(str){
	str = parseInt(str);
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

function wuya_messager(title,msg,type){
	$.messager.alert(title,msg,type);
	$(".messager-window").css("position","fixed");
	$(".window-shadow").css("position","fixed");
	$(".messager-window").css("top","300px");
	$(".window-shadow").css("top","300px");
}