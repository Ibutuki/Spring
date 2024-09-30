<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<html>
	<head>
		<title>登录</title>

		<link rel="stylesheet" href="${path}/resources/css/main.css" type="text/css"></link>
	</head>

	<body>
		<form action="users_login" method="post">
			<center>${msg}</center>
			<table align="center">
				<caption>
					学员信息管理系统
				</caption>
				<tr>
					<td>
						姓名：
					</td>
					<td>
						<input type="text" id="userName" name="userName">
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" id="userPwd" name="pwd">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="登录">
						<a href="${path}/save.jsp">注册！</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

