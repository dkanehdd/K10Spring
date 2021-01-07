<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myAvengers</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>DI를 활용한 어벤져스 히어로</h2>
	
	<h3>생성자 사용하여 빈생성하기</h3>
	
	<h4>캡틴아메리카 정보</h4>
	<li>
		${captainAmerica }
	</li>
	
	<h4>아이언맨 정보</h4>
	<li>
		${ironMan }
	</li>
</div>
</body>
</html>