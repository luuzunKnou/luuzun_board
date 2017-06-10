<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Member List</title>

<style type="text/css">
#divMemberList {
	width: 900px;
	margin: 0 auto;
}
</style>

</head>
<body>
	<div id=divMemberList>
		<c:if test="${memberList.size() == 0}">
			가입된 회원이 없습니다.
		</c:if>
		<c:if test="${memberList.size() > 0}">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>비밀번호</td>
					<td>가입일</td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="item" items="${memberList}">
					<tr>
						<td>${item.memberId }</td>
						<td>${item.memberName }</td>
						<td>${item.memberPassword }</td>
						<td>${item.getMemberRegDateString() }</td>
						<td><a href="modifyProcess.do?id=${item.memberId}">수정</a></td>
						<td><a href="deleteProcess.do?id=${item.memberId}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>