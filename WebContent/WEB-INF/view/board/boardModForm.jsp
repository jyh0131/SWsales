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
	#regForm{
		width: 65%;
		margin: 0 auto;
		border-top: 2px solid #878787;
		border-bottom: 1px solid #ccc;
		padding-top: 30px;
		padding-bottom: 30px;
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
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/submenu/pMain.png">
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