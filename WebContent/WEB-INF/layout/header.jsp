<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	String userID = (String)session.getAttribute("userID");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>luuzun Board</h1>
	</header>
	<div id="login">
	
	<c:if test="${!empty userAuth}">
		${userAuth }님 반갑습니다.
		<a href="logout.do">로그아웃</a>
		<a href="changePassword.do">비밀번호 변경</a>
	</c:if>
	
	<c:if test="${empty userAuth}">
		<a href="join.do">회원가입</a>
		<a href="login.do">로그인</a>
	</c:if>
	</div>
	<div class="ui three item menu">
		<a href="writeArticle.do"    class="item">게시글 작성</a>
		<a href="showArticleList.do" class="item">게시글 보기</a>
		<a href="showMemberList.do"  class="item">회원보기</a>
	</div>
	<!-- <nav>
		<ul>
			<li><a href="writeArticle.do">게시글 작성</a></li>
			<li><a href="showArticleList.do">게시글 보기</a></li>
			<li><a href="showMemberList.do">회원보기</a></li>
		</ul>
	</nav> -->
</body>
</html>