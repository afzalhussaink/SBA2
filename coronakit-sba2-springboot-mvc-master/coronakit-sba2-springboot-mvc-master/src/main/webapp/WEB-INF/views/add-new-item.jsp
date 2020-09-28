<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Add Product</title>
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
	<section class="container-fluid p-4">
		<h3>${isNew?'New Product':'Edit Product' }</h3>

		<div class="col-sm-4">
			<form:form
				action="${isNew?pageContext.request.contextPath.concat('/admin/product-entry'):pageContext.request.contextPath.concat('/admin/product-save') }"
				method="POST" modelAttribute="product">

				<div class="form-group">
					<form:label path="id">Product Id</form:label>
					<form:input type="number" path="id" readonly="${!isNew }" class="form-control"/>
					<form:errors path="id" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="productName">Product Name</form:label>
					<form:input type="text" path="productName" class="form-control"/>
					<form:errors path="productName" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="productDescription">Description</form:label>
					<form:input type="text" path="productDescription" class="form-control"/>
					<form:errors path="productDescription" class="well well-danger"/>
				</div>
				<div class="form-group">
					<form:label path="cost">Cost</form:label>
					<form:input type="decimal" path="cost" class="form-control"/>
					<form:errors path="cost" class="well well-danger"/>
				</div>
				<div class="form-group text-right">
					<button class="btn btn-primary">SAVE</button>
				</div>
				
			</form:form>
		</div>
	</section>
</body>
</html>