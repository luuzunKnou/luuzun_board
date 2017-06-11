<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to luuzun Board</title>
<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
<script	src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="semantic/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">

</head>
<body>
<div id ="wrap">
	<jsp:include page="WEB-INF/layout/header.jsp"></jsp:include>
	<script type="text/javascript">
		location.href="showArticleList.do";
	</script>
	<jsp:include page="WEB-INF/layout/footer.jsp"></jsp:include>
</div>
</body>
</html>