<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="../include/header.jsp"%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
      buttonImage: "../images/vMgr/iconmonstr-calendar-6-240.png",
      buttonImageOnly: true,
      buttonText: "시작"
    });
    
    $( "#datepickerEnd" ).datepicker({
      showOn: "button",
      buttonImage: "../images/vMgr/iconmonstr-calendar-6-240.png",
      buttonImageOnly: true,
      buttonText: "종료"
    });
  } );
  </script>
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
	.total{
		text-align: right;
	}
</style>
<section>
	<h1>날짜별 판매현황 조회</h1>
	<fieldset>
		<label>조 회 기 간 </label>
		<input type="text" id="datepickerStart"> <input type="text" id="datepickerEnd"> <button>검색</button>
		<input type="checkbox">전체
	</fieldset>
	<table>
		<tr>
			<th>주문번호</th>
			<th>고객상호명</th>
			<th>품목명</th>
			<th>주문수량</th>
			<th>주문일자</th>
		</tr>
		<c:forEach var="ds" items="${list }">
				<tr>
					<td>
						<c:choose>
							<c:when test="${ds.o_no <10 }">O000${ds.o_no }
							</c:when>
							<c:when test="${ds.o_no >=10 && ds.o_no <100 }">O00${ds.o_no }
							</c:when>
							<c:when test="${ds.o_no >=100 && ds.o_no <1000}">O0${ds.o_no }
							</c:when>
						</c:choose>
					</td>
					<td>${ds.c_name }</td>
					<td>${ds.p_name }</td>
					<td>${ds.o_qty }</td>
					<td>${ds.o_date }</td>
				</tr>
		</c:forEach>
	</table>
</section>	
<%@include file="../include/footer.jsp"%>