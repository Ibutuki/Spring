<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>学员信息注册</title>
		<link rel="stylesheet" href="<%=path%>/resources/css/main.css"
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
		<form action="users_reg" method="post"
			onsubmit="return validateForm()">
			<table align="center">
				<caption>
					用户信息注册
				</caption>
				<tr>
					<td>
						帐号：
					</td>
					<td>
						<input type="text" id="stuName" name="name">
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" id="stuPwd" name="pwd">
					</td>
				</tr>
				<tr>
					<td>
						重复密码：
					</td>
					<td>
						<input type="password">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="注册">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

