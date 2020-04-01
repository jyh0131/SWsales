<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<table>
			<tr>
				<th>회사번호</th>
				<th>회사명</th>
				<th>사업자 등록번호</th>
				<th>주 소</th>
				<th>전화번호</th>
				<th>FAX번호</th>
				<th></th>
			</tr>
			<c:forEach var="supplier" items="${list }">
				<tr>
					<td>${supplier.sNo }</td>
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
	</div>
</body>
</html>