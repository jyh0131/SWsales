<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Icon trigger</title>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
  <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
  <script>
  $( function() {
    $( "#datepickerStart" ).datepicker({
      showOn: "button",
      buttonImage: "../../images/iconmonstr-calendar-6-240.png",
      buttonImageOnly: true,
      buttonText: "Select date"
    });
    
    $( "#datepickerEnd" ).datepicker({
      showOn: "button",
      buttonImage: "../../images/iconmonstr-calendar-6-240.png",
      buttonImageOnly: true,
      buttonText: "Select date"
    });
  } );
  </script>
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
	<h1>날짜별 판매현황 조회</h1>
	<fieldset>
		<label>조회기간</label>
		<input type="text" id="datepickerStart"> 시작  <input type="text" id="datepickerEnd"> 종료 <button>검색</button>
		<input type="checkbox">전체
	</fieldset>
	<table>
		<tr>
			<td>주문번호</td>
			<td>고객상호명</td>
			<td>품목명</td>
			<td>주문수량</td>
			<td>주문일자</td>
		</tr>
		<tr>
			<td>O0001</td>
			<td>민수시스템</td>
			<td>V3VirusWall FileScan for Linux</td>
			<td>75</td>
			<td>2020-01-01</td>
		</tr>
		<tr>
			<td>O0001</td>
			<td>민수시스템</td>
			<td>V3VirusWall FileScan for Linux</td>
			<td>75</td>
			<td>2020-01-01</td>
		</tr>
		<tr>
			<td>O0001</td>
			<td>민수시스템</td>
			<td>V3VirusWall FileScan for Linux</td>
			<td>75</td>
			<td>2020-01-01</td>
		</tr>
	</table>
</body>
</html>