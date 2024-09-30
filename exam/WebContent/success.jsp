<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="ShopInfoAction_index">继续下一次购物订单信息</a><br/>
订单编号:${orderId}<br/>
创建时间:${timestamp }<br/>
请记住你本次的订单编号，以备查用关闭<br/>
</body>
</html>