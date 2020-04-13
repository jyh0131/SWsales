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
	span#k_title{
		color: red;
		background-color: white;
	}	
	div#list_container{
		margin-top: 100px;
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
	#container{
		width: 60%;
		margin: 0 auto;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		
		$("#btnTop").click(function() {
			location.href="clientDeliveryList.do";
		})
		
		$(".btnDel").click(function() {
			var no = $(this).attr("data-cdNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/product/cDeliveryDel.do?cdNo="+no;
			}
		})
	});
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Client Delivery List</h1>
			<hr>
			<h3>제품 관리 > 출고 > <span id="k_title">출고 리스트</span></h3>
		</div>
		<div id="list_container">
<!-- 			<form action="clientDeliverySearch.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="pName">품목명</option>
						<option value="pCno">고객 상호명</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch">
					<input type="reset" value="초기화" id="btnClear">
					<input type="button" value="전체" id="btnAll">
				</div>
			</form> -->
			<table id="tbl">
				<tr>
					<th>출고번호</th>
					<th>고객 상호명</th>
					<th>품목명</th>
					<th>출고수량</th>
					<th>출고일자</th>
					<th>수정/삭제</th>
				</tr>
 				<c:forEach var="clientDelivery" items="${list }">
					<tr class="tbl_point">
 						<td class="tbl_point">
	 						<c:choose>
								<c:when test="${clientDelivery.cdNo < 10 }">
									CD000${clientDelivery.cdNo }
								</c:when>
								<c:when test="${clientDelivery.cdNo >= 10 }">
									CD00${clientDelivery.cdNo }
								</c:when>
							</c:choose> 
						</td>
					
						<td>${clientDelivery.cName.cName }</td>
						<td>${clientDelivery.pName }</td>
						<td>${clientDelivery.cdSno.oQty }</td>
						<td><fmt:formatDate value="${clientDelivery.cdDate }" type="both" pattern="yyyy-MM-dd"/></td> <!-- yyyy-MM-dd(E) -->	
						<td>
							<a href="${pageContext.request.contextPath}/product/cDeliveryMod.do?cdNo=${clientDelivery.cdNo}"><button id="btnMod">수정</button></a>
							<button class="btnDel" style="cursor: pointer" data-cdNo="${clientDelivery.cdNo }">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="bottom_btns">
				<input type="image" src="${pageContext.request.contextPath}/images/main/ico_topList.png" id="btnTop">
			</div>
		</div>			
		</div>		
</section>		
<%@ include file="../include/footer.jsp" %>    