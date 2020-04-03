<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
</style>
<section>
	<h1>S/W 전체 판매현황</h1>
	<table>
		<tr>
			<th>날짜</th>
			<th>분류</th>
			<th>품목명</th>
			<th>주문번호</th>
			<th>주문수량</th>
			<th>판매금액</th>
		</tr>
		<c:forEach var="swTotal" items="${list }">
				<tr>
					<td>${swTotal.o_date }</td>
					<td>${swTotal.cate_name }</td>
					<td>${swTotal.p_name }</td>
					<td>${swTotal.o_no }</td>
					<td>${swTotal.o_qty }</td>
					<td class="price">${swTotal.salesAmount }　</td>
				</tr>
		</c:forEach>
	</table>
	<fieldset class="total">
		<label>총 판매금액</label>
		<input type="text">
	</fieldset>
</section>
<%@include file="../include/footer.jsp"%>