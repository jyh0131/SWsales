<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	#point{
		width: 65%;
    	height: 40px;
    	margin: 0 auto;
    	margin-top: 100px;
	}
	.red{
		color: red;
		
	}	
	#regForm{
		width: 65%;
		margin: 0 auto;
		border-top: 2px solid #878787;
		border-bottom: 1px solid #ccc;
		padding-top: 30px;
		padding-bottom: 30px;
	}
	#form{
		width: 80%;
		margin: 0 auto;
	}
	label{
		width: 150px;
		float: left;
		line-height: 40px;
    	font-weight: bold;
    	font-size: 14px;
	}
	.text{
		margin-bottom: 30px;
		width: 500px;
    	height: 40px;
    	margin-right: 20px;
	}
	#btnSname, #btnSaddress{
	    width: 130px;
    	height: 35px;
	}
	#add{
		width: 65%;
		margin: 0 auto;
		text-align: center;
	}
	#btnAdd{
		width: 160px;
   		height: 45px;
    	background-color: #384D75;
   		color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	margin-top: 30px;
    	font-size: 18px;
	}
	input[name*='cdNo'], input[name*='cName'], input[name*='pName'], input[name*='oQty']{
		font-weight: bold;
		outline: none;
		background: #eee;
	}
	input[name*='cdNo']{
		color: #000080;
		font-size: 16px;	
	}
	input[name*='cName']{
		color: #990000;	
	}
	input[name*='pName']{
		color: #336600;	
	}			
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Registration</h1>
			<hr>
			<h3>제품 관리 > 제품 등록 > <span id="k_title">소프트웨어 상품 등록</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/cDeliveryMod.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>품목번호</label>
					<input type="text" name="cdNo" class="text" value="CD00${clientDelivery.cdNo}" readonly="readonly"><br>
					<input type="hidden" name="no" class="text" value="${clientDelivery.cdNo}">
					
					<label><span class="red">* </span>고객 상호명</label>
					<input type="text" name="cName" class="text" value="${clientDelivery.cName.cName}" readonly="readonly"><br>
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="pName" class="text" value="${clientDelivery.pName}"  readonly="readonly"><br>
					
					<label><span class="red">* </span>출고수량</label>
					<input type="text" name="oQty" class="text" value="${clientDelivery.cdSno.oQty}"  readonly="readonly"><br>
					
					<label><span class="red">* </span>출고일자</label>
					<input type="date" name="cdDate" class="text" value="${clientDelivery.cdDate}"><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="등록" id="btnAdd">
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>