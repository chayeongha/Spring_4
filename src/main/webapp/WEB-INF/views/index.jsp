<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<c:import url="./layout/bootStrap.jsp"/>
	<c:import url="./layout/summerNote.jsp"></c:import>
	<title>Home</title>
</head>
<body>
	<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="editor"></div>

<script type="text/javascript">


	$("#editor").summernote({
        height: 400
	});
</script>

</body>
</html>
