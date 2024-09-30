<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="emp">添加新员工信息</a>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>姓</th>
			<th>邮件</th>
			<th>性别</th>
			<th>部门</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.emps}" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender == 0 ? "female":"male" }</td>
				<td>${emp.department }</td>
				<td><a href="emp/${emp.id }" class="delete">删除</a>/<a href="emp/${emp.id }">更新</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action = "" method="POST">
		<input type="hidden" value="DELETE" name="_method">
	</form>
	<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script>
		$(function(){
			$(".delete").click(function(){
				$("form").attr("action",this.href);
				$("form").submit();
				return false;
			})
		})
	</script>
</body>
</html>