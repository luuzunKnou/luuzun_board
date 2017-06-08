<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>

<script>
	
	$(function(){
		$("form[name='f1']").submit(function() {
			$("span[class='errorMsg']").css("display","none");
	         if(checkInputEmpty($("input[name]")) == false){
	            return false;
	         }
	         
			/* $("span[class='errorMsg']").css("display","none");
			if($("input[name='memberId']").val() == ""){
				var $next = $("input[name='memberId']").next(".errorMsg");
				$next.css("display","block");
				return false;
			}
			if($("input[name='memberName']").val() == ""){
				var $next = $("input[name='memberName']").next(".errorMsg");
				$next.css("display","block");
				return false;
			}
			if($("input[name='memberPassword']").val() == ""){
				var $next = $("input[name='memberPassword']").next(".errorMsg");
				$next.css("display","block");
				return false;
			} */
			if($("input[name='memberCheckPassword']").val() != $("input[name='memberPassword']").val()){
				var $next = $("input[name='memberCheckPassword']").next(".errorMsg");
				$next.css("display","block");
				return false;
			}
		})
	});
</script>

</head>
<body>
	<form action="join.do" method="post" name="f1">
		<fieldset>
			<legend>회원가입</legend>
		
			<p><label>아이디</label>
			<input type="text" name="memberId" value="">
			<span class="errorMsg">ID를 입력하세요.</span>
			
			<p><label>이름</label>
			<input type="text" name="memberName" value="">
			<span class="errorMsg">이름을 입력하세요.</span>
			
			<p><label>비밀번호</label>
			<input type="text" name="memberPassword">
			<span class="errorMsg">비밀번호를 입력하세요.</span>
			
			<p><label>비밀번호 확인</label>
			<input type="text" name="memberCheckPassword">
			<span class="errorMsg">비밀번호가 일치하지 않습니다.</span>
			
			<p><input type="submit" value="가입">
			<input type="reset" value="취소">
		</fieldset>
	</form>
	<c:if test="${duplicateId == true}">
		<p class="errorMsgByID">이미 사용중인 아이디입니다.
	</c:if>
</body>
</html>