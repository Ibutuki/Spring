<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>用户展示页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<div class="row clearfix">
<div class="col-md-12 column">
<div class="page-header">
<h1>
<small>书籍列表 —— 显示所有书籍</small>
</h1>
</div>
</div>
</div>
<div class="row">
<div class="col-md-4 column">
<a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddUser">新增</a>
</div>
<div class="col-md-8 column">
<form class="form-inline" action="${pageContext.request.contextPath}/user/queryUser" method="post" style="float: right">
<input type="text" name="queryUserName" class="form-control" placeholder="请输入要查
询的书籍">
<input type="submit" value="查询" class="btn btn-primary"/>
</form>
</div>
</div>
<div class="row clearfix">
<div class="col-md-12 column">
<table class="table table-hover table-striped">
<thead>
<tr>
<th>编号</th>
<th>姓名</th>
<th>密码</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${list}">
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.pwd}</td>
<td>
<a href="${pageContext.request.contextPath}/book/update?id=${user.id}">修
改</a> &nbsp;|&nbsp; <a href="${pageContext.request.contextPath}/book/del/${user.id}">删除</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</body>
</html>