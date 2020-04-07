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
	span#k_title{
		color: red;
		background-color: white;
	}
	span#d_title{
		color: navy;
		background-color: yellow;
	}
	
	div#proAdd{
	width: 100%;
	height: 40px;
	margin-top: 100px;
	text-align: right;
	}

	button#btnMod{
		width: 130px;
		height: 40px;
		background-color: #384D75; /* #87cefa */
		color: white;
		border: 1px solid white;
		border-radius: 5px;
		margin-right: 10px;
	}
		
	button#btnDel{
		width: 130px;
		height: 40px;
		background-color: #384D75; /* #f08080 */
		color: white;
		border: 1px solid white;
		border-radius: 5px;
		margin-right: 10px;
	}
	
	div#detail_container{
		width: 100%;
		margin-top: 50px;
	}
	
	table{
		width: 100%;
		border-collapse: collapse;
	}
	th, td{
		border: 1px solid #ccc;
	}
	td#tbl_title{
		height: 100px;
		text-align: left;
		background-color: #bad1e8;
		border-bottom: 10px solid #0d1f30;
		border-top-right-radius: 30px;
		border-top-left-radius: 30px;
		border-top: none;
		border-left: none;
		border-right: none;
	}
	td#tbl_title h1{
		font-size: 30px;
		letter-spacing: 4px;
		padding-left: 20px;
	}
	th{
		width: 350px;
		height: 50px;
		text-align: center;
		font-size: 19px;
		color: #0d1f30;
		background-color: #eee;
		letter-spacing: 3px;
	}
	td{
		background: #F9FAFB;
		font-size: 18px;
	}
	td#pro_img{
		width: 400px;
		height: 400px;
		background: white;
	}
	td img{
		width: 401px;
		height: 434px;
	}
	td p {
		padding-left: 10px;
	}
	td p#pNo {
		font-weight: bold;
		color: #000080;
	}
	td p#pCate{
		font-weight: bold;
	}
	td p#pName{
		font-weight: bold;
		color: #336600;
	}
	td p#pPrice{
		font-weight: bold;
		color: blue;
	}
	td span#pSname{
		font-weight: bold;
		color: #990000;
	}
	td p#pQty{
		font-weight: bold;
	}	
</style>
	<section>
		<div id="title">
			<h1>Software Product Detail</h1>
			<hr>
			<h3>제품 관리 > 소프트웨어 상품 리스트 > <span id="k_title">소프트웨어 제품 상세정보</span> : <span id="d_title">[${detail.pName } - ${detail.pCate}]</span></h3>
		</div>
		<div id="proAdd">
			<a href="${pageContext.request.contextPath}/product/productMod.do"><button id="btnMod">수 정</button></a>	
			<a href="${pageContext.request.contextPath}/product/productAdd.do"><button id="btnDel">삭 제</button></a>	
		</div>
		<div id="detail_container">
			<table>
				<tr>
					<td colspan="3" id="tbl_title"><h1>▶ [${detail.pCate}] ${detail.pName }  </h1></td>
				</tr>
				<tr>
					<td rowspan="8" id="pro_img"><img src="${pageContext.request.contextPath}/productIMG/${detail.pPicPath}"></td>
					<th>품목번호</th>
					<td>
						<p id="pNo">P00${detail.pNo}</p>
					</td>
				</tr>
				<tr>
					<th>분류</th>
					<td>
						<p id="pCate">${detail.pCate}</p>
					</td>
				</tr>
				<tr>
					<th>품목명</th>
					<td>
						<p id="pName">${detail.pName }</p>
					</td>
				</tr>
				<tr>
					<th>공급가격</th>
					<td>
						<p><fmt:formatNumber value="${detail.pCost}" pattern="\#,###.##"/></p>
					</td>
				</tr>
				<tr>
					<th>판매가격</th>
					<td>
						<p id="pPrice"><fmt:formatNumber value="${detail.pPrice}" pattern="\#,###.##"/></p>
					</td>
				</tr>
				<tr>
					<th>공급회사</th>
					<td>
						<p> - <span id="pSname">${detail.pSno.sName} (S00${detail.pSno.sNo})</span></p>
						<p> - ${detail.pSno.sAddress }</p>
						<p> - ${detail.pSno.sTel }</p>
					</td>
				</tr>
				<tr>
					<th>최초 재고수량</th>
					<td>
						<p id="pQty">${detail.pQty} 개</p>
					</td>
				</tr>
				<tr>
					<th>최초등록일자</th>
					<td>
						<p><fmt:formatDate value="${detail.pDate}" type="both" pattern="yyyy-MM-dd"/></p>
					</td>
				</tr>																								
			</table>				
		</div>
	</section>
<%@ include file="../include/footer.jsp" %>