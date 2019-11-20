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
	
	<div>
	
			<c:forEach items="${dto.files}" var="file">
			
				<a href="../resources/upload/${board}/${file.fname}">${file.oname}</a>
			
			</c:forEach>
	
	</div>
	
	

	<div class="button">

		<a class="btn btn-danger" href="${board}Update?num=${dto.num} ">Update</a>
		<a class="btn btn-primary" href="${board}Delete?num=${dto.num}" >Delete</a>
		<c:if test="${board ne 'notice'}">
		<a class="btn btn-success" href="${board}Reply?num=${dto.num} " >Reply</a>
		</c:if>
	</div>

</body>

</body>
</html>