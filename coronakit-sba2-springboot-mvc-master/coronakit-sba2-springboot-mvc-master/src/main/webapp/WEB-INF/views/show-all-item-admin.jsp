<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - List Products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<div class="jumbotron">
		<h2>Corona Kit - Product List</h2>
	</div>
	<c:if test="${msg != null }">
		<div class="card card-danger">
			<div class="card-head">
				<h3>Info</h3>
			</div>
			<div class="card-body">
				<p>${msg }</p>
			</div>
		</div>
	</c:if>
	<a href="${pageContext.request.contextPath}/admin/product-entry">Add New Product</a>
	<section class="container-fluid p-4">
		<c:choose>
			<c:when test="${products == null || products.isEmpty() }">
				<p class="well well-danger">No Products Available</p>
			</c:when>
			<c:otherwise>
				<table class="table table-striped table-hover" border="1" cellspacing="5px" cellpadding="5px">
					<tr>
	                    <th>Product#</th>
	                    <th>Product Name</th>
	                    <th>Description</th>
	                    <th>Cost</th>
	                    <th>Action</th>
	                </tr>
	                <c:forEach items="${products }" var="product">
	                    <tr>
	                        <td>${product.id }</td>
	                        <td>${product.productName }</td>
	                        <td>${product.productDescription }</td>
	                        <td>${product.cost }</td>
	                        <td>
	                            <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath }/admin/product-delete/${product.id }">DELETE</a>
	                            <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath }/admin/product-edit/${product.id}">EDIT</a>
	                        </td>
	                    </tr> 
	                </c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>