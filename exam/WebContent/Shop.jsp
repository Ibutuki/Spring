<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>

</head>
<body>
<center>
<form action="ShopInfoAction_queryOrderState" method="post">
        <label for="orderId">输入订单号：</label>
        <input type="text" id="orderId" name="orderId"><input type="submit" value="查询"><br><br>
	    <c:choose>    
	        <c:when test="${not empty state }">
	        	<p>${state }</p>
	        </c:when>
	   </c:choose>
</form>
<form action="ShopInfoAction_queryShop" method="post">
        <label for="shopName">输入关键字：</label>
        <input type="text" id="shopName" name="shopName"><br>
        <label for="descr">选择商品类别：</label>
        <select name="descr">
        	<option value="all">全部</option>
        	<option value="咖啡">咖啡</option>
        	<option value="快餐">快餐</option>
        </select>
        <input type="submit" value="查询">
</form>
	<div style="height:100%; width:100%;">
		<c:forEach var="shopInfo" items="${shopInfoList }">
			<div style="float:left; height:100px; width:100px;">
				名称：${shopInfo.shopName }<br/>
				现价：${shopInfo.price }<br/>
				历史价格：${shopInfo.oldPrice }<br/>
				分类：${shopInfo.descr }<br/>
				<a href="ShopInfoAction_intoCar?id=${shopInfo.id}">加入购物车</a>
			</div>
			<div style="float:left; height:100px; width:40px;"></div>
		</c:forEach>
	</div>
 </center>
</body>
</html>