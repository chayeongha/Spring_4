<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />

	<h1>member Login page</h1>

	<form action="./memberLogin" method="post">
		<label for="ID">ID:</label> <input type="text" class="form-control"
			id="id" name="id">

		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" id="pw" name="pw">
		</div>
		<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div>
		<button type="submit" class="btn btn-primary px-3">Login</button>
	</form>




</body>
</html>