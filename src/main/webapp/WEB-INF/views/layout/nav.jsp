
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/notice/noticeList">Notice List</a></li>
          <li><a href="${pageContext.request.contextPath}/notice/noticeWrite">Notice Write</a></li>

          <li><a href="${pageContext.request.contextPath}/qna/qnaList">QNA</a></li>


        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/notice/noticeList">Notice</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
   
    
    
      <li><a href="${pageContext.request.contextPath}/member/memberMypage"><span class="glyphicon glyphicon-education"></span> My Page</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
  
    <!--로그인 전  -->
	  <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
  
    </ul>
  </div>

</nav>
		


