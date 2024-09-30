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
<table border="1px" id="table1">
	<thead>
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>状态</th>
			<th>修改状态</th>
			<th>查看明细</th>
		</tr>
	</thead>
	<c:set var="total" value="0"/>
	<tbody>
		<c:forEach var="detail" items="${orderList }" varStatus="status">
			<tr data-id=${detail.orderId }>
				<td>${detail.orderId }</td>
				<td>${detail.createDtm }</td>
				<td>${detail.stateOut }</td>
				<td>
					<a href="OrderAction_updateState?state=0&orderId=${detail.orderId }">待审核</a>&nbsp;
					<a href="OrderAction_updateState?state=1&orderId=${detail.orderId }">已审核</a>&nbsp;
					<a href="OrderAction_updateState?state=2&orderId=${detail.orderId }">已付款</a>&nbsp;
					<a href="OrderAction_updateState?state=3&orderId=${detail.orderId }">已发货</a>
				</td>
				<td>
				    <form action="OrderAction_showTable2" method="post">
				        <input type="hidden" name="orderId" value="${detail.orderId }"/>
				        <input type="submit" value="查明细"/>
				    </form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
订单明细
<table border="1px" id="table2">
	<thead>
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>总金额</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="detail" items="${orderDetails}">
			<tr>
				<td>${detail.ID}</td>
				<td>${detail.shopInfo.shopName}</td>
				<td>${detail.shopInfo.price}</td>
				<td>${detail.quantity}</td>
				<td>${detail.totalPrice}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<span>订单总金额: ${totalAmount}</span>
</body>
</html>