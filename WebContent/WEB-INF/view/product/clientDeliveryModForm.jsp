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
	$(function() {
		$("#btnReset").click(function() {
			location.href="${pageContext.request.contextPath}/product/clientDeliveryList.do"
		})
		
		var no = $("input[name=no]").val();
		console.log(no);
		if(no < 10){
			$("input[name=cdNo]").val("CD000"+no);
		}else if(no > 9 && no < 100){
			$("input[name=cdNo]").val("CD00"+no);
		}else if(no > 99 && no < 1000){
			$("input[name=cdNo]").val("CD0"+no);
		}
	})
</script>
<section>
		<!-- form 타이틀 -->
		<div id="title">
			<h1>Client Delivery Modification</h1>
			<hr>
			<h3><a href="${pageContext.request.contextPath}/product/pSubMenu.do">제품 관리</a> > <a href="${pageContext.request.contextPath}/product/clientDeliveryList.do">출고 리스트</a> > <span id="k_title">&nbsp;출고 정보 수정&nbsp;</span></h3>
		</div>
		<!-- form -->		
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/product/cDeliveryMod.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>품목번호</label>
					<input type="text" name="cdNo" class="text" readonly="readonly"><br>
					<input type="hidden" name="no" value="${clientDelivery.cdNo}">
					
					<label><span class="red">* </span>고객 상호명</label>
					<input type="text" name="cName" class="text" value="${clientDelivery.cName.cName}" readonly="readonly"><br>
					
					<label><span class="red">* </span>품목명</label>
					<input type="text" name="pName" class="text" value="${clientDelivery.pName}"  readonly="readonly"><br>
					
					<label><span class="red">* </span>출고수량</label>
					<input type="text" name="oQty" class="text" value="${clientDelivery.cdSno.oQty}"  readonly="readonly"><br>
					
					<label><span class="red">* </span>출고일자</label>
					<fmt:formatDate value="${clientDelivery.cdDate}" var="viewDt" pattern="yyyy-MM-dd" />
					<input type="date" name="cdDate" class="text" value="${viewDt}"><br>
				</div>
			</div>
			<div id="add">
				<input type="submit" value="수정" id="btnAdd">
				<input type="button" value="취소" id="btnReset" style="cursor: pointer">		
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp" %>