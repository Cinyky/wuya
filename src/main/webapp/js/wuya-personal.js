	$(function() {
		
		
		
	});

	function changeType(type){
		console.debug("change type +++++++"+type);
		$.post(
				"http://localhost:8080/wuya/answer/"+id+"/upvote",
				function(rs){
					console.debug("changeType type rs :"+rs);
					
				}
			);
	}




