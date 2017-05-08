	$(function () {
		path = "http://localhost:8080/wuya";
	});
	
	function handle(uid,nickName,banTime){
		console.debug("---------------banTime:"+banTime+"type:"+$.type(banTime));
		$("#nickName").text(nickName);
		var state = "正常";
		var now = new Date();
		var user = new Date(parseInt(banTime));
		console.debug("now ====>"+now+"user =>>>>"+user);
		 $("#handleUser").unbind("click");
		if(now > user){		//正常状态
			$("#showdays").show();
			$("#handleUser").text("封号");
			$("#handleUser").click(function(){
				console.debug("click ban "+uid);
				banUser(uid);
			});
		}else{
			console.debug("---------------banTime:"+banTime+"type:"+$.type(banTime));
			state = "封号至"+getMyDate(parseInt(banTime));
			$("#showdays").hide();
			$("#handleUser").text("解禁");
			$("#handleUser").click(function(){
				console.debug("click ban "+uid);
				cancelUser(uid);
			})
		}
		$("#state").text(state);
		$("#ban").modal("show");
	}
	
	function getMyDate(str){
		console.debug("=======date===="+str);
	    var oDate = new Date(str),  
	    oYear = oDate.getFullYear(),  
	    oMonth = oDate.getMonth()+1,  
	    oDay = oDate.getDate(),  
	    oHour = oDate.getHours(),  
	    oMin = oDate.getMinutes(),  
	    oSen = oDate.getSeconds(),  
	    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin);//最后拼接时间  
	    return oTime;  
	};  
	//补0操作  
	function getzf(num){  
	    if(parseInt(num) < 10){  
	        num = '0'+num;  
	    }  
	    return num;  
	} 

	function banUser(uid){
		console.debug("ban User uid ====>"+uid);
		var days = $('input:radio[name="days"]:checked').val();
		console.debug("banUser   ==>"+days);
		var banurl = path + "/admin/user/"+uid+"/"+days+"/ban";
		$.post(
				banurl,
				function(rs){
					console.debug("banuser rs:"+rs);
					if(rs.indexOf("error")>0){
						console.debug("error index+++>"+rs.indexOf("error"));
						var resultArr = rs.split("|");
						var result = resultArr[0];
						var info = resultArr[1];
						wuya_messager("无涯封号系统",info,"error");
						return;
					}else{
						var user = eval("("+rs+")");
						var uid = user.uid;
						var nickName = user.nickName;
						var banTime = user.banTime;
						console.debug("success uid==>"+user.uid+"nickName==>"+user.nickName+"banTime:"+banTime);
						var alertInfo = nickName+" 封号成功，封号至"+ getMyDate(banTime);
						$("#handle"+uid).unbind("click");
						$("#handle"+uid).click(
								function(){
									handle(uid,nickName,banTime)
								}
						);
						wuya_messager("无涯封号系统",alertInfo,"info");
						$("#ban").modal("hide");
						return;
					}
				}
		);
	} 
	
	
	function cancelUser(uid){
		console.debug("ban User uid ====>"+uid);
		var banurl = path + "/admin/user/"+uid+"/cancel/ban";
		$.post(
				banurl,
				function(rs){
					console.debug("cancelUser rs:"+rs);
					if(rs.indexOf("error")>0){
						console.debug("error index+++>"+rs.indexOf("error"));
						var resultArr = rs.split("|");
						var result = resultArr[0];
						var info = resultArr[1];
						wuya_messager("无涯封号系统",info,"error");
						return;
					}else{
						var user = eval("("+rs+")");
						var uid = user.uid;
						var nickName = user.nickName;
						var banTime = user.banTime;
						console.debug("success uid==>"+user.uid+"nickName==>"+user.nickName+"banTime:"+banTime);
						var alertInfo = nickName+" 解禁成功";
						$("#handle"+uid).unbind("click");
						$("#handle"+uid).click(
								function(){
									handle(uid,nickName,banTime)
								}
						);
						wuya_messager("无涯封号系统",alertInfo,"info");
						$("#ban").modal("hide");
						return;
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