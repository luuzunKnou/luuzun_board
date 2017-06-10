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
<script type="text/javascript">
	$(function(){
		var $isValidData = false;
		var $isValidId = false;

		$(".formTag").blur(function() {
			$("span[class='errorMsg']").css("display","none");
			//공백 여부 체크
			if(checkInputEmpty($("input[name]")) == false){
			} 			
			//패스워드 일치 여부 체크
			else if($("input[name='memberCheckPassword']").val() != $("input[name='memberPassword']").val()){
				var $next = $("input[name='memberCheckPassword']").nextAll(".errorMsg");
				$next.css("display","block");
			} else {
				 $isValidData = true;
			}
		})
		
		$(".idForm").blur(function() {
			//입력 ID로 member 정보를 받음
			$.ajax({
				url:"idDuplicationCheck.do",
				type:"get",
				dataTye:"json",
				data:{"memberId": $("input[name='memberId']").val()},
				success:function(data){
					console.log(data);
					var $next = $("input[name='memberId']").nextAll(".duplicateIdErrorMsg");
					if(data.isDuplicateId=="false") {
						$next.css("display","none");
						$isValidId = true;
					} else {				
						$next.css("display","block");
					}
				}
			})	
		})
		
		$("form[name='f1']").submit(function() {
			if($isValidData && $isValidId){
				alert('회원 가입에 성공하셧습니다.');
			} else {
				alert('Invalid Data  '+$isValidData+':'+$isValidId);
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
			<input type="text" name="memberId" value="" class="formTag idForm">
			<span class="errorMsg">ID를 입력하세요.</span>
			<span class="duplicateIdErrorMsg">이미 사용중인 아이디 입니다.</span>
			
			<p><label>이름</label>
			<input type="text" name="memberName" value="" class="formTag">
			<span class="errorMsg">이름을 입력하세요.</span>
			
			<p><label>비밀번호</label>
			<input type="text" name="memberPassword" class="formTag">
			<span class="errorMsg">비밀번호를 입력하세요.</span>
			
			<p><label>비밀번호 확인</label>
			<input type="text" name="memberCheckPassword" class="formTag">
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