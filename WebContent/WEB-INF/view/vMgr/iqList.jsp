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
	#Excessive{
		width: 80px;
		height: 36px;
		background-color: #F29661;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		right: 0;
	}
	#Moderate{
		width: 80px;
		height: 36px;
		background-color: #F29661;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		right: 0;
	}
	#Shortage{
		width: 80px;
		height: 36px;
		background-color: #F29661;
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function (){
		$("#All").click(function(){
			location.href="iq.do";
		})
		$("#Excessive").click(function(){
			location.href="iqExcessive.do";
		})
		$("#Moderate").click(function(){
			location.href="iqModerate.do";
		})
		$("#Shortage").click(function(){
			location.href="iqShortage.do";
		})
	});
</script>
</head>
<body>
	<form action="iqSearch.do" method="post">
	<div id="title">
		<h1>Supplier List</h1>
		<hr>
		<h3>현황조회 / 보고 > <span id="k_title">재고현황 조회</span></h3>
	</div>
	<div id="list_container">
		<fieldset>
			<label>품 목 명</label>
			<input type="text" name="iqSearch">
			<input type="submit" value="조회" id="Search" style="cursor:pointer">
			<input type="button" value="전체" id="All" style="cursor:pointer">
			<input type="button" value="재고과다" id="Excessive" style="cursor:pointer">
			<input type="button" value="적정재고" id="Moderate" style="cursor:pointer">
			<input type="button" value="재고부족" id="Shortage" style="cursor:pointer">
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
	</div>
	</form>
<%@include file="../include/footer.jsp"%>