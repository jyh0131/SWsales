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
    	outline-color: red;
	}
	#btnPname, #btnSname{
	    width: 130px;
    	height: 35px;
 		color: white;
		outline: none;
		border: none;
		border-radius: 5px; 
	}
	#btnPname{
		background: #f08080;
	}
	#btnSname{
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
	input[name*='pNo']{
		font-weight: bold;
		color: #000080;
		font-size: 16px;
		outline: none;
		background: #eee;
	}
	select[name*='pCate']{
		font-weight: bold;
	}
	select[name*='pName']{
		font-weight: bold;
		color: #336600;
	}
	input[name*='pPrice']{
		font-weight: bold;
		color: blue;
	}
	select[name*='pSno']{
		font-weight: bold;
		color: #990000;	
	}
	input[name*='pQty']{
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
$(function () {
	//등록버튼
	$("#btnAdd").click(function () {
		var text = $("#pName").val();
		var text1 = $("select[name=pCate]").val();
		if(tex1 == "선택해주세요"){
			alert("dasdada");
			location.href="productAdd.do";
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
						alert("등록된 품목입니다.");
					}else if(res.result == "fail"){
						alert("등록 가능한 품목입니다.");
					}
				}
			})
		}
	})
	
	$("#btnSname").click(function() {
		var sName = $("#sName").val();
		if(sName == ""){
			alert("회사명을 입력해주세요");
		}else{
			$.ajax({
				url:"${pageContext.request.contextPath}/client/supplierSearchName.do",
				type:"get",
				data:{"sName":sName},
				dataType:"json",
				success:function(res){
					console.log(res);
					if(res.result == "success"){
						alert("등록된 회사입니다.");
					}else if(res.result == "fail"){
						alert("공급회사 등록이 필요합니다.");
					}
				}
			})
		}
	})
	
	$("#btnReset").click(function() {
		location.href="${pageContext.request.contextPath}/product/productList2.do";
	})
	
	var pno = $("input[name=pNo]").val();
	console.log(pno);
	if(pno < 10){
		$("input[name=no]").val("P000"+pno);
	}else if(pno > 9 && pno < 100){
		$("input[name=no]").val("P00"+pno);
	}else if(pno > 99 && pno < 1000){
		$("input[name=no]").val("P0"+pno);
	}
})	
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Registration</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/productList2.do">소프트웨어 제품 리스트</a> > <span id="k_title">소프트웨어 제품 등록</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/productAdd.do" method="post" enctype="multipart/form-data">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>품목번호</label>
					<input type="text" name="pNo" class="text" value=" P00${product.pNo+1 }" readonly="readonly"><br>
					<input type="hidden" name="pNo" value="${product.pNo+1 }">
					
					<label><span class="red">* </span>분류명</label>
					<select name="pCate" class="text">
							<option selected>선택해주세요</option>
						<c:forEach var="category" items="${list1}">
							<option value="${category.cateNo}">${category.cateName}</option>
						</c:forEach>
					</select>
					<br>
								
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="pName" class="text" placeholder=" >> 중복확인" id="pName">
					<input type="button" value="중복확인" id="btnPname" style="cursor: pointer"><br>
										
					<label><span class="red">* </span>공급가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="pCost" class="text"><br>
					
					<label><span class="red">* </span>판매가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="pPrice" class="text"><br>
					
					<label><span class="red">* </span>공급 회사명</label>
					<select name="pSno" class="text">
							<option selected>선택해주세요</option>
						<c:forEach var="supplier" items="${list3}">
							<option value="${supplier.sNo}">${supplier.sName}</option>
						</c:forEach>
					</select>
					<input type="button" value="조 회" id="btnSname" style="cursor: pointer"><br>				
					
					<label><span class="red">* </span>최초재고수량</label>
					<input type="text" name="pQty" class="text"><br>
					
					
					<label><span class="red">* </span>최초등록일자</label>
					<input type="date" name="pDate" class="text"><br>
					
					<label>&nbsp&nbsp&nbsp제품 이미지</label>
					<input type="file" name="pPic"><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="등록" id="btnAdd" style="cursor: pointer">
			<input type="button" value="취소" id="btnReset" style="cursor: pointer">			
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>