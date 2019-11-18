<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<c:import url="./layout/bootStrap.jsp"/>
	<title>Home</title>
</head>
<body>
	<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="result">
		<input type="text" id="num">
		<button id="btn">Click</button>
		
		
</div>


<script type="text/javascript">
	${"#btn"}.click(function() {
			var num= ${"#num"}.val();
			
// 			1.메서드 형식정하기
// 			선택자없이사용할땐 $만 쓴다.
// 			2. url주소 뒤에
// 			3. 파라미터 같이 써준다.
// 			$.get("./getNum?num="+num , function(data) {
// 				$("#result").append(data);																	
// 			});
			
			$.post("./getNum" , {num: num,} ,function(data) {
				$("#result").append(data);
			});
			
		
});


</script>


</body>
</html>
