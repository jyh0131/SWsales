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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Registration</h1>
			<hr>
			<h3>제품 관리 > 소프트웨어 제품 리스트 > <span id="k_title">소프트웨어 제품 등록</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/productList.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>품목번호</label>
					<input type="text" name="pNo" class="text" value=" P00${product.pNo+1 }" readonly="readonly"><br>
					
 					<label><span class="red">* </span>분류명</label>
					<select name="pCate" class="text">
						<option selected>선택해주세요</option>
						<option value="사무">사무</option>
						<option value="개발">개발</option>
						<option value="전문분야">전문분야</option>
						<option value="멀티미디어">멀티미디어</option>
						<option value="기업업무">기업업무</option>
						<option value="서버">서버</option>						
					</select>
					<br>
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="pName" class="text" placeholder=" >> 중복확인">
					<input type="button" value="중복확인" id="btnSname"><br>
					
					<label><span class="red">* </span>공급가격</label>
					<input type="text" name="pCost" class="text"><br>
					
					<label><span class="red">* </span>판매가격</label>
					<input type="text" name="pPrice" class="text"><br>
					
					<label><span class="red">* </span>공급 회사명</label>
					<input type="text" name="pSno" class="text" placeholder=" >> 회사명 조회">
					<input type="button" value="조 회" id="btnSname"><br>
					
					<label><span class="red">* </span>최초재고수량</label>
					<input type="text" name="pQty" class="text"><br>
					
					
					<label><span class="red">* </span>최초등록일자</label>
					<input type="date" name="pDate" class="text"><br>
					
					<label>&nbsp&nbsp제품 이미지</label>
					<input type="file" name="pPic"><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="등록" id="btnAdd"><a href="${pageContext.request.contextPath}/product/productList1.do">리스트</a>
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>