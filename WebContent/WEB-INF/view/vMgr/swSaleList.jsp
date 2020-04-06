<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ include file="../include/header.jsp" %>
<style>
	h1{
		text-align: center;
		margin:20px 0;
		font-size: 35px;
	}
	fieldset{
		padding:3px 10px;
		margin:10px 0;
		font-size: 20px;
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
		border-top: 2px solid #878787;
		background-color: #F9FAFB;
	}
	tr:nth-child(even){
		background-color: #eee;
	}
	tr:nth-child(odd){
		background-color: #F9FAFB;
	}
	.price{
		text-align: right;
	}
	.total{
		text-align: right;
		font-size: 20px;
	}
	.total input{
		text-align: center;
		font-size: 20px;
		width:200px;
		margin:15px 0 0 5px;
		background-color:#FFFFFF;
		border:2px solid #384D75;
	}
</style>
<section>
	<h1>S/W별 판매현황 조회</h1>
	<fieldset>
		<label>품목명</label>
		<input type="text" name="swSearch">
		<input type="submit" value="조회" id="Search" style="cursor:pointer">
		<input type="button" value="전체" id="All" style="cursor:pointer">
	</fieldset>
	<table>
		<tr>
			<td>품목명</td>
			<td>분류</td>
			<td>공급회사명</td>
			<td>공급금액</td>
			<td>판매금액</td>
			<td>할인금액</td>
			<td>판매이윤</td>
		</tr>
		<c:forEach var="sw" items="${list }">
				<tr>
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
</section>
<%@ include file="../include/footer.jsp" %>