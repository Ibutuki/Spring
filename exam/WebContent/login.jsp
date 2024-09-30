<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script>
	function reloadImage(url){
		var img = document.getElementById("pic");
		img.src = url+"?" + Math.random();
	}
	function chk_image(){
		   var img = document.getElementById("pic");
		   img.src = "image.jsp?" + Math.random();
		}
</script>
</head>

<body>
	<h2>登录页面</h2>
	<form action="UserAction_login" method="post">
	    账号: <input type="text" id="username" name="userName"/><br/>
	    密码: <input type="password" id="password" name="usePassword"/><br/>
	    图片验证码: <input name="captcha" type="text" id="captcha"/><span id="notice3">${msg}</span><br/>
	    <img id="pic" border=1 src="image.jsp?,Math.random();" onclick="return chk_image();"><a href="javaScript:reloadImage('image.jsp');">点击刷新验证码</a><br/>
	    <input type="submit" value="登录">
	</form>
</body>
</html>