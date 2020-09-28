<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Corona-Kit</a>

	<!-- Toggler/collapsibe Button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<security:authorize access="hasRole('ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/home">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/admin/product-list">Products</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/admin/product-entry">New
						Product</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/logout">Sign Out</a></li>
			</security:authorize>

			<security:authorize access="hasRole('USER')">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/home">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/user/product-list">Products</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/logout">Sign Out</a>
				</li>
			</security:authorize>
			
			<security:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/login">Sign In</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/register">Sign Up</a>
				</li>
			</security:authorize>

		</ul>
	</div>
</nav>