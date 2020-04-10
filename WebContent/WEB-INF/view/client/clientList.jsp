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
		background: url("${pageContext.request.contextPath}/images/title/csTitle.png") no-repeat;
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
	div#title h3 a{
		text-decoration: none;
		color: black;
	}
	div#title h3 a:hover{
		border-bottom: 3px solid black;
	}
	span#k_title{
		color: red;
		background-color: white;
	}
	#search{
		margin: 10px;
		position: relative;
	}
	#lblSearch{
		width: 70px;
   		height: 39px;
    	display: inline-block;
    	background-color: #ccc;
    	line-height: 35px;
    	text-align: center;
    	margin-left: -10px;
    	margin-right: -6px;
	}
	#selSearch{
		width: 150px;
    	height: 36px;
   		margin-left: -10px;
	}
	#ipSearch{
		width: 200px;
    	height: 32px;
    	margin-top: 2px;
	}
	#btnSearch{
		width: 60px;
		height: 36px;
		background-color: #384D75;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#btnClear{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#btnAll{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		position: absolute;
		right: 0;
	}
	#list_container{
		position: relative;
		margin-top: 100px;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	table tr:nth-child(2n+1){
		background: #F9FAFB;
	}
	table tr:nth-child(2n){
		background: #eee;
	}
	th, td{
		border: 1px solid #ccc;
		text-align: center;
		height: 46px;
	}
	th{
		border-top: 2px solid #878787;
		background-color: #F9FAFB;
		font-size: 17px;
	}
	tr.tbl_point:hover{
		background: #5D5D5D;
		color: yellow;
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
	.btnMod {
		color: white;
		border: 1px white;
		background-color: #87cefa;
		width: 40px;
    	height: 30px;
    	border-radius: 5px;
	}
	.btnDel {
		color: white;
		border: 1px white;
		background-color: #f08080;
		width: 40px;
    	height: 30px;
    	border-radius: 5px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		$("#btnAll").click(function() {
			location.href="clientList.do";
		})
		
		$(".btnDel").click(function() {
			var no = $(this).attr("data-cNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/client/clientDel.do?no="+no;
			}
		})
	});
</script>

	<section>
		<div id="title">
			<h1>Client List</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/client/cSubMenu.do">거래처 관리</a> > <span id="k_title">고객사 리스트</span></h3>
		</div>
		<div id="list_container">
			<form action="clientSearch.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="cName">상호명</option>
						<option value="cCeo">대표명</option>
						<option value="cTel">전화번호</option>
						<option value="cSman">담당직원</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch" style="cursor: pointer">
					<input type="reset" value="초기화" id="btnClear" style="cursor: pointer">
					<input type="button" value="전체" id="btnAll" style="cursor: pointer">
				</div>
			</form>
			<table id="tbl">
				<tr>
					<th style="width: 150px;">고객번호</th>
					<th style="width: 200px;">상호명</th>
					<th style="width: 150px;">대표명</th>
					<th style="width: 600px;">주 소</th>
					<th style="width: 190px;">전화번호</th>
					<th style="width: 150px;">담당직원</th>
					<th style="width: 150px;">수정/삭제</th>
				</tr>
				<c:forEach var="client" items="${list }">
					<tr class="tbl_point">
 						<td class="tbl_point">
							<c:choose>
								<c:when test="${client.cNo < 10 }">
									C000${client.cNo }
								</c:when>
								<c:when test="${client.cNo >= 10 }">
									C00${client.cNo }
								</c:when>
							</c:choose>
						</td>
						<td>${client.cName }</td>
						<td>${client.cCeo }</td>
						<td>${client.cAddress }</td>
						<td>${client.cTel }</td>
						<td>${client.cSman }</td>
						<td>
							<a href="${pageContext.request.contextPath}/client/clientMod.do?no=${client.cNo}"><button class="btnMod" style="cursor: pointer">수정</button></a>
							<button class="btnDel" style="cursor: pointer" data-cNo="${client.cNo }">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<jsp:include page="../paging/clientPaging.jsp">
				<jsp:param value="${paging.page}" name="page" />
				<jsp:param value="${paging.beginPage}" name="beginPage" />
				<jsp:param value="${paging.endPage}" name="endPage" />
				<jsp:param value="${paging.prev}" name="prev" />
				<jsp:param value="${paging.next}" name="next" />
			</jsp:include>
		</div>
	</section>
<%@ include file="../include/footer.jsp" %>