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
	      dateFormat : "yy-mm-dd",
	      buttonImage: "../images/vMgr/iconmonstr-calendar-6-240.png",
	      buttonImageOnly: true,
	      buttonText: "시작"
	    });
	    
	    $( "#datepickerEnd" ).datepicker({
	      showOn: "button",
	      dateFormat : "yy-mm-dd",
	      buttonImage: "../images/vMgr/iconmonstr-calendar-6-240.png",
	      buttonImageOnly: true,
	      buttonText: "종료"
	    });
	    
	  } );
  </script>
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
	fieldset input{
		height:25px;
	}
	.date{
		font-weight: bold;
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
	tr.tbl_point:hover{
		background: black;
		color: red;
	}
	.total{
		text-align: right;
	}
	.carimg{
		margin-top:50px;
	}
</style>
<script>
	$(function (){
		$("#All").click(function(){
			location.href="dateSale.do";
		})
	});
</script>
<section>
	<div id="title">
		<h1>Sales By Date</h1>
		<hr>
		<h3>현황조회 / 보고 > <span id="k_title">날짜별 판매현황 조회</span></h3>
	</div>
	<div id="list_container">
		<form action="dateSearch.do" method="post">
			<fieldset>
				<label>조 회 기 간 </label>
				<input type="text" id="datepickerStart" name="startDate">
				<input type="text" id="datepickerEnd" name="endDate">
				<input type="submit" value="검색" id="Search" style="cursor:pointer">
				<input type="button" value="전체" id="All" style="cursor:pointer">
				<span>${dateText }</span>
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
						<tr class="tbl_point">
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
		</form>
	</div>	
</section>	
<%@include file="../include/footer.jsp"%>