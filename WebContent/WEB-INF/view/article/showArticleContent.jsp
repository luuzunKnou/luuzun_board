<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Article Content</title>

<style type="text/css">
	#divArticleContent { width:1200px; }
	.attr {width:100px;}
	.val {width:600px;}
</style>

</head>
<body>
<c:if test="${isPermission==false}">
	<script type="text/javascript">
		alert("권한이 없습니다.");
	</script>
</c:if>
	<div id="divArticleContent">
		<table border="1">
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
		<button type="button" onclick="location.href='modifyArticle.do?articleNo=${articleContent.article.articleNo }'">
			수정</button>
		<button type="button" onclick="location.href='deleteArticle.do?articleNo=${articleContent.article.articleNo }&memberId=${articleContent.article.writerId.memberId }'">
			삭제</button>
		<button type="button" onclick="history.back()">
			돌아가기</button>	
	</div>
</body>
</html>