<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<c:import url="./layout/bootStrap.jsp" />
<title>Home</title>
</head>
<body>
	<c:import url="./layout/nav.jsp" />
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>


	<script type="text/javascript">
	
	var xmlhttp;
	
	if (window.XMLHttpRequest) {
	   // code for modern browsers
	   xmlhttp = new XMLHttpRequest();
	 } else {
	   // code for old IE browsers
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//index.jsp는 루트폴더밑이라고 생각해야함 ../
	//request 정보
	xmlhttp.open("GET" , "./testAjax");
	
	//매개변수 지정안하면 get방식
	xmlhttp.send();
	
	//
	xmlhttp.onreadystatechange=function() {
		if(this.readystate ==4 && this.status == 200){
			alert(this.responseText);
			
		}
		
		
	}
	


</script>

</body>
</html>
