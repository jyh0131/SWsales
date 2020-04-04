<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	#point{
		width: 65%;
    	height: 40px;
    	margin: 0 auto;
	}
	.red{
		color: red;
		
	}
	#imgDiv{
		width: 100%;
		height: 600px;
		margin: 0 auto;
		margin-top: 50px;
		margin-bottom: 20px;
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumZipAddress() {
		new daum.Postcode({
			oncomplete:function(data) {
				jQuery("#sAddress").val(data.address);
				jQuery("#sAddress").focus();
				console.log(data);
			}
		}).open();
	}
	$(function () {
		$("#btnSname").click(function () {
			var sName = $("#sName").val();
			if(sName == ""){
				alert("회사명을 입력해주세요.");
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
							alert("등록 가능한 회사입니다.");
						}
					}
				})
			}
		})
		
		$("#btnReset").click(function() {
			location.href="${pageContext.request.contextPath}/client/supplierList.do"
		})
		
		var sno = $("input[name=sNo]").val();
		console.log(sno);
		if(sno < 10){
			$("input[name=no]").val("S000"+sno);
		}else if(sno > 9 && sno < 100){
			$("input[name=no]").val("S00"+sno);
		}else if(sno > 99 && sno < 1000){
			$("input[name=no]").val("S0"+sno);
		}
		
	})
</script>
	<section>
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/main/test1.png">
		</div>
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/client/supplierAdd.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>회사번호</label>
					<input type="text" name="no" class="text" readonly="readonly"><br>
					<input type="hidden" name="sNo" value="${supplier.sNo+1 }">
					
					<label><span class="red">* </span>회사명</label>
					<input type="text" name="sName" class="text" id="sName" placeholder=" >> 중복확인">
					<input type="button" value="중복확인" id="btnSname" style="cursor: pointer"><br>
					
					<label><span class="red">* </span>사업자등록번호</label>
					<input type="text" name="sBln" class="text" placeholder=" 000-00-00000"><br>
					
					<label>&nbsp&nbsp주소</label>
					<input type="text" name="sAddress" id="sAddress"class="text" placeholder=" >> 주소검색">
					<input type="button" value="주소검색" id="btnSaddress" onclick="openDaumZipAddress();" style="cursor: pointer"><br>
					
					<label><span class="red">* </span>전화번호</label>
					<input type="text" name="sTel" class="text" placeholder=" '-'로 구분하여 입력"><br>
					
					<label>&nbsp&nbspFAX번호</label>
					<input type="text" name="sFax" class="text" placeholder=" '-'로 구분하여 입력"><br>
				</div>
			</div>
			<div id="add">
				<input type="submit" value="등록" id="btnAdd" style="cursor: pointer">
				<input type="button" value="취소" id="btnReset" style="cursor: pointer">
			</div>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>