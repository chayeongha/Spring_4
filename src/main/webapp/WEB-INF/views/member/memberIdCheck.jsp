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

<div class="container">
	<h1>${param.id} 는 ${msg} </h1>

	<form class="form-inline" action="./memberIdCheck">
    <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${param.id} ">
    	<button type="submit" class="btn-btn-default">submit</button>
    	
    	<c:if test="${ empty dto}">
    	<input type="button" id="useId" value="사용하기"> 
    	</c:if>
    	
    </div>
    
    
  
  </form>
		
		</div>


<script type="text/javascript">
	$("#useId").click(function() {
		//사용하기를누르면 id값이 join페이지에 값이 들어감.
	    //오픈한 창에있는 id값과  join페이지()에있는 id값을 구분을하여값을 바꿔줄수있도록해야함.
		var id=$("#id").val();
		
		//javascript 방식
			//window.opener.document.getElementById("id").value=id;
		
		//Jquery 방식
		$("#id", opener.document).val(id);
		
		window.self.close();
		
	});

</script>





</body>
</html>