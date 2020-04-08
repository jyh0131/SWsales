<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<style>
/** form 타이틀 **/
div#title {
	width: 100%;
	height: 200px;
	line-height: 100px;
	margin-top: 50px;
	background: url("${pageContext.request.contextPath}/images/title/soTitle.png") no-repeat;
	background-size: 100%, 200px;
}

div#title h1 {
	font-size: 40px;
	letter-spacing: 8px;
	padding-left: 60px;
}

div#title h3 {
	letter-spacing: 3px;
	padding-left: 60px;
}

span#k_title {
	color: red;
	background-color: white;
}

#search {
	margin: 10px;
	position: relative;
}

#lblSearch {
	width: 70px;
	height: 39px;
	display: inline-block;
	background-color: #ccc;
	line-height: 35px;
	text-align: center;
	margin-left: -10px;
	margin-right: -6px;
}

#selSearch {
	width: 150px;
	height: 36px;
	margin-left: -10px;
}

#ipSearch {
	width: 200px;
	height: 32px;
	margin-top: 2px;
}

#btnSearch {
	width: 60px;
	height: 36px;
	background-color: #384D75;
	border: 1px solid white;
	color: white;
	border-radius: 5px;
}

#btnClear {
	width: 60px;
	height: 36px;
	background-color: #ccc;
	border: 1px solid white;
	color: white;
	border-radius: 5px;
}

#btnAll {
	width: 60px;
	height: 36px;
	background-color: #ccc;
	border: 1px solid white;
	color: white;
	border-radius: 5px;
	position: absolute;
	right: 0;
}

#list_container {
	width: 100%;
	margin: 0 auto;
	padding-top: 100px;
	position: relative;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table tr:nth-child(2n+1) {
	background: #F9FAFB;
}

table tr:nth-child(2n) {
	background: #eee;
}

th, td {
	border: 1px solid #ccc;
	text-align: center;
	height: 46px;
}

th {
	border-top: 2px solid #878787;
	background-color: #F9FAFB;
	font-size: 17px;
}

tr.tbl_point:hover {
	background: black;
	color: red;
}

#btnAdd {
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

span#y {
	font-weight: bold;
	color: blue;
}

.n {
	font-weight: bold;
	color: red;
}
	div#bottom_btns{
		width: 100%;
		height: 50px;
		margin-top: 30px;
	}
	input#btnTop{
		width: 50px;
		height: 50px;
		border: 1px solid #eee;
		position: absolute;
		right: 0; 		
	}	
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {

		$("#btnTop").click(function() {
			location.href = "orderNYList.do";
		})
	});
</script>

<section>
	<div id="title">
		<h1>Confirm Order Of Customer</h1>
		<hr>
		<h3>
			주문관리 > <span id="k_title">주문 확인 / 처리</span>
		</h3>
	</div>
	<div id="list_container">
<!-- 		<form action="orderSearch.do" method="post">
			<div id="search">
				<select id="selSearch" name="selSearch">
					<option selected>선택해주세요</option>
					<option value="pName">품목명</option>
					<option value="pCno">고객 상호명</option>
				</select> <input type="text" name="search" id="ipSearch"> <input
					type="submit" value="검색" id="btnSearch"> <input
					type="reset" value="초기화" id="btnClear"> <input
					type="button" value="전체" id="btnAll">
			</div>
		</form> -->
		<table id="tbl">
			<tr>
				<th>주문번호</th>
				<th>주문일자</th>
				<th>고객상호명</th>
				<th>품목명</th>
				<th>주문수량</th>
				<th>주문요구사항</th>
				<th>입금여부</th>
				<th>주문완료</th>
				<th>주문담당자</th>
			</tr>
			<c:forEach var="Order" items="${list }">
					<td class="tbl_point"><c:choose>
							<c:when test="${Order.oNo < 10 }">
									O000${Order.oNo }
								</c:when>
							<c:when test="${Order.oNo >= 10 }">
									O00${Order.oNo }
								</c:when>
						</c:choose></td>
					<td><fmt:formatDate value="${Order.oDate}" type="both"
							pattern="yyyy-MM-dd" /></td>
					<td>${Order.oCname.cName}</td>
					<td>${Order.oPname.pName}</td>
					<td>${Order.oQty}</td>
					<td>${Order.oMemo}</td>
					
					<td><c:if test="${Order.oDps == 1}">
							<input type="checkbox" checked>
						</c:if> <c:if test="${Order.oDps == 0}">
							<input type="checkbox">
						</c:if></td>
					<td><c:if test="${Order.oOk == '1'}">
							<span id="y">Y</span>
						</c:if> <c:if test="${Order.oOk == '0'}">
							<span class="n">N</span>
						</c:if></td>
					<td>${Order.oEname.empName},EE00${Order.oEno.empNo}</td>
					<%-- 						<td>
							${SupplierOrder.soSname.sName}
							<c:choose>
								<c:when test="${SupplierOrder.soSname.sNo < 10 }">
									(S000${SupplierOrder.soSname.sNo })
								</c:when>
								<c:when test="${SupplierOrder.soSname.sNo >= 10 }">
									(S00${SupplierOrder.soSname.sNo })
								</c:when>
							</c:choose>
						</td>
						<td><fmt:formatNumber value="${SupplierOrder.soPcost.pCost}" pattern="\#,###.##"/></td>
						<td>${SupplierOrder.soQty}개</td>
						<td><fmt:formatDate value="${SupplierOrder.soDate}" type="both" pattern="yyyy-MM-dd"/></td>	
						<td>
							<a href="#"><button>수정</button></a>
							<a href="#"><button>삭제</button></a>
						</td> --%>
				</tr>
			</c:forEach>
		</table>
		<div id="bottom_btns">
				<input type="image" src="${pageContext.request.contextPath}/images/main/ico_topList.png" id="btnTop">
			</div>			
		</div>			
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
