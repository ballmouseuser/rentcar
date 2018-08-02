package com.pgy.rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgy.rentcar.dao.JSPBoard_IDao;
import com.pgy.rentcar.dto.JSPBoard_Dto;
/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BController {

	private static final Logger logger = LoggerFactory.getLogger(BController.class);
	
	@Autowired
	private SqlSession sqlSession;

	
	@RequestMapping("/BoardList")
	public String list(Model model, HttpServletRequest request) throws SQLException {
		System.out.println("BoardList()");
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		int num = dao.getAllCount();
		model.addAttribute("BoardList", dao.selectAll());
		model.addAttribute("num", num);
		return "Main.jsp?center=BoardList";
	}
	
	@RequestMapping("/BoardWriteForm")
	public String writeForm(Model model, HttpServletRequest request) { // 게시글 작성 폼으로 이동
		return "Main.jsp?center=BoardWriteForm";
	}
	
	@RequestMapping("/BoardWriteProc") // 게시물 작성
	public String writeProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		System.out.println("write()");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 

		model.addAttribute("request", request);

		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		
		if(writer.equals("")||subject.equals("")||email.equals("")||password.equals("")||content.equals("")) {
			out.println("<script>alert('텍스트필드를 모두 채워주세요.'); location.href='BoardWriteForm';</script>");
			out.flush();
			return null;
		}
		
		
		dao.insert(writer, email, subject, password, content);

		return "redirect:BoardList";
	}
	
	@RequestMapping("/BoardInfo") // 게시물보기
	public String boardInfo(Model model, HttpServletRequest request) throws SQLException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		String key = request.getParameter("num");
		dao.upreadcnt(Integer.parseInt(request.getParameter("num")));
		model.addAttribute("dto", dao.select(key));
		return "Main.jsp?center=BoardInfo";
	}
	
	@RequestMapping("/BoardDeleteForm")
	public String boardDeleteForm(Model model, HttpServletRequest request) {
		return "Main.jsp?center=BoardDeleteForm";
	}
	
	@RequestMapping("/BoardDeleteProc")
	public String boardDeleteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		String xpwd = request.getParameter("xpwd");
		String num = request.getParameter("num");
		JSPBoard_Dto dto = dao.select(num);
		if(dto.getPassword().equals(xpwd)) {
			dao.delete(Integer.parseInt(num));
			System.out.println("삭제완료");
			return "redirect:BoardList";
		}else {
			out.println("<script>alert('암호가 틀립니다.'); location.href='BoardDeleteForm?num="+num+"';</script>");
			out.flush();
			return null;
		}
	}
	
	@RequestMapping("/BoardUpdateForm")
	public String boardUpdateForm(Model model, HttpServletRequest request) throws SQLException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		String num = request.getParameter("num");
		model.addAttribute("dto", dao.select(num));
		return "Main.jsp?center=BoardUpdateForm";
	}
	
	@RequestMapping("/BoardUpdateProc")
	public String boardUpdateProc(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String password = request.getParameter("password");
		String num = request.getParameter("num");
		JSPBoard_Dto dto = dao.select(num);
		
		if(dto.getPassword().equals(password)) {
			dao.update(request.getParameter("subject"), request.getParameter("content"), num);
			return "redirect:BoardInfo?num="+num;
		}else {
				out.println("<script>alert('수정할 수 없습니다.'); location.href='BoardUpdateForm?num="+num+"';</script>");
				out.flush();
				return null;
		}
	}
	
	@RequestMapping("/BoardReWriteForm")
	public String boardReWriteForm(Model model, HttpServletRequest request) throws SQLException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		String num = request.getParameter("num");
		model.addAttribute("dto", dao.select(num));
		return "Main.jsp?center=BoardReWriteForm";
	}
	
	@RequestMapping("/BoardReWriteProc")
	public String boardReWriteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
		String ref = request.getParameter("ref");
		String re_step = request.getParameter("re_step");
		String re_level = request.getParameter("re_level");
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		int backPage = Integer.parseInt(session.getAttribute("currentPage")+"");
		int backBlock = Integer.parseInt(session.getAttribute("currentBlock")+"");
		
		dao.re_level_up(ref, re_level);
		
		dao.insert_reply(writer, email, subject, password, Integer.parseInt(ref), Integer.parseInt(re_step)+1, Integer.parseInt(re_level)+1, content);
	
		return "redirect:BoardList?pageNum="+backPage+"&pageBlock="+backBlock;

	}
}
