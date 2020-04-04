<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
	/** 이미지 **/
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
	
	/** 서브메뉴 **/
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
	div#submenu ul a:hover{
		border-bottom: 4px solid black;
		font-size: 19px;
	}
</style>
<section>
		<div id="imgDiv">
			<img src="${pageContext.request.contextPath}/images/main/test1.png">
		</div>
		<div id="submenu">
			<ul>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_regi.png"><br>
					<a href="${pageContext.request.contextPath}/product/productAdd.do"><b>제품 등록</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_so.png"><br>
					<a href="${pageContext.request.contextPath}/product/supplierOrderList.do"><b>발주 / 매입</b> ></a>
				</li>
				<li>
					<img src ="${pageContext.request.contextPath}/images/main/smenu_cd.png"><br>
					<a href="${pageContext.request.contextPath}/product/clientDeliveryList.do"><b>출 고</b> ></a>
				</li>				
			</ul>
		</div>		
</section>
<%@ include file="../include/footer.jsp" %>