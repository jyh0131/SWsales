<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
	/** 서브메뉴 메인 이미지 **/
	#imgDiv{
		width: 100%;
		height: 600px;
		margin: 0 auto;
		margin-top: 50px;
		margin-bottom: 20px;
		position: relative;
	}
	#imgDiv img#sMainImg{
		width: 100%;
		height: 600px;	
	}
	
	/** 서브메뉴 로고 title **/	
	#imgDiv div#sub_log_title{
		width: 700px;
		height: 245px;
		position: absolute;
		left: 30px;
		top: 130px;
	}
	#imgDiv div#sub_log_title img#title1{
		opacity: 0;
		width: 250px;
		height: 50px;
		margin-left: 100px;
		padding-top: 30px;

	}
	#imgDiv div#sub_log_title img#title2{
		opacity: 0;
 		width: 700px;
		height: 115px;
		margin-left: -30px;		
	}
	#imgDiv div#sub_log_title h2{
		opacity: 0;
		border-bottom: 1px solid black;
		margin-left: -10px;
		width: 5px;
	}
	#imgDiv div#sub_log_title h1{
		opacity : 0;
		padding-top: 10px;
		font-size: 35px;
		font-weight: bold;
	}
	/** 서브메뉴 **/
	div#submenu{
		width: 100%;
		height: 150px;
		line-height: 50px;

	}
	div#submenu ul{
		width: 100%;
		height: 150px;
		padding-top: 20px;
	}
	div#submenu ul li{
		width: 810px;
		height: 120px;
		float: left;
		list-style: none;
		text-align: center;
	}
	div#submenu ul li img{
		width: 55px;
		height: 55px;
		padding-top: 10px;
	}
	div#submenu ul li a{
		text-decoration: none;
		color:  #0067B8;
		font-size: 17px;
	}
	div#submenu ul a:hover{
		border-bottom: 4px solid black;
		font-size: 19px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#sub_log_title img#title1").animate({"margin-left":"220px","opacity":"1"},1800);
		$("#sub_log_title img#title2").animate({"margin-left":"0","opacity":"1"},1500);
		$("#sub_log_title h2").animate({"margin-left":"0","width":"700px","opacity":"1"},2000);
		$("#sub_log_title h1").animate({"margin-left":"35px","letter-spacing": "8px","opacity":"1"},2000);		
	})
</script>
<section>
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/submenu/oMain.png" id="sMainImg">
			<div id="sub_log_title">
				<img src ="${pageContext.request.contextPath}/images/submenu/subLogo.png" id="title1">
				<img src ="${pageContext.request.contextPath}/images/submenu/oTitle.png" id="title2">
				<h2></h2>
			<h1>주문 관리</h1>
			</div>
		</div>
		<div id="submenu">
			<ul>
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/oSubIcon1.png"><br>
					<a href="${pageContext.request.contextPath}/client/supplierList.do"><b>주문 등록</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/oSubIcon2.png"><br>
					<a href="${pageContext.request.contextPath}/client/clientList.do"><b>주문 확인&처리</b> ></a>
				</li>				
			</ul>
		</div>
		<!-- 테스트용:나중에 삭제 -->
		<p>
			<a href="${pageContext.request.contextPath}/product/clientDeliveryList.do"><b>주문관리 테스트</b> ></a>
		</p>
</section>
<%@ include file="../include/footer.jsp" %>