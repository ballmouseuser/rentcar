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
		JSPMember_Dto dto = (JSPMember_Dto)request.getAttribute("dto");
	%>
	<center>
		<h1>회원정보수정하기</h1>
			<table border="1" width="500">
		<form action="MemberUpdateProc" method="post">
				<tr height="50" align="center">
					<td  bgcolor="#cccccc">아이디</td>
					<td><%=dto.getId()%></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">이메일</td>
					<td><input type="email" name="email" size="40"
						value="<%=dto.getEmail()%>"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">전화</td>
					<td><input type="tel" name="tel" size="40"
						value="<%=dto.getTel()%>"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">직업</td>
					<td><input type="text" name="job" size="40"
						value="<%=dto.getJob()%>"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">취미</td>
					<td><input type="text" name="hobby" size="40"
						value="<%=dto.getHobby()%>"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">패스워드</td>
					<td><input type="password" name="pass" size="40"></td>
				</tr>
				<input type="hidden" name="id" value="<%=dto.getId()%>"></td>
				<tr height="50" bgcolor="lightgreen" align="center">
					<td colspan="2">
						<input type="submit" value="저장하기" class="btn btn-default"></form>
						<button onclick="location.href='MemberInfo?id=<%=dto.getId() %>'" class="btn btn-default">돌아가기</button>
					</td>
				</tr>

			</table>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
