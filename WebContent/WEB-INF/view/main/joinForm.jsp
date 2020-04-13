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
	body{
    	background-image: url("${pageContext.request.contextPath}/images/main/join1.jpg");
    	background-size: cover;	
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
	#btnJoin{
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
		var passRules = /^(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}$/;
		
		$("#pass1").change(function() {
			var pass1 = $("#pass1").val();
			if(passRules.test(pass1)){
				$("#span1").html(": 사용가능").css("color", "green");
			}else{
				$("#span1").html(": 사용불가").css("color", "red");
				$("#pass1").val('');
			}
		})
		$("#pass2").change(function() {
			var pass1 = $("#pass1").val();
			var pass2 = $("#pass2").val();
			if(pass1 == pass2){
				$("#span2").html(": 비밀번호 일치").css("color", "green");
			}else{
				$("#span2").html(": 비밀번호 불일치").css("color", "red");
				$("#pass2").val('');
			}
		})
		
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
							$("#empId").val("");
						}else if(res.result == "empty"){
							alert("등록 가능한 ID입니다.");
							$("#idCheck").val("true");
						}
					}
				})
			}
		})
		
		$("#btnJoin").click(function() {
			var empName = $("#empName").val();
			var dept = $("#dept").val();
			var position = $("#position").val();
			var empId = $("#empId").val();
			var pass1 = $("#pass1").val();
			var pass2 = $("#pass2").val();
			var email = $("#email").val();
			var idCheck = $("#idCheck").val();
			
			if(idCheck == "false"){
				alert("사용자ID 중복확인을 해주세요.");
				return false;
			}
			if(empName == ""||dept==""||position==""||empId==""||pass1==""||pass2==""||email==""){
				alert("모든 정보를 입력해주세요");
				return false;	
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
					<input type="text" name="empName" id="empName" class="box" placeholder="실명을 입력하세요"><br>
					
					<label class="text">부서명</label><br>
					<select class="box" id="dept" name="deptName">
						<option value="none">선택</option>
						<option value="기획총무부">기획총무부</option>
						<option value="경리회계부">경리회계부</option>
						<option value="상품관리부">상품관리부</option>
						<option value="영업관리 1부">영업관리 1부</option>
						<option value="영업관리 2부">영업관리 2부</option>
						<option value="영업관리 3부">영업관리 3부</option>
						<option value="쇼핑몰사업부">쇼핑몰사업부</option>
						<option value="해외사업부">해외사업부</option>
						<option value="고객만족부">고객만족부</option>
					</select><br>
					
					<label class="text">직급</label><br>
					<select class="box" id="position" name="empTitle">
						<option value="none">선택</option>
						<option value="부장">부장</option>
						<option value="차장">차장</option>
						<option value="과장">과장</option>
						<option value="대리">대리</option>
						<option value="사원">사원</option>
						<option value="인턴">인턴</option>
					</select><br>
					
					<label class="text">사용자ID</label><br>
					<input type="text" name="empId" id="empId" class="box" style="width: 200px" placeholder=">> 중복확인을 해주세요">
					<input type="button" id="btnCheck" style="cursor: pointer" value="중복확인"><br>
					<input type="hidden" id="idCheck" value="false">
					
					<label class="text">비밀번호 <span id="span1"></span><br>
						<span style="font-size: 12px; color: blue;">(숫자, 특수문자, 영문 1자리 이상 포함, 8자리 이상)</span>
					</label><br>
					<input type="password" name="password" id="pass1" class="box" placeholder="비밀번호"><br>
					
					<label class="text">비밀번호확인<span id="span2"></span></label><br>
					<input type="password" name="passwordCheck" id="pass2" class="box" placeholder="비밀번호 확인"><br>
					
					<label class="text">이메일 주소</label><br>
					<input type="email" name="empMail" id="email" class="box" placeholder="이메일 주소"><br>
					
					<input type="submit" value="사원등록" id="btnJoin" style="cursor: pointer">
				</form>
			</div>
		</div>
	</section>
</body>
</html>