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


	<div id="noticeResult">
		
	</div>
	
	<div>
		<select id="animal">
			<option value="d">Dog</option>
			<option value="c">Cat</option>
			<option value="b">Bird</option>
		</select>
		
		<div id="kind">
			<select>
				<option>치와와</option>
				<option>푸들</option>
				<option>말티즈</option>
			</select>
		</div>
	</div>
	
	<div>
		<input type="text" id="num">
		<button id="btn">Number</button>
	</div>
	
	<div id="result"></div>


	<!------------------------------ AJAX 자바스크립트방식 ----------------------- -->
	<script type="text/javascript">
	
	$('#animal').change(function() {
		//1. XMLHttpRequest 객체 생성
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp = new XMLHttpRequest();
		}else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP")
		}
		
		//2. 요청 정보 작성		
		xmlhttp.open("GET", "./selectAnimal?kind="+$('#animal').val());
		
		//3. 요청 전송
		//GET
		xmlhttp.send();
		
		//POST
		//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//xmlhttp.send("파라미터이름=파라미터값&파라미터이름2=파라미터값2");
		
		//4. 결과 처리
		xmlhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				$('#kind').html(this.responseText);
			}
		}
	});
	
/*--------------------------------------------------------------------------------------------  */
	
	
	//btn
	$("#btn").click(function() {
		
	var xmlhttp;
	
	if (window.XMLHttpRequest) {
	   // code for modern browsers
	   xmlhttp = new XMLHttpRequest();
	 } else {
	   // code for old IE browsers
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var num= $("#num").val()
	
	//index.jsp는 루트폴더밑이라고 생각해야함 ../
	//request 정보
	xmlhttp.open("POST", "./testAjax");
	//POST방식
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	//매개변수 지정안하면 get방식
	//xmlhttp.send();
	
	
	//POST방식
	//xmlhttp.send("파라미터"); 파라미터는 키와 벨류로 이루어짐. 
	xmlhttp.send("num="+num);
	
	xmlhttp.onreadystatechange=function() {
		if(this.readyState ==4 && this.status == 200){
			
	//자바스크립트방식
	//document.getElementById("result").innerHTML= this.responseText
			
	//제이쿼리방식
	$("#result").html(this.responseText);
			
		}
	}
	
	});


	/*--------------------------------------------------------------------------------------------  */
	
	//noticeResult예제 noticelist에 있는 최신글 5개를 가져오라.
	
	//1. XMLHttpRequest 객체생성
	var xmlhttp;
	
	if (window.XMLHttpRequest) {
		   xmlhttp = new XMLHttpRequest();
		 } else {
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	
	//2. 요청정보 작성 데이터는 가져오기만하면됨으로 파라미터를 사용할필요없다.
	xmlhttp.open("GET" , "./notice/noticeResult");//메서드 형식
	
	//3. 요청 전송. 겟방식은 매개변수 없이
	//GET
	xmlhttp.send();

	//4. 결과 처리
	xmlhttp.onreadystatechange=function(){
	if(this.readyState ==4 && this.status == 200){
		$("#noticeResult").html(this.responseText)
			
		}
		
	}
	
	
	
	
	
	
</script>

</body>
</html>
