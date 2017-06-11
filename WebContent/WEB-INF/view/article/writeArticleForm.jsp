<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Article Form</title>
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
	<form action="writeArticle.do" method="post" name="f1" enctype="multipart/form-data">
		<fieldset><legend>게시글 작성</legend>
		<p>
			<label>제목</label>
			<input type="text" name="title" placeholder="Title" id="inputTitle">
			<span class="errorMsg"> 제목을 입력하세요 </span> 
		<p>
			<label>내용</label><textarea rows="" cols="" name="content" id="inputTitle"></textarea>
			<span class="errorMsg"> 내용을 입력하세요 </span> 
		<p>
			<label>파일 업로드</label>
			<input type="file" name="fileName" id="inputFrom">
		<p>
			<input type="submit" value="작성하기" class="ui inverted gray basic button">
			<input type="reset" value="다시작성"class="ui inverted gray basic button">
			<input type='button' value="돌아가기" onClick='history.back()'class="ui inverted gray basic button"> 
		</fieldset>
	</form>
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
</div>
</body>
</html>