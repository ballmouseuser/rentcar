package com.pgy.rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgy.rentcar.dao.RentCar_IDao;
import com.pgy.rentcar.dao.Rent_Reserve_IDao;
import com.pgy.rentcar.dto.RentCar_Dto;
import com.pgy.rentcar.dto.Rent_Reserve_Dto;
import com.pgy.rentcar.dto.ReserveView;

@Controller
public class RController {
	
	@Autowired
	private SqlSession sqlSession;
	private HttpSession session;

	@RequestMapping("/ReserveView")
	public String reserveView(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Rent_Reserve_IDao dao = sqlSession.getMapper(Rent_Reserve_IDao.class);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		session = request.getSession();
		System.out.println(session.getAttribute("id"));
		
		if(session.getAttribute("id")==null) {
			out.println("<script>alert('로그인 후 다시 시도해주세요.'); location.href='Login';</script>");
			out.flush();
			return null;
		}else {
			session = request.getSession();
			String id = (String)session.getAttribute("id");		
			List<ReserveView> list = dao.selectAllView(id);
			model.addAttribute("list", list);
			return "Main.jsp?center=ReserveView";
		}
	}
	@RequestMapping("/Delete")
	public String delete(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "Main.jsp?center=Delete";
	}
	@RequestMapping("/DeleteConfirm")
	public String deleteConfirm(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int regno = (int) (session.getAttribute("deleteNum"));
		Rent_Reserve_IDao dao = sqlSession.getMapper(Rent_Reserve_IDao.class);
		dao.delete(regno);
		return "redirect:ReserveView";
	}
	
	@RequestMapping("/Adjust")
	public String adjust(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int regno = Integer.parseInt(request.getParameter("regno"));
		Rent_Reserve_IDao dao = sqlSession.getMapper(Rent_Reserve_IDao.class);
		model.addAttribute("dto", dao.selectVO(regno));
		return "Main.jsp?center=Adjust";
	}
	
	@RequestMapping("/AdjustProc")
	public String adjustProc(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Rent_Reserve_IDao dao = sqlSession.getMapper(Rent_Reserve_IDao.class);
		Rent_Reserve_Dto dto = new Rent_Reserve_Dto();
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setRday(request.getParameter("rday"));
		dto.setDday(Integer.parseInt(request.getParameter("dday")));
		dto.setQty(Integer.parseInt(request.getParameter("qty")));
		dto.setInsurance(Integer.parseInt(request.getParameter("insurance")));
		dto.setNavigation(Integer.parseInt(request.getParameter("navigation")));
		dto.setWifi(Integer.parseInt(request.getParameter("wifi")));
		dto.setBabyseat(Integer.parseInt(request.getParameter("babyseat")));
		dto.setRegno(Integer.parseInt(request.getParameter("regno")));
		dto.setMemid(request.getParameter("memid"));
		
		model.addAttribute("dto", dao.update(dto));
		return "redirect:ReserveView";
	}
	
	@RequestMapping("/CarReserveMain")
	public String carReserveMain(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		model.addAttribute("allcount", dao.allcount());
		model.addAttribute("list", dao.selectAll());
		return "Main.jsp?center=CarReserveMain";
	}
	
	@RequestMapping("/CarReserveInfo")
	public String carReserveInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		int no = Integer.parseInt(request.getParameter("no"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=CarReserveInfo";
	}
	@RequestMapping("/CarOptionSelect")
	public String carOptionSelect(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		int no = Integer.parseInt(request.getParameter("no"));
		model.addAttribute("dto", dao.selectVo(no));
		return "Main.jsp?center=CarOptionSelect";
	}
	
	@RequestMapping("/CarReserveResult")
	public String carReserveResult(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, IOException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		Rent_Reserve_IDao dao2 = sqlSession.getMapper(Rent_Reserve_IDao.class);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		int no = Integer.parseInt(request.getParameter("no"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		String rday = request.getParameter("rday");
		int insurance = Integer.parseInt(request.getParameter("insurance"));
		int wifi = Integer.parseInt(request.getParameter("wifi"));
		int navigation = Integer.parseInt(request.getParameter("navigation"));
		int babyseat = Integer.parseInt(request.getParameter("babyseat"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		HttpSession session = request.getSession();
		String memid = (String)session.getAttribute("id");
		
		if(rday.isEmpty() || rday.equals("")) {
			out.println("<script>alert('날짜를 입력해주세요.'); location.href='CarReserveInfo?no="+no+"';</script>");
			out.flush();
			return null;
		}
			
		RentCar_Dto dto = dao.selectVo(no);
		Rent_Reserve_Dto dto2 = new Rent_Reserve_Dto();
		
		dto2.setBabyseat(babyseat);
		dto2.setDday(dday);
		dto2.setInsurance(insurance);
		dto2.setMemid(memid);
		dto2.setNo(no);
		dto2.setQty(qty);
		dto2.setNavigation(navigation);
		dto2.setRday(rday);
		dto2.setWifi(wifi);
		
		Date d1 = new Date();
		Date d2 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d1 = sdf.parse(rday);
		d2 = sdf.parse(sdf.format(d2));
		
		int res = d1.compareTo(d2);// -1,0,1
		if(res == -1) {
			out.println("<script>alert('현재 이전 날짜는 예약일로 사용할 수 없습니다.'); location.href='CarReserveInfo?no="+no+"';</script>");
			out.flush();
			return null;
		}else if(memid==null || memid.equals("")) {
			out.println("<script>alert('로그인 후 이용해주세요.'); location.href='Login';</script>");
			out.flush();
			return null;
		}
		
		dao2.insert(dto2);
		//dto2.setRegno(dao2.getCurrval());
		
		model.addAttribute("dto", dto);
		model.addAttribute("dto2", dto2);
		
		return "Main.jsp?center=CarReserveResult";
	}
	@RequestMapping("/CarCategoryList")
	public String carCategoryList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		int category = Integer.parseInt(request.getParameter("category"));
		
		model.addAttribute("category", dao.selectKey(category));

		return "Main.jsp?center=CarCategoryList";
	}
	
	@RequestMapping("/CarAllList")
	public String carAllList(Model model, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		model.addAttribute("list", dao.selectAll());

		return "Main.jsp?center=CarAllList";
	}
	
	
}
