<%@page import="com.pgy.rentcar.dto.JSPMember_Dto"%>
<%@page import="java.util.List"%>
<%@page import="com.pgy.rentcar.common.PageManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title>가입자명단</title>
</head>
<body>
	<%
		String joinroot = (String) session.getAttribute("joinroot");
		String id = (String) session.getAttribute("id");
		if (id == null)
			id = "GUEST";
		//=============================================================
		// 화면에 보여질 게시글의 개수를 지정(임의로 설정)
		int perPage = 5; // (1) 화면에 보여질 글 갯수
		int perBlock = 5; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수 

		// (3)-----------------------------------
//		int rowCount = 0;//dao.getAllCount(); //전체 글의 갯수를 저장하는 변수 
//		try {
//			rowCount = dao.getAllCount();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


		int rowCount = Integer.parseInt(request.getAttribute("num").toString());
		
		
		// 현재 보고자 하는 페이지 와 페이지 블럭
		// 현재 카운터를 클릭한 번호값을 읽어옴 
		String pageNum = request.getParameter("pageNum");
		// 만약 처음 boardList.jsp 를 클릭하거나 수정 삭제 등 다른 게시글에서 이 페이지로 넘어오면 
		// pageNum값이 없어서 null처리를 해줌
		if (pageNum == null) {
			pageNum = "1";
		}
		// (4)------------------------------------
		int currentPage = Integer.parseInt(pageNum);
		String blockNum = request.getParameter("blockNum");
		if (blockNum == null) {
			blockNum = "1";
		}
		// (5)-------------------------------------
		int currentBlock = Integer.parseInt(blockNum);

		// 페이지 관리 객체를 생성 - new PageManager((1), (2))
		PageManager pm = new PageManager(perPage, perBlock);
		// 페이지 관리 객체 환경설정 - pm.setRowCount((3),(4),(5))
		pm.setRowCount(rowCount, currentPage, currentBlock);
		//테이블에 표시할 번호를 지정 - 거꾸로 줄력해 나갈것임.
		int number = pm.number;
		
		List<JSPMember_Dto> list2 = (List<JSPMember_Dto>)request.getAttribute("MemberList");
		List<JSPMember_Dto> list = list2.subList(pm.startRow-1, pm.endRow);
		
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);

		//=============================================================
	%>
	<center>
		<h1><%=id%>님 모든 회원의 등록 정보입니다.(<%=currentPage%>/<%=pm.pageCount %>)
		</h1>
		<table border="1" width="800">
			<tr height="50" align="center" bgcolor="#cccccc">
				<td width="100">아이디</td>
				<td width="150">이메일</td>
				<td width="200">전화</td>
				<td width="100">직업</td>
				<td width="250">취미</td>
			</tr>
			<%
			for (JSPMember_Dto x : list) {
			%>
			<tr height="50">
				<td width="100"><a
					href="MemberInfo?id=<%=x.getId()%>"> <%=x.getId()%></a></td>
				<td width="150"><%=x.getEmail()%></td>
				<td width="200"><%=x.getTel()%></td>
				<td width="100"><%=x.getJob()%></td>
				<td width="250"><%=x.getHobby()%></td>
			</tr>

			<%
			}
			%>
		</table>
		아이디를 누르면 상세보기가 출력됩니다.(<a href="MemberJoin" class="btn btn-default">회원가입</a>)
	</center>
	<p>
		<%
			out.write(pm.getPagenation("MemberList"));
		%>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>