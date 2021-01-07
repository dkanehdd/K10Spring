<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myCalculator</title>
<link rel="stylesheet" href="../common/bootstrap4.5.3/css/bootstrap.css" />
<script src="../common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>DI를 활용한 간단한 사칙연산 계산기</h2>
	
	<h3>200과 100의 사칙연산 결과는?</h3>
	
	<ul>
		<li>덧셈결과 : ${addResult }</li>
		<li>뺄셈결과 : ${subResult }</li>
		<li>곱셈결과 : ${mulResult }</li>
		<li>나눗셈셈결과 : ${divResult }</li>
	</ul>
</div>
</body>
</html>