<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
		margin: 0;
		padding: 0;
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
		})
		.css({"background-color":"#F9FAFB"});
		
		$("#tbl tr").filter(function (idx, obj) {
			return idx % 2 != 0;
		})
		.css({"background-color":"#eee"});
		
		$("#btnAll").click(function() {
			location.href="supplierList.do";
		})
	});
</script>
<body>
	<div id="container">
		<form action="supplierSearch.do" method="post">
			<div id="search">
				<select id="selSearch" name="selSearch">
					<option selected>선택해주세요</option>
					<option value="sName">회사명</option>
					<option value="sBln">사업자등록번호</option>
					<option value="sTel">전화번호</option>
				</select>
				<input type="text" name="search" id="ipSearch">
				<input type="submit" value="검색" id="btnSearch">
				<input type="reset" value="초기화" id="btnClear">
				<input type="button" value="전체" id="btnAll">
			</div>
		</form>
		<table id="tbl">
			<tr>
				<th>회사번호</th>
				<th>회사명</th>
				<th>사업자 등록번호</th>
				<th>주 소</th>
				<th>전화번호</th>
				<th>FAX번호</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach var="supplier" items="${list }">
				<tr>
					<td>
						<c:choose>
							<c:when test="${supplier.sNo < 10 }">
								S000${supplier.sNo }
							</c:when>
							<c:when test="${supplier.sNo >= 10 }">
								S00${supplier.sNo }
							</c:when>
						</c:choose>
					</td>
					<td>${supplier.sName }</td>
					<td>${supplier.sBln }</td>
					<td>${supplier.sAddress }</td>
					<td>${supplier.sTel }</td>
					<td>${supplier.sFax }</td>
					<td>
						<a href="#"><button>수정</button></a>
						<a href="#"><button>삭제</button></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="#"><button id="btnAdd">등 록</button></a>
	</div>
</body>
</html>