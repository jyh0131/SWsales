<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ include file="../include/header.jsp" %>
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
	div#title h3 a{
		text-decoration: none;
		color:black;
	}
	div#title h3 a:hover{
		border-bottom: 3px solid black;
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
	fieldset input[type="checkbox"]{
		width:20px;
		line-height: 30px;
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
			location.href="swSale.do";
		})
	});
</script>
<section>
	<form action="swSearch.do" method="post">
	<div id="title">
		<h1>Sales By S/W</h1>
		<hr>
		<h3><a href="vSubMenu.do">현황조회 / 보고</a> > <span id="k_title">S/W별 판매현황 조회</span></h3>
	</div>
	<div id="list_container">
			<fieldset>
				<label>품 목 명</label>
				<input type="text" name="swSearch">
				<input type="submit" value="조회" id="Search" style="cursor:pointer">
				<input type="button" value="전체" id="All" style="cursor:pointer">
			</fieldset>
			<table>
				<tr>
					<th>품목명</th>
					<th>분류</th>
					<th>공급회사명</th>
					<th>공급금액</th>
					<th>판매금액</th>
					<th>할인금액</th>
					<th>판매이윤</th>
				</tr>
				<c:forEach var="sw" items="${list }">
						<tr class="tbl_point">
							<td>${sw.p_name }</td>
							<td>${sw.cate_name }</td>
							<td>${sw.s_name }</td>
							<td class="price"><fmt:formatNumber value="${sw.supplyAmount }" pattern="#,###,###"/>　</td>
							<td class="price"><fmt:formatNumber value="${sw.salesAmount }" pattern="#,###,###"/>　</td>
							<td class="price"><fmt:formatNumber value="${sw.discount }" pattern="#,###,###"/>　</td>
							<td class="price"><fmt:formatNumber value="${sw.salesProfit }" pattern="#,###,###"/>　</td>
							<c:set var="sum1" value="${sum1 + sw.salesAmount }"/>
							<c:set var="sum2" value="${sum2 + sw.salesProfit }"/>
						</tr>
				</c:forEach>
			</table>
			<fieldset class="total">
				<label>총 판매금액</label>
				<input type="text" value=<fmt:formatNumber value="${sum1}" pattern="#,###,###"/> readonly>
				<label>총 판매이윤</label>
				<input type="text" value=<fmt:formatNumber value="${sum2}" pattern="#,###,###"/> readonly>
			</fieldset>
		</div>			
		</form>
</section>
<%@ include file="../include/footer.jsp" %>