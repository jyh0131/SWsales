<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
		background: url("${pageContext.request.contextPath}/images/main/formtest.png") no-repeat;
		background-size: 100%, 200px;
		margin-bottom: 100px;
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
	#point{
		width: 65%;
    	height: 40px;
    	margin: 0 auto;
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
	#btnCname, #btnCaddress{
	    width: 130px;
    	height: 35px;
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumZipAddress() {
		new daum.Postcode({
			oncomplete:function(data) {
				jQuery("#cAddress").val(data.address);
				jQuery("#cAddress").focus();
				console.log(data);
			}
		}).open();
	}
	$(function () {
		$("#btnCname").click(function () {
			var cName = $("#cName").val();
			if(cName == ""){
				alert("상호명을 입력해주세요.");
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/client/clientSearchName.do",
					type:"get",
					data:{"cName":cName},
					dataType:"json",
					success:function(res){
						console.log(res);
						if(res.result == "success"){
							alert("등록된 상호명입니다.");
						}else if(res.result == "fail"){
							alert("등록 가능한 상호명입니다.");
						}
					}
				})
			}
		})
		
		$("#btnReset").click(function() {
			location.href="${pageContext.request.contextPath}/client/clientList.do"
		})
		
		var cno = $("input[name=cNo]").val();
		console.log(cno);
		if(cno < 10){
			$("input[name=no]").val("C000"+cno);
		}else if(cno > 9 && cno < 100){
			$("input[name=no]").val("C00"+cno);
		}else if(cno > 99 && cno < 1000){
			$("input[name=no]").val("C0"+cno);
		}
	})
</script>
	<section>
		<div id="title">
			<h1>Supplier List</h1>
			<hr>
			<h3>거래처 관리 / 고객사 정보수정</h3>
		</div>	
		<div id="point">
			<label class="red">＊ 필수입력</label>
		</div>
		<form action="${pageContext.request.contextPath}/client/clientMod.do" method="post">
			<div id="regForm">
				<div id="form">
					<label><span class="red">* </span>고객번호</label>
					<input type="text" name="no" class="text" readonly="readonly"><br>
					<input type="hidden" name="cNo" value="${client.cNo }">
					
					<label><span class="red">* </span>상호명</label>
					<input type="text" name="cName" class="text" id="cName" placeholder=" >> 중복확인" value="${client.cName }">
					<input type="button" value="중복확인" id="btnCname" style="cursor: pointer"><br>
					
					<label><span class="red">* </span>대표명</label>
					<input type="text" name="cCeo" class="text" value="${client.cCeo }"><br>
					
					<label>&nbsp&nbsp주소</label>
					<input type="text" name="cAddress" id="cAddress"class="text" placeholder=" >> 주소검색"  value="${client.cAddress }">
					<input type="button" value="주소검색" id="btnCaddress" onclick="openDaumZipAddress();" style="cursor: pointer"><br>
					
					<label><span class="red">* </span>전화번호</label>
					<input type="text" name="cTel" class="text" placeholder=" '-'로 구분하여 입력" value="${client.cTel }"><br>
					
					<label>&nbsp&nbsp담당직원</label>
					<input type="text" name="cSman" class="text" value="${client.cSman }"><br>
				</div>
			</div>
			<div id="add">
				<input type="submit" value="수정" id="btnMod" style="cursor: pointer">
				<input type="button" value="취소" id="btnReset" style="cursor: pointer">
			</div>
		</form>
	</section>
<%@ include file="../include/footer.jsp" %>