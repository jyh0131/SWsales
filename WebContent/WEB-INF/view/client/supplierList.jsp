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
		margin-bottom: 60px;
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
		border-top: 3px solid #747474;/* #878787; */
		border-bottom: 5px double #747474;/* #878787; */
		background-color: #BDBDBD;/* #F9FAFB; */
		font-size: 17px;
		height: 55px;
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
			location.href="supplierList.do";
		})
		
		$(".btnDel").click(function() {
			var no = $(this).attr("data-sNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/client/supplierDel.do?no="+no;
			}
		})
	});
</script>

	<section>
		<div id="title">
			<h1>Supplier List</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/client/cSubMenu.do">거래처 관리</a> > <span id="k_title">&nbsp;공급회사 리스트&nbsp;</span></h3>
		</div>		
		<div id="list_container">
			<form action="supplierSearch.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="sName">회사명</option>
						<option value="sBln">사업자등록번호</option>
						<option value="sTel">전화번호</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch" style="cursor: pointer">
					<input type="reset" value="초기화" id="btnClear" style="cursor: pointer">
					<input type="button" value="전체" id="btnAll" style="cursor: pointer">
				</div>
			</form>
			<table id="tbl">
				<tr>
					<th style="width: 150px;">회사번호</th>
					<th style="width: 200px;">회사명</th>
					<th style="width: 210px;">사업자 등록번호</th>
					<th style="width: 600px;">주 소</th>
					<th style="width: 170px;">전화번호</th>
					<th style="width: 170px;">FAX번호</th>
					<th style="width: 150px;">수정/삭제</th>
				</tr>
				<c:forEach var="supplier" items="${list }">
					<tr class="tbl_point">
 						<td class="tbl_point">
							<c:choose>
								<c:when test="${supplier.sNo < 10 }">
									S000${supplier.sNo }
								</c:when>
								<c:when test="${supplier.sNo > 9 && supplier.sNo < 100 }">
									S00${supplier.sNo }
								</c:when>
								<c:when test="${supplier.sNo > 99 && supplier.sNo < 1000}">
									SO0${supplier.sNo }
								</c:when>								
							</c:choose>
						</td>
						<td>${supplier.sName }</td>
						<td>${supplier.sBln }</td>
						<td>${supplier.sAddress }</td>
						<td>${supplier.sTel }</td>
						<td>${supplier.sFax }</td>
						<td>
							<a href="${pageContext.request.contextPath}/client/supplierMod.do?no=${supplier.sNo}"><button class="btnMod" style="cursor: pointer">수정</button></a>
							<button class="btnDel" style="cursor: pointer" data-sNo="${supplier.sNo }">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="${pageContext.request.contextPath}/client/supplierAdd.do"><button id="btnAdd" style="cursor: pointer">등 록</button></a>
			<jsp:include page="../paging/supplierPaging.jsp">
				<jsp:param value="${paging.page}" name="page" />
				<jsp:param value="${paging.beginPage}" name="beginPage" />
				<jsp:param value="${paging.endPage}" name="endPage" />
				<jsp:param value="${paging.prev}" name="prev" />
				<jsp:param value="${paging.next}" name="next" />
			</jsp:include>
		</div>
	</section>
<%@ include file="../include/footer.jsp" %>