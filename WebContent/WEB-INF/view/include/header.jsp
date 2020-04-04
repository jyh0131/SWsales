<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAMBAWAN IT 공식 홈페이지</title>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	div#container{
		width: 1620px;
		margin: 0 auto;
	}
	/** header **/
	header{
		width: 1620px;
		height: 64px;
		position: relative;
	}
	header img#h_logo{
		margin-left: 10px;
		margin-top: 15px;
	}
	header ul#h_menu{
		width: 700px;
		position: absolute;
		left: 170px;
		top: 30px;
	}
	header ul#h_menu li{
		float: left;
		margin-left: 30px;
		list-style: none;
	}
	header ul#h_menu li a{
		color: black;
		text-decoration: none;
		font-size: 13px;
	}
	header ul#h_menu li a:hover{
		border-bottom: 2px solid black;
	}	
	header ul#h_login{
		width: 250px;
		position: absolute;
		right: 0;
		top: 35px;
	}
	header ul#h_login li{
		float: left;
		margin-left:10px;
		list-style: none;
		font-size: 13px;
	}
	header ul#h_login li a{
		color: black;
		text-decoration: none;
	}
	header ul#h_login li a:hover {
		border-bottom: 2px solid black;
	}
</style>
<body>
	<div id="container">
		<header>
			<a href="${pageContext.request.contextPath}/main/main.do"><img src="${pageContext.request.contextPath}/images/main/h_logo.png" width="157" height="64" id="h_logo"></a>
			<ul id="h_menu">
				<li><a href="#">NAMBAWAN IT</a></li>
				<li><a href="${pageContext.request.contextPath}/client/supplierList.do">거래처 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/order/oSubMenu.do">주문 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/vMgr/vSubMenu.do">현황조회/보고</a></li>
				<li><a href="#">공지사항</a></li>
			</ul>
			<ul id="h_login">
				<li><a href="#">LOGIN</a></li>
				<li>|</li>
				<li><a href="#">REGISTER</a></li>
				<li>|</li>
				<li><a href="#">SEARCH</a></li>
				<li><img src="${pageContext.request.contextPath}/images/main/search.PNG"></li>
			</ul>		
		</header>