<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>보드 삭제 폼</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String root = (String) session.getAttribute("root");
	%>
	<center>
		<h2>게시글삭제</h2>
		<table border="1">
			<form action="BoardDeleteProc" method="post">
				<input type="hidden" name="num" value="<%=num%>">
				<tr height="40">
					<td>비밀번호</td>
					<td><input type="password" name="xpwd" size="60"></td>
				</tr>

				<tr height="40" align="center">
					<td colspan="2"><input type="submit" value="삭제완료" class="btn btn-default">&nbsp;
						&nbsp;
			</form>
			<input type="button"
				onclick="location.href='BoardInfo?num=<%=num%>'" value="되돌리기" class="btn btn-default">
			&nbsp; &nbsp;
			</td>
			</tr>
		</table>

	</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>


</body>
</html>