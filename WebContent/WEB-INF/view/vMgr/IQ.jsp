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
	<h1>재고현황 조회</h1>
	<fieldset>
		<label>품목명</label>
		<input type="text"> <button>조회</button>
		<input type="radio" name="iq">전체
		<input type="radio" name="iq">재고과다
		<input type="radio" name="iq">적정재고
		<input type="radio" name="iq">재고부족
	</fieldset>
	<table>
		<tr>
			<td>품목명</td>
			<td>공급회사명</td>
			<td>재고수량</td>
			<td>판매가격</td>
			<td>공급가격</td>
			<td>재고평가</td>
		</tr>
		<tr>
			<td>window 10 pro</td>
			<td>마이크로소프트</td>
			<td>0</td>
			<td>300,000</td>
			<td>240,000</td>
			<td>재고부족</td>
		</tr>
		<tr>
			<td>window 10 pro</td>
			<td>마이크로소프트</td>
			<td>0</td>
			<td>300,000</td>
			<td>240,000</td>
			<td>재고부족</td>
		</tr>
		<tr>
			<td>window 10 pro</td>
			<td>마이크로소프트</td>
			<td>0</td>
			<td>300,000</td>
			<td>240,000</td>
			<td>재고부족</td>
		</tr>
	</table>
</body>
</html>