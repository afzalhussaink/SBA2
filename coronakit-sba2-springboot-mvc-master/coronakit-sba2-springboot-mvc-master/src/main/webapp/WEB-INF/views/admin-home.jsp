<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Home</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>This is Admin dashboard</h1>
	<a href="${pageContext.request.contextPath}/admin/product-entry">Add New Product</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/admin/product-list">List All Products</a>
	</body>
</html>