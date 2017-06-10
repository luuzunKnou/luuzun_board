<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Article Form</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style type="text/css">
	fieldset {width: 700px;}
</style>
</head>
<body>
	<form action="modifyArticle.do" method="post" name="f1" enctype="multipart/form-data">
		<fieldset><legend>게시물 작성</legend>
			<input type="hidden" name="articleNo" value="${articleContent.article.articleNo }">
		<p>
			<label>제목</label><input type="text" name="title" value="${articleContent.article.title}">
			<span class="errorMsg"> 제목을 입력하세요 </span> 
		<p>
			<label>내용</label><textarea rows="30" cols="60" name="content">${articleContent.content}</textarea>
			<span class="errorMsg"> 내용을 입력하세요 </span> 
		<p>
			<label>파일 업로드</label>
			<input type="file" name="fileName">
		<p>
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>