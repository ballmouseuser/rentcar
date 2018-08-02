<%@page import="com.pgy.rentcar.dto.JSPBoard_Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pgy.rentcar.common.PageManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>보드리스트</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String root = (String) session.getAttribute("root");
		String id = (String) session.getAttribute("id");
		// 화면에 보여질 게시글의 개수를 지정(임의로 설정)
		int perPage = 10; // (1) 화면에 보여질 글 갯수
		int perBlock = 10; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수 

		// (3)-----------------------------------
		//int rowCount = dao.getAllCount(); //전체 글의 갯수를 저장하는 변수 
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
		//테이블에 표시할 번호를 지정 - 거꾸로 출력해 나갈것임.
		int number = pm.number;

		List<JSPBoard_Dto> list2 = (List<JSPBoard_Dto>)request.getAttribute("BoardList");
		List<JSPBoard_Dto> list = list2.subList(pm.startRow-1, pm.endRow);
//		try {
//			list = dao.selectPart(pm.startRow, pm.endRow);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
	%>
	<center>

		<h2>
			전체글보기(<%=currentPage + "/" + pm.pageCount%>)
		</h2>
		<table style="width:900px;" class="table table-hover">
			<tr height="40" align="center" style="font-size: 80%;">
				<td colspan="5" align="left">
				<%
					if(id!=null){%>
						<button onclick="location.href='BoardWriteForm'" class="btn btn-default">글쓰기</button>						
					<%}
				%>
				</td>
			</tr>
			<tr style="font-size: 80%;" align="center" bgcolor="lightgreen">
				<td width="50" style="color: blue;">번호</td>
				<td width="350" style="color: blue;">제목</td>
				<td width="100" style="color: blue;">작성자</td>
				<td width="150" style="color: blue;">날짜</td>
				<td width="50" style="color: blue;">조회수</td>
			</tr>
			<%
				//int cnt = 0;
				for (JSPBoard_Dto x : list) {
					if (x.getRef() % 2 == 0) {
			%>
			<tr bgColor="#effbf8">
				<%
					} else {
				%>
			
			<tr bgColor="cef6e3">
				<%
					}
						//cnt++;
				%>

				<td align="center"><%=number%></td>
				<td><a href="BoardInfo?num=<%=x.getNum()%>"
					style="text-decoration: none"> <%
 	if (x.getRe_step() > 1) {
 			for (int i = 0; i < (x.getRe_step() - 1) * 3; i++) {
 %>&nbsp; <%
 	}
 		}
 %> <%=x.getSubject()%></a></td>
				<td align="center"><%=x.getWriter()%></td>
				<td align="center"><%=x.getReg_date()%></td>
				<td align="center"><%=x.getReadcount()%></td>
				<%
					number--;// 주의 - 한 번호씩 내려 쓴다.*********************************
					}
				%>
			</tr>
			<tr height="2" bgcolor="lightgreen">
				<td colspan="5"></td>
			</tr>
		</table>

		<p>
			<%
				out.write(pm.getPagenation("BoardList"));
			%>
		</p>
	</center>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
</body>
</html>