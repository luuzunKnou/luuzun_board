<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:board";
		try {
			con = DriverManager.getConnection(jdbcDriver);
			if (con != null) {
				out.print("커넨션 풀에 연결되었습니다.");
			} else {
				out.print("커넥션 풀에 연결 실패하였습니다");
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
	%>
</body>
</html>