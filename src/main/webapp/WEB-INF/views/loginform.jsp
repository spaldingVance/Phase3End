<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="row mt-3">
		<div class="col-md-4 offset-md-4 text-center">
			<h1>Login</h1>
			<a class="btn btn-primary" href="/" role="button">Back to Home</a> <br>
		</div>
	</div>

	<div class="row mt-2">
		<div class="col-md-4 offset-md-4 text-center">
			<form:form modelAttribute="user">
				<form:errors path="*" element="div" />

				<div class="row mt-2">
					<form:label path="userEmail">Email</form:label>
					<form:errors path="userEmail" />
					<form:input path="userEmail" required="true" />
				</div>
				<div class="row mt-2">
					<form:label path="password">Password</form:label>
					<form:input path="password" required="true" />
					<form:errors path="password" />
				</div>
				<div class="row mt-2">
					<div class="col-md-4 offset-md-4">
						<input type="submit" value="Login" />
					</div>

				</div>
			</form:form>
		</div>
	</div>

</body>
</html>