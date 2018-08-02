
<%@page import="com.pgy.rentcar.dto.JSPMember_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title></title>
</head>
<body>

	<%
		String joinroot = (String) session.getAttribute("joinroot");
		String id = request.getParameter("id");
		JSPMember_Dto dto = null;
		dto = (JSPMember_Dto) request.getAttribute("dto");
	%>
	<center>
		<h1>회원정보상세보기</h1>
		<table border="1" width="500">
			<tr height="50" align="center">
				<td bgcolor="#cccccc">아이디</td>
				<td><%=dto.getId()%></td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">이메일</td>
				<td><%=dto.getEmail()%></td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">전화</td>
				<td><%=dto.getTel()%></td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">직업</td>
				<td><%=dto.getJob()%></td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">연령대</td>
				<td><%=dto.getAge()%></td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">취미</td>
				<td><%=dto.getHobby()%></td>
			</tr>
			<tr height="50" bgcolor="lightgreen">
				<td colspan="2" align="center">
					<button
						onclick="location.href='MemberUpdateForm?id=<%=dto.getId()%>'"
						class="btn btn-default">회원정보 수정</button>
					<button
						onclick="location.href='MemberDeleteForm?id=<%=dto.getId()%>'"
						class="btn btn-default">회원 탈퇴</button>
					<c:choose>
						<c:when test="${id eq 'admin'}">
							<button onclick="location.href='MemberList'"
								class="btn btn-default">목록보기</button>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>
				</td>

			</tr>

		</table>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>