<%@page import="java.util.List"%>
<%@page import="com.pgy.rentcar.dto.RentCar_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = (String) session.getAttribute("id");
		RentCar_Dto dto = (RentCar_Dto) request.getAttribute("dto");
	%>

	<font size="6" color="gray"><%=dto.getName()%> 수정</font>
	<form action="UpdateCarInfoProc" method="post">
		<center>
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="hidden" name="no" value="<%=dto.getNo() %>"><%=dto.getNo() %></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=dto.getName()%>"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td>
						<input type="radio" name="category" value="1" <c:if test="${dto.category eq '1'}">checked="checked"</c:if>/>소형
						<input type="radio" name="category" value="2" <c:if test="${dto.category eq '2'}">checked="checked"</c:if>/>중형
						<input type="radio" name="category" value="3" <c:if test="${dto.category eq '3'}">checked="checked"</c:if>/>대형
					
					</td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price"
						value="<%=dto.getPrice()%>"></td>
				</tr>
				<tr>
					<td>인승</td>
					<td><select name="usepeople">
					 		<option value="8" <c:if test="${dto.usepeople eq '1'}">selected="selected"</c:if>>1인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '2'}">selected="selected"</c:if>>2인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '3'}">selected="selected"</c:if>>3인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '4'}">selected="selected"</c:if>>4인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '5'}">selected="selected"</c:if>>5인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '6'}">selected="selected"</c:if>>6인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '7'}">selected="selected"</c:if>>7인승</option>	
							<option value="8" <c:if test="${dto.usepeople eq '8'}">selected="selected"</c:if>>8인승</option>	
									
					</select></td>
				</tr>
				<tr>
					<td>제조회사</td>
					<td><input type="text" name="company"
						value="<%=dto.getCompany()%>"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="text" name="img" value="<%=dto.getImg() %>"></td>
				</tr>
				<tr>
					<td height="70">정보</td>
					<td><textarea cols="32" rows="6" name="info" value="<%=dto.getInfo()%>"><%=dto.getInfo()%></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='UpdateCancel'">
					</td>
				</tr>
				
			</table>
		</center>
	</form>
</body>
</html>