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
	  <h2>${PageName}Update Page</h2>
	  <form action="./${board}Update" method="post" id="frm" >
	  	<input type="hidden" name="num" value="${dto.num}">
	  	
	    <div class="form-group">
	      <label for="name">TITLE</label>
	      <input type="text" class="form-control" id="title" value="${dto.title}" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">WRITER</label>
	      <input type="text" class="form-control" id="writer" value="${dto.writer}" name="writer" readonly="readonly">
	    </div>
	    
	    <div class="form-group">
      		<label for="comment">Contents:</label>
      		<textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
   		</div>
   		
   		<button type="submit" class="btn btn-default" id="submit">UPDATE</button>
		<a href="./${board}List" class="btn btn-default">LIST</a>
   		
	  </form>
	 </div>

</body>
</html>