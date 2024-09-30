<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="CarAction_update" method="post">
	<input type="hidden" name="orderId" value="${orderId}">
	购买数量<input type="text" name="quantity" >
	<input type="submit">
</form>
</body>
</html>