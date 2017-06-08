<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#divMemberList {
	width: 900px;
	margin: 0 auto;
}
</style>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$.ajax({
			url:"showMemberList.do",
			type:"get",
			dataTye:"json",
			success:function(data){
				console.log(data);
				/* $(data).each(function(i, element){
					var $liobj = $("<li>");
					$liobj.html(element.memberId);
					$("#tableMemberList").append($liobj);
				}) */
			}
		})
	});
</script>

</head>
<body>
	<div id="divMemberList">
		<table border="1" id="tableMemberList">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>비밀번호</td>
				<td>가입일</td>
			</tr>
		</table>
	</div>


	<%-- <div id=divMemberList>
		<c:if test="${memberList.size() == 0}">
			가입된 회원이 없습니다.
		</c:if>
		<c:if test="${memberList.size() > 0}">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>비밀번호</td>
					<td>가입일</td>
				</tr>
				<c:forEach var="item" items="${memberList}">
					<tr>
						<td>${item.memberId }</td>
						<td>${item.memberName }</td>
						<td>${item.memberPassword }</td>
						<td>${item.memberRegDate }</td>
						<td><a href="modifyProcess.do?id=${item.id}">수정</a></td>
						<td><a href="deleteProcess.do?id=${item.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div> --%>
</body>
</html>