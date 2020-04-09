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
	#contain{
		width: 50%;
		margin: 0 auto;
		margin-top: 40px;
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
		background-color: #F6F6F7;
	}
	#ATitle{
		border-top: 2px solid #878787;
	}
	#boardTitle{
		text-align: left;
		padding-left: 15px;
	}
	#AContent{
		height: 300px;
		text-align: left;
	}
	#tblDiv{
		position: relative;
		margin-bottom: 80px;
	}
	#btnMod{
		width: 60px;
		height: 40px;
		background-color: #384D75;
		color: white;
		margin: 10px 0;
    	position: absolute;
    	right: 130px;
		border: 1px solid white;
		border-radius: 5px;
	}
	#btnDel{
		width: 60px;
		height: 40px;
		background-color: #384D75;
		color: white;
		margin: 10px 0;
    	position: absolute;
    	right: 65px;
		border: 1px solid white;
		border-radius: 5px;
	}
	#btnList{
		width: 60px;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		$("#btnDel").click(function() {
			var no = $(this).attr("data-bNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/board/boardDel.do?no="+no;
			}
		})
	});
</script>
<section>
	<div id="title">
			<h1>Notice List</h1>
			<hr>
			<h3>공지사항</h3>
		</div>
	<div id="contain">
		<div id="tblDiv">
			<table id="tblBoard">
				<tr id="ATitle">
					<th>제목</th>
					<td colspan="3" id="boardTitle">${board.bTitle }</td>
				</tr>
				<tr>
					<th>부서명</th>
					<td style="width: 240px">${board.bDept }</td>
					<th>등록일</th>
					<td style="width: 240px"><fmt:formatDate value="${board.bRegDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${board.bName }</td>
					<th>조회수</th>
					<td>${board.bReadCnt }</td>
				</tr>
				<tr>
					<th colspan="4">글내용</th>
				</tr>
				<tr>
					<td colspan="4" id="AContent"><pre style="padding-left: 30px;">${board.content }</pre></td>
				</tr>
			</table>
			<c:if test="${Auth.empId == board.bId }">
				<a href="${pageContext.request.contextPath}/board/boardMod.do?no=${board.bNo }"><button id="btnMod" style="cursor: pointer">수 정</button></a>
				<button id="btnDel" data-bNo = "${board.bNo }" style="cursor: pointer">삭 제</button>
			</c:if>
			<a href="${pageContext.request.contextPath}/board/boardList.do"><button id="btnList" style="cursor: pointer">목 록</button></a>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>