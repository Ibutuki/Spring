<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学员信息列表</title>

		<link rel="stylesheet" href="${path}/resources/css/main.css"
			type="text/css"></link>
	</head>
	<script type="text/javascript">
		function del(id) {
			if (confirm("确认删除？")) {
				window.location.href = "users_del?id=" + id;
			}
		}
	</script>
	<body>
		<table align="center">
			<caption>
				学员信息列表
			</caption>
			<tr>
				<td>
					编号
				</td>
				<td>
					账号
				</td>
				<td>
					密码
				</td>
				<td>
					操作
				</td>
			</tr>
			<!-- 迭代取出每一个book实例 -->
			<s:iterator id="stus" value="#attr.list">
				<tr>
				<td>
					<s:property value="#stus.id"/>
				</td>
				<td>
					<s:property value="#stus.name"/>
				</td>
				<td>
					<s:property value="#stus.pwd"/>
				</td>
				<td>
					<a href="javascript:del(<s:property value='#stus.id'/>)">删除</a>
					<a href="users_loadUsers?id=${requestScope.stus.id }">详细信息</a>
				</td>
			</tr>
			</s:iterator>
			
		</table>
	</body>
</html>
