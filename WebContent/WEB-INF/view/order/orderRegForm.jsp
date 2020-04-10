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
	span#k_title{
		color: red;
		background-color: white;
	}
	div#order_container{
		width: 100%;
		height: 700px;
		margin-top: 100px;
	}
	div#order_container div.order_box{
		width: 50%;
		height: 600px;
		float: left;
	}
	div#order_container div.order_box:nth-child(1){
		text-align: center;
	}	
	div#order_container div.order_box img{
		width: 500px;
		height: 500px;
		border: 3px solid black;
	}
	div.product_info{
		width: 503px;
		height: 150px;
		background: #eee;									
		text-align: left;
		margin-left: 155px;
		margin-top: 20px;
		
	}
	div.product_info p:first-child{
		padding: 20px;
	}
	div.product_info p:nth-child(2){
		padding-left: 20px;
	}
 	div.product_info p:last-child{
		padding-left: 20px;
	}
	span#cate{
		background: #CD3B3B;
		color: white;
		font-weight: bold;
		border-radius:5px;
		font-size: 20px; 
	}
	span#pName{
		color: #353535;
		font-size: 25px;
		font-weight: bold;
	}
	span#pCost{
		color: #747474;
	}			
	div#order_container div.order_box div#point{
		width: 100%;
    	height: 50px;
    	border-bottom: 1px solid #353535;
    	line-height: 50px;
    	margin-bottom: 30px;
	}
	label{
		width: 150px;
		float: left;
		font-weight: bold;
		font-size: 14px;
	}
	.text{
		margin-bottom: 30px;
		width: 500px;
    	height: 40px;
    	margin-right: 20px;
    	outline-color: red;
	}
	textarea{
		width: 500px;
	}	
	.red{
		color: red;
		font-weight: bold;
		font-size: 18px;
	}
	#btnQty{
		width: 130px;
    	height: 35px;
 		color: white;
		outline: none;
		border: none;
		border-radius: 5px; 
		background: #FFCC33;
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
	input[name*='oNo']{
		font-weight: bold;
		color: #000080;
		font-size: 16px;
		outline: none;
		background: #eee;
	}
	select[name*='oCname']{
		font-weight: bold;
		color: #990000;			
	}
	input[name*='oPname']{
		font-weight: bold;
		color: #336600;
		font-size: 16px;
		background: #eee;				
	}
	input[name*='oQty']{
		font-weight: bold;
	}
	input::placeholder{
		color:red;
		letter-spacing: 6px;		
	}	
</style>
<section>
	<!-- form 타이틀 -->
	<div id="title">
		<h1>Order Registration</h1>
		<hr>
		<h3>주문 관리 > <span id="k_title">주문 등록</span></h3>
	</div>
	<div id="order_container">
		<div class="order_box">
			<img src="${pageContext.request.contextPath}/productIMG/${order.pPicPath}">
			<div class = "product_info">
				<p><span id="cate">&nbsp${order.pCate}&nbsp</span> <span id="pName">${order.pName}</span></p>
				<p><b>공급회사 : </b>${order.pSno.sName}</p>
				<p><b>판매가격 : </b><fmt:formatNumber value="${order.pPrice}" pattern="#,###.##원"/> <span id="pCost">(공급가격: <fmt:formatNumber value="${order.pCost}" pattern="\#,###.##"/>)</span></p>			
			</div>
		</div>
		<div class="order_box">
			<div id="point">
				<label class="red">＊ 필수입력</label>
			</div>
			<form>
				<label>&nbsp<span class="red">* </span>주문번호</label>
				<input type="text" name="oNo" class="text" readonly="readonly" value="POO${order.pNo}"><br>
				
				<label>&nbsp<span class="red">* </span>주문일자</label>
				<input type="date" name="oDate" class="text"><br>
				
				<label><span class="red">* </span>고객 상호명</label>
				<select name="oCname" class="text">
						<option selected>선택해주세요</option>
					<c:forEach var="client" items="${list}">
						<option value="${client.cNo}">${client.cName}</option>
					</c:forEach>
				</select><br>				
				
				<label>&nbsp<span class="red">* </span>품목명</label>
				<input type="text" name="oPname" class="text" readonly="readonly" value="${order.pName}"><br>
				
				<label>&nbsp<span class="red">* </span>주문수량</label>
				<input type="text" name="oQty" placeholder=" >> 재고조회 후 수량입력" class="text">
				<input type="button" value="재고조회" id="btnQty" style="cursor: pointer"><br>
				
				<label>&nbsp&nbsp&nbsp고객요구사항</label>
				<textarea rows="10" cols="60"></textarea><br>
				<div id="add">
					<input type="submit" value="등록" id="btnAdd" style="cursor: pointer">
					<input type="button" value="취소" id="btnReset" style="cursor: pointer">			
				</div>
			</form>
		</div>
	</div>	
</section>
<%@ include file="../include/footer.jsp" %>