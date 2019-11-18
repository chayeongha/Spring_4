<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

   <c:forEach items="${list}" var="vo">
   
   <ul>
   		<li><a href="./notice/noticeSelect?num=${vo.num}">${vo.title}</a></li>
   		<li>${vo.reg_date}</li>
   		
   <ul>
   
   
   </c:forEach> 
    
   

    