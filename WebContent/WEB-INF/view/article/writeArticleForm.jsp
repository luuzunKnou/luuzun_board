<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Article Form</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style type="text/css">
	fieldset {width: 700px;}
</style>
<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
<script	src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="semantic/semantic.min.js"></script>

</head>
<body>
<div id ="wrap">
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<form action="writeArticle.do" method="post" name="f1" enctype="multipart/form-data">
		<fieldset><legend>게시물 작성</legend>
		<p>
			<label>제목</label><input type="text" name="title">
			<span class="errorMsg"> 제목을 입력하세요 </span> 
		<p>
			<label>내용</label><textarea rows="30" cols="60" name="content"></textarea>
			<span class="errorMsg"> 내용을 입력하세요 </span> 
		<p>
			<label>파일 업로드</label>
			<input type="file" name="fileName">
		<p>
			<input type="submit" value="추가">
			<input type="reset" value="다시작성">
			<input type='button' value="돌아가기" onClick='history.back()'> 
		</fieldset>
	</form>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
</div>
</body>
</html>