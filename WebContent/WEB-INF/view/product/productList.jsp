<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>
<style>
 	*{
		margin: 0;
		padding: 0;
	}
	#imgDiv{
		width: 100%;
		height: 600px;
		margin: 0 auto;
		margin-top: 50px;
		margin-bottom: 20px;
	}
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
		width: 540px;
		height: 120px;
		float: left;
		list-style: none;
		text-align: center;
	}
	div#submenu ul li img{
		width: 50px;
		height: 50px;
		padding-top: 10px;
	}
	div#submenu ul li a{
		text-decoration: none;
		color:  #0067B8;
		font-size: 17px;
	}
	div#submenu ul li:hover{
		background: #D5D5D5;
		display: block;
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
		font-size: 17px;
	}
	.tbl_point:hover{
		color: red;
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

	<section>
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/main/test1.png">
		</div>
		<div id="submenu">
			<ul>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_regi.png"><br>
					<a href="#"><b>제품 등록</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_so.png"><br>
					<a href="#"><b>발주 / 매입</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_cd.png"><br>
					<a href="#"><b>출 고</b> ></a>
				</li>				
			</ul>
		</div>
		<div id="title">
			<h1>Software Product List</h1>
			<hr>
			<h3>제품 관리 / 소프트웨어 상품 리스트</h3>
		</div>
		<div id="container">
			<form action="supplierSearch.do" method="post">
				<div id="search">
					<select id="selSearch" name="selSearch">
						<option selected>선택해주세요</option>
						<option value="pName">품목명</option>
						<option value="pCate">분류명</option>
						<option value="pSno">공급회사명</option>
					</select>
					<input type="text" name="search" id="ipSearch">
					<input type="submit" value="검색" id="btnSearch">
					<input type="reset" value="초기화" id="btnClear">
					<input type="button" value="전체" id="btnAll">
				</div>
			</form>
			<table id="tbl">
				<tr>
					<th>품목번호</th>
					<th>분류명</th>
					<th>품목명</th>
					<!-- <th>품목 이미지</th> -->
					<th>공급가격</th>
					<th>판매가격</th>
					<th>공급회사명</th>
					<th>최초재고수량</th>
					<th>최초등록일자</th>
					<th>수정/삭제</th>
				</tr>
				<c:forEach var="product" items="${list }">
					<tr class="tbl_point">
						<td class="tbl_point">
							<c:choose>
								<c:when test="${product.pNo < 10 }">
									P000${product.pNo }
								</c:when>
								<c:when test="${product.pNo >= 10 }">
									P00${product.pNo }
								</c:when>
							</c:choose>
						</td>
						<td>${product.pCate }</td>
						<td>${product.pName }</td>
						<%-- <td>${product.pPicPath }</td> --%>
						<td><fmt:formatNumber value="${product.pCost }" pattern="\#,###.##"/></td>
						<td><fmt:formatNumber value="${product.pPrice }" pattern="\#,###.##"/></td>
						<td>${product.pSno.sName }
							<c:choose>
								<c:when test="${product.pSno.sNo < 10 }">
									(S000${product.pSno.sNo })
								</c:when>
								<c:when test="${product.pSno.sNo >= 10 }">
									(S00${product.pSno.sNo })
								</c:when>
							</c:choose>
						</td>
						<td>${product.pQty }</td>
						<td><fmt:formatDate value="${product.pDate }" type="both" pattern="yyyy-MM-dd"/></td> <!-- yyyy-MM-dd(E) -->	
						<td>
							<a href="#"><button>수정</button></a>
							<a href="#"><button>삭제</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a href="${pageContext.request.contextPath}/product/productAdd.do"><button id="btnAdd">등 록</button></a>
		</div>
<%@ include file="../include/footer.jsp" %>