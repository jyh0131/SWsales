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
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
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
	#contain{
		width: 70%;
		margin: 0 auto;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	th, td{
		border-bottom: 1px solid #ccc;
		text-align: center;
		height: 55px;
	}
	#tblDiv{
		position: relative;
	}
	#btnAdd{
		width: 130px;
		height: 40px;
		background-color: #384D75;
		color: white;
		margin: 10px 0;
    	position: absolute;
    	right: 0;
		border: 1px solid white;
		border-radius: 5px;
	}
</style>
<section>
	<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/main/test1.png">
	</div>
	<div id="title">
			<h1>Notice List</h1>
			<hr>
			<h3>공지사항</h3>
		</div>
	<div id="contain">
		<div id="tblDiv">
			<table id="tblBoard">
				<tr>
					<th>제목</th>
					<td>${board.bTitle }</td>
				</tr>
				<tr>
					<th>부서명</th>
					<td>${board.bDept }</td>
					<th>등록일</th>
					<td>${board.bRegDate }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${board.bName }</td>
					<th>조회수</th>
					<td>${board.bReadCnt }</td>
				</tr>
				<tr>
					<th>글내용</th>
				</tr>
				<tr>
					<td>${board.content }</td>
				</tr>
			</table>
			<a href="${pageContext.request.contextPath}/board/boardAdd.do"><button id="btnAdd" style="cursor: pointer">등 록</button></a>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>