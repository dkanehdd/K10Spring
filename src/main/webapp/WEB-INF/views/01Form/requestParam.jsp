<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestParam</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">

	<h2>Form값 받기</h2>
	
	<h3>@RequestParam 어노테이션으로 파라미터 받기</h3>
	
	<ul>
		<li>이름 : ${memberDTO.name }</li>
		<li>아이디 : ${memberDTO.id }</li>
		<li>패스워드 : ${memberDTO.pw }</li>
		<li>이메일 : ${memberDTO.email }</li>
	</ul>
</div>
</body>
</html>