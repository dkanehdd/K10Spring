<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">

	<h2>Hello Spring Framework</h2>
	<h3>첫번째 컨트롤러 만들기</h3>
	<!-- 컨트롤러에서 Model객체에 저장한 값을 EL로 출력한다. -->
	<h4>컨트롤러에서 뷰로 전달한값 : ${firstMessage }</h4>
	
	<script type="text/javascript">
	$(function() {
		alert("jQuery실행 됨?");
	});
	</script>
</div>
</body>
</html>