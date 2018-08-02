<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약기록 삭제 작업</title>
</head>
<body>
<%
	int regno = Integer.parseInt(request.getParameter("regno"));
	String root = (String)session.getAttribute("root");
	session.setAttribute("deleteNum", regno);
	%>
	<script>
		
		x = confirm('확실합니까?');
		// document.write(x);
		if(!x){
			alert('되돌아 갑니다.');
			history.go(-1);
		}else{
			location.href='DeleteConfirm';
		}
	</script>

</body>
</html>