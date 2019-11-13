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

	<h1>Notice List Page</h1>
	<!-- <a href="./noticeSelect?n=33">Select One</a>
		<a href="./noticeWrite">Notice Write</a>
		<img alt="" src="../resources/images/Iu3.jpg"> -->
	<h1>${list.get(0).getNum()}</h1>
	<table class="table">
		<thead>
			<tr class="info">
				<th>Num</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Date</th>
				<th>Hit</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${list}" var="dto2" varStatus="st">

				<tr class="warning">
					<td>${dto2.num}</td>
					<td><a href="./noticeSelect.notice?num=${dto2.num}">${dto2.title}</a></td>
					<td>${dto2.writer}</td>
					<td>${dto2.reg_date}</td>
					<td>${dto2.hit}</td>

				</tr>

			</c:forEach>

		</tbody>
	</table>

	<div>
		<form id="frm" action="./noticeList">
		<input type="hidden" id="curPage" value="1" name="curPage">
			<select name="kind">
					<option id="kt" value="kt">TITLE</option>
					<option id="kc" value="kc">CONTENTS</option>
					<option id="kw" value="kw">WRITER</option>
			</select>
			<input type="text" name="search" value="${pager.search}">
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
	  </div>
	 
	  <a href="./noticeWrite">Write</a>
	
	 
	 <script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind ==''){
			kind="kt";
		}
	 	$("#"+kind).prop("selected", true);
	 	$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	 
	 </script>


</body>
</html>