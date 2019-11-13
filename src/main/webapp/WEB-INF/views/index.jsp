<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<c:import url="../layout/bootStrap.jsp"/>
	<title>Home</title>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
