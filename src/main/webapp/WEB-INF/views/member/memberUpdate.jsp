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

<h1>Member Update Page</h1>


	<form action="./memberUpdate" method="post">
		
		<!-- 아이디 -->
		<div class="form-group">
			<label for="id">아이디</label> 
			<input type="text" class="form-control" id="id" name="id" placeholder="ID" required="required"> 
				<input type="button"  class="btn btn-primary px-3" value="중복확인"  id="checkId">
		</div>


		<!-- 비밀번호 -->
		<div class="form-group">
			<label for="user_pw">비밀번호</label> 
			<input type="password"
				class="form-control" id="pw" name="pw" placeholder="PASSWORD"
				required="required">
		</div>

		<!-- 이름 -->
		<div class="form-group">
			<label for="user_name">이름</label> 
			<input type="text"
				class="form-control" id="name" name="name" placeholder="Name"
				required="required">
		</div>

		<!-- 생년월일 -->
		<div class="form-group required">
			<label for="user_birth">생년월일</label> 
			<input type="text"
				class="form-control" id="birth" name="birth"
				placeholder="ex) 19990415" required="required">
		</div>

		<!-- 이메일 -->
		<div class="form-group">
			<label for="user_email">이메일</label> 
			<input type="email"
				class="form-control" name="email" id="email" placeholder="E-mail">
		</div>

		<!-- 성 -->
		<div class="form-group">
			<label for="user_gender">성별</label>
			<!-- <input type="text" -->
			<!-- class="form-control" name="gender" id="gender"placeholder="ex)남자 m,M  여자 f,F"> -->
			<label><input type="checkbox" name="gender" value="F">여성</label> 
			<label><input type="checkbox" name="gender" value="M">남성</label>
		</div>

		<div class="form-group">
				<label for="point">POINT:</label>
				<input type="text" class="form-control" id="point" placeholder="Your Point" required="required" name="point" readonly="readonly" value="${member.point}">
		  </div>
		

		<div class="reg_button">
			<button class="btn btn-primary px-3" type="submit">update</button>
		</div>


	</form>

<script type="text/javascript">

	//$(선택자).action();
	//호출 하는데 2가지방법
		
	$("#checkId").click(function() {
		
	       window.open("./memberIdCheck?id="+$("#id").val(),"","width=1000,height=400,left=400,top=200");
			
	       
	       
	});//callback함수

	</script>
</body>
</html>