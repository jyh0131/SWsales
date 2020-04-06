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
	#Search{
		width: 60px;
		height: 36px;
		background-color: #384D75;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
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
</head>
<body>
	<h1>재고현황 조회</h1>
	<fieldset>
		<label>품목명</label>
		<input type="text" name="iqSearch">
		<input type="submit" value="조회" id="Search" style="cursor:pointer">
		<input type="radio" name="radio" checked="checked">전체
		<input type="radio" name="radio">재고과다
		<input type="radio" name="radio">적정재고
		<input type="radio" name="radio">재고부족
	</fieldset>
	<table>
		<tr>
			<th>품목명</th>
			<th>공급회사명</th>
			<th>재고수량</th>
			<th>판매가격</th>
			<th>공급가격</th>
			<th>재고평가</th>
		</tr>
		<c:forEach var="iq" items="${list }">
				<tr>
					<td>${iq.p_name }</td>
					<td>${iq.s_name }</td>
					<td>${iq.iq_qty }</td>
					<td class="price"><fmt:formatNumber value="${iq.p_price}" pattern="#,###,###"/>　</td>
					<td class="price"><fmt:formatNumber value="${iq.p_cost }" pattern="#,###,###"/>　</td>
					<td>${iq.evaluation }</td>
				</tr>
			</c:forEach>
	</table>
<%@include file="../include/footer.jsp"%>