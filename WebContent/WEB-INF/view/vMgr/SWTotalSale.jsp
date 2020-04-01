<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>S/W 전체 판매현황</h1>
	<table>
		<tr>
			<td>날짜</td>
			<td>분류</td>
			<td>품목명</td>
			<td>주문번호</td>
			<td>주문수량</td>
			<td>판매금액</td>
		</tr>
		<tr>
			<td>2020-01</td>
			<td>개발</td>
			<td>DEXTUpload Pro</td>
			<td>O0016</td>
			<td>25</td>
			<td class="price">13,200,000</td>
		</tr>
		<tr>
			<td>2020-01</td>
			<td>개발</td>
			<td>DEXTUpload Pro</td>
			<td>O0016</td>
			<td>25</td>
			<td class="price">13,200,000</td>
		</tr>
		<tr>
			<td>2020-01</td>
			<td>개발</td>
			<td>DEXTUpload Pro</td>
			<td>O0016</td>
			<td>25</td>
			<td class="price">13,200,000</td>
		</tr>
	</table>
	<fieldset class="total">
		<label>총 판매금액</label>
		<input type="text">
	</fieldset>
</body>
</html>