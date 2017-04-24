
function showReport() {
	$('#report').modal('toggle');
}

function changeFocus(topicId){
	$.post(
			"http://localhost:8080/wuya/topic/"+topicId+"/focus",
			{
				"topicId":topicId
			},
			function(rs){
				console.debug("changeFocus rs :"+rs)
				var arr = rs.split("|");
				var method = arr[0];
				var count = arr[1];
				var str ="";
				if(method=="1"){//cunzai 
					str = "关注";
				}else{
					str = "取消关注";
				}
				$("#checkFocus"+topicId).html(str);
				$("#focusNums"+topicId).html(count);
			}
		);
}

//换话题 切换
function changeTopics(){
	$.getJSON(
			"http://localhost:8080/wuya/topic/recommend",
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
					str +="<a href='#' ><img class='img-rounded media-object' src='http://localhost:8080/wuya/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
					str +="	<div style='display:inline-block;position:relative;top:10px;'>";
					str +="		<span>话题："+topic.topicName+"</span><br>";
					str +="		<span>关注人数</span><span id='focusNums"+topic.topicId+"'>"+topic.focusNums+"</span>";
					str +="		</div>";
					str +="			<a class='btn btn-primary pull-right' style='position:relative;top:10px;' id='checkFocus"+topic.topicId+"'"; 
					str +="					onclick='changeFocus('${recTopics.topicId}')' >";
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