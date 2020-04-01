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
		<tr>
			<td>windows 10 pro</td>
			<td>사무</td>
			<td>마이크로소프트</td>
			<td class="price">11,520,000</td>
			<td class="price">14,400,000</td>
			<td class="price">0</td>
			<td class="price">2,880,000</td>
		</tr>
		<tr>
			<td>windows 10 pro</td>
			<td>사무</td>
			<td>마이크로소프트</td>
			<td class="price">11,520,000</td>
			<td class="price">14,400,000</td>
			<td class="price">0</td>
			<td class="price">2,880,000</td>
		</tr>
		<tr>
			<td>windows 10 pro</td>
			<td>사무</td>
			<td>마이크로소프트</td>
			<td class="price">11,520,000</td>
			<td class="price">14,400,000</td>
			<td class="price">0</td>
			<td class="price">2,880,000</td>
		</tr>
	</table>
	<fieldset class="total">
		<label>총 판매금액</label>
		<input type="text">
		<label>총 판매이윤</label>
		<input type="text">
	</fieldset>
</body>
</html>