<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postLogin</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>POST방식으로 전송된 로그인 파라미터</h3>
	
	<ul>
		<li>아이디 : ${id }</li>
		<li>패스워드 : ${pw }</li>
	</ul>
</div>
</body>
</html>