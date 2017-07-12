<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.nian.student.pojo.User"%>

<!-- add jstl here: automaticly convert to java code, no need to write java-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- ?????????????? -->
<script>
	
</script>

<style type="text/css">
body {
	padding: 25px;
}
</style>

</head>
<body>

	<div class="panel panel-primary">

		<div class="panel-heading">
			<h3 class="panel-title">Student Entry</h3>
		</div>

		<div class="panel-body">

			<form action="update.do" method="post">

				<!-- so will not insert a new record, instead update this id record only -->
				<!-- form can be used as insert or update now; value is not displayed on source page means no id, insert; is data is there, update only-->
				<input type="hidden" id="id" name="id"
					value="${requestScope.user.id}" />

				<div class="form-group">
					<label for="name">Name</label> <input type="text"
						class="form-control" name="name" id="name" placeholder="Name"
						value="${requestScope.user.name}">
				</div>
				
				<div class="form-group">
					<label for="address">Address</label> <input type="text"
						class="form-control" name="address" id="address" placeholder="Address"
						value="${requestScope.user.address}">
				</div>
				
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" id="username" placeholder="Username"
						value="${requestScope.user.username}">
				</div>
				
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password" placeholder="Password"
						value="${requestScope.user.password}">
				</div>
			
				<div class="form-group">
					<label for="dob">Dob</label> <input type="text"
						class="form-control" id="dob" placeholder="Dob"
						value="<fmt:formatDate value="${requestScope.user.dob}" pattern="dd/MM/yyyy"/>"
						readonly="readonly">
				</div>

				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>

	</div>


	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Student List</h3>
		</div>
		<div class="panel-body">

			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Address</th>
						<th>Dob</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${requestScope.userList}" var="row">

						<tr>
							<td>${row.id}</td>
							<td>${row.name}</td>
							<td>${row.address}</td>
							<td><fmt:formatDate value="${row.dob}" pattern="dd/MM/yyyy" />
							</td>
							<td><a href="update.do?id=${row.id}">Edit</a></td>
							<td><a href="delete.do?id${row.id}">Delete</a></td>
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>