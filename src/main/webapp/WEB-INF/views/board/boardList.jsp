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


	
  		<div >
    		<h1>${PageName}</h1>
		</div>
	
	
	
	<div class="container">
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>NUM</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    	<c:forEach items="${list}" var="dto" varStatus="st">
		      <tr>
		        <td>${dto.num}</td>
		        <td>
		        <c:catch>
		        <c:forEach begin="1" end="${dto.depth}">↳↳</c:forEach>
		        </c:catch>
		        <a href="./${board}Select?num=${dto.num}">${dto.title}</a></td>
		        <td>${dto.writer}</td>
		        <td>${dto.reg_date}</td>
		        <td>${dto.hit}</td>
		      </tr>
	    	</c:forEach>
	    </tbody>
	  </table>
		  
		  
		  
		  <div>
		  	<form action="./${board}List" id="frm">
		  	<input type="hidden" id="curPage" value="1" name="curPage">
		  		<select id="kind" name="kind">
		  			<option id="kt" value="kt">TITLE</option>
		  			<option id="kw" value="kw">WRITER</option>
		  			<option id="kc" value="kc">CONTENTS</option>
		  		</select>
		  		<input type="text" id="search" name="search" value="${pager.search}">
		  		<button>검색</button>
		  	</form>
		  </div>
	  
	  <div>
	 	 <ul class="pagination">
		 	 <c:if test="${pager.curBlock gt 1}">
		 	 	<li><span id="${pager.startNum-1}" class="list">이전</span></li>
		 	 </c:if>
			 <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			 	<li><span id="${i}" class="list">${i}</span></li>
			 </c:forEach>
			 <c:if test="${pager.curBlock lt pager.totalBlock}">
			 	<li><span id="${pager.lastNum+1}" class="list">다음</span></li>
			 </c:if>
	  	 </ul>
	  	 <a href="${board}Write">Write</a>
	  </div>
	  
	 </div>	
	  <script type="text/javascript">
	  	var kind = '${pager.kind}'
		if(kind == ''){
			kind = "kt";
		}
		$("#"+kind).prop("selected", true);
	 	$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	  </script>
		  
	  
</body>
</html>