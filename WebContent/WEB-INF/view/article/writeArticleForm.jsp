<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style type="text/css">
	fieldset {width: 700px;}
</style>
</head>
<body>
	<form action="writeArticle.do" method="post" name="f1" enctype="multipart/form-data">
		<fieldset><legend>회원가입</legend>
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
		</fieldset>
	</form>
</body>
</html>