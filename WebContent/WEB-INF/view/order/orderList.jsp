<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<style>
	/** form 타이틀 **/
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/title/soTitle.png") no-repeat;
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
	div#product_cate{
		border: 1px solid red;
		width: 100%;
		height: 60px;
		text-align: center;
		margin-top: 100px;
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
	
	div#product_list{
		width: 100%;
		text-align: center;
		margin-top: 20px;
	}
	div.productImg{
		width: 324px;
		height: 350px;
		float: left;
		position: relative;
	}
	div.productImg img{
		width: 300px;
		height: 310px;
		border: 1px solid black;
	}
	div.productImg p{
		font-weight: bold;
		text-align: center;
		line-height: 20px;
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
	
	div.productImg a:hover div.caption{
		opacity:1;
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
		})
		$("#cate2").click(function(){
			location.href="orderCate2List.do";
		})
		$("#cate3").click(function(){
			location.href="orderCate3List.do";
		})
		$("#cate4").click(function(){
			location.href="orderCate4List.do";
		})
		$("#cate5").click(function(){
			location.href="orderCate5List.do";
		})
		$("#cate6").click(function(){
			location.href="orderCate6List.do";
		})		
	});
</script>
<section>
	<!-- form 타이틀 -->
	<div id="title">
		<h1>Order Registration</h1>
		<hr>
		<h3>주문 관리 > <span id="k_title">주문 상품</span></h3>
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
	<div id="product_list">
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
					<p>${product.pName}</p>		
				</div>
			</c:forEach>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>