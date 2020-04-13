<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ include file="../include/header.jsp" %>    
<style>
	/** form 타이틀 **/
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/title/oTitle.png") no-repeat;
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
		color: black;
	}
	div#title h3 a:hover{
		border-bottom: 3px solid black;
	}	
	span#k_title{
		color: red;
		background-color: white;
	}
	div#icon_dummy{
		width: 100%;
		height: 80px;
		text-align: center;
		margin-top: 100px; 
	}
	div#icon_dummy ul{
		width: 80%;
		height: 80px;
		padding-left: 265px;
	}
	div#icon_dummy ul li{
		width: 12%;
		float: left;
		list-style: none;
		padding-top: 20px;
	}
	div#icon_dummy ul li img{
		width: 50px;
		height: 50px;
	}
	div#product_cate{
		width: 100%;
		height: 60px;
		text-align: center;
	}
	div#product_cate input[type*='button']{
		width: 130px;
		height: 35px;
		color: white;
		background: #A6A6A6;
		border-radius: 5px;
		outline: none;
		border: none;
		margin: 10px;
	}
	div#product_cate input:hover{
		background: #f08080;
		font-weight: bold;
	}	
	div#product_cate input#All{
		font-weight: bold;
		background: #384D75;
	}
	div#search{
		width: 100%;
		height: 70px;
		margin-top: 30px;
		text-align: center;
	}
 	div#search input#sinput{
		width: 56%;
		height: 45px;
		outline: none;
		border-top: none;
		border-left: none;
		border-right: none;
		border-bottom: 3px solid #384D75;
		background: url("${pageContext.request.contextPath}/images/order/icon_search.png") no-repeat;
		background-size: 25px 25px contain;
		background-position: left;
		padding-left:80px;
	}
	input#btnSearch{
		width: 60px;
		height: 50px;
		border: 1px solid #384D75;
		background-color: #384D75;
		outline: none;
		border-radius: 0 5px 5px 0;
		color: white;
	}
	input::placeholder{
		letter-spacing: 5px;
	}
	div#product_list{
		width: 100%;
		text-align: center;
		margin-top: 50px;
	}
	div.productImg{
		width: 324px;
		height: 450px;
		float: left;
		position: relative;
	}
	div.productImg img{
		width: 300px;
		height: 310px;
		border: 1px solid black;
	}
 	div.productImg img:hover{
		border: 5px solid red;
	}
	div.product_info{
		width: 305px;
		height: 120px;
		background: #eee;
		margin-left: 10px;
		text-align: left;
	}
	div.product_info p:first-child{
		padding: 10px;
	}
	div.product_info p:nth-child(2){
		padding-left: 10px;
	}
 	div.product_info p:last-child{
		padding-left: 10px;
	}
	span#cate{
		background: #CD3B3B;
		color: white;
		font-weight: bold;
		border-radius:5px;
		font-size: 16px; 
	}
	span#pName{
		color: #353535;
		font-size: 20px;
		font-weight: bold;
	}
	span#pCost{
		font-size: 10px;
		color: #747474;
	}		
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function (){
		$("#All").click(function(){
			location.href="orderAllList.do";
		})
		$("#cate1").click(function(){
			location.href="orderCate1List.do";
			$("#cate1").css({'color':'navy','background':'#FFCD12'});
		})
		$("#cate2").click(function(){
			location.href="orderCate2List.do";
			$("#cate2").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate3").click(function(){
			location.href="orderCate3List.do";
			$("#cate3").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate4").click(function(){
			location.href="orderCate4List.do";
			$("#cate4").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate5").click(function(){
			location.href="orderCate5List.do";
			$("#cate5").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate6").click(function(){
			location.href="orderCate6List.do";
			$("#cate6").css({'color':'navy','background':'#FFCD12'});
		})		
	});
</script>
<section>
	<!-- form 타이틀 -->
	<div id="title">
		<h1>Product Order Category</h1>
		<hr>
		<h3><a href="${pageContext.request.contextPath}/order/oSubMenu.do">주문 관리</a> > <span id="k_title">&nbsp;주문 제품별 카테고리&nbsp;</span></h3>
	</div>
	<div id="icon_dummy">
		<ul>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_all.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate1.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate2.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate3.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate4.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate5.png"></li>
			<li><img src="${pageContext.request.contextPath}/images/order/icon_cate6.png"></li>
		</ul>
	</div>
	<div id="product_cate">
		<input type="button" value="전체" id="All" style="cursor:pointer">
		<input type="button" value="사무" id="cate1" style="cursor:pointer">
		<input type="button" value="개발" id="cate2" style="cursor:pointer">
		<input type="button" value="전문분야" id="cate3" style="cursor:pointer">
		<input type="button" value="멀티미디어" id="cate4" style="cursor:pointer">
		<input type="button" value="기업업무" id="cate5" style="cursor:pointer">
		<input type="button" value="서버" id="cate6" style="cursor:pointer">		
	</div>
	<div id="search">
		<form action="orderSearch.do" method="post">
			<input type="text" name="sinput" id="sinput" placeholder=" >> 제품명을 입력하세요">
			<input type="submit" value = "Search" id="btnSearch" style="cursor:pointer">
		</form>
	</div>		
	<div id="product_list">
			<c:forEach var="product" items="${list }">
				<div class="productImg">
					<a href="${pageContext.request.contextPath}/order/orderAdd.do?pNo=${product.pNo}"> <!-- 여러값을 넘기기 -->
						<img src="${pageContext.request.contextPath}/productIMG/${product.pPicPath}">
					</a>
					<div class="product_info">
						<p><span id="cate">&nbsp;${product.pCate}&nbsp;</span> <span id="pName">${product.pName}</span></p>
						<p><b>공급회사 : </b>${product.pSno.sName}</p>
						<p><b>판매가격 : </b><fmt:formatNumber value="${product.pPrice}" pattern="#,###.##원"/> <span id="pCost">(공급가격: <fmt:formatNumber value="${product.pCost}" pattern="\#,###.##"/>)</span></p>
					</div>
				</div>
			</c:forEach>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>