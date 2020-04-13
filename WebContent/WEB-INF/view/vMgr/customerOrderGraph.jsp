<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!--  <link rel="stylesheet" href="/resources/demos/style.css"> -->
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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawVisualization);
	
	function drawVisualization(){
		 var data = google.visualization.arrayToDataTable([
			/*['고객사명', '영화정보통신', '세종특별자치시청', '상내정보통신', '우우시스템',
				'대전광역시 교육청', '금변시스템', '전라북도청', '대전광역시청', '부산광역시 교육청', '세종특별자치시 교육청'],
			[' ', 1747240000, 1042800000, 1020250000, 819280000, 789250000,
				654500000, 595650000, 534820000, 524535000, 485100000] 
			*/
			
				['고객사명', <c:forEach var="co" items="${cName}">
									'${co.c_name}',
							</c:forEach>],
				[' ', <c:forEach var="co" items="${pPrice}">
								${co.p_price},
							</c:forEach>]
			])
			
			var options = {
					title: "상위 10개 고객사",
					vAxis: {title: '판매금액' },
					hAxis: {title: '고객사'},
					seriesType: 'bars'
			};
			
		var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	}
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
	div#title h3 a{
		text-decoration: none;
		color:black;
	}
	div#title h3 a:hover{
		border-bottom: 3px solid black;
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
		width: 130px;
		height: 36px;
		background-color: #008000;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		margin:0 1px;
		margin-bottom:10px;
	}
	fieldset{
		padding:3px 10px;
		margin:10px 0;
		font-size: 17px;
		height:100px;
		line-height: 38px;
		border:none;
		text-align: center;
	}
	fieldset input{
		height:25px;
	}
	.date{
		font-weight: bold;
	}
	#text{
		margin-top:5px;
	}
	#Search{
		width: 60px;
		height: 36px;
		background-color: #384D75;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#chart_div{
		height:700px;
	}
</style>

<section>
	<div id="title">
		<h1>Customer Order</h1>
		<hr>
		<h3><a href="vSubMenu.do">현황조회 / 보고</a> > <span id="k_title">고객사 주문현황 그래프</span></h3>
	</div>
	<div id="list_container">
		<div id="menu">
			<a href="${pageContext.request.contextPath}/vMgr/customerOrder.do"><button class="btnMenu">고객사 주문현황</button></a>
			<a href="${pageContext.request.contextPath}/vMgr/salesman.do"><button class="btnMenu">영업사원 실적</button></a>
		</div>
		<form action="coSearch.do" method="post">
			 <fieldset>
				<label>조 회 기 간 </label>
				<input type="text" id="datepickerStart" name="startDate">
				<input type="text" id="datepickerEnd" name="endDate">
				<input type="submit" value="검색" id="Search" style="cursor:pointer">
				<div id="text">${dateText }</div>
			</fieldset>
			<div id="chart_div">
			
			</div>
		</form>
	</div>
</section>

<%@include file="../include/footer.jsp"%>