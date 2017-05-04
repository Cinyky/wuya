$(function () {
		$("#userName").keyup(function(){
			var val =  $(this).val();
			console.debug("showValidate keyup :"+val);
		});
		//
		$("#showPwd").bind({
		     click: function(){
		     console.debug($("#showPwd").attr("checked"));
		      if($("#showPwd").attr("checked")){
		      	console.debug("隐藏");
		        $("#password").val($("#passwordShow").val());
		        $("#passwordShow").hide();
		        $("#password").show();
		        $("#showPwd").removeAttr("checked");
//		        $("#showPwdTxt").text("隐藏密码");
		      }else{
		      	console.debug("显示");
		        $("#passwordShow").val($("#password").val());
		        $("#password").hide();
		        $("#passwordShow").show();
		        	$("#showPwd").attr("checked","true");
//		        	$("#showPwdTxt").text("显示密码");
		      }
		     }
	    });
		
//		$("#loginSubmit").bind({
//		     click: function(){
//		    	 
//		     }
//	    });
//		
		
});


function changeImg(path){
		var img = document.getElementById("img");  
		img.src = path+"/verifycode/generateImg?date=" + new Date();;
	} 

function wuya_messager(title,msg,type){
	$.messager.alert(title,msg,type);
	$(".messager-window").css("position","fixed");
	$(".window-shadow").css("position","fixed");
	$(".messager-window").css("top","300px");
	$(".window-shadow").css("top","300px");
}