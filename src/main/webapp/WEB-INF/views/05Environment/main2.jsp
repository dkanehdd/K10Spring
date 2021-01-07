<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main2</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>XML파일에 프로퍼티 파일을 명시한 후 외부파일 읽어오기</h2>
	
	<h3>메인관리자정보</h3>
	
	<ul>
		<li>아이디 : ${mainUserId }</li>
		<li>패스워드 : ${mainUserPw }</li>
	</ul>
	
	<h3>서브관리자정보</h3>
	<ul>
		<li>아이디 : ${subUserId }</li>
		<li>패스워드 : ${subUserPw }</li>
	</ul>
</div>
</body>
</html>