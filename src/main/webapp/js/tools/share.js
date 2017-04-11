  //分享
  function share(id,shareType){
	  console.debug("+++++++share id==>>"+id);
	  console.debug("+++++++share shareType==>>"+shareType);
	  $.post(
				"http://localhost:8080/wuya/share/"+shareType+"/add",
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