<%@page import="com.pgy.rentcar.dto.JSPBoard_Dto"%>
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
<title>보드 업데이트 폼</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String root = (String) session.getAttribute("root");
		//BoardDAO dao = new BoardDAO();
		JSPBoard_Dto dto = null;
		String subject = "";
		String content = "";
		dto = (JSPBoard_Dto)request.getAttribute("dto");
//		try {
			//bean = dao.select(num);
			//subject = bean.getSubject();
			//content = bean.getContent();

//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	%>
	<center>
		<h2>게시글수정</h2>
		<form action="BoardUpdateProc" method="post">
			<table width="600">
				<tr height="40">
					<td width="120" align="center" bgcolor="lightGreen">작성자</td>
					<td width="180" align="center"><%=dto.getWriter()%></td>
					<td width="120" align="center" bgcolor="lightGreen">작성일</td>
					<td width="180" align="center"><%=dto.getReg_date()%></td>
				</tr>

				<tr height="40">
					<td width="120" align="center" bgcolor="lightGreen">제목</td>
					<td width="480" colspan="3">&nbsp; <input type="text"
						name="subject" value="<%=dto.getSubject()%>" size="60"></td>
				</tr>
				<tr height="40">
					<td width="120" align="center" bgcolor="lightGreen">패스워드</td>
					<td width="480" colspan="3">&nbsp; <input type="password"
						name="password" size="60"></td>
				</tr>
				<tr height="40" align="center">
					<td width="120" align="center" bgcolor="lightGreen">글내용</td>
					<td width="480" colspan="3"><textarea rows="10" cols="70"
							name="content" align="left"><%=dto.getContent()%></textarea></td>
				</tr>
				<tr>

					<td colspan="4" align="center"><input type="hidden" name="num"
						value="<%=dto.getNum()%>"> <input type="submit"
						value="글수정" class="btn btn-default"> &nbsp;&nbsp; <input type="button"
						onclick="location.href='BoardList'" value="전체글보기" class="btn btn-default"></td>
				</tr>
			</table>
	</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>