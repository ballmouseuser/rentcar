<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>BatchForm.jsp</title>
</head>
<body>
<!-- <script>
	var pass = prompt('관리자비밀번호 넣어세요');
	if(pass!='1234'){
		history.go(-1);
	}
</script>
 -->
<center>
<form action="BatchProc" method="post">
	<table width="800">
		<tr align="center">
		<td colspan="2">
		<font size="5" color="gray">
			[렌트카등록배치처리작업]
		</font>
		</td>
		</tr>
		<tr>
		<td width="100"  bgcolor="lightgreen">입력정보배치방법</td>
		<td>
		차종/1소형,2중형,3대형/랜트료/사용인원/회사/이미지파일명/상세정보#
		</td>
		</tr>
		
		<tr>
		<td width="100"  bgcolor="lightgreen">입력샘플</td>
		<td>
		SANTAFE/3/50000/5/현대/santafe.jpg/현대의 야심 브렌드#
		</td>
		</tr>
		<tr>
			<td width="100" bgcolor="lightgreen">배치자료입력</td>
			<td width="600">
			<textarea rows="15" cols="100" name="content"></textarea>
			</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
			<input type="submit" value="배치처리"/>
		</td>
		</tr>
	</table>
</form>
</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>