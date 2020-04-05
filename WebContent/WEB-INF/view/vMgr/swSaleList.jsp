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
	fieldset button{
		font-size: 18px;
		padding:0 3px;
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
	}
</style>
<section>
	<h1>S/W별 판매현황 조회</h1>
	<fieldset>
		<label>품목명</label>
		<input type="text"> <button>조회</button>
		<input type="checkbox">전체
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
				</tr>
		</c:forEach>
	</table>
	<fieldset class="total">
		<label>총 판매금액</label>
		<input type="text">
		<label>총 판매이윤</label>
		<input type="text">
	</fieldset>
</section>
<%@ include file="../include/footer.jsp" %>