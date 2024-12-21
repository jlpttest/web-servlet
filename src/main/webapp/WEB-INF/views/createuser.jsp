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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar sticky-top " style="background-color: #04AA6D">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="#">Sticky top</a>
		</div>
	</nav>



	<div class="container">
		<div class="row">
			<form action="${pageContext.request.contextPath}/create-user" method="post"
				enctype="multipart/form-data">
				<div class="col-md-6 mx-auto ">
					<h2>Register</h2>
					<p>Please fill in this form to create an account.</p>
					<hr>
				</div>
				<div class="col-md-6 mx-auto">
					<label for="inputEmail4"  class="form-label"><b>Email</b></label> <input
						name="email" type="email" class="form-control" required />
				</div>
				<div class="col-md-6 mx-auto">

					<label for="inputName" class="form-label"><b>Full Name</b></label>
					<input name="name" type="text" id="inputName" class="form-control" />
				</div>
				<div class="col-md-6 mx-auto">
					<label for="avatarFile" class="form-label">Avatar:</label> <input
						class="form-control" type="file" id="avatarFile" name="uploadFile"
						accept=".png, .jpg, .jpeg">
				</div>
				<div class="col-md-6 mx-auto my-3">
					<img style="max-height: 250px; display: none;" alt="avatar preview"
						id="avatarPreview" />
				</div>
				<div class="col-md-6 mx-auto">
					<div class="d-flex justify-content-around">
						<button type="submit" class="registerbtn btn btn-success">
							<b>Register</b>
						</button>
						<a href="${pageContext.request.contextPath}/user-list"
							type="button" class="btn btn-danger"><b>Cancel</b></a>
					</div>
				</div>


			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
<script>
                $(document).ready(() => {
                    const avatarFile = $("#avatarFile");
                    avatarFile.change(function (e) {
                        const imgURL = URL.createObjectURL(e.target.files[0]);
                        $("#avatarPreview").attr("src", imgURL);
                        $("#avatarPreview").css({ "display": "block" });
                    });
                });
            </script>
</html>