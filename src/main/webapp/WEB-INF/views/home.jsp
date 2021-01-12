<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./common/bootstrap4.5.3/css/bootstrap.css" />
<script src="./common/jquery/jquery-3.5.1.js"></script>
</head>
<body>
<div class="container">
	<h2>스프링 MVC 시작하기</h2>
	
	<!--  
		SPRING MVC 에서는 이미지와 같은 리소스를 사용하기 위해
		별도로 resources 폴더를 제공한다.
		해당 폴더의 설정은 servlet-context.xml에서 할수있다.
	-->
	<h3>resources 폴더 사용하기</h3>
	<!--  
		원래의 폴더명은 resources이나 아래와같이 res, images로
		매핑하였게 때문에 매핑명을 통해 경로를 지정할 수 있다.
	-->
	<img src="./res/1.png" alt="스폰지밥" width="200"/>
	<img src="./images/1.png" alt="스폰지밥" width="200"/>
	
	<h3>첫번째 컨트롤러 만들기</h3>
	<!-- Step1 : 항상 요청명을 먼저 결정한다. -->
	<ul>
		<li>
			<a href="./home/helloSpring" target="_blank">
				첫번째 컨트롤러 바로가기
			</a>
		</li>
	</ul>
	
	<!-- 컨트롤러 : FormController.java -->
	<h3>form값 처리하기</h3>
	<ul>
		<li><a href="./form/servletRequest?id=kosmo&pw=1234" target="_black">
			HttpServletRequest로 폼값받기
		</a></li>
		<li><a href="./form/requestParam.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.com" target="_black">
			@requestParam 어노테이션으로 폼값받기
		</a></li>
		<li><a href="./form/commandObjGet.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.com" target="_black">
			커맨드(Command)객체로 한번에 폼값받기
		</a></li>
		<li><a href="./form/gildong99/코스모" target="_black">
			pathVariable 어노테이션으로 폼값받기
		</a></li>
	</ul>
	
	<!-- 컨트롤러 : RequestMappingController.java -->
	<h3>@RequestMapping 어노테이션 활용</h3>
	<li>
		<a href="./requestMapping/index.do" target="_blank">
			requestMapping시작페이지 바로가기
		</a>
	</li>
	
	<!-- 컨트롤러 : ValidateController.java -->
	<h2>폼 데이터 검증하기 - Validator</h2>
	<li>
		<a href="validate/memberRegist.do" target="_blank">
			회원가입 바로가기
		</a>
	</li>
	
	<!-- 컨트롤러 : DIController.java -->
	<h3>DI(Dependency Injection) : 의존성 주입</h3>
	<li>
		<a href="di/myCalculator" target="_blank">
			간단한 사칙연산 계산기
		</a>
	</li>
	<li>
		<a href="di/myBMICal" target="_blank">
			BMI(비만지수) 계산하기
		</a>
	</li>
	<li>
		<a href="di/myAvengers" target="_blank">
			어벤져스 히어로
		</a>
	</li>
	<li>
		<a href="di/myAnnotation" target="_blank">
			어노테이션을 이용한 DI활용
		</a>
	</li>
	
	<h3>Environment 객체를 이용한 외부파일 참조하기</h3>
	<li>
		<a href="environment/main1" target="_blank">
			외부파일 참조하기 1(Environment객체 사용)
		</a>
	</li>
	<li>
		<a href="environment/main2" target="_blank">
			외부파일 참조하기 2(XML설정파일 사용)
		</a>
	</li>
	<li>
		<a href="environment/main3" target="_blank">
			외부파일 참조하기 3(어노테이션 사용)
		</a>
	</li>
	
	
	<h3>파일업로드</h3>
	<li>
		<a href="./fileUpload/uploadPath.do" target="_blank">
			upload폴더의 물리적 경로 확인하기
		</a>
	</li>
	<li>
		<a href="./fileUpload/uploadForm.do" target="_blank">
			파일업로드 폼
		</a>
	</li>
	<li>
		<a href="./fileUpload/uploadList.do" target="_blank">
			파일목록보기
		</a>
	</li>
	
	<h3>@Controller, @Service, @Repository 어노테이션</h3>
	<li>
		<a href="./service/myService.do">바로가기1</a>
	</li>
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
	<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
</div>
</body>
</html>
