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
		width: 358px;
		list-style: none;
		float: left;
		margin-left: 30px;
		line-height: 25px;
	}
	div#m_dummy_img1 ul li p{
		font-size: 14px;
	}
	div#m_dummy_img2{
		width: 1600px;
		margin-top: 20px;
	}	
	div#m_dummy_img2 img{
		width: 1600px;
		height: 600px;
		margin-top: 80px;
		margin-bottom: 80px;
	}
	div#m_dummy_img3{
		height: 350px;
		margin-bottom: 100px;
	}
	div#m_dummy_img3 ul li{
		width: 358px;
		list-style: none;
		float: left;
		margin-left: 30px;
		line-height: 25px;
	}
	div#m_dummy_img3 ul li p{
		font-size: 14px;
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
				<h3>여러분을 위한 365</h3>
				<p>날마다 NAMBAWAN Office 365로 할 수 있는 일들을 찾아보세요.</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy2.png">
				<h3>원격으로 간편하게 일하기</h3>
				<p>원격 소프트웨어로 어디서나 무료로 채팅하고, 회의하고, 통화하고, 공동 작업할 수 있습니다.</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy3.png">
				<h3>더욱 새로워진 Surface Software</h3>
				<p>더욱 가벼워진 소프트웨어로 강력한 개성을 뽐내세요.</p>				
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy4.png">
				<h3>원격으로 작업하면서도 보호 상태 유지</h3>
				<p>사용자가 신뢰할 수 있는 지속적이며 포괄적인 보호 기능이 제공됩니다.</p>				
			</li>
		</ul>
	</div>
	<div id="m_dummy_img2">
		<img src="${pageContext.request.contextPath}/images/main/main_dummy5.png">
	</div>
	<div id="m_dummy_img3">
		<ul>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy6.png">
				<h3>비즈니스용 NAMBAWAN Office 365</h3>
				<p>동급 최고의 Office 앱, 지능형 클라우드 서비스 및 고급 보안으로 비즈니스를 운영하고 성장시키세요.</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy7.png">
				<h3>온라인 교실 만들기</h3>
				<p>최상의 소프트웨어 프로그램으로 교육자와 학생에 무료로 제공하는 Teams 프로그램을 사용하여 과제를 만들고 가상으로 공동 작업하는 등 여러 활동을 하는 방법에 대한 전문가의 팁을 확인하세요.</p>
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy8.png">
				<h3>Kubernetes 작동</h3>
				<p>어떻게 작동하는지 알아보고 클라우드 네이트브 앱 개발을 바로 시작하세요.</p>				
			</li>
			<li>
				<img src="${pageContext.request.contextPath}/images/main/main_dummy9.png">
				<h3>Visual Studio 2019</h3>
				<p>생산적이로 현대적이며 혁신적인 IDE인 Visual Studio 2019를 바로 사용하세요.</p>				
			</li>
		</ul>	
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