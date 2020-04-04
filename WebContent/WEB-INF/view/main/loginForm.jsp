<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	#imgDiv{
		width: 100%;
		height: 600px;
		margin: 0 auto;
		margin-top: 50px;
		margin-bottom: 20px;
	}
	#imgDiv img{
		width: 100%;
		height: 600px;	
	}
	#logoDiv{
		width: 35%;
		margin: 0 auto;
		text-align: center;
		margin-top: 80px;
		margin-bottom: 30px;
	}
	#logo{
		width: 50%;
	}
	#login{
		width: 30%;
    	margin: 0 auto;
    	height: 320px;
    	border: 1px solid #bbb;
    	border-radius: 5px;
    	box-shadow: 5px 5px 10px #bbb;
	}
	.text{
		font-size: 14px;
		color: #555;
	}
	.box{
		width: 310px;
		height: 30px;
		margin-top: 10px;
    	margin-bottom: 20px;
	}
	#loginbox{
		width:65%;
		margin: 0 auto;
		padding-top: 30px;
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
</style>
<section>
	<div id="imgDiv">
		<img src="${pageContext.request.contextPath}/images/main/test1.png">
	</div>
	<div id="logoDiv">
		<img src="${pageContext.request.contextPath}/images/main/h_logo.png" alt="회사로고" id="logo">
	</div>
	<div id="login">
		<div id="loginbox">
			<form action="">
				<label class="text">사용자ID</label><br>
				<input type="text" name="id" class="box"><br>
				<label class="text">비밀번호</label><br>
				<input type="password" name="password" class="box"><br>
				<input type="radio" name="emp" value="employee">
				<label>직원</label>
				<input type="radio" name="emp" value="admin">
				<label>관리자</label>
				<input type="submit" value="로그인" id="btnLogin">
			</form>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>