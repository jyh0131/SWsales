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
	button#btnAll{
		width: 130px;
		height: 40px;
		background-color: #ccc;
		color: white;
		border: 1px solid white;
		border-radius: 5px;
		margin-right: 10px;
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
	div#bottom_btns{
		width: 100%;
		height: 50px;
		border: 1px solid red;
	}
	input#btnTop{
		width: 50px;
		height: 50px;
		border: 1px solid #eee;
	}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		
		//Top버튼
		$("#btnTop").click(function() {
			location.href="productList2.do";
		})
	});
</script>
	<section>
		<div id="title">
			<h1>Software Product List</h1>
			<hr>
			<h3>제품 관리 > <span id="k_title">소프트웨어 제품 리스트</span></h3>
		</div>
		<div id="proAdd">
			<a href="${pageContext.request.contextPath}/product/productList1.do"><button id="btnAll">전 체 LIST</button></a>		
			<a href="${pageContext.request.contextPath}/product/productAdd.do"><button id="btnAdd">제 품 등 록</button></a>	
		</div>
		<div id="pImg_container">
			<c:forEach var="product" items="${list }">
				<div class="productImg">
					<a href="${pageContext.request.contextPath}/product/productDetail.do?pNo=${product.pNo}">
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
<%-- 		<div id="bottom_btns">
				<input type="image" src="${pageContext.request.contextPath}/images/main/ico_topList.png" id="btnTop">
			</div>			
		</div>	 --%>		
</section>	
<%@ include file="../include/footer.jsp" %>