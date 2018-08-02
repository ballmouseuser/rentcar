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
<title>Insert title here</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String root = (String) session.getAttribute("root");
		JSPBoard_Dto dto = null;
		dto = (JSPBoard_Dto)request.getAttribute("dto");
	%>
	<center>
		<h2>게시글보기</h2>
		<table width="600">
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">글번호</td>
				<td align="center" width="180"><%=dto.getNum()%></td>
				<td align="center" width="120" bgcolor="skyblue">조회수</td>
				<td align="center" width="180"><%=dto.getReadcount()%></td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">작성자</td>
				<td align="center" width="180"><%=dto.getWriter()%></td>
				<td align="center" width="120" bgcolor="skyblue">작성일</td>
				<td align="center" width="180"><%=dto.getReg_date()%></td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">제목</td>
				<td align="center" colspan="3"><%=dto.getSubject()%></td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">글내용</td>
				<td align="center" colspan="3"><%=dto.getContent()%></td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4"><input type="button"
					value="답글쓰기"
					onclick="location.href='BoardReWriteForm?num=<%=dto.getNum()%>'" class="btn btn-default">
					<input type="button" value="수정하기"
					onclick="location.href='BoardUpdateForm?num=<%=dto.getNum()%>'" class="btn btn-default">
					<input type="button" value="삭제하기"
					onclick="location.href='BoardDeleteForm?num=<%=dto.getNum()%>'" class="btn btn-default">
					<%
						int backPage = Integer.parseInt(session.getAttribute("currentPage") + "");
						int backBlock = Integer.parseInt(session.getAttribute("currentBlock") + "");
					%> <input type="button" value="목록보기"
					onclick="location.href='BoardList?pageNum=<%=backPage%>&pageBlock=<%=backBlock%>'" class="btn btn-default">
				</td>
			</tr>


		</table>
	</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>