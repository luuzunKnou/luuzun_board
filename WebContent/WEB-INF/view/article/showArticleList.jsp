<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#divArticleList{ width:1200px; margin: 0 auto; }

</style>

</head>
<body>
	<div id="divArticleList">
		<c:if test="${articleList.size() == 0}">
			등록된 글이 없습니다.
		</c:if>
		<c:if test="${articleList.size() > 0}">
			<table border="1">
				<tr>
					<td>번호			</td>
					<td>작성자 아이디	</td>
					<td>작성자 이름		</td>
					<td>제목			</td>
					<td>작성시간		</td>
					<td>수정시간		</td>
					<td>조회수			</td>
				</tr>
				<c:forEach var="item" items="${articleList}">
					<tr>
						<td>${item.number }</td>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td><a href="read.do?articleNo=${item.number}">${item.title}</a></td>
						<td>${item.regDate}</td>
						<td>${item.modifiedDate}</td>
						<td>${item.readCount}</td>
						<td><a href="modifyProcess.do?id=${item.number}">수정</a></td>
						<td><a href="deleteProcess.do?id=${item.number}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>