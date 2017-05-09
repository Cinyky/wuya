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