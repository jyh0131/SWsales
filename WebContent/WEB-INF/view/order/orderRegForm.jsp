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
	div#order_container{
		width: 100%;
		height: 700px;
		margin-top: 100px;
		border: 1px solid red;
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
		width: 600px;
		height: 600px;
		border: 3px solid black;
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
	input[name*='oNo']{
		font-weight: bold;
		color: #000080;
		font-size: 16px;
		outline: none;
		background: #eee;
	}
	input[name*='oCname']{
		font-weight: bold;
		color: #990000;			
	}
	input[name*='oPname']{
		font-weight: bold;
		color: #336600;		
	}
	input[name*='oQty']{
		font-weight: bold;
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
			<img src="${pageContext.request.contextPath}/images/main/인텔리제이.png">
		</div>
		<div class="order_box">
			<div id="point">
				<label class="red">＊ 필수입력</label>
			</div>
			<form>
				<label>&nbsp<span class="red">* </span>주문번호</label>
				<input type="text" name="oNo" class="text" readonly="readonly"><br>
				
				<label>&nbsp<span class="red">* </span>주문일자</label>
				<input type="date" name="oDate" class="text"><br>
				
				<label>&nbsp<span class="red">* </span>고객 상호명</label>
				<input type="text" name="oCname" class="text"><br>
				
				<label>&nbsp<span class="red">* </span>품목명</label>
				<input type="text" name="oPname" class="text">
				<input type="button" value="조회" id="btnPname" style="cursor: pointer"><br>
				
				<label>&nbsp<span class="red">* </span>주문수량</label>
				<input type="text" name="oQty" placeholder=" >> 품목명 조회 후 수량조회" class="text"><br>
				
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