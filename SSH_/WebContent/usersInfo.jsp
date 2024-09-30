<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改学员信息</title>
		<link rel="stylesheet" href="${path}/resources/css/main.css"
			type="text/css"></link>
		<script language="javascript" type="text/javascript">
		function $(id) {
			return document.getElementById(id);
		}
		function checkName() {
			var stuName=$("stuName").value;
			if (stuName=="") {
			     alert("帐号不能为空！");
			     $("stuName").focus();
			     return false;
			}
			return true;
		}
		function checkPwd() {
			var stuPwd=$("stuPwd").value;
			if (stuPwd=="") {
			     alert("密码不能为空！");
			     $("stuPwd").focus();
			     return false;
			}
			return true;
		}
		function validateForm() {
			//alert(checkName());
			if(checkName() && checkPwd()) {
				return true;
			}
			return false;
		}
    </script>
	</head>

	<body>

		<form action="users_updUser" method="post"
			onsubmit="return validateForm()">
			<table align="center">
				<caption>
					用户详细信息
				</caption>
				<tr>
					<td>
						用户编号
					</td>
					<td>
						<input type="text" id="stuName" value="<s:property value='%{#request.users.id}'/>" name="id" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td>
						<input  type="text" id="stuPwd" value="<s:property value='%{#request.users.name}'/>" name="name" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
						<input  type="password" id="stuPwd" value="<s:property value='%{#request.users.pwd}'/>" name="pwd">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="修改">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
