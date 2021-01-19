<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Form</title>
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
		<div class="col-md-12 text-center">
			<h1>Update Task</h1>
		</div>
	</div>
	<div class="row mt-2 text-center">
		<div class="col-md-4 offset-md-4 text-center">
			<form:form modelAttribute="newTask">
				<form:errors path="*" element="div" />
				<div class="row mt-2">

					<form:hidden path="user" required="true"
						value="${newTask.getUser()}" />
					<form:errors path="user" />
				</div>
				<div class="row mt-2">
					<form:label path="taskName">Name</form:label>
					<form:input path="taskName" required="true" />
					<form:errors path="taskName" />
				</div>

				<div class="row mt-2">
					<form:label path="taskStartDate">Start Date</form:label>
					<form:input path="taskStartDate" required="true" type="date" />
					<form:errors path="taskStartDate" />
				</div>

				<div class="row mt-2">
					<form:label path="taskEndDate">End Date</form:label>
					<form:input path="taskEndDate" required="true" type="date" />
					<form:errors path="taskEndDate" />
				</div>

				<div class="row mt-2">

					<form:label path="taskDescription">Description</form:label>
					<form:textarea path="taskDescription" required="true" />
					<form:errors path="taskDescription" />
				</div>

				<div class="row mt-2">
					<form:label path="taskSeverity">Severity</form:label>
					<form:select path="taskSeverity">
						<form:option value="NONE" label="Select" />
						<form:option value="High" label="High" />
						<form:option value="Medium" label="Medium" />
						<form:option value="Low" label="Low" />
					</form:select>
					<form:errors path="taskSeverity" />
				</div>

				<div class="row mt-2 text-center">
					<div class="col-md-4 offset-md-4">
						<button class="btn btn-primary" type="submit" value="Update Task">Submit</button>
					</div>
				</div>
			</form:form>

		</div>
	</div>

</body>
</html>