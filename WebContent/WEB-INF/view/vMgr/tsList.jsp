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
	#menu{
		margin-top:40px;
		margin-left:10px;
	}
	.btnMenu{
		width: 150px;
		height: 36px;
		background-color: #A6A6A6;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		margin:0 1px;
		margin-bottom:10px;
	}
	fieldset{
		padding:3px 10px;
		margin:10px 0;
		font-size: 20px;
		height:38px;
		line-height: 38px;
		border:none;
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
<section>
	<div id="title">
		<h1>Transaction Specification</h1>
		<hr>
		<h3>현황조회 / 보고 > <span id="k_title">거래명세</span></h3>
	</div>
	<div id="list_container">
		<div id="menu">
			<a href="${pageContext.request.contextPath}/vMgr/swTotalSale.do"><button class="btnMenu">S/W 전체 판매현황</button></a>
			<a href="${pageContext.request.contextPath}/vMgr/ts.do"><button class="btnMenu">거래명세</button></a>
		</div>
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
	</div>
</section>	
<%@include file="../include/footer.jsp"%>