<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/SpringMVC_L2/restRequestParam?username=test&age=25">requestparam</a>
	<a href="/SpringMVC_L2/testRequestHeader">testRequestHeader</a>
	<a href="/SpringMVC_L2/handle6?age=1">sessionId</a>
	</br>
	<a href="/SpringMVC_L2/testPOJO?name=test&address.name=test">testPOJO</a>
	</br>
	<a href="/SpringMVC_L2/testServletAPI?name=test">testServletAPI</a>
	</br>
	<a href="/SpringMVC_L2/testModelAndView">testModelAndView</a>
	</br>
	<a href="/SpringMVC_L2/testMap">testMap</a>


</body>
</html>