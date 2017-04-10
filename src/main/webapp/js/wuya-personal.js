	$(function() {
		
		
		
	});

	function changeType(type,id){
		console.debug("change type +++++++"+type);
		$.post(
				"http://localhost:8080/wuya/user/"+type+"/"+id+"/personalcontent",
				function(rs){
					console.debug("changeType type rs :"+rs);
					
				}
			);
	}




