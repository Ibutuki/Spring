<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="helloword">hello</a>
<a href="springmvc/helloworld">test@reqestMapping</a>
<a href="springmvc/testMethod1">hello</a>
<form action="springmvc/testMethod" method="post">
	<input type="submit">
</form>
<br/>

<a href="springmvc/testAntPath/xxx/xx/abc">ANThello</a>
<a href="springmvc/testAntPath/*/abc">ANThello</a>
<a href="springmvc/testAntPath/abcxx">ANThello</a>
<br/>

<a href="springmvc/testPathVariable/1">ANThello</a>
<br/>

<a href="springmvc/testRESTGet/1">get</a>
<form action="springmvc/testRESTPost/1" method="post">
	<input type="submit">
</form>
<form action="springmvc/testRESTPut/1" method="post">
	<input type="hidden" name="_method" value="PUT">
	<input type="submit">
</form>
<form action="springmvc/testRESTDelete/1" method="post">
	<input type="hidden" name="_method" value="PUT">
	<input type="submit">
</form>

</body>
</html>