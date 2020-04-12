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
		position: relative;
	}
	div#checkOk{
		width: 180px;
		font-size: 14px;
		color: red;
		font-weight: bold;
		position: absolute;
		right: 100px;
		top: 800px;
	}	
	input::placeholder{
		color:red;
		letter-spacing: 6px;		
	}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		/*** 등록막기 ***/
	 	$("form").submit(function() {
			//주문 등록일자
			var date = $("#oDate").val();
			if(date == ""){
				alert("주문일자를 입력하세요.");
				$("#oDate").focus();
				return false;				
			}
			
			var cName = $("select[name='oCname']").val(); //선택해주세요
			if(cName == "선택해주세요"){
				alert("고객상호명을 선택해주세요.");
			 	$("#oCname").focus(); //포커스
				return false;
			}
			
			var oQty = $("#oQty").val();
			var qtyReg = /^[0-9]*$/;
			
			if(oQty == ""){
				alert("주문수량을 입력하세요.");
				$("#oQty").focus();
				return false;
			}
			
	  		if(qtyReg.test(oQty) == false){
				alert("(주문수량) 숫자만 입력하세요.");
				$("#oQty").focus();
				return false;
			}			
			
			var check = $("#checkOk").html();
			if(check != "재고수량이 확인되었습니다."){
				alert("재고조회 확인이 필요합니다.");
				return false;
			}
		})			
		 	/*** 주문수량 : 재고조회 버튼 ***/	
			$("#btnQty").click(function () {
				var qty = $("#Qty").val();
				if(qty == ""){
					alert("재고가 없습니다. 제품 주문이 필요합니다.");
				}else{
					alert("재고수량은"+qty+"개 입니다.");
					$("#btnQty").hide();
					$("#checkOk").html("재고수량이 확인되었습니다.");					
				}
			})
			

	 	
	/*** 취소버튼 ***/
	$("#btnReset").click(function() {
		location.href="${pageContext.request.contextPath}/order/orderAllList.do";
	})
	
	/*** 품목번호 입력창에 출력되는 형식***/
	var ono = $("#oNo").val();
	console.log(ono); // ex : 98
	if(ono < 10){
		$("input[name=no]").val("O000"+ono); //O0001
	}else if(ono > 9 && ono < 100){
		$("input[name=no]").val("O00"+ono); //O0010
	}else if(ono > 99 && ono < 1000){
		$("input[name=no]").val("O0"+ono); //O0100
	}		
	
})
</script>
<section>
	<!-- form 타이틀 -->
	<div id="title">
		<h1>Order Registration</h1>
		<hr>
		<h3><a href="${pageContext.request.contextPath}/order/oSubMenu.do">주문 관리</a> > <a href="${pageContext.request.contextPath}/order/orderAllList.do">주문 제품별 카테고리</a> > <span id="k_title">&nbsp;주문 등록&nbsp;</span></h3>
	</div>
	<div id="order_container">
		<div class="order_box">
			<img src="${pageContext.request.contextPath}/productIMG/${product.pPicPath}">
			<div class = "product_info">
				<p><span id="cate">&nbsp;${product.pCate}&nbsp;</span> <span id="pName">${product.pName}</span></p>
				<p><b>공급회사 : </b>${product.pSno.sName}</p>
				<p><b>판매가격 : </b><fmt:formatNumber value="${product.pPrice}" pattern="#,###.##원"/> <span id="pCost">(공급가격: <fmt:formatNumber value="${product.pCost}" pattern="\#,###.##"/>)</span></p>			
			</div>
		</div>
		<div class="order_box">
			<div id="point">
				<label class="red">＊ 필수입력</label>
			</div>
			<form action="${pageContext.request.contextPath}/order/orderAdd.do" method="post">
				<label>&nbsp;<span class="red">* </span>주문번호</label>
				<input type="text" name="oNo" class="text" readonly="readonly" value="OOO${order.oNo}" id="oNo"><br>
				
				
				<label>&nbsp;<span class="red">* </span>주문일자</label>
				<input type="date" name="oDate" class="text" id="oDate"><br>
				
				<label><span class="red">* </span>고객 상호명</label>
				<select name="oCname" class="text" id="oCname">
						<option selected="selected" value="선택해주세요">선택해주세요</option>
					<c:forEach var="client" items="${list}">
						<option value="${client.cNo}">${client.cName}</option>
					</c:forEach>
				</select><br>				
				
				<label>&nbsp;<span class="red">* </span>품목명</label>
				<input type="text" name="oPname" class="text" readonly="readonly" value="${product.pName}" id="oPname"><br>
				<input type="hidden" name="pNo" value="${product.pNo}" id="pNo">
				
				<label>&nbsp;<span class="red">* </span>주문수량</label>
				<input type="text" name="oQty" placeholder=" >> 재고조회 후 수량입력" class="text" id="oQty">
				<input type="hidden" name="Qty" value="${Qty.iqQty}" id="Qty">
				<input type="button" value="재고조회" id="btnQty" style="cursor: pointer">
				<div id="checkOk"></div><br>
				
				<label>&nbsp;&nbsp;&nbsp;고객요구사항</label>
				<textarea rows="10" cols="60" name="oMemo" id="oMemo"></textarea><br>
				
				<input type="hidden" name="emp" value="${Auth.empNo}" id="emp">
				<div id="add">
					<input type="submit" value="등록" id="btnAdd" style="cursor: pointer">
					<input type="button" value="취소" id="btnReset" style="cursor: pointer">			
				</div>
			</form>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>