<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ja">
<meta charset="UTF-8">
<head>
	<title>ComicRental</title>
</head>
<body>
	<% request.getRequestDispatcher("/WEB-INF/view/clerkLogin.jsp").forward(request, response); %>
</body>
</html>
