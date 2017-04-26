$(function() {
	updateUserInfoTypes = ["headpic","signature","sex","profile","location","birth","all"];
	path = "http://localhost:8080/wuya";
	uploadurl = path+'/upload/headpic';
	$("#changeHeadPic").change(function(){
		var formData = new FormData();
		formData.append('file', $('#changeHeadPic')[0].files[0]);
		$.ajax({
		    url: uploadurl,
		    type: 'POST',
		    cache: false,
		    data: formData,
		    processData: false,
		    contentType: false
		}).done(function(res) {
			console.debug(res);
			$("#prePic").attr('src',uploadurl+"/"+res);
			$("input[name='update_headpic']").val(res);
		}).fail(function(res) {
			alert("上传失败")
		});
	});
});


function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}

function submitUserInfo(type,info){
	console.debug("submitUserInfo=======");
	var index = parseInt(type);
	if(index>6){
		return;
	}
	var method = updateUserInfoTypes[index];
	var updateurl = path+"/user/info/"+method+"/update";
	console.debug("saveUserInfo: type==>"+type+" index=>>"+index+" method==>"+method);
	console.debug("saveUserInfo: updateurl==>"+updateurl);

	var data ="";
	var alert_info = "";
	var dataIndex= "input[name='update_"+method+"']";
	if(index==2){
		dataIndex = "input[name='update_"+method+"']:checked";
	}
	console.debug()
	switch(index)
	{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		  data=$(dataIndex).val();
		  break;
		case 6:
			var alertArr=new Array();
			for(var i=0;i<6;i++){
				var method = updateUserInfoTypes[i];
				var dataIndex= "input[name='update_"+method+"']";
				if(index==2){
					dataIndex = "input[name='update_"+method+"']:checked";
				}
				var tmpval = $(dataIndex).val();
				if(tmpval==""){
					alertArr[i]=i;
					continue;
				}
					data += tmpval;
					if(i<5){
						data+="|";
					}
				
			}
			console.debug("saveUserInfo == data:++>"+data+" ==info:++>"+info);
			var length = alertArr.length;
			console.debug("alertArr == length:"+length);
			if(length>0){
				var alertInfo = "";
				for(var i=0;i<length;i++){
					alertInfo += updateUserInfoTypes[i];
					if(i<length){
						alertInfo +=","
					}
					
				}
				alert(alertInfo+" 不可为空");
				return;
			}
		  break;
		default:
		  break;
	}
	console.debug("saveUserInfo == data:++>"+data+" ==info:++>"+info);
	if(data==info) return;
	$.post(
			updateurl,
			{
				"info":data
			},
			function(rs){
				console.debug("rs==>"+rs);
				if("fail"==rs){
					alert("更新用户信息失败");
				}else{
//					updateUserInfoTypes = ["headpic","signature","sex","profile","location","birth","all"];
					var user = eval("("+rs+")");
					console.debug(user.nickName);
					var rsArrs = new Array(user.headPic,user.signature,user.sex,user.profile,user.location,user.location);
					for(var i=0;i<rsArrs.length;i++){
						console.debug(rsArrs[i]);
					}
					if(index==0){
						$("#myPic").attr('src',uploadurl+"/"+rsArrs[index]);
						$("#myHeadPic").attr('src',uploadurl+"/"+rsArrs[index]);
					}else if(index==2){
						var str ="男";
						if(rsArrs[index]==0){
							str="女"
						}
						$("#"+updateUserInfoTypes[index]+"_show").text(str);
					}else if(index==5){
						$("#"+updateUserInfoTypes[index]+"_show").text(data);
					}else{
						$("#"+updateUserInfoTypes[index]+"_show").text(rsArrs[index]);
					}
					
//					for(var i=0;i<6;i++){
//						var method = updateUserInfoTypes[i];
//						var dataIndex= "";
//						if(i==2){
//							dataIndex = "input[name='update_"+method+"']:checked";
//						}else{
//							if(i==0){
//								$("#myPic").attr('src',uploadurl+"/"+rsArrs[i]);
//								$("#myHeadPic").attr('src',uploadurl+"/"+rsArrs[i]);
//							}else{
//								dataIndex= "input[name='update_"+method+"']";
//								$(dataIndex).val(rsArrs[i]);
//								$(dataIndex).attr("placeholder",rsArrs[i]);
//							}
//						}
//					}
					
				}
				if(index>0){
					changeShow(index);
				}
				
			}
	);
}


function changeShow(pos){
	console.debug("====changeShow==="+pos);
	$("#change"+pos).toggle(100);
	$("#show"+pos).toggle();
}







