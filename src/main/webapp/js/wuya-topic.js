
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