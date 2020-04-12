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
		background: url("${pageContext.request.contextPath}/images/main/formtest.png") no-repeat;
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
	
	div#proAdd{
		width: 100%;
		height: 40px;
		margin-top: 100px;
		text-align: right;
	}
	div#proAdd input[type*='button']{
		width: 72px;
		height: 35px;
		color: white;
		background: #A6A6A6;
		border-radius: 5px;
		outline: none;
		border: none;
		margin: 10px;
		float: left;
	}
	div#proAdd input:hover{
		background: #f08080;
		font-weight: bold;
		
	}	
	div#proAdd input#All{
		font-weight: bold;
		background: #384D75;
	}		
	button#btnAll{
		width: 130px;
		height: 40px;
		background-color: #ccc;
		color: white;
		border: 1px solid white;
		border-radius: 5px;
		margin-right: 10px;
		margin-top: 5px;
	}
		
	button#btnAdd{
		width: 130px;
		height: 40px;
		background-color: #384D75;
		color: white;
		border: 1px solid white;
		border-radius: 5px;
		margin-right: 10px;
	}
	
	div#pImg_container{
		width: 100%;
		text-align: center;
		margin-top: 50px;
	}
	
	div.productImg{
		width: 324px;
		height: 350px;
		float: left;
		position: relative;
		margin-bottom: 30px;
	}
	div.productImg img{
		width: 300px;
		height: 310px;
		border: 1px solid black;
	}
	div.productImg p{
		font-weight: bold;
		text-align: left;
		line-height: 20px;
		font-size: 20px;
		padding-left:20px; 
		padding-top: 5px;
	}
 	span#cate{
		background: #CD3B3B;
		color: white;
		font-weight: bold;
		border-radius:5px;
		font-size: 16px; 
	}
	
	div.caption{
		width: 300px;
		height: 310px;
		text-align: center;
		background-color: rgba(0,0,0,0.6);
		color: white;
		position: absolute;
		left: 12px;
		top:1px;
		line-height: 90px;
 		opacity: 0;
		transition: all 1s ease;
	}
	div.caption p{
		text-align: center;
		font-size: 18px;
		padding: 0;
	}	
	div.productImg a:hover div.caption{
		opacity:1;
	}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		$("#All").click(function(){
			location.href="productList2.do";
		})
		$("#cate1").click(function(){
			location.href="productCate1List.do";
			$("#cate1").css({'color':'navy','background':'#FFCD12'});
		})
		$("#cate2").click(function(){
			location.href="productCate2List.do";
			$("#cate2").css({'color':'navy','background':'#FFCD12'});
		})
		$("#cate3").click(function(){
			location.href="productCate3List.do";
			$("#cate3").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate4").click(function(){
			location.href="productCate4List.do";
			$("#cate4").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate5").click(function(){
			location.href="productCate5List.do";
			$("#cate5").css({'color':'navy','background':'#FFCD12'});			
		})
		$("#cate6").click(function(){
			location.href="productCate6List.do";
			$("#cate6").css({'color':'navy','background':'#FFCD12'});
		})
		

	});
</script>
	<section>
		<div id="title">
			<h1>Software Product List</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <span id="k_title">&nbsp;소프트웨어 제품 리스트&nbsp;</span></h3>
		</div>
		<div id="proAdd">
			<input type="button" value="전체" id="All" style="cursor:pointer">
			<input type="button" value="사무" id="cate1" style="cursor:pointer">
			<input type="button" value="개발" id="cate2" style="cursor:pointer">
			<input type="button" value="전문분야" id="cate3" style="cursor:pointer">
			<input type="button" value="멀티미디어" id="cate4" style="cursor:pointer">
			<input type="button" value="기업업무" id="cate5" style="cursor:pointer">
			<input type="button" value="서버" id="cate6" style="cursor:pointer">		
			<a href="${pageContext.request.contextPath}/product/productList1.do"><button id="btnAll" style="cursor: pointer">전 체 LIST</button></a>		
			<a href="${pageContext.request.contextPath}/product/productAdd.do"><button id="btnAdd" style="cursor: pointer">제 품 등 록</button></a>	
		</div>
		<div id="pImg_container">
			<c:forEach var="product" items="${list }">
				<div class="productImg">
					<a href="${pageContext.request.contextPath}/product/productDetail.do?pNo=${product.pNo}&pCate=${product.pCate.cateNo}"> <!-- 여러값을 넘기기 -->
						<img src="${pageContext.request.contextPath}/productIMG/${product.pPicPath}">
						<div class="caption">
							<h1> < ${product.pCate} > </h1>
							<h3>${product.pName}</h3>
							<p>공급가격 : <fmt:formatNumber value="${product.pCost}" pattern="#,###.##원"/></p>
							<p>판매가격 : <fmt:formatNumber value="${product.pPrice}" pattern="#,###.##원"/></p>
						</div>
					</a>
					<p class="category"><span id="cate">&nbsp;${product.pCate}&nbsp;</span> ${product.pName}</p>
				</div>
			</c:forEach>
		</div>		
</section>	
<%@ include file="../include/footer.jsp" %>