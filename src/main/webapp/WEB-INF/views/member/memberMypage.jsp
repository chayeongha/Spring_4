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

<div class="container">
		<h2>My Page Form</h2>
		<form action="./memberUpdate" id="frm" onsubmit=true method="post">
		   
		    <div class="form-group">
				<label for="id">ID:</label>
				<input type="text" class="form-control" id="id" placeholder="Enter ID" required="required" name="id" value="${member.id}" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
				<label for="pw">PW:</label>
				<input type="password" class="form-control" id="pw" placeholder="Enter PW" required="required" name="pw" value="${member.pw}" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
				<label for="name">NAME:</label>
				<input type="text" class="form-control" id="name" placeholder="Enter NAME" required="required" name="name" value="${member.name}" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
				<label for="email">EMAIL:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter E-MAIL" required="required" name="email" value="${member.email}" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
				<label for="birth">BIRTH:</label>
				<input type="text" class="form-control" id="birth" placeholder="Enter Birth" required="required" name="brith"  value="${member.birth}" readonly="readonly">
		    </div>
		    
		     <div class="form-group">
				<label for="gender">Gender:</label>
				
				<c:if test="${member.gender eq 'm' or member.gender eq 'M'}">
					<label><input type="checkbox" name="gender" value="M" checked="checked">Male</label>
					<label><input type="checkbox" name="gender" value="F">Female</label>
				</c:if>
				<c:if test="${member.gender eq 'f' or member.gender eq 'F'}">
					<label><input type="checkbox" name="gender" value="M" >Male</label>
					<label><input type="checkbox" name="gender" value="F" checked="checked">Female</label>
				</c:if>
				
				</div>
				
		    <div class="form-group">
				<label for="point">POINT:</label>
				<input type="text" class="form-control" id="point" placeholder="Your Point" required="required" name="point" readonly="readonly" value="${member.point}">
		    </div>
		    
			<a href="./memberUpdate"><input type="button" class="btn btn-default" value="Go Update"></a> 
			<a href="./memberDelete?id=${member.id}" class="btn btn-default">QUIT</a>
		    
		    
	
		</form>
	</div>

</body>
</html>