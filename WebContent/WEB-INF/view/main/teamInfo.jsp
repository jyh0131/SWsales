<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/lightbox.css">
<style>
@import url('https://fonts.googleapis.com/css?family=Playball|Playfair+Display|Raleway&display=swap');
	div#teamImg{
		width: 100%;
		height: 390px;
		margin-top: 30px;
		position: relative;
	}
	div#teamImg img#mainImg{
		width: 100%;
		height: 400px;
		border-bottom: 12px solid #FF5E00;
	}
	div#teamImg div#teamTitle{
		width: 700px;
		height: 300px;
		position: absolute;
		left: 30px;
		top: 70px;
		color: white;
	}
	div#teamImg div#teamTitle img#title1{
		opacity: 0;
		width: 250px;
		height: 50px;
		margin-left: 100px;
		padding-top: 30px;

	}
	div#teamImg div#teamTitle img#title2{
		opacity: 0;
 		width: 700px;
		height: 115px;
		margin-left: -30px;		
	}	
	div#teamImg div#teamTitle h2{
		opacity: 0;
		border-bottom: 1px solid black;
		margin-left: -10px;
		width: 5px;
	}
	div#teamImg div#teamTitle h1{
		opacity : 0;
		padding-top: 10px;
		font-size: 20px;
		font-weight: bold;
	}	
	div.pTitle{
		margin-top: 80px;
		width: 100%;
		height: 35px;
		text-align: center;
	}
	div.pTitle h1{
		font-size: 35px;
		font-family: 'Playball';
	}
	div.pTitle p.line{
		width: 100px;
		height: 15px;
		border-bottom: 3px solid black;
		margin: 0 auto;
	}		
	div#teamInfo{
		width: 100%;
		height: 300px;
		margin-top: 80px;
	}
	div#teamInfo p{
		width: 50%;
		margin-left: 240px;
		font-size: 14px;
		font-weight: bold;
		color: #353535;
		margin-bottom: 10px;
	}
	table{
		border-collapse: collapse;
		width: 70%;
		margin:0 auto;
	}
	tr{
		border: 1px solid lightgray;
	}
	th,td{
		padding: 10px;
		font-size: 13px;
		color: #353535;
	}
	div.pBox{
		width: 100%;
		height: 600px;
		margin-top: 80px;
		text-align: center;
		border: 1px dashed lightgray;
	}
	div.pBox img{
		width: 150px;
		height: 150px;
		margin: 65px;
		border: 1px solid #A6A6A6;
	}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/lightbox.min.js"></script>
<script>
$(document).ready(function() {
	$("#teamTitle img#title1").animate({"margin-left":"220px","opacity":"1"},1800);
	$("#teamTitle img#title2").animate({"margin-left":"0","opacity":"1"},1500);
	$("#teamTitle h2").animate({"margin-left":"0","width":"700px","opacity":"1"},2000);
	$("#teamTitle h1").animate({"margin-left":"35px","letter-spacing": "8px","opacity":"1"},2000);		
})
</script>
<section>
	<div id="teamImg">
		<img src="${pageContext.request.contextPath}/images/main/teaminfo_01.jpg" id="mainImg">
		<div id="teamTitle">
		    <img src ="${pageContext.request.contextPath}/images/submenu/subLogo.png" id="title1">
			<img src ="${pageContext.request.contextPath}/images/submenu/pTitle.png" id="title2">
			<h2></h2>
			<h1>Su Jin / Jae Seung / A Reum</h1>
		</div>
	</div>
	<div class="pTitle">
	<h1>x&nbsp;x &nbsp;&nbsp;Team Nam Bawon&nbsp;&nbsp; x&nbsp;x</h1>
	<p class="line"></p>
	</div>
	<div id="teamInfo">
		<p>본 프로젝트는 영남인재교육원 JAVA기반 스마트 웹&컨텐츠 응용SW 전문가(3기) 팀 Nam Bawan의 자산입니다.</p>
		<table>
			<tr>
				<th>프로젝트 명</th>
				<td>S/W 판매관리 프로그램 [ WINDOW(Java Swing) / WEB(JSP:JavaServer Page) ]</td>
			</tr>
			<tr>
				<th>팀이름(팀원)</th>
				<td>Nam Bawon(권수진 / 현재승 / 정아름)</td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td>2020-01-07 ~ 2020-04-13</td>
			</tr>
			<tr>
				<th>개발툴, DB</th>
				<td>eclipse, tomcat, MySQL</td>
			</tr>
			<tr>
				<th>사용언어</th>
				<td>Java, JSP, HTML, CSS, JavaScript, jQuery, ajax</td>
			</tr>
			<tr>
				<th>형상관리</th>
				<td>github</td>
			</tr>
			<tr>
				<th>이미지 출처</th>
				<td>마이크로 소프트 www.microsoft.com</td>
			</tr>												
		</table>
	</div>
	<div class="pTitle">
		<h1> &nbsp;&nbsp;P r o j e c t&nbsp;&nbsp; </h1>
		<p class="line"></p>		
	</div>
	<div class="pBox">
		<a href="${pageContext.request.contextPath}/images/teamInfo/1.jpg" data-lightbox="image-1" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/1.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/2.jpg" data-lightbox="image-2" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/2.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/4.jpg" data-lightbox="image-3" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/4.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/5.jpg" data-lightbox="image-5" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/5.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/6.jpg" data-lightbox="image-6" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/6.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/7.jpg" data-lightbox="image-7" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/7.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/8.jpg" data-lightbox="image-8" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/8.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/9.jpg" data-lightbox="image-9" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/9.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/10.jpg" data-lightbox="image-10" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/10.jpg"></a>
		<a href="${pageContext.request.contextPath}/images/teamInfo/11.jpg" data-lightbox="image-11" data-title="회의"><img src ="${pageContext.request.contextPath}/images/teamInfo/11.jpg"></a>
	</div>	
</section>
<%@include file="../include/footer.jsp"%>