<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	#imgDiv{
		width: 85%;
		height: 400px;
		border: 1px solid red;
		margin: 0 auto;
		margin-top: 50px;
		margin-bottom: 50px;
	}
	#regForm{
		width: 85%;
		margin: 0 auto;
	}
	label{
		width: 130px;
		float: left;
	}
</style>
<section>
	<div id="imgDiv">
		<!-- 이미지추가부분 -->
	</div>
	<div></div>
	<div id="regForm">
		<form action="">
			<label>회사번호</label>
			<input type="text" name="sNo"><br>
			<label>회사명</label>
			<input type="text" name="sName">
			<input type="button" value="중복확인" id="btnSname"><br>
			<label>사업자등록번호</label>
			<input type="text" name="sBln"><br>
			<label>주소</label>
			<input type="text" name="sAddress">
			<input type="button" value="주소검색" id="btnSaddress"><br>
			<label>전화번호</label>
			<input type="text" name="sTel"><br>
			<label>FAX번호</label>
			<input type="text" name="sFax"><br>
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>