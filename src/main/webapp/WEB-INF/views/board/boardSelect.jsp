<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>${PageName}Select Page</h1>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>CONTENTS</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.num}</td>
					<td>${dto.title}</td>
					<td>${dto.writer}</td>
					<td>${dto.contents}</td>
					<td>${dto.reg_date}</td>
					<td>${dto.hit}</td>

				</tr>
			</tbody>
		</table>
	</div>


	<div class="button">

		<a class="btn btn-danger" href="${board}Update?num=${dto.num} ">Update</a>
		<a href="${board}Delete?num=${dto.num}" class="btn btn-primary">Delete</a>
		<c:if test="${board ne 'notice'}">
		<a href="${board}Reply?num=${dto.num} " class="btn btn-success">답변달기</a>
		</c:if>
	</div>

</body>

</body>
</html>