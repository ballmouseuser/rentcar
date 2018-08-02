package com.pgy.rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgy.rentcar.dao.JSPMember_IDao;
import com.pgy.rentcar.dao.Rent_Reserve_IDao;
import com.pgy.rentcar.dto.JSPMember_Dto;

@Controller
public class MController {

	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;

	@RequestMapping("/MemberJoin")
	public String memberJoin(Model model, HttpServletRequest request) {
		return "Main.jsp?center=MemberJoin";
	}

	@RequestMapping("/JoinProc")
	public String joinProc(Model model, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		JSPMember_Dto dto = new JSPMember_Dto();
		dto.setId(request.getParameter("id"));
		dto.setPass(request.getParameter("pass"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		dto.setAge(request.getParameter("age"));
		dto.setJob(request.getParameter("job"));
		dto.setHobby(request.getParameter("hobby"));
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		dao.insert(dto);

		return "redirect:Main";
	}

	@RequestMapping("/Login")
	public String login(Model model, HttpServletRequest request) throws SQLException {
		return "Main.jsp?center=Login";
	}

	@RequestMapping("/LoginProc")
	public String loginProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		PrintWriter out = response.getWriter(); 
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		session = request.getSession();
		
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pass",pass);
		int res = dao.login(map);
		if(res==1) {
			session.setAttribute("id", id);
			session.setAttribute("pass", pass);
			return "redirect:Main";
		}else {	 
			out.println("<script>alert('아이디나 비밀번호가 틀립니다.'); location.href='Login';</script>");
			out.flush();
			return null;
		}
	}
	
	@RequestMapping("/Logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		if(session != null) {		
			session.invalidate();
		}
		return "redirect:Main";
	}
	
	@RequestMapping("/MemberList")
	public String memberList(Model model, HttpServletRequest request) throws SQLException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		int num = dao.getAllCount();
		model.addAttribute("MemberList", dao.selectAll());
		model.addAttribute("num", num);
		return "Main.jsp?center=MemberList";
	}
	
	@RequestMapping("/MemberInfo")
	public String memberInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		String key = request.getParameter("id");
		if(key.equals("GUEST")) {
			out.println("<script>alert('로그인 후 이용 가능합니다.'); location.href='Login';</script>");
			out.flush();
			return null;
		}
		model.addAttribute("dto", dao.select(key));
		return "Main.jsp?center=MemberInfo";
	}
	
	@RequestMapping("/MemberDeleteForm")
	public String memberDeleteForm(Model model, HttpServletRequest request) throws SQLException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		String id = request.getParameter("id");
		model.addAttribute("dto", dao.select(id));
		return "Main.jsp?center=MemberDeleteForm";
	}
	
	@RequestMapping("/MemberDeleteProc")
	public String memberDeleteProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String xpwd = request.getParameter("pass");
		String id = request.getParameter("id");
		JSPMember_Dto dto = dao.select(id);
		
		if(dto.getPass().equals(xpwd)) {
			dao.delete(id);
			System.out.println("삭제완료");
			
			return "redirect:Logout";
		}else {
			out.println("<script>alert('암호가 틀립니다.'); location.href='MemberDeleteForm?id="+id+"';</script>");
			out.flush();
			return null;
		}
	}
	
	@RequestMapping("/MemberUpdateForm")
	public String memberUpdateForm(Model model, HttpServletRequest request) throws SQLException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		String id = request.getParameter("id");
		model.addAttribute("dto", dao.select(id));
		return "Main.jsp?center=MemberUpdateForm";
	}
	
	@RequestMapping("/MemberUpdateProc")
	public String memberUpdateProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
		response.setContentType("text/html; charset=UTF-8");	 
		PrintWriter out = response.getWriter(); 
		
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		JSPMember_Dto dto = dao.select(id);
		
		//JSPMember_Dto dto2 = new JSPMember_Dto();
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		dto.setJob(request.getParameter("job"));
		dto.setHobby(request.getParameter("hobby"));
		dto.setId(id);
		if(dto.getPass().equals(pass)) {
			dao.update(dto);
			System.out.println("수정완료");
			return "redirect:MemberInfo?id="+id;
		}else {
			out.println("<script>alert('암호가 틀립니다.'); location.href='MemberUpdateForm?id="+id+"';</script>");
			out.flush();
			return null;
		}
	}

}
