	$(function() {
		path = "http://localhost/wuya";
		personalTypes = ["回答", "问题", "分享", "话题", "好友"];
		friendStatus = ["关注", "取关"];
	});

	function changeType(type,id,uid){
		console.debug("change type +++++++"+type);
		$.post(
				path+"/user/"+type+"/"+id+"/personalcontent",
				function(rs){
					console.debug("changeType type rs :"+rs);
					$("#type").text(personalTypes[parseInt(type)-1]);
					var str = "";
					if("empty"==rs){
						str ="查到结果为空";				
					}else{
						str =getStr(rs,type,uid)				
					}
					
					$("#whatContent").empty();
					$("#whatContent").append(str);
					
				
				}
			);
	}
	
	function getStr(rs,type,uid){
		/*
    	 * 1.回答
           2.提问
           3.分享
           4.创建的话题
           5.好友
    	 */
		console.debug("change type == rs==>>"+rs);
		console.debug("change type == type==>>"+type);
		console.debug("change type == uid==>>"+uid);
		var arrs = eval(rs);
		var str = "";
		if("1"==type){//回答
			for(var i=0;i<arrs.length;i++){
				var arr = arrs[i];
				var answer = eval(arr.answer);
				var user = eval(arr.user);
				var question = eval(arr.question);
				str +="<div class='piece' id='piece"+answer.answerId+"'>"
				str +="  <h3><a href='"+path+"/question/"+question.questionId+"/detail'>"+question.questionInfo+"</a></h3>";
				str +="    <div style='color: grey'><span id='upvoteCountTop"+answer.answerId+"'>"+answer.upvoteCount+"</span> 人赞同该回答</div>";
				str +="       <p>";
				str +=			answer.answerInfo;
				str +="       </p>";
				str +="      <div>";
				if(answer.isUpvoted== "1"){
					str +="        	<a class='media-object badge alert-danger' style='width:64px;'  onclick='upvote(\""+answer.answerId+"\")' id='upvoteBot"+answer.answerId+"'>";
					str +=           	answer.upvoteCount+"&nbsp;";
					str +="          	<i class='fa fa-thumbs-down'></i>";
					str +="     	</a>";
				}else{
					str +="       	<a class='media-object badge alert-success' style='width:64px;'  onclick='upvote(\""+answer.answerId+"\")' id='upvoteBot"+answer.answerId+"'>";
					str +=           	answer.upvoteCount+"&nbsp;";
					str +="             	<i class='fa fa-thumbs-up'></i>";
					str +="       	</a>";
				}
				str +="   <a>分享</a>";
				if(user.uid!=user.uid){
					str +="		<a data-toggle='modal' data-target='#report'  onclick='report(\""+answer.answerId+"\",\"1\")'>举报</a>";
				}else{
					str +="     &nbsp;来自我自己的回答";
				}
				str +="      </div>";
				str +="  </div>";
			}
		}else if("2"==type){//问题
			$("#type").text("提问");
			for(var i=0;i<arrs.length;i++){
				var arr = arrs[i];
				var topic = eval(arr.topic);
				var user = eval(arr.user);
				var question = eval(arr.question);
				str +="<div class='piece' id='piece"+question.questionId+"'>";
				str +=" <ul class='media-list'>";
				str +="  <li class='media'>";
				str +="    <a href='"+path+"/topic/"+topic.topicId+"/detail'  class='pull-left'><img class='img-rounded media-object' src='"+path+"/upload/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
				str +="    <div class='media-body'>";
				str +="      <h7 class='media-heading'>来自话题：<a href='"+path+"/topic/"+topic.topicId+"/detail'>"+topic.topicName+"</a></h7>";
				str +="      <h4 class='media-heading'>"+question.questionInfo+"</h4>";
				str +="      <h6 class='media-heading'>";
				str +="       <span>"+user.nickName+"</span>&nbsp;";
				str +="       <span>"+user.signature+"</span>";
				str +="      </h6>";
				str +="    </div>";
				str +="   </li>";
				str +=" </ul>";
				str +="</div>";
			}
		}else if("3"==type){//分享
			for(var i=0;i<arrs.length;i++){
				var arr = arrs[i];
				var type = arr.shareType;
				if(type=="1"){
					var answer  = eval(arr.answer);
					var user = eval(arr.user);
					var question = eval(arr.question);
					str +="<div class='piece' id='piece"+answer.answerId+"'>";
					str +="  <h4>分享了回答</h4>";
					str +=" <h3><a href='"+path+"/question/"+question.questionId+"/detail'>"+question.questionInfo+"</a></h3>";
					str +="   <img src='"+path+"/upload/headpic/"+user.headPic+"'  class='navbarimg-responsive img-thumbnail ' width='42px' height='42px'>";
					str +="   <span><a href='"+path+"/"+user.uid+"/personal'>"+user.nickName+"</a></span><br>";
					str +="   <span>"+user.signature+"</span>";
					str +="  <div style='color: grey'>"+answer.upvoteCount+" 人赞同该回答</div>";
					str +="    <p>";
					str +=        answer.answerInfo;
					str +="   </p>";
				    str +="    <div>";
				    if(answer.isUpvoted== "1"){
						str +="        	<a class='media-object badge alert-danger' style='width:64px;'  onclick='upvote('"+answer.answerId+"')'>";
						str +=              	answer.upvoteCount+"&nbsp;";
						str +="          	<i class='fa fa-thumbs-down'></i>";
						str +="     	</a>";
					}else{
						str +="       	<a class='media-object badge alert-success' style='width:64px;'  onclick='upvote('"+answer.answerId+"')'>";
						str +=           	answer.upvoteCount+"&nbsp;";
						str +="             	<i class='fa fa-thumbs-up'></i>";
						str +="       	</a>";
					}
					str +="  <a>分享</a>";
					if(user.uid!=user.uid){
						str +="		<a data-toggle='modal' data-target='#report' >举报</a>";
					}else{
						str +="     &nbsp;来自我自己的回答";
					}
					str +="  </div>";
					str +=" </div>";
				}else{
					var topic  = eval(arr.topic);
					var user = eval(arr.user);
					var question = eval(arr.question);
					str +="<div class='piece' id='piece"+question.answerId+"'>";
					str +="  <h4>分享了问题</h4>";
					str +="  <ul class='media-list'>";
				    str +="   <li class='media'>";
				    str +="    <a href='"+path+"/topic/"+topic.topicId+"/detail' class='pull-left'><img class='img-rounded media-object' src='"+path+"/upload/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
					str +="    <div class='media-body'>";
					str +="     <h7 class='media-heading'>来自话题：<a href='"+path+"/topic/"+topic.topicId+"/detail'>"+topic.topicName+"</a></h7>";
					str +="     <h4 class='media-heading'>"+question.questionInfo+"</h4>";
					str +="    <h6 class='media-heading'>";
					str +="      <span>我是一个大帅哥</span>&nbsp;";
					str +="      <span>个性签名</span>";
					str +="    </h6>";
					str +="  </div>";
					str +=" </li>";
					str +="  </ul>";
					str +="</div> ";
				}
			}
			
		}else if("4"==type){//话题
			for(var i=0;i<arrs.length;i++){
				var arr = arrs[i];
				var type = arr.topicType;
				if(type=="1"){
					var topic  = eval(arr.topic);
					var user = eval(arr.user);
					str +="<div class='piece' id='piece"+topic.topicId+"'>";
					str +="  <h4>关注了话题</h4>";
					str +="  <ul class='media-list'>";
					str +="    <li class='media'>";
					str +="    <a href='"+path+"/topic/"+topic.topicId+"/detail' class='pull-left'><img class='img-rounded media-object' src='"+path+"/upload/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
					str +=" <div class='media-body'>";
					str +="   <h7 class='media-heading'>话题：<a href='"+path+"/topic/"+topic.topicId+"/detail'>"+topic.topicName+"</a></h7>";
					str +="   <h6 class='media-heading'>";
					if(user.uid=="Cinyky"){
						str +="      <span>系统创建话题</span>&nbsp;";
					}else{
						str +="      <span>话题作者:"+user.nickName+"</span><br>";
						str +="      <span>创建时间"+topic.topicTime+"</span>";
					}
					str +="    </h6>";
					str +="  </div>";
					str +="  </li>";
					str +=" </ul>";
					str +=" </div>";
				}else{
					str +="<div class='piece' id='piece"+topic.topicId+"'>";
					str +="  <h4>创立了话题</h4>";
					str +="  <ul class='media-list'>";
					str +="    <li class='media'>";
					str +="    <a href='"+path+"/topic/"+topic.topicId+"/detail' class='pull-left'><img class='img-rounded media-object' src='"+path+"/upload/topicimg/"+topic.topicPic+"' height='42' width='42'></a>";
					str +="     <div class='media-body'>";
					str +="   <h7 class='media-heading'>话题：<a href='"+path+"/topic/"+topic.topicId+"/detail'>"+topic.topicName+"</a></h7>";
					str +="         <h6 class='media-heading'>";
					str +="         <span>话题作者:我自己</span>&nbsp";
	                str +="      <span>创建时间"+topic.topicTime+"</span>";
	                str +="    </h6>";
	    			str +="  </div>";
	    			str +="  </li>";
	    			str +=" </ul>";
	    		    str +=" </div>";
				}
			}
		}else if("5"==type){
/*			str +="<a href='' class='btn' style='color: orange;' onclick='toggleFriends("+1+")'>他关注的人</a>";
			str +="<a href='' class='btn' onclick='toggleFriends("+1+")'>关注他的人 </a>";*/
			for(var i=0;i<arrs.length;i++){
				var arr = arrs[i];
				var type = arr.friendType;
				var user = eval(arr.user);
					str+="<div class='piece' id='friend"+user.uid+"'>";
					str+="    <img src='"+path+"/upload/headpic/"+user.headPic+"' class='navbarimg-responsive img-thumbnail' width='64px' height='64px'>";
					str+="    <div style='display: inline-block;position: relative;top: 20px'>";
					str+="     <span>"+user.nickName+"</span><br>";
					str+="     <span>"+user.signature+"</span><br>";
					str+="      <span>"+user.answerNums+" 回答</span>&nbsp;<span>"+user.focusedFriends+" 关注者</span>";
					str+="   </div> ";
					str+="    <a class='btn btn-primary pull-right' style='margin-top: 30px' onclick='changeFriend(\""+user.uid+"\")' id='friendStatus"+user.uid+"'>";
					if(type="1"){
						str+="取关";
					}else{
						str+="关注";
					}
					str+="</a>";
					str+="  </div>";
			}
		}
		return str;
	}
	
	
	function changeFriend(anotherUid){
		$.post(
				path+"/user/"+anotherUid+"/friend",
				function(rs){
					console.debug("changeFriend anotherUid  :"+changeFriend);
					if("fail"==rs){
						wuya_messager("无涯好友系统","修改好友失败","error");
					}else{
						var str = "";
						if(rs=="1"){
							str = "关注";
							wuya_messager("无涯好友系统","取关成功","success");
						}else{
							str = "取关";
							wuya_messager("无涯好友系统","关注成功","success");
						}
						$("#friendStatus"+anotherUid).val(str);
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
	
	
	function wuya_messager(title,msg,type){
		$.messager.alert(title,msg,type);
		$(".messager-window").css("position","fixed");
		$(".window-shadow").css("position","fixed");
		$(".messager-window").css("top","300px");
		$(".window-shadow").css("top","300px");
	}




