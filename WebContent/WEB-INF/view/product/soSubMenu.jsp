<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
	section{
		width: 100%;
		height: 1450px;
	}
	div#so_box1{
		width: 100%;
		height: 700px;
		background-color: #F5F5F5;
		margin-top: 50px;	
	}
	div.so_title{
		width: 100%;
		height: 350px;
		margin-top: 150px;
	}	
	div.so_title img#title1{
		opacity: 0;
		width: 250px;
		height: 50px;
		margin-left: 100px;
		padding-top: 30px;

	}
	div.so_title img#title2{
		opacity: 0;
 		width: 488px;
		height: 99px;
		margin-left: -30px;		
	}		

	div.so_title h2{
		opacity: 0;
		border-bottom: 1px solid black;
		margin-left: -5px;
		width: 5px;
	}
 	div.so_title h1{
		opacity : 0;
		padding-top: 10px;
		font-size: 35px;
		font-weight: bold;
	}		
	div#so_box1 img[src*='soMain1']{
		width: 800px;
		height: 620px;
		padding-left: 10px;
		padding-top: 80px;
	}

	div.box1{
		width: 50%;
		height: 636px;
		float: left;
	}
	div#so_box2{
		width: 100%;
		height: 700px;
		background-color: #EAEAEA;
	}
	div#so_box2 img[src*='soMain2']{
		width: 800px;
		height: 620px;
		padding-top: 80px;
	}
	div.box2{
		width: 50%;
		height: 636px;
		float: left;		
	}
	ul.so_sub{
		width: 100%;
		height: 100px;
	}
	ul.so_sub li{
		width: 50%;
		list-style: none;
		float: left;
		text-align: center;
		line-height: 40px;
	}
	ul.so_sub li img[src*='submenu']{
	 	width: 50px;
	 	height: 50px;
	}	
	ul.so_sub li a{
		text-decoration: none;
		color:  #0067B8;
		font-size: 17px;
		font-weight: bold;
	}
	ul.so_sub li a:hover{
		border-bottom: 4px solid black;
		font-size: 19px;		
	}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("div.so_title img#title1").animate({"margin-left":"220px","opacity":"1"},1800);
		$("div.so_title img#title2").animate({"margin-left":"100px","opacity":"1"},2000);
		$("div.so_title h2").animate({"margin-left":"50px","width":"700px","opacity":"1"},2000);
		$("div.so_title h1").animate({"margin-left":"140px","letter-spacing": "8px","opacity":"1"},2000);		
	})
</script>
<section>
	<div id="so_box1">
		<div class="box1">
			<div class="so_title">
				<img src ="${pageContext.request.contextPath}/images/submenu/subLogo.png" id="title1">
				<img src ="${pageContext.request.contextPath}/images/submenu/soTitle1.png" id="title2">
				<h2></h2>
				<h1>발주 관리</h1>			
			</div>
			<ul class="so_sub">
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/soSubIcon1.png"><br>
					<a href="${pageContext.request.contextPath}/product/sOrderAdd1.do">발주 이력 등록</a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/soSubIcon2.png"><br>
					<a href="${pageContext.request.contextPath}/product/supplierOrderList1.do">발주 이력 리스트</a>
				</li>
			</ul>
		</div>
		<div class="box1"><img src="${pageContext.request.contextPath}/images/submenu/soMain1.png"></div>
	</div>
	<div id="so_box2">
		<div class="box2"><img src="${pageContext.request.contextPath}/images/submenu/soMain2.png"></div>
		<div class="box2">
			<div class="so_title">
				<img src ="${pageContext.request.contextPath}/images/submenu/subLogo.png" id="title1">
				<img src ="${pageContext.request.contextPath}/images/submenu/soTitle2.png" id="title2">
				<h2></h2>
				<h1>매입 관리</h1>			
			</div>		
			<ul class="so_sub">
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/soSubIcon1.png"><br>
					<a href="${pageContext.request.contextPath}/product/sOrderAdd2.do">매입 이력 등록</a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/submenu/soSubIcon2.png"><br>				
					<a href="${pageContext.request.contextPath}/product/supplierOrderList2.do">매입 이력 리스트</a>
				</li>
			</ul>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>