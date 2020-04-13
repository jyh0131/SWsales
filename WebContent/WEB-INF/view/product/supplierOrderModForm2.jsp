<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
$(function() {
	/*** 수정막기 ***/
	$("form").submit(function () {
		var spPname = $("input[name='spPname']").val();
		if(spPname == ""){
			alert("품목명을 입력하세요.");
			return false;
		}
		
		var spQty = $("input[name='spQty']").val();
		if(spQty == ""){
			alert("매입수량을 입력하세요.");
			return false;
		}
		
		var spDate = $("input[name='spDate']").val();
		if(spDate == ""){
			alert("매입 등록일자를 입력하세요.");
			return false;
		}
	})
	
	$("#btnPname").click(function () {
		var pName = $("#pName").val();
		if(pName == ""){
			alert("품목명을 입력해주세요.");
		}else{
			$.ajax({
				url:"${pageContext.request.contextPath}/product/productSearchName.do",
				type:"get",
				data:{"pName":pName},
				dataType:"json",
				success:function(res){
					console.log(res);
					if(res.result == "success"){
						alert("존재하는 품목입니다.");
					}else if(res.result == "fail"){
						alert("존재하지 않는 품목입니다.");
					}
				}
			})
		}
	})
	
	$("#btnReset").click(function() {
		location.href="${pageContext.request.contextPath}/product/supplierOrderList2.do"
	})
	
	var spNo = $("input[name=no]").val();
	console.log(spNo);
	if(spNo < 10){
		$("input[name=spNo]").val("SP000"+spNo);
	}else if(spNo > 9 && spNo < 100){
		$("input[name=spNo]").val("SP00"+spNo);
	}else if(spNo > 99 && spNo < 1000){
		$("input[name=spNo]").val("SP0"+spNo);
	}
})
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Purchase Modification</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/soSubMenu.do">발주/매입</a> > <a href="${pageContext.request.contextPath}/product/supplierOrderList2.do">매입 이력 리스트</a> > <span id="k_title">&nbsp;매입 이력 수정&nbsp;</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/supplierOrderMod2.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>매입번호</label>
					<input type="text" name="spNo" class="text" readonly="readonly"><br>
					<input type="hidden" name="no" value="${SupplierPurchase.spNo}">
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="spPname" id="pName" class="text" placeholder=" >> 품목명 조회" value="${SupplierPurchase.spPname.pName }">
					<input type="button" value="조회" id="btnPname"><br>
					
					<label><span class="red">* </span>공급 회사명</label>
					<input type="text" name="spSname" class="text" readonly="readonly" value="${SupplierPurchase.spSname.sName}"><br>
					
					<label><span class="red">* </span>매입가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="spPcost" class="text" readonly="readonly" value="${SupplierPurchase.spPcost.pCost}"><br>
					
					<label><span class="red">* </span>매입수량</label>
					<input type="text" name="spQty" class="text" value="${SupplierPurchase.spQty}"><br>
					
					<label><span class="red">* </span>매입 등록일자</label>
					<input type="date" name="spDate" class="text" value='<fmt:formatDate  value="${SupplierPurchase.spDate }" pattern="yyyy-MM-dd"/>'><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="수정" id="btnAdd" style="cursor: pointer">
			<input type="button" value="취소" id="btnReset" style="cursor: pointer">					
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>