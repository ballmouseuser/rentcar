<%@page import="com.pgy.rentcar.dto.ReserveView"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>예약확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String memid = (String) session.getAttribute("id");
		String img = null;
		if (memid == null) {
	%>
	<script>
		alert("로그인 후 사용하세요");
		history.go(-1);
	</script>
	<%
		}

		int regno = 0;

		List<ReserveView> list = (List<ReserveView>) request.getAttribute("list");

		Date d1 = new Date();
		Date d2 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d2 = sdf.parse(sdf.format(d2));
	%>

	<center>
		<font size="6" color="gray"><%=memid%>님 예약리스트(<%=list.size()%>건)</font>
		<table width="85%">
			<tr align="center" bgcolor="lightgreen">
				<td>예약번호</td>
				<td>차량이미지</td>
				<td>차종</td>
				<td>예약일</td>
				<td>대여일수</td>
				<td>대여수량</td>
				<td>보험</td>
				<td>WIFI</td>
				<td>NAVI</td>
				<td>BBST</td>
				<td>대여금액내역</td>
				<td>수정</td>
				<td>예약취소</td>
			</tr>
			<tr>

				<%
					for (ReserveView x : list) {
						d1 = sdf.parse(x.getRday());
						regno = x.getRegno();
						img = x.getImg();
						int res = d1.compareTo(d2);// -1,0,1
						if (res == -1) {
							out.print(x.getReverseInfoRow("lightgray"));
						} else {
							out.print(x.getReverseInfoRow("white"));
						}
				%>
				<td><button
						onclick="location.href='Adjust?regno=<%=regno%>&img=<%=img%>'"
						class="btn btn-default">수정</button></td>
				<td><button onclick="location.href='Delete?regno=<%=regno%>'"
						class="btn btn-default">예취</button></td>
			</tr>
			<%
				}
			%>
			</tr>
		</table>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>