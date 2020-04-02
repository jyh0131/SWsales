<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
$(function(){
	  $('.bxslider').bxSlider({
		  auto: true,
		  pager: true,
		  slideWidth: 1600,
		  });
	})
</script>
<style>
	div#m_dummy_icons{
		text-align: center;
		padding: 20px;
	}
	div#m_dummy_icons img{
		width: 600px;
		height: 93px;
	}
	div#m_dummy_img1 ul li{
		list-style: none;
		float: left;
		margin-left: 30px;
	}
	div#m_dummy_img2 img{
		width: 1600px;
		height: 600px;
	}
	div#m_sns ul li{
		float: left;
		list-style: none;
		margin-left: 15px;
		color: #353535;
	}
	div#m_sns ul li a img{
		width: 23px;
		height: 23px;
	}
</style>
<section>
	<br><br>
	<div class="bxslider">
		<div><img src="${pageContext.request.contextPath}/images/main/bx1.png"></div>
		<div><img src="${pageContext.request.contextPath}/images/main/bx4.png"></div>
		<div><img src="${pageContext.request.contextPath}/images/main/bx2.png"></div>		
		<div><img src="${pageContext.request.contextPath}/images/main/bx3.png"></div>		
	</div>
	<div id="m_dummy_icons">
		<img src="${pageContext.request.contextPath}/images/main/main_icon.png">
	</div>
	<div id="m_dummy_img1">
		<ul>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy1.png">
				<h3>제목</h3>
				<p>내용</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy2.png">
				<h3>제목</h3>
				<p>내용</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy3.png">
				<h3>제목</h3>
				<p>내용</p>				
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy4.png">
				<h3>제목</h3>
				<p>내용</p>				
			</li>
		</ul>
	</div>
	<div id="m_dummy_img2">
		<img src="${pageContext.request.contextPath}/images/main/main_dummy5.png">
	</div>
	<div id="m_dummy_img3">
	</div>
	<div id="m_sns">
		<ul>
			<li>NAMBAWAN IT 알아보기 >> </li>
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/main/ico_face.png"></a></li>
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/main/ico_kakao.png"></a></li>
			<li><a href="#"><img src="${pageContext.request.contextPath}/images/main/ico_naver.png"></a></li>
		</ul>
	</div>
</section>
<%@include file="../include/footer.jsp"%>