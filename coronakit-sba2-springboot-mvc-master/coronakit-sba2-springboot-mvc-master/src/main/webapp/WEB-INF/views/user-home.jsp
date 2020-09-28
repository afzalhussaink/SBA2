<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User - Home</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>This is User dashboard</h1>
	<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit Details</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/user/show-list">List All Products</a>
	</body>
</body>
</html>