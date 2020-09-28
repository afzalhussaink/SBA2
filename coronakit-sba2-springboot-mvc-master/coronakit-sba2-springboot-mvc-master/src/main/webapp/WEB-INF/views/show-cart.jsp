<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User - Show Kit</title>
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
<body>
	<jsp:include page="header.jsp" />
	<section class="container-fluid p-4">
	<h3>Selected Items</h3>
	<form action="${pageContext.request.contextPath }/user/checkout" method="POST">
		<c:choose>
			<c:when test="${cartProducts == null || cartProducts.isEmpty() }">
				<p>No Iems Added Yet in Corona Kit. Please first add prodcuts.</p>
				<a href="${pageContext.request.contextPath}/user/show-list">List All Products</a>
			</c:when>
			<c:otherwise>

				<table class="table table-striped table-hover" border="1" cellspacing="5px" cellpadding="5px">
					<tr>
						<th>Product#</th>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${cartProducts }" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.productName }</td>
							<td><input type="integer" name="quantity"></td>
							<td>
								<a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath }/user/delete/${product.id}">REMOVE FROM KIT</a>
							</td>
							<td><input type="hidden" name="productId" value="${product.id }"></td>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-primary">Checkout</button>
			</c:otherwise>
		</c:choose>
	</form>
	</section>
</body>
</html>