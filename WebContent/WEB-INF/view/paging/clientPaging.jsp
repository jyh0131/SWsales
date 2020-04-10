<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	#contai{
		width: 80%;
    	margin: 0 auto;
    	text-align: center;
	}
	#paging{
    	font-size: 15px;
    	margin-top: 20px;
	}
	#paging a,#nowPage{
		text-decoration: none;
    	color: black;
    	margin-left: 30px;
	}
</style>
	<div id="contai">
		<div id="paging">
			<!-- 1~10까지 있는 페이지의 페이징 -->
			<c:url var="action" value="/client/clientList.do" />
			<c:if test="${param.prev}">
				<a href="${action}?page=${param.beginPage-1}">◀</a>
			</c:if>
			<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1"
				var="index">
				<c:choose>
					<c:when test="${param.page==index}">
	            		<span id="nowPage" style="color: skyblue; text-decoration: underline;">${index}</span>
	        		</c:when>
					<c:otherwise>
						<a href="${action}?page=${index}">${index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${param.next}">
				<a href="${action}?page=${param.endPage+1}">▶</a>
			</c:if>
		</div>
	</div>