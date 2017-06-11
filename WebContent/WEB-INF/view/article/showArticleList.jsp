<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Article List</title>
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
		<c:if test="${articleList.size() == 0}">
			등록된 글이 없습니다.
		</c:if>
		<c:if test="${articleList.size() > 0}">
			<table>
				<tr>
					<td id="tdNo">		No				</td>
					<td id="tdId">		아이디			</td>
					<td id="tdName">	이름			</td>
					<td id="tdTitle">	제목			</td>
					<td id="tdRegTime">	작성시간		</td>
					<td id="tdModTime">	수정시간		</td>
					<td id="tdCnt">		조회			</td>
				</tr>
				<c:forEach var="item" items="${articleList}">
					<tr>
						<td>${item.articleNo }</td>
						<td>${item.writerId.memberId }</td>
						<td>${item.writerId.memberName }</td>
						<td><a href="readArticle.do?articleNo=${item.articleNo}">${item.title}</a></td>
						<td>${item.getArticleRegDateString()}</td>
						<td>${item.getArticleModDateString()}</td>
						<td>${item.readCnt}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
</div>
</body>
</html>