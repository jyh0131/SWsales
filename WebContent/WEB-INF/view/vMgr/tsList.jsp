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
	<h1>거래명세</h1>
	<table>
		<tr>
			<td>공급회사명</td>
			<td>주문일자</td>
			<td>고객상호명</td>
			<td>품목명</td>
			<td>수량</td>
			<td>단가</td>
			<td>금액</td>
			<td>세금</td>
			<td>총납품금액</td>
		</tr>
		<tr>
			<td>가가플러스</td>
			<td>2020-01-28</td>
			<td>경기도 교육청</td>
			<td>Popmaker</td>
			<td>2</td>
			<td class="price">44,000</td>
			<td class="price">88,000</td>
			<td class="price">8,800</td>
			<td class="price">96,800</td>
		</tr>
		<tr>
			<td>가가플러스</td>
			<td>2020-01-28</td>
			<td>경기도 교육청</td>
			<td>Popmaker</td>
			<td>2</td>
			<td class="price">44,000</td>
			<td class="price">88,000</td>
			<td class="price">8,800</td>
			<td class="price">96,800</td>
		</tr>
		<tr>
			<td>가가플러스</td>
			<td>2020-01-28</td>
			<td>경기도 교육청</td>
			<td>Popmaker</td>
			<td>2</td>
			<td class="price">44,000</td>
			<td class="price">88,000</td>
			<td class="price">8,800</td>
			<td class="price">96,800</td>
		</tr>
	</table>
	<fieldset class="total">
		<label>총 납품금액</label>
		<input type="text">
	</fieldset>
</body>
</html>