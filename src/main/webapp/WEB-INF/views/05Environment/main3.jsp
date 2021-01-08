<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main3</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>어노테이션을 이용한 외부파일 참조하기</h2>
	
	<h3>게시판 설정값 읽어오기</h3>
	
	<ul>
		<li>아이디 : ${id }</li>
		<li>패스워드 : ${pass }</li>
		<li>드라이버 : ${driver }</li>
		<li>커넥트URL : ${url }</li>
	</ul>
</div>

</body>
</html>