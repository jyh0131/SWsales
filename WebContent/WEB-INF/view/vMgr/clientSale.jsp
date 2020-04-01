<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		text-align: center;
	}
	table{
		border: 1px solid black;
		border-collapse: collapse;
		width:1000px;
		text-align: center;
	}
	td{
		border: 1px solid black;
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
	<h1>고객별 판매현황 조회</h1>
	<fieldset>
		<label>고객상호명</label>
		<input type="text"> <button>조회</button>
		<input type="checkbox">전체
	</fieldset>
	<table>
		<tr>
			<td>고객상호명</td>
			<td>품목명</td>
			<td>수량</td>
			<td>입금여부</td>
			<td>판매가격</td>
			<td>매출금</td>
			<td>미수금</td>
		</tr>
		<c:forEach var="cs" items="${list }">
			<tr>
				<td>
					${cs.c_name }
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>민수시스템</td>
			<td>V3VirusWall FileScan for Linux</td>
			<td>75</td>
			<td>Y</td>
			<td class="price">1,579,000</td>
			<td class="price">118,425,000</td>
			<td class="price">0</td>
		</tr>
		<tr>
			<td>민수시스템</td>
			<td>V3VirusWall FileScan for Linux</td>
			<td>75</td>
			<td>Y</td>
			<td class="price">1,579,000</td>
			<td class="price">118,425,000</td>
			<td class="price">0</td>
		</tr>
	</table>
	<fieldset class="total">
		<label>총 매출금</label>
		<input type="text">
		<label>총 미수금</label>
		<input type="text">
	</fieldset>
</body>
</html>