<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAMBAWAN IT 로그인</title>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	#imgDiv{
		width: 100%;
		margin: 0 auto;
	}
	#imgDiv img{
		width: 108px;
    	height: 45px;
    	margin-left: -15px;
    	margin-top: -15px;
    	margin-bottom: 20px;
	}
	#section{
		width: 100%;
		height: 397px;
		padding: 270px 0px;
		background-image: url("${pageContext.request.contextPath}/images/main/login.jpg");
		background-size: cover;
	}
	#login{
		width: 250px;
    	margin: 0 auto;
    	height: 280px;
    	border: 1px solid #bbb;
    	border-radius: 5px;
    	background-color: white;
    	padding: 44px;
	}
	.text{
		font-size: 14px;
		color: #555;
	}
	.box{
		width: 240px;
		height: 30px;
		margin-top: 10px;
    	margin-bottom: 20px;
	}
	#loginbox{
		width:99%;
		position: relative;
	}
	#btnLogin{
		width: 70px;
    	height: 30px;
    	background-color: #00346b;
    	color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	position: absolute;
    	right: 0;
	}
	.emp{
		margin-top: 8px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		var result = ${error};
		console.log(result);
		if(result == 1){
			alert("해당 아이디가 존재하지 않습니다. 회원가입을 해주세요.")
		}else if(result == 2){
			alert("비밀번호가 틀렸습니다. 다시 확인해주세요.")
		}
	})
</script>
</head>
<body>
	<section id="section">
		<div id="login">
			<div id="imgDiv">
				<img src="${pageContext.request.contextPath}/images/main/h_logo.png">
			</div>
			<div id="loginbox">
				<form action="${pageContext.request.contextPath}/main/login.do" method="post">
					<label class="text">사용자ID</label><br>
					<input type="text" name="id" class="box"><br>
					<label class="text">비밀번호</label><br>
					<input type="password" name="password" class="box"><br>
					<!-- <input class="emp" type="radio" name="emp" value="employee">
					<label class="emp" style="margin-right: 10px">직원</label>
					<input class="emp" type="radio" name="emp" value="admin">
					<label class="emp">관리자</label> -->
					<input type="submit" value="로그인" id="btnLogin" style="cursor: pointer">
				</form>
			</div>
		</div>
	</section>
</body>
</html>