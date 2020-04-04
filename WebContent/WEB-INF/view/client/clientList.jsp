<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
	#imgDiv img{
		width: 100%;
		height: 600px;	
	}
	div#submenu{
		width: 100%;
		height: 150px;
		line-height: 50px;

	}
	div#submenu ul{
		width: 100%;
		height: 150px;
		padding-top: 20px;
	}
	div#submenu ul li{
		width: 810px;
		height: 120px;
		float: left;
		list-style: none;
		text-align: center;
	}
	div#submenu ul li img{
		width: 55px;
		height: 55px;
		padding-top: 10px;
	}
	div#submenu ul li a{
		text-decoration: none;
		color:  #0067B8;
		font-size: 17px;
	}
	div#submenu ul a:hover{
		border-bottom: 4px solid black;
		font-size: 19px;
	}
	div#title{
		width: 100%;
		height: 200px;
		line-height: 100px;
		margin-top: 50px;
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
	#search{
		margin: 10px;
		position: relative;
	}
	#lblSearch{
		width: 70px;
   		height: 39px;
    	display: inline-block;
    	background-color: #ccc;
    	line-height: 35px;
    	text-align: center;
    	margin-left: -10px;
    	margin-right: -6px;
	}
	#selSearch{
		width: 150px;
    	height: 36px;
   		margin-left: -10px;
	}
	#ipSearch{
		width: 200px;
    	height: 32px;
    	margin-top: 2px;
	}
	#btnSearch{
		width: 60px;
		height: 36px;
		background-color: #384D75;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#btnClear{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
	}
	#btnAll{
		width: 60px;
		height: 36px;
		background-color: #ccc;
		border: 1px solid white;
		color: white;
		border-radius: 5px;
		position: absolute;
		right: 0;
	}
	#container{
		width: 60%;
		margin: 0 auto;
		position: relative;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	th, td{
		border: 1px solid #ccc;
		text-align: center;
		height: 46px;
	}
	th{
		border-top: 2px solid #878787;
		background-color: #F9FAFB;
	}
	#btnAdd{
		width: 130px;
		height: 40px;
		background-color: #384D75;
		color: white;
		margin: 10px 0;
    	position: absolute;
    	right: 0;
		border: 1px solid white;
		border-radius: 5px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function () {
		$("#tbl tr").filter(function (idx, obj) {
			return idx % 2 == 0;
		}).css({"background-color":"#F9FAFB"});
		
		$("#tbl tr").filter(function (idx, obj) {
			return idx % 2 != 0;
		}).css({"background-color":"#eee"});
		
		$("#btnAll").click(function() {
			location.href="clientList.do";
		})
		
		$(".btnDel").click(function() {
			var no = $(this).attr("data-cNo");
			console.log(no);
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href="${pageContext.request.contextPath}/client/clientDel.do?no="+no;
			}
		})
	});
</script>

	<section>
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/main/test1.png">
		</div>
		<div id="submenu">
			<ul>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_sp.png"><br>
					<a href="${pageContext.request.contextPath}/client/supplierList.do"><b>공급 회사</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_cl.png"><br>
					<a href="${pageContext.request.contextPath}/client/clientList.do"><b>고객사</b> ></a>
				</li>				
			</ul>
		</div>
		<div id="title">
			<h1>Client List</h1>
			<hr>
			<h3>거래처 관리 / 고객사 리스트</h3>
		</div>
		<div id="container">
			<form action="clientSearch.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="cName">상호명</option>
						<option value="cCeo">대표명</option>
						<option value="cTel">전화번호</option>
						<option value="cSman">담당직원</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch" style="cursor: pointer">
					<input type="reset" value="초기화" id="btnClear" style="cursor: pointer">
					<input type="button" value="전체" id="btnAll" style="cursor: pointer">
				</div>
			</form>
			<table id="tbl">
				<tr>
					<th>고객번호</th>
					<th>상호명</th>
					<th>대표명</th>
					<th>주 소</th>
					<th>전화번호</th>
					<th>담당직원</th>
					<th>수정/삭제</th>
				</tr>
				<c:forEach var="client" items="${list }">
					<tr>
						<td>
							<c:choose>
								<c:when test="${client.cNo < 10 }">
									C000${client.cNo }
								</c:when>
								<c:when test="${client.cNo >= 10 }">
									C00${client.cNo }
								</c:when>
							</c:choose>
						</td>
						<td>${client.cName }</td>
						<td>${client.cCeo }</td>
						<td>${client.cAddress }</td>
						<td>${client.cTel }</td>
						<td>${client.cSman }</td>
						<td>
							<a href="${pageContext.request.contextPath}/client/clientMod.do?no=${client.cNo}"><button style="cursor: pointer">수정</button></a>
							<button class="btnDel" style="cursor: pointer" data-cNo="${client.cNo }">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
<%@ include file="../include/footer.jsp" %>