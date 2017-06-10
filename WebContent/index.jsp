<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty userAuth}">
		${userAuth }님 반갑습니다.
		<a href="writeArticle.do">게시글 작성</a>
		<a href="showArticleList.do">게시글 보기</a>
		<a href="logout.do">로그아웃</a>
		<a href="changePassword.do">비밀번호 변경</a>
	</c:if>
	
	<c:if test="${empty userAuth}">
		<a href="join.do">회원가입</a>
		<a href="login.do">로그인</a>
		<a href="showMemberList.do">회원보기</a>
	</c:if>
</body>
</html>