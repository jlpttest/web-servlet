<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar sticky-top " style="background-color: #04AA6D">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="#">Sticky top</a>
		</div>
	</nav>



	<div class="container">
		<div class="row">
			<h3 class="text-center">List of User</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Avatar</th>
						<th>User Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td>
								<div class="d-flex align-items-center">
									<img src="${pageContext.request.contextPath}/resources/img/laptop1.jpg"
										class="img-fluid me-5 rounded-circle"
										style="width: 80px; height: 80px;" alt="">
								</div>
							</td>
							<td><c:out value="${user.userName}" /></td>
							<td><c:out value="${user.email}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>