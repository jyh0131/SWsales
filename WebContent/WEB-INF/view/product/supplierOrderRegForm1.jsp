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
	input[name*='soNo']{
		font-weight: bold;
		color: #000080;
		font-size: 16px;
		outline: none;
		background: #eee;
	}
	select[name*='pInfo']{
		font-weight: bold;
		color: #336600;
		position: relative;
	}
	div#checkOk{
		width: 200px;
		font-size: 14px;
		color: red;
		font-weight: bold;
		position: absolute;
		right: 500px;
		top: 640px;
	}	
	input[name*='soSname']{
		font-weight: bold;
		color: #990000;	
	}
	input[name*='soSname'], input[name*='soPcost']{
		outline: none;
		background: #eee;
	}
	input[name*='soPcost'], input[name*='soQty']{
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
		/*** 등록막기 ***/
	 	$("form").submit(function() {
	 		//품목명
	 		var pName = $("select[name='pInfo']").val();
			if(pName == "선택해주세요"){
				alert("품목명을 선택해주세요.");
				$("#soPname").focus();
				return false;
			}
			
			var check = $("#checkOk").html();
			if(check != "품목명 조회가 완료되었습니다."){
				alert("품목명 조회가 필요합니다.");
				return false;
			}
			
			//공급회사명, 발주가격
			var sName = $("#soSname").val();
			var cost = $("#soPcost").val();
			if(sName == "" && cost == ""){
				alert("품목명 조회가 필요합니다.");
				$("#soPname").focus();
				$("#soPcost").focus();
				return false;				
			}
			
			//발주수량
			var qty = $("#soQty").val();
			var qtyReg = /^[0-9]*$/;
			if(qty == ""){
				alert("발주수량을 입력하세요.");
				$("#soQty").focus();
				return false;				
			}
			
			if(qtyReg.test(qty) == false){
				alert("(발주수량) 숫자만 입력하세요.");
				$("#soQty").focus();
				return false;			
			}
			
			//발주 등록일자
			var date = $("#soDate").val();
			if(date == ""){
				alert("발주 등록일자를 입력하세요.");
				$("#soDate").focus();
				return false;				
			}
	 	})
	 	
		/*** 품목명 조회 버튼 ***/
		$("#btnPname").click(function() {
			var pName = $("select[name='pInfo']").val(); //품목번호를 가져옴
			if(pName == "선택해주세요"){
				alert("품목명을 선택해주세요.");
				$("#soPname").focus();
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/product/productSearchNo.do",
					type:"get",
					data:{"pInfo":pName},
					dataType:"json",
					success:function(res){
						console.log(res);
						if(res.result == "success"){
							/* alert(pName); */
							var arr = pName.split("/"); // arr[0] : 번호/ arr[1] / arr[2]
							$("#soSname").val(arr[1]);
							$("#soPcost").val(arr[2]);
							$("#btnPname").hide();
							$("#checkOk").html("품목명 조회가 완료되었습니다.");
						}
					}
				})
			}
			
		})
		
	})
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Software Product Order Registration</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/soSubMenu.do">발주/매입</a> > <span id="k_title">발주 이력 등록</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/sOrderAdd1.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>발주번호</label>
					<input type="text" name="soNo" class="text" value=" SO00${SupplierOrder.soNo+1 }" readonly="readonly"><br>
					
					<!-- 품목명 조회후 공급회사명, 발주가격 자동입력 -->
						<label><span class="red">* </span>품목명</label>
						<select name="pInfo" class="text" id="soPname">
							<option selected="selected" value="선택해주세요">선택해주세요</option>					
								<c:forEach var="product" items="${list}">
									<option value="${product.pNo}/${product.pSno.sName}/${product.pCost}">[${product.pCate}] ${product.pName}</option>
								</c:forEach>
						</select>
						<input type="button" value="조회" id="btnPname" style="cursor: pointer">
						<div id="checkOk"></div><br>
						
							<label><span class="red">* </span>공급 회사명</label>
							<input type="text" name="soSname" class="text" readonly="readonly" id="soSname" placeholder=" >> 품목명 조회가 필요합니다(자동입력)"><br>
							<label><span class="red">* </span>발주가격 <span class="cnt">(1개당)</span></label>
							<input type="text" name="soPcost" class="text"  readonly="readonly" id="soPcost" placeholder=" >> 품목명 조회가 필요합니다(자동입력)"><br>				
					
					<label><span class="red">* </span>발주수량</label>
					<input type="text" name="soQty" class="text" id="soQty"><br>
					
					<label><span class="red">* </span>발주 등록일자</label>
					<input type="date" name="soDate" class="text" id="soDate"><br>
				</div>
			</div>
			<div id="add">
			<input type="submit" value="등록" id="btnAdd" style="cursor: pointer">
			<input type="button" value="취소" id="btnReset" style="cursor: pointer">		
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>