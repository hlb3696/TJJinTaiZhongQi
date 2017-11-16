<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>

<title>天津金泰项目</title>

</head>
<body>

	<h1>我是主页面</h1>
	
	<button id="btn">数据上传</button>
	
	<!-- <button id="loginBtn">登陆测试</button> -->

</body>
<script type="text/javascript">
$(function(){
	
	$("#btn").click(function(){
		$.post("/uploadData",function(data){
			alert(data);
		});
	});
	
	$("#loginBtn").click(function(){
		$.post("/httpUrl",function(data){
			//alert(data);
		});
	});
	
	
});
</script>

</html>