<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<html>
		<meta charset="UTF-8">
		<title>跳转中</title>
<body>
	<h1><span id="sp">5</span>s后跳转。。。<a href="wuya-index.html">立即跳转</a></h1>
	
	<script type="text/javascript"> 
		onload=function(){ 
			setInterval(go, 1000); 
		}; 
		var x=5; //利用了全局变量来执行 
		function go(){ 
			x--; 
			if(x>0){ 
				document.getElementById("sp").innerHTML=x; //每次设置的x的值都不一样了。 
			}else{ 
					location.href='wuya-index.html'; 
			} 
		} 
	</script> 
</body>
</html>
