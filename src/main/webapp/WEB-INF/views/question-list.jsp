<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div>
				<a href="#" class="navbar-brand"> Question List </a>
			</div>
		</nav>
	</header>
	
	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Question</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Question</th>
						<th>Answer1</th>
						<th>Answer2</th>
						<th>Answer3</th>
						<th>Answer4</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="question" items="${questions}">

						<tr>
							<td><c:out value="${question.id}" /></td>
							<td><c:out value="${question.answer1}" /></td>
							<td><c:out value="${question.answer2}" /></td>
							<td><c:out value="${question.answer3}" /></td>
							<td><c:out value="${question.answer4}" /></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>