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
		border: 1px solid red;
		text-align: right;
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
		border: 1px solid red;
		text-align: center;
	}
	
	div.productImg{
		width: 324px;
		height: 350px;
		float: left;
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

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		
		$("#btnAll").click(function() {
			location.href="supplierList.do";
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
			<a href="${pageContext.request.contextPath}/product/productAdd.do"><button id="btnAdd">제 품 등 록</button></a>	
		</div>
		<div id="pImg_container">
			<c:forEach var="product" items="${list }">
				<div class="productImg">
					<a href="${pageContext.request.contextPath}/product/productDetail.do?pNo=${product.pNo}">
						<img src = "${product.pPicPath}">
					</a>
					<p>${product.pName}</p>
				</div>
			</c:forEach>
		</div>
</section>		
<%@ include file="../include/footer.jsp" %>