<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
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
   <script type="text/javascript">
     google.charts.load('current', {'packages':['corechart']});
     google.charts.setOnLoadCallback(drawChart);

     
    
     function drawChart() {
        var data = google.visualization.arrayToDataTable([
         /*  ['문심차', 22],
            ['홍소목', 17],
            ['양옥고', 15],
            ['강궁소', 12],
            ['서사정', 6],
            ['한전내', 5],
            ['최지오', 5],
            ['한지석', 5],
            ['장우공', 4],
            ['왕우내', 3],  */
          
            ['사원명', '%'],
            
          	<c:forEach var="sp" items="${list}">
				['${sp.e_name}', ${sp.salesMoney}],
			</c:forEach>
          
        ]);

        var options = {
          title: '상위 10인 영업사원'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
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
	#All{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		right: 0;
	}
	#piechart{
		padding-left:250px;
		height:650px;
	}
</style>

<section>
	<div id="title">
		<h1>Customer Order</h1>
		<hr>
		<h3>현황조회 / 보고 > <span id="k_title">영업사원 실적 그래프</span></h3>
	</div>
	<div id="list_container">
		<div id="menu">
			<a href="${pageContext.request.contextPath}/vMgr/customerOrder.do"><button class="btnMenu">고객사 주문현황</button></a>
			<a href="${pageContext.request.contextPath}/vMgr/salesman.do"><button class="btnMenu">영업사원 실적</button></a>
		</div>
		<form action="salesmanSearch.do" method="post">
			<fieldset>
				<label>조 회 기 간 </label>
				<input type="text" id="datepickerStart" name="startDate">
				<input type="text" id="datepickerEnd" name="endDate">
				<input type="submit" value="검색" id="Search" style="cursor:pointer">
				<div id="text">${dateText }</div>
			</fieldset>
			<div id="piechart">
			
			</div>
		</form>
	</div>
</section>

<%@include file="../include/footer.jsp"%>