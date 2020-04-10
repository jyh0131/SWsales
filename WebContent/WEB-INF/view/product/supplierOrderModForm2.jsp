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
	
	#point{
		width: 65%;
    	height: 40px;
    	margin: 0 auto;
    	margin-top: 100px;
	}
	.red{
		color: red;
		font-weight: bold;
		font-size: 18px;		
		
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
	#btnPname{
	    width: 130px;
    	height: 35px;
 		color: white;
		outline: none;
		border: none;
		border-radius: 5px; 
		background: #A6A6A6;
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
	#btnReset{
		width: 160px;
   		height: 45px;
    	background-color: #bbb;
   		color: white;
    	border: 1px solid white;
    	border-radius: 5px;
    	margin-top: 30px;
    	font-size: 18px;
	}	
	input[name*='spNo']{
		font-weight: bold;
		color: #000080;
		font-size: 16px;
		outline: none;
		background: #eee;
	}
	input[name*='spPname']{
		font-weight: bold;
		color: #336600;
	}
	input[name*='spSname']{
		font-weight: bold;
		color: #990000;
		outline: none;
		background: #eee;			
	}
	input[name*='spPcost']{
		outline: none;
		background: #eee;		
	}
	input[name*='spPcost'], input[name*='spQty']{
		font-weight: bold;
	}
	input::placeholder{
		color:red;
		letter-spacing: 6px;
	}	
	span.cnt{
		color: blue;
		font-size: 12px;
	}		
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Purchase Registration</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/soSubMenu.do">발주/매입</a> > <span id="k_title">매입 이력 등록</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/sOrderAdd2.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>매입번호</label>
					<input type="text" name="spNo" class="text" value=" SP00${SupplierPurchase.spNo+1 }" readonly="readonly"><br>
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="spPname" class="text" placeholder=" >> 품목명 조회">
					<input type="button" value="조회" id="btnPname"><br>
					
					<label><span class="red">* </span>공급 회사명</label>
					<input type="text" name="spSname" class="text" readonly="readonly"><br>
					
					<label><span class="red">* </span>매입가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="spPcost" class="text" readonly="readonly"><br>
					
					<label><span class="red">* </span>매입수량</label>
					<input type="text" name="spQty" class="text"><br>
					
					<label><span class="red">* </span>매입 등록일자</label>
					<input type="date" name="spDate" class="text"><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="등록" id="btnAdd">
			<input type="button" value="취소" id="btnReset" style="cursor: pointer">					
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>