  $(function(){
	  path = "http://localhost/wuya";
  });
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
						alert("取消点赞成功");
					}else{
						$("#upvoteBot"+id).removeClass("alert-success");
						$("#upvoteBot"+id).addClass("alert-danger");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoDown);
						alert("点赞成功");
					}
				}
			);
  }
  
  //加好友
	function changeFriend(anotherUid){
		console.debug(anotherUid);
		console.debug("关注");
		$.post(
				path+"/user/"+anotherUid+"/friend",
				function(rs){
					console.debug("changeFriend anotherUid  :"+anotherUid);
					if("fail"==rs){
						alert("失败");
					}else{
						console.debug("rs:"+rs);
						if(rs=="1"){
							$("#checkFriend"+anotherUid).text("关注");
						}else if(rs=="2"){
							$("#checkFriend"+anotherUid).text("取关");
						}
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
						alert("分享成功");
					}else{
						alert("分享失败");
					}
				}
			);
  }
  
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
						alert("举报成功");
						$("#reportInfo").val("");
						$('#report').modal('hide');
					}else{
						alert("举报失败");
					}
				}
			);
  }
  
  
  function getMyDate(str){
	  	console.debug("start trans "+str);
	    var oDate = new Date(str),  
	    oYear = oDate.getFullYear(),  
	    oMonth = oDate.getMonth()+1,  
	    oDay = oDate.getDate(),  
	    oHour = oDate.getHours(),  
	    oMin = oDate.getMinutes(),  
	    oSen = oDate.getSeconds(),  
	    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
	    console.debug(oDate);
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
					console.debug("rsrsrsrs:"+rs);
				}
			);
	}


     