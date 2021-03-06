<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>
<style>
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/title/nTitle.png") no-repeat;
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
	#contain{
		width: 70%;
		margin: 0 auto;
		margin-top: 40px;
	}
	#formDiv{
		position: relative;
		margin-bottom: 10px;
		margin-left: 906px;
	}
	#inpSearch{
		width: 140px;
    	height: 34px;
    	border: 1px solid white;
	    border-bottom: 1px solid #ccc;
	    background-image: url("${pageContext.request.contextPath}/images/board/ico_search.png");
	    background-size:10%;
	    background-position: left;
	    background-repeat: no-repeat;
	    padding-left: 25px;
    	font-size: 16px;
	}
	#btnSearch{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		position: absolute;
		right: 0;
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
	th{
		border-top: 2px solid #878787;
		background-color: #F9FAFB;
	}
	th:first-child {
		width: 10%;
	}
	th:nth-child(2) {
		width: 52%;
	}
	th:nth-child(3) {
		width: 10%;
	}
	#tblDiv{
		position: relative;
		margin-bottom: 80px;
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
	#bTitle{
		text-decoration: none;
		color: black;
	}
	#secTd{
		text-align: left;
	}
</style>
<section>
	<div id="title">
		<h1>Notice List</h1>
		<hr>
		<h3>공지사항</h3>
	</div>
	<div id="contain">
		<div id="formDiv">
			<form action="${pageContext.request.contextPath}/board/boardSelect.do" method="get">
				<input type="text" name="inpSearch" id="inpSearch">
				<input type="submit" value="검색" id="btnSearch" style="cursor: pointer">
			</form>
		</div>
		<div id="tblDiv">
			<table id="tblBoard">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bNo }</td>
						<td id="secTd"><a href="${pageContext.request.contextPath}/board/boardDetail.do?no=${board.bNo }&readCnt=${board.bReadCnt}" id="bTitle">${board.bTitle }</a></td>
						<td>${board.bName }</td>
						<td>${board.bReadCnt }</td>
						<td><fmt:formatDate value="${board.bRegDate }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${Auth.empManager == 1 }">
				<a href="${pageContext.request.contextPath}/board/boardAdd.do"><button id="btnAdd" style="cursor: pointer">등 록</button></a>
			</c:if>
			<jsp:include page="../paging/boardPaging.jsp">
				<jsp:param value="${paging.page}" name="page" />
				<jsp:param value="${paging.beginPage}" name="beginPage" />
				<jsp:param value="${paging.endPage}" name="endPage" />
				<jsp:param value="${paging.prev}" name="prev" />
				<jsp:param value="${paging.next}" name="next" />
			</jsp:include>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>