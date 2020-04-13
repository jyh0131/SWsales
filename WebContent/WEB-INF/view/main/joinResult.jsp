<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAMBAWAN IT 사원등록</title>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background-image: url("${pageContext.request.contextPath}/images/main/join1.jpg");
		background-size: cover;	
	}
	#section{
		width: 100%;
		height: 321px;
		padding: 308px 0px;
	}
	#login{
		width: 550px;
    	margin: 0 auto;
    	height: 230px;
    	border: 1px solid #bbb;
    	border-radius: 5px;
    	background-color: white;
    	padding: 44px;
	}
	#imgDiv{
		width: 38%;
    	margin: 0 auto;
    	float: left;
	}
	#imgDiv img{
		width: 200px;
    	height: 80px;
    	margin-left: -25px;
    	margin-top: 50px;
	}
	#loginbox{
		width:100%;
		position: relative;
	}
	#welcome1{
		font-size: 14px;
    	margin-top: 15px;
	}
	#welcome2{
		font-size: 14px;
		margin-top: 6px;
	}
	#btnLogin{
		width: 190px;
    	height: 60px;
    	margin-top: 40px;
    	background: #00346b;
    	color: white;
    	border: 1px solid white;
	}
</style>
</head>
<body>
	<section id="section">
		<div id="login">
			<div id="imgDiv">
				<img src="${pageContext.request.contextPath}/images/main/h_logo.png">
			</div>
			<div id="loginbox">
				<h2 style="margin-top: 20px;"><span style="color: red;">직원등록</span>이 완료되었습니다.</h2>
				<p id="welcome1">NAMBAWAN IT의 가족이 되신 것을 환영합니다.</p>
				<p id="welcome2">아래 버튼을 누르시면 로그인 페이지로 이동합니다.</p>
				<a href="${pageContext.request.contextPath}/main/login.do"><button id="btnLogin" style="cursor: pointer">로그인하기</button></a>
			</div>
		</div>
	</section>
</body>
</html>