<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title>회원가입</title>
</head>
<body>
<%
String joinroot=(String)session.getAttribute("joinroot");
%>
	<center>
		<h2>회원가입</h2>
		<form action='JoinProc' method='post'>
			<table width='800' >
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">아이디</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='input' name='id'
						size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">비밀번호</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='password'
						name='pass' size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">이메일</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='email'
						name='email' size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">전화번호</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='tel' name='tel'
						size='40'></td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">연령대</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='radio' name='age'
						value='10대'>10대&nbsp;&nbsp; <input type='radio' name='age'
						value='20대'>20대&nbsp;&nbsp; <input type='radio' name='age'
						value='30대'>30대&nbsp;&nbsp; <input type='radio' name='age'
						value='40대'>40대&nbsp;&nbsp; <input type='radio' name='age'
						value='50대'>50대&nbsp;&nbsp; <input type='radio' name='age'
						value='60대'>60대&nbsp;&nbsp;</td>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">직업</td>
					<td width='550' align='left' bgcolor="lightgreen"><select name='job'>
							<option value='교사'>교사</option>
							<option value='판사'>판사</option>
							<option value='공무원'>공무원</option>
							<option value='회사원'>회사원</option>
							<option value='공인중개사'>공인중개사</option>
					</select>
				</tr>
				<tr height='30'>
					<td width='150' align='center' bgcolor="#cccccc">취미</td>
					<td width='550' align='left' bgcolor="lightgreen"><input type='checkbox'
						name='hobby' value='승마'>승마&nbsp;&nbsp; <input
						type='checkbox' name='hobby' value='당구'>당구&nbsp;&nbsp; <input
						type='checkbox' name='hobby' value='바둑'>바둑&nbsp;&nbsp; <input
						type='checkbox' name='hobby' value='게임'>게임&nbsp;&nbsp; <input
						type='checkbox' name='hobby' value='등산'>등산&nbsp;&nbsp; <input
						type='checkbox' name='hobby' value='낚시'>낚시&nbsp;&nbsp;</td>
				</tr>
				<tr height='30' bgcolor="lightgreen">
					<td align='center' colspan='2'><input type='submit' value='가입하기' class="btn btn-default">
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>