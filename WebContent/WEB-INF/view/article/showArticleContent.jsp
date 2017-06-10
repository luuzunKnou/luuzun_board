<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	#divArticleContent { width:1200px; margin: 0 auto; }
	.attr {width:100px;}
	.val {width:600px;}
</style>

</head>
<body>
	<div id="divArticleContent">
		<table border="1">
			<tr>
				<td class="attr">번호					</td>
				<td class="val">${articleContent.article.articleNo }	</td>
			</tr>
			
			<tr>
				<td class="attr">작성자</td>
				<td class="val">${articleContent.article.writerId.memberName }	</td>
			</tr>
			
			<tr>
				<td class="attr">제목</td>
				<td class="val">${articleContent.article.title}</td>
			</tr>
			
			<tr>
				<td class="attr">내용</td>
				<td class="val">${articleContent.content}</td>
			</tr>
		</table>
	</div>
</body>
</html>