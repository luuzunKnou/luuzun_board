<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Form</title>
<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
<script	src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="semantic/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript">
	$(function(){
		$("form[name='f1']").submit(function() {
			if(checkInputEmpty($("input[name]")) == false){
				return false;
			}
		});
	});
</script>

</head>
<body>
<div id ="wrap">
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<div id="article">
	<c:if test="${notMatchPassword}">
		<script type="text/javascript">
			alert("비밀번호가 일치하지 않습니다.");
		</script>
	</c:if>
	<form name="f1" action="changePassword.do" method="post">
		<fieldset>
		<p><label> 현재 비밀번호 </label> 
			<input type="password" name="oldPassword" value="">
			<span class="errorMsg">비밀번호를 입력해 주세요</span>
		
		<p>
			<label> 새 비밀번호 </label> 
			<input type="password" name="newPassword" value="">
			<span class="errorMsg">비밀번호를 입력해 주세요</span>
		<p>
			<input type="submit" value="비밀번호 변경">
		</p>
		</fieldset>
	</form>
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
</div>
</body>
</html>