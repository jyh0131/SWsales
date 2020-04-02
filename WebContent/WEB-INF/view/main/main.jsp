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
		  slideWidth: 1599,
		  });
	})
</script>
<style>
	div.bxslider{
	}
</style>
<section>
	<div class="bxslider">
		<div><img src="${pageContext.request.contextPath}/images/main/test1.jpg"></div>
		<div><img src="${pageContext.request.contextPath}/images/main/test2.jpg"></div>
	</div>
</section>
<%@include file="../include/footer.jsp"%>