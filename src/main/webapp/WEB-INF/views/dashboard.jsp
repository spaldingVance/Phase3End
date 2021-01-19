<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dashboard</title>

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
	<div class="row">
		<div class="col-md-4 offset-4 mt-2 text-center">
			<h1>Dash Board</h1>
		</div>
	</div>


	<div class="row mt-2">
		<div class="col-md-6 offset-md-3">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Start Date</th>
						<th scope="col">End Date</th>
						<th scope="col">Description</th>
						<th scope="col">Severity</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${taskList}" var="task">

						<tr>
							<td>${task.getTaskName()}</td>
							<td>${task.getTaskStartDate()}</td>
							<td>${task.getTaskEndDate()}</td>
							<td>${task.getTaskDescription()}</td>
							<td>${task.getTaskSeverity()}</td>
							<td><a class="btn btn-warning"
								href="/task/${task.getId()}/update-task/${task.getUser().getUserEmail()}"
								role="button">Edit Task</a></td>
							<td><a class="btn btn-danger"
								href="/task/${task.getId()}/delete-task/${task.getUser().getUserEmail()}"
								role="button">Delete Task</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="col-md-6 offset-md-3 mt-3 text-center">

		<a class="btn btn-primary" href="/user/add-task" role="button">Add
			a Task</a> <a class="btn btn-primary" href="/logout" role="button">Logout</a>
	</div>




</body>
</html>