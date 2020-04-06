<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@include file="../include/header.jsp"%>
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
	<h1>거래명세</h1>
	<table>
		<tr>
			<th>공급회사명</th>
			<th>주문일자</th>
			<th>고객상호명</th>
			<th>품목명</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
			<th>세금</th>
			<th>총납품금액</th>
		</tr>
		<c:forEach var="ts" items="${list }">
				<tr>
					<td>${ts.s_name }</td>
					<td>${ts.o_date }</td>
					<td>${ts.c_name }</td>
					<td>${ts.p_name }</td>
					<td>${ts.o_qty }</td>
					<td class="price"><fmt:formatNumber value="${ts.p_price }" pattern="#,###,###"/>　</td>
					<td class="price"><fmt:formatNumber value="${ts.salesAmount }" pattern="#,###,###"/>　</td>
					<td class="price"><fmt:formatNumber value="${ts.tax }" pattern="#,###,###"/>　</td>
					<td class="price"><fmt:formatNumber value="${ts.totalDA }" pattern="#,###,###"/>　</td>
					<c:set var="sum" value="${sum + ts.totalDA }"/>
				</tr>
		</c:forEach>
	</table>
	<fieldset class="total">
		<label>총 납품금액</label>
		<input type="text" value=<fmt:formatNumber value="${sum}" pattern="#,###,###"/> readonly>
	</fieldset>
</section>	
<%@include file="../include/footer.jsp"%>