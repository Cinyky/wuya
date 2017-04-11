	$(function() {
		
		
		
	});

	function changeType(type,id){
		console.debug("change type +++++++"+type);
		$.post(
				"http://localhost:8080/wuya/user/"+type+"/"+id+"/personalcontent",
				function(rs){
					console.debug("changeType type rs :"+rs);
					var str = getStr(rs,type);
				}
			);
	}
	
	function getStr(rs,type){
		/*
    	 * 1.提问
           2.回答
           3.分享
           4.创建的话题
           5.好友
    	 */
		var str = "";
		if("1"==type){
			
		}else if("2"==type){
			
		}else if("3"==type){
			
		}else if("4"==type){
			
		}else if("5"==type){
			
		}
	}




