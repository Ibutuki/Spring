<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="emp">
			<c:if test = "${emp != null }">
				<input name="_method" value="PUT" type="hidden" />
			</c:if>
			id:<form:input path="id" readonly="readonly"/><br/>
			email:<form:input path="email"/><br/>
			<%
				Map<Integer,String> map = new HashMap<Integer,String>();
				map.put(0,"female");
				map.put(1,"male");
				request.setAttribute("map", map);
			%>
			gender:<form:radiobuttons path="gender" items="${map}"/><br/>
			department:<form:select path="department.id" items="${dpm}" itemValue="id" itemLabel="departmentName"/><br/>
			lastName:<form:input path="lastName"/><br/>
			<input type="submit" value="submit">
	</form:form>
	
</body>
</html>