<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	#imgDiv{
		
	}
	#imgDiv img{
		width: 108px;
    	height: 45px;
    	margin-left: -15px;
    	margin-top: -15px;
    	margin-bottom: 10px;
	}
	#section{
	    width: 100%;
    	height: 737px;
    	padding: 100px 0;
    	background-image: url(/SWsales/images/main/join1.jpg);
    	background-size: cover;
	}
	#login{
		width: 290px;
    	margin: 0 auto;
    	height: 650px;
    	border: 1px solid #bbb;
    	border-radius: 5px;
    	background-color: white;
    	padding: 44px;
	}
	.text{
		font-size: 14px;
		color: #555;
		font-weight: bold;
	}
	.box{
		width: 280px;
    	height: 25px;
    	margin-top: 10px;
    	margin-bottom: 13px;
    	border: 1px solid white;
    	border-bottom: 1px solid #ccc;
	}
	input::-webkit-input-placeholder {color:#ccc;}
	#loginbox{
		position: relative;
		height: 615px;
	}
	#btnLogin{
		width: 290px;
    	height: 41px;
    	background-color: #00346b;
    	color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	position: absolute;
    	right: 4px;
    	bottom: -15px;
	}
	.emp{
		margin-top: 8px;
	}
	#btnCheck{
		width: 80px;
    	background: #bbb;
    	border: 1px solid white;
    	height: 30px;
    	color: white;
    	border-radius: 5px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		var pass1 = $("#pass1").val();
		var pass2 = $("#pass2").val();
		
		$("#btnCheck").click(function () {
			var empId = $("#empId").val();
			if(empId == ""){
				alert("사용자ID를 입력해주세요.");
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/main/empIdSearch.do",
					type:"get",
					data:{"empId":empId},
					dataType:"json",
					success:function(res){
						console.log(res);
						if(res.result == "duplicate"){
							alert("등록된 ID입니다.");
						}else if(res.result == "empty"){
							alert("등록 가능한 ID입니다.");
						}
					}
				})
			}
		})
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
				<form action="${pageContext.request.contextPath}/main/join.do" method="post">
					<label class="text">사원번호</label><br>
					<input type="text" name="empNo" value="${empNo }" class="box" readonly><br>
					
					<label class="text">이름</label><br>
					<input type="text" name="empName" class="box" placeholder="실명을 입력하세요"><br>
					
					<label class="text">부서명</label><br>
					<select class="box">
						<option>선택</option>
						<option>기획총무부</option>
						<option>경리회계부</option>
						<option>상품관리부</option>
						<option>영업관리 1부</option>
						<option>영업관리 2부</option>
						<option>영업관리 3부</option>
						<option>쇼핑몰사업부</option>
						<option>해외사업부</option>
						<option>고객만족부</option>
					</select><br>
					
					<label class="text">직급</label><br>
					<select class="box">
						<option>선택</option>
						<option>부장</option>
						<option>차장</option>
						<option>과장</option>
						<option>대리</option>
						<option>사원</option>
						<option>인턴</option>
					</select><br>
					
					<label class="text">사용자ID</label><br>
					<input type="text" name="empId" id="empId" class="box" style="width: 200px" placeholder=">> 중복확인을 해주세요">
					<input type="button" id="btnCheck" style="cursor: pointer" value="중복확인"><br>
					
					<label class="text">
						비밀번호<br>
						<span style="font-size: 12px; color: blue;">(8~10자 이하,영어,숫자,특수문자(_@!#$%&)포함)</span>
					</label><br>
					<input type="password" name="password" id="pass1" class="box" placeholder="비밀번호"><br>
					
					<label class="text">비밀번호확인<c:if test=""></c:if></label><br>
					<input type="password" name="passwordCheck" id="pass2" class="box" placeholder="비밀번호 확인"><br>
					
					<label class="text">이메일 주소</label><br>
					<input type="email" name="empMail" class="box" placeholder="이메일 주소"><br>
					
					<input type="submit" value="사원등록" id="btnLogin" style="cursor: pointer">
				</form>
			</div>
		</div>
	</section>
</body>
</html>