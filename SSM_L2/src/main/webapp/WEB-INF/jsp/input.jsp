<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/user/toAddUser" method="POST" modelAttribute="user">
			<c:if test = ${not empty user }>
				<input type="hidden" name="_method" value="PUT"/>
			</c:if>
			id:<form:input path="id" readonly="readonly"/><br/>
			name:<form:input path="name"/><br/>
			password:<form:input path="pwd"/><br/>
			<input type="submit" value="submit">
	</form:form>
</body>
</html>