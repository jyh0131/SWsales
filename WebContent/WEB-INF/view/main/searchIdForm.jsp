<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAMBAWAN IT 아이디찾기</title>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	body{
		background-image: url("${pageContext.request.contextPath}/images/main/login.jpg");
		background-size: cover;	
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
	#btnSearch{
		width: 95px;
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
			var empNo = $("input[name='empNo']").val();
			var empName = $("input[name='empName']").val();
			
			if(empNo == "" || empNo == "EE" || empName == ""){
				alert("사원번호와 이름을 정확히 입력해주세요.")
				return false;
			}
		})
		var result = ${error};
		console.log(result);
		if(result == 1){
			alert("해당 아이디가 존재하지 않습니다. 다시 확인해주세요");
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
				<form action="${pageContext.request.contextPath}/main/searchId.do" method="post">
					<label class="text">사원번호</label><br>
					<input type="text" name="empNo" class="box" value="EE"><br>
					<label class="text">이 름</label><br>
					<input type="text" name="empName" class="box"><br>
					<input type="submit" value="아이디 찾기" id="btnSearch" style="cursor: pointer">
				</form>
				<a href="${pageContext.request.contextPath}/main/main.do"><button id="btnReset" style="cursor: pointer">돌아가기</button></a>
			</div>
		</div>
	</section>
</body>
</html>