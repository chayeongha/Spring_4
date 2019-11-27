<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- utf-8 -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ page session="false"%>
<html>
<head>
<c:import url="./layout/bootStrap.jsp" />
<c:import url="./layout/summerNote.jsp"></c:import>
<title>Home</title>
</head>
<body>
	<c:import url="./layout/nav.jsp" />
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	
	<div class="container">
	<div id="movies">
	
	</div>
	
	<img alt="" src="" id="img">
	</div>
	
	<div class="container">
	<button id="btn">Get Json</button>
	<button id="btn2">CLICK</button>
	<button id="btn3">CLICK movies</button>
	</div>
	
	
	<script type="text/javascript">
		// $("#btn").click(function() {
		// 	//메서드가 겟방식일땐 $.get("url", 콜백함수=돌아올함수); , $.ajax

		// 	$.get("./getJson1" , function(data) {
		// 		data=data.trim();
		// 		data=JSON.parse(data); // 데이타라는스트링타입을 json타입으로 바꿔주세요라는 뜻이다.
		// 		//alert(typeof data);==>데이타타입을 엘럿창뛰워줌. string타입 으로출력

		// 		//alert(data.name); iu출력
		// 		alert(data.age); //27출력

		// 	} );
		// });

// 		$("#btn").click(function() {
// 			//메서드가 겟방식일땐 $.get("url", 콜백함수=돌아올함수); , $.ajax

// 			$.get("./getJson2?num=200", function(data) {
// 				//		data=data.trim();
// 				//data=JSON.parse(data); // 데이타라는스트링타입을 json타입으로 바꿔주세요라는 뜻이다.
// 				//alert(typeof data);==>데이타타입을 엘럿창뛰워줌. string타입 으로출력

// 				alert(data.title);
// 				alert(data.writer);
// 				alert(data.contents);

// 				alert(typeof data);

// 			});
// 		});
		
		$("#btn").click(function() {
			//메서드가 겟방식일땐 $.get("url", 콜백함수=돌아올함수); , $.ajax

			$.get("./getJson3", function(data) {
				//		data=data.trim();
				//data=JSON.parse(data); // 데이타라는스트링타입을 json타입으로 바꿔주세요라는 뜻이다.
				//alert(typeof data);==>데이타타입을 엘럿창뛰워줌. string타입 으로출력

				//반복문
				//for(var i=0; i<data.length;i++){
				//data가 배열타입임으로 제일첫번째 인덱스의 넘을 가져오려면
				//alert(data[0].num);
				//console.log(data[i].num);
				//}
												//d=인덱스번호 //vo는 가져올곳
				$.each(data, function(d ,vo) {
					console.log(d);
					console.log(vo.num);
				});
				
				
			});
		});
		
		
		$("#btn2").click(function() {
			
			$.ajax({
				type:"GET",
				url: "https://api.manana.kr/exchange/price.json",
				//파라미터보낼떈 data에담아
				data:{
					base:"USD", 
					price:1,
					code:"KRW"
				},
				success:function(data){
					console.log(data.KRW);
				}
				
			});
	
		});
		
		$("#btn3").click(function() {
			$.ajax({
				//파라미터값을 설정.
				type:"GET",
				url:"https://yts.lt/api/v2/list_movies.json",
				
				data:{
					limit:2,
					data:{
						title	:	"Hustlers",
						large_cover_image	:"https://yts.lt/assets/images/movies/hustlers_2019/large-cover.jpg",
						year	:	"2019",
						rating	:	"6.6",
						runtime	:	"110"
					}
					
				},
				success:function(data){
					console.log(data);
					$("#movies").append("<h1>"+data.data.movies[0].title+"</h1>");
					$("#movies").append("<h2>"+"개봉년도:"+data.data.movies[0].year+"년"+"</h2>");
					$("#movies").append("<h2>"+"평점:"+data.data.movies[0].rating+"점"+"</h2>");
					$("#movies").append("<h2>"+"상영시간:"+data.data.movies[0].runtime+"분"+"</h2>");
					
					//속성값 바꾸는것 prop 
					$("#img").prop("src","https://yts.lt/assets/images/movies/hustlers_2019/large-cover.jpg");
					
				}
				
			});
			
		});
		
	</script>
</body>
</html>
