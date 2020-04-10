<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>
<style>	
	/** form 타이틀 **/
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
	#list_container{
		width: 100%;
		margin: 0 auto;
		padding-top: 100px;
		position: relative;
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
   td button{
      border-radius: 5px;
      outline: none;
      border: none;
      color: white;
      padding: 6px;
      font-weight: bold;
   }
   td button#btnMod{
      background: #87cefa;
   }
    td button.btnDel{
      background: #f08080;
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
	span#cost{
		color: blue;
		font-size: 14px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		//Top버튼
		$("#btnTop").click(function() {
			location.href="supplierOrderList1.do";
		})
		
		//삭제버튼
		$(".btnDel").click(function() {
			var no = $(this).attr("data-soNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/product/supplierOrderDel1.do?no="+no;
			}
		})
	});
</script>

	<section>
		<div id="title">
			<h1>Software Product Order List</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/soSubMenu.do">발주/매입</a> > <span id="k_title">발주 이력 리스트</span></h3>
		</div>
		<div id="list_container">
<!-- 			<form action="supplierOrder1Search.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="pName">품목명</option>
						<option value="pSno">공급회사명</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch">
					<input type="reset" value="초기화" id="btnClear">
					<input type="button" value="전체" id="btnAll">
				</div>
			</form> -->
			<table id="tbl">
				<tr id="tbl_title">
					<th>발주번호</th>
					<th>품목명</th>
					<th>공급회사명</th>
					<th>발주가격<br>
						<span id="cost">(공급가격-1개당)</span></th>
					<th>발주수량</th>
					<th>발주일자</th>
					<th>수정/삭제</th>
				</tr>
				<c:forEach var="SupplierOrder" items="${list }">
					<tr class="tbl_point">
						<td class="tbl_point">
							<c:choose>
								<c:when test="${SupplierOrder.soNo < 10 }">
									SO000${SupplierOrder.soNo }
								</c:when>
								<c:when test="${SupplierOrder.soNo >= 10 }">
									SO00${SupplierOrder.soNo }
								</c:when>
							</c:choose>
						</td>
						<td>${SupplierOrder.soPname.pName}</td>
						<td>
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
							<a href="#"><button id="btnMod" style="cursor: pointer">수정</button></a>
							<button class="btnDel" style="cursor: pointer" data-soNo="${SupplierOrder.soNo }">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="bottom_btns">
				<input type="image" src="${pageContext.request.contextPath}/images/main/ico_topList.png" id="btnTop">
			</div>
		</div>
</section>		
<%@ include file="../include/footer.jsp" %>    