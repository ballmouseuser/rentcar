
<%@page import="com.pgy.rentcar.dto.JSPMember_Dto"%>
<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>멤버업데이트</title>
</head>
<body>
	<%
	String joinroot=(String)session.getAttribute("joinroot");	
	String id = request.getParameter("id");
	JSPMember_Dto dto = null;
	dto = (JSPMember_Dto)request.getAttribute("dto");
	%>
	<center>
		<h1>회원탈퇴하기</h1>
			<table border="1" width="500">
		<form action="MemberDeleteProc" method="post">
				<tr height="50" align="center">
					<td  bgcolor="#cccccc">아이디</td>
					<td><%=dto.getId()%></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">패스워드</td>
					<td><input type="password" name="pass" size="40"></td>
				</tr>
				<input type="hidden" name="id" value="<%=dto.getId()%>"></td>
				<tr height="50" bgcolor="lightgreen" align="center">
					<td colspan="2">
						<input type="submit" value="탈퇴하기" class="btn btn-default"></form>
						<button onclick="location.href='MemberInfo?id=<%=dto.getId() %>'" class="btn btn-default">취소하기</button>
					</td>
				</tr>

			</table>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
