<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Member List</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
<script	src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="semantic/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">

</head>
<body>
<div id ="wrap">
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<div id="article">
		<c:if test="${memberList.size() == 0}">
			가입된 회원이 없습니다.
		</c:if>
		<c:if test="${memberList.size() > 0}">
			<table id="memberTable">
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>비밀번호</td>
					<td>가입일</td>
				</tr>
				<c:forEach var="item" items="${memberList}">
					<tr>
						<td>${item.memberId }</td>
						<td>${item.memberName }</td>
						<td>${item.memberPassword }</td>
						<td>${item.getMemberRegDateString() }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>