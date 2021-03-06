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
	#btnMod{
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
	input[name*='pName']{
		font-weight: bold;
		color: #336600;
	}
	input[name*='pPrice']{
		font-weight: bold;
		color: blue;
	}
	input[name*='pSno']{
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
$(function() {
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
	
	var pCateName = $("input[name=cate]").val();
	console.log(pCateName);
	$("#pCate").val(pCateName).prop("selected", true);
		
		
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
	
	/*** 품목번호 입력창에 출력되는 형식***/
	var no = $("input[name=no]").val();
	console.log(no); // ex : 98
	if(no < 10){
		$("input[name=pNo]").val("P000"+no); //P0001
	}else if(no > 9 && no < 100){
		$("input[name=pNo]").val("P00"+no); //P0010
	}else if(no > 99 && no < 1000){
		$("input[name=pNo]").val("P0"+no); //P0100
	}
})
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Modification</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/productList2.do">소프트웨어 제품 리스트</a> > <a href="${pageContext.request.contextPath}/product/productDetail.do?pNo=${product.pNo}&pCate=${product.pCate.cateNo}">소프트웨어 제품 상세정보</a> > <span id="k_title">&nbsp;소프트웨어 제품 수정&nbsp;</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/productMod.do" method="post" enctype="multipart/form-data">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>품목번호</label>
					<input type="text" name="pNo" class="text" readonly="readonly"><br>
					<input type="hidden" name="no" value="${product.pNo}">
					
 					<label><span class="red">* </span>분류명</label>
 					<input type="hidden" name="cate" value="${product.pCate.cateNo }">
					<select name="pCate" class="text" id="pCate">
						<option selected>선택해주세요</option>
						<option value=1>사무</option>
						<option value=2>개발</option>
						<option value=3>전문분야</option>
						<option value=4>멀티미디어</option>
						<option value=5>기업업무</option>
						<option value=6>서버</option>						
					</select>
					<br>
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="pName" class="text" placeholder=" >> 중복확인" value="${product.pName}" id="pName">
					<input type="button" value="중복확인" id="btnPname"><br>
					
					<label><span class="red">* </span>공급가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="pCost" class="text" value="${product.pCost}"><br>
					
					<label><span class="red">* </span>판매가격 <span class="cnt">(1개당)</span></label>
					<input type="text" name="pPrice" class="text" value="${product.pPrice}"><br>
					
					<label><span class="red">* </span>공급 회사명</label>
					<input type="text" name="pSno" class="text" placeholder=" >> 회사명 조회" value="${product.pSno.sName}" id="sName">
					<input type="button" value="조 회" id="btnSname"><br>
					
					<label><span class="red">* </span>최초재고수량</label>
					<input type="text" name="pQty" class="text" value="${product.pQty}"><br>
					
					
					<label><span class="red">* </span>최초등록일자</label>
					<input type="date" name="pDate" class="text" value='<fmt:formatDate  value="${product.pDate }" pattern="yyyy-MM-dd"/>'><br>
					
					<label>&nbsp&nbsp제품 이미지</label>
					<input type="file" name="pPic" value="${product.pPicPath}" ><br>
				</div>
			</div>
			<div id="add">
				<input type="submit" value="수정" id="btnMod" style="cursor: pointer">
				<input type="button" value="취소" id="btnReset" style="cursor: pointer">			
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>