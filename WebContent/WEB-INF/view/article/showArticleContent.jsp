<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Article Content</title>
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
	<c:if test="${isPermission==false}">
		<script type="text/javascript">
			alert("권한이 없습니다.");
		</script>
	</c:if>
	<div id="article">
		<table id="showContent">
			<tr>
				<td class="attr">번호</td>
				<td class="val">${articleContent.article.articleNo } </td>
			</tr>
			
			<tr>
				<td class="attr">작성자</td>
				<td class="val">${articleContent.article.writerId.memberId } </td>
			</tr>
			
			<tr>
				<td class="attr">제목</td>
				<td class="val">${articleContent.article.title} </td>
			</tr>
			
			<tr>
				<td class="attr">내용</td>
				<td class="val">${articleContent.content} </td>
			</tr>
			
			<tr>
				<td class="attr">파일</td>
				<td class="val"><a href="downloadProcess.do?filename=${articleContent.filePath}">${articleContent.filePath}</a>
			</tr>
		</table>
		<div id="btnGroup">
		<button type="button" class="ui inverted gray basic button"
				onclick="location.href='modifyArticle.do?articleNo=${articleContent.article.articleNo }'">
			수정</button>
		<button type="button" class="ui inverted gray basic button"
				onclick="location.href='deleteArticle.do?articleNo=${articleContent.article.articleNo }&memberId=${articleContent.article.writerId.memberId }'">
			삭제</button>
		<button type="button" class="ui inverted gray basic button" onclick="history.back()">
			돌아가기</button>
		</div>	
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
</div>
</body>
</html>