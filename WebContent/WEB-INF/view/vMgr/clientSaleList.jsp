<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>
<style>
	/** form 타이틀 **/
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/title/vTitle.png") no-repeat;
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
		margin-top: 50px;
	}

	fieldset{
		padding:3px 10px;
		margin:10px 0;
		font-size: 17px;
		height:38px;
		line-height: 38px;
		border:none;
	}
	#Search{
		width: 60px;
		height: 36px;
		background-color: #384D75;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#All{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		right: 0;
	}
	fieldset input{
		height:25px;
	}
	table{
		border-collapse: collapse;
		width:100%;
		text-align: center;
		height: 46px;
	}
	th, td{
		border: 1px solid #ccc;
		height: 46px;
	}
	th{
		border-top: 3px solid #747474;/* #878787; */
		border-bottom: 5px double #747474;/* #878787; */
		background-color: #BDBDBD;/* #F9FAFB; */
		font-size: 17px;
		height: 55px;
	}
	tr:nth-child(even){
		background-color: #eee;
	}
	tr:nth-child(odd){
		background-color: #F9FAFB;
	}
	tr.tbl_point:hover{
		background: #5D5D5D;
		color: yellow;
	}
	.price{
		text-align: right;
	}
	.total{
		text-align: right;
	}
	.total input{
		text-align: right;
		font-size: 20px;
		width:200px;
		margin:15px 0 0 5px;
		background-color:#FFFFFF;
		border:2px solid #384D75;
		padding-right:8px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function (){
		$("#All").click(function(){
			location.href="clientSale.do";
		})
	});
</script>
<section>
	<div id="title">
		<h1>Sales By Customer</h1>
		<hr>
		<h3>현황조회 / 보고 > <span id="k_title">고객별 판매현황 조회</span></h3>
	</div>
	<div id="list_container">
		<form action="csSearch.do" method="post">
			<fieldset>
				<label>고 객 상 호 명</label>
				<input type="text" name="clientSearch">
				<input type="submit" value="조회" id="Search" style="cursor:pointer">
				<input type="button" value="전체" id="All" style="cursor:pointer">
			</fieldset>
			<table>
				<tr>
					<th>고객상호명</th>
					<th>품목명</th>
					<th>수량</th>
					<th>입금여부</th>
					<th>판매가격</th>
					<th>매출금</th>
					<th>미수금</th>
				</tr>
				<c:forEach var="cs" items="${list }">
						<tr class="tbl_point">
							<td>${cs.c_name }</td>
							<td>${cs.p_name }</td>
							<td>${cs.o_qty }</td>
							<td>${cs.o_dps }</td>
							<td class="price"><fmt:formatNumber value="${cs.p_price}" pattern="#,###,###"/>　</td>
							<td class="price"><fmt:formatNumber value="${cs.salesMoney }" pattern="#,###,###"/>　</td>
							<td class="price"><fmt:formatNumber value="${cs.uncollected }" pattern="#,###,###"/>　</td>
							<c:set var="sum1" value="${sum1 + cs.salesMoney }"/>
							<c:set var="sum2" value="${sum2 + cs.uncollected }"/>
						</tr>
				</c:forEach>
			</table>
			<fieldset class="total">
				<label>총 매출금</label>
				<input type="text" value=<fmt:formatNumber value="${sum1}" pattern="#,###,###"/> readonly>
				<label>총 미수금</label>
				<input type="text" value=<fmt:formatNumber value="${sum2}" pattern="#,###,###"/> readonly>
			</fieldset>
		</form>
	</div>
</section>
<%@include file="../include/footer.jsp"%>