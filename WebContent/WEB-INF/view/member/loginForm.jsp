<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
<script	src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="semantic/semantic.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript">
	$(function(){
		$("form[name='f1']").submit(function() {
			$("span[class='errorMsg']").css("display","none");
			if(checkInputEmpty($("input[name]")) == false){
				return false;
			}
		});
		
		$("#join").click(function() {
			location.href = "join.do";
		})
	});
</script>

</head>
<body>
<div id ="wrap">
	<jsp:include page="../../layout/header.jsp"></jsp:include>
	<div id="article">
	<form name="f1" action="login.do" method="post">
		<fieldset>
		<p><label> 아이디 </label> 
			<input type="text" name="id" value="">
			<span class="errorMsg">ID를 입력하세요.</span>
		
		<p>
			<label> 비밀번호 </label> <input type="password" name="password" value="">
			<span class="errorMsg">비밀번호를 입력하세요.</span>
		
		<p>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" id="join">
		</p>
		</fieldset>
	</form>
	
	<c:if test="${notJoin}">
		<p class="error2"> 회원이 아닙니다.
	</c:if>
	
		<c:if test="${notMatchPassword}">
		<p class="error2"> 비밀번호가 일치하지 않습니다.
	</c:if>
	</div>
	<jsp:include page="../../layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>