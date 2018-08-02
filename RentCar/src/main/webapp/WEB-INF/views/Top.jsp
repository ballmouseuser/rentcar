<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title>VISION GROUPWARE</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String root = (String) session.getAttribute("root");
		String joinroot = (String) session.getAttribute("joinroot");
		if (id == null) {
			id = "GUEST";
		}
	%>
	<table width="85%">
		<tr height="70">
			<td colspan="4"><a href="Main" style="text-decoration: none">
					<img alt="로고출력자리" src="resources/img/LOGO1.jpg" height="80"
					width="100">
			</a></td>
			<td align="center" width="200">
				<%
					if (id.equals("GUEST")) {
				%>
				<button onclick="location.href='Login'" class="btn btn-login">로그인</button>
				<button onclick="location.href='MemberJoin'" class="btn btn-default">회원가입</button>
				<%
					} else {
				%> <%=id%>님
				<button onclick="location.href='Logout'" class="btn btn-default">로그아웃</button>
				<%
					}
				%>

			</td>
		</tr>
	</table>

	<table width="85%">
		<tr height="50">
			<td align="center" width="20%" bgcolor="#355C7D"><a
				href="CarReserveMain" style="text-decoration: none"> <font
					color="white" size="4" onMouseover="this.style.color='black';"
					onMouseout="this.style.color='white';">렌트카 예약</font></a></td>
			<td align="center" width="20%" bgcolor="#355C7D"><a
				href="ReserveView" style="text-decoration: none"><font
					color="white" size="4" onMouseover="this.style.color='black';"
					onMouseout="this.style.color='white';">예약 확인</font></a></td>
			<td align="center" width="20%" bgcolor="#355C7D"><a
				href="BoardList" style="text-decoration: none"><font
					color="white" size="4" onMouseover="this.style.color='black';"
					onMouseout="this.style.color='white';">자유 게시판</font></a></td>
			<%
				if (id.equals("admin")) {
			%>
			<td align="center" width="20%" bgcolor="#355C7D"><a
				href="CarProcess" style="text-decoration: none"><font
					color="white" size="4" onMouseover="this.style.color='black';"
					onMouseout="this.style.color='white';" style="font:bord;">차량 등록</font></a></td>
			<%
				}
			%>
			<c:choose>
				<c:when test="${id eq 'admin'}">
					<td align="center" width="20%" bgcolor="#355C7D"><a
						href="MemberList" style="text-decoration: none"><font
							color="white" size="4" onMouseover="this.style.color='black';"
							onMouseout="this.style.color='white';">고객 정보</font></a></td>
				</c:when>
				<c:otherwise>
					<td align="center" width="20%" bgcolor="#355C7D"><a
						href="MemberInfo?id=<%=id%>" style="text-decoration: none"><font
							color="white" size="4" onMouseover="this.style.color='black';"
							onMouseout="this.style.color='white';">고객정보</font></a></td>
				</c:otherwise>
			</c:choose>
		</tr>

	</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>