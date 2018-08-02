<%@page import="com.pgy.rentcar.dto.RentCar_Dto"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<%
	int no =Integer.parseInt(request.getParameter("no"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	String img = request.getParameter("img");
	
	RentCar_Dto dto = (RentCar_Dto)request.getAttribute("dto");
	
%>
</head>
<body>
	<center>
		<form action="CarReserveResult" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">[<%=dto.getName()%>
					
								옵션선택]</font></td>
				</tr>
				<tr>
					<td rowspan="7" width="50%" align="center"><image alt="" src="resources/img/<%=img%>" width="450"></image></td>

					<td width="25%" align="center">대여기간</td>
					<td width="25%" align="left" width="40"><select name="dday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
							<option value="6">6일</option>
							<option value="7">7일</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">대여일자</td>
					<td align="left"><input type="date" name="rday" ></td>
				</tr>
				
				<tr>
					<td width="25%" align="center">보험적용</td>
					<td align="left"><select name="insurance" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">WiFi적용</td>
					<td align="left"><select name="wifi" width="40">
							<option value="1">적용(1일1만원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>

				<tr>
					<td width="25%" align="center">Navigation적용</td>
					<td align="left"><select name="navigation" width="40">
							<option value="1">적용(무료)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">Baby seat적용</td>
					<td align="left"><select name="babyseat" width="40">
							<option value="1">적용(5000원)</option>
							<option value="0">비적용</option>
					</select></td>
				</tr>
				<tr>
					
					<td width="25%" align="center" colspan="2">
					<input type="hidden" name="qty" value="<%=qty%>">
					<input type="hidden" name="no" value="<%=no%>">
					<input type="submit" value="차량예약하기" class="btn btn-default"></td>
				</tr>

			</table>
		</form>
		<p>
			<font size="5" color="gray">차량정보보기</font>
		<p>
			<%=dto.getInfo()%>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>