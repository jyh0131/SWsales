<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	header ul#h_login1{
		width: 145px;
		position: absolute;
		right: 0;
		top: 35px;
	}
	header ul#h_login1 li{
		float: left;
		margin-left:10px;
		list-style: none;
		font-size: 13px;
	}
	header ul#h_login1 li a{
		color: black;
		text-decoration: none;
	}
	header ul#h_login1 li a:hover {
		border-bottom: 2px solid black;
	}
	header ul#h_login2{
		width: 275px;
		position: absolute;
		right: 0;
		top: 35px;
	}
	header ul#h_login2 li{
		float: left;
		margin-left:10px;
		list-style: none;
		font-size: 13px;
	}
	header ul#h_login2 li a{
		color: black;
		text-decoration: none;
	}
	header ul#h_login2 li a:hover {
		border-bottom: 2px solid black;
	}
</style>
<body>
	<div id="container">
		<header>
			<a href="${pageContext.request.contextPath}/main/main.do"><img src="${pageContext.request.contextPath}/images/main/h_logo.png" width="157" height="64" id="h_logo"></a>
			<ul id="h_menu">
				<li><a href="${pageContext.request.contextPath}/main/teamInfo.do">NAMBAWAN IT</a></li>
				<li><a href="${pageContext.request.contextPath}/client/cSubMenu.do">거래처 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/order/oSubMenu.do">주문 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/vMgr/vSubMenu.do">현황조회/보고</a></li>
				<li><a href="${pageContext.request.contextPath}/board/boardList.do">공지사항</a></li>
			</ul>	
			<c:if test="${Auth == null }">
				<ul id="h_login1">
					<li><a href="${pageContext.request.contextPath}/main/login.do">LOGIN</a></li>
					<li>|</li>
					<li><a href="${pageContext.request.contextPath}/main/join.do">REGISTER</a></li>
					<%-- <li>|</li>
					<li><a href="#">SEARCH</a></li>
					<li><img src="${pageContext.request.contextPath}/images/main/search.PNG"></li> --%>
				</ul>
			</c:if>
			<c:if test="${Auth != null }">
				<ul id="h_login2">
					<li><a href="${pageContext.request.contextPath}/main/profile.do?id=${Auth.empId}">${Auth.empName }[${Auth.empId }] ${Auth.empTitle }님</a></li>
					<li>|</li>
					<li><a href="${pageContext.request.contextPath}/main/logout.do">LOGOUT</a></li>
					<%-- <li>|</li>
					<li><a href="#">SEARCH</a></li>
					<li><img src="${pageContext.request.contextPath}/images/main/search.PNG"></li> --%>
				</ul>
			</c:if>		
		</header>