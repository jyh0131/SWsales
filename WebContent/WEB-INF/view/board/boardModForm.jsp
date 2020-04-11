<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/main/formtest.png") no-repeat;
		background-size: 100%, 200px;
	}
	div#title h1{
		font-size: 40px;
		letter-spacing: 8px;
		padding-left: 60px;
	}
	div#title h3{
		letter-spacing: 3px;
		padding-left: 60px;
	}
	span#k_title{
		color: red;
		background-color: white;
	}	
	#regForm{
		width: 65%;
		margin: 0 auto;
		border-top: 2px solid #878787;
		border-bottom: 1px solid #ccc;
		padding-top: 30px;
		padding-bottom: 30px;
		margin-top: 40px;
	}
	#form{
		width: 80%;
		margin: 0 auto;
	}
	label{
		width: 150px;
		float: left;
		line-height: 40px;
    	font-weight: bold;
    	font-size: 14px;
	}
	.text{
		margin-bottom: 30px;
		width: 505px;
    	height: 40px;
    	margin-right: 20px;
	}
	#add{
		width: 65%;
		margin: 0 auto;
		text-align: center;
	}
	#btnMod{
		width: 160px;
   		height: 45px;
    	background-color: #384D75;
   		color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	margin-top: 30px;
    	font-size: 18px;
	}
	#btnReset{
		width: 160px;
   		height: 45px;
    	background-color: #bbb;
   		color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	margin-top: 30px;
    	font-size: 18px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		$("#btnReset").click(function() {
			location.href="${pageContext.request.contextPath}/board/boardList.do"
		})		
	})
</script>
	<section>
		<div id="title">
			<h1>Notice Modify</h1>
			<hr>
			<h3>공지사항  > <span id="k_title">공지사항 수정</span></h3>
		</div>
		<form action="${pageContext.request.contextPath}/board/boardMod.do" method="post">
			<div id="regForm">
				<div id="form">
					<label>제목</label>
					<input type="text" name="bTitle" class="text" placeholder="제목을 입력해주세요" value="${board.bTitle }"><br>
					
					<label>작성자</label>
					<input type="text" name="bName" class="text" value="${board.bName }" readonly><br>
					<input type="hidden" name="bNo" value="${board.bNo }">
					<input type="hidden" name="bReadCnt" value="${board.bReadCnt }">
					
					<label>내용</label>
					<textarea rows="10" cols="70" placeholder="내용을 입력해주세요" name="bContent">${board.content }</textarea><br>
				</div>
			</div>
			<div id="add">
				<input type="submit" value="수정" id="btnMod" style="cursor: pointer">
				<input type="button" value="취소" id="btnReset" style="cursor: pointer">
			</div>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>