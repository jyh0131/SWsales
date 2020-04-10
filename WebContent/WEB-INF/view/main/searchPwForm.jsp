<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAMBAWAN IT 비밀번호찾기</title>
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
	#btnSend{
		width: 130px;
    	height: 30px;
    	background-color: #00346b;
    	color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	position: absolute;
    	right: 80px;
    	bottom: -40px;
	}
	#btnReset{
		width: 75px;
    	height: 30px;
    	background-color: #00346b;
    	color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	position: absolute;
    	right: 0;
    	bottom: -40px;
	}
	#wantId{
		font-size: 12px;
    	text-decoration: none;
   		color: gray;
    	position: absolute;
    	left: 0;
    	bottom: 0px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("form").submit(function (e) {
			var empId = $("input[name='empId']").val();
			var empMail = $("input[name='empMail']").val();
			
			if(empId == "" || empMail == ""){
				alert("사용자ID와 등록된 이메일을 정확히 입력해주세요.")
				return false;
			}
		})
		var result = ${error};
		console.log(result);
		if(result == 1){
			alert("아이디나 이메일 정보가 맞지 않습니다.");
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
				<form action="${pageContext.request.contextPath}/main/searchPw.do" method="post">
					<label class="text">사용자ID</label><br>
					<input type="text" name="empId" class="box" value="${emp.empId }"><br>
					<label class="text">이메일 주소</label><br>
					<input type="text" name="empMail" class="box" placeholder="등록당시 입력한 이메일"><br>
					<input type="submit" value="임시 비밀번호 전송" id="btnSend" style="cursor: pointer">
				</form>
				<a href="${pageContext.request.contextPath}/main/main.do"><button id="btnReset" style="cursor: pointer">돌아가기</button></a>
			</div>
		</div>
	</section>
</body>
</html>