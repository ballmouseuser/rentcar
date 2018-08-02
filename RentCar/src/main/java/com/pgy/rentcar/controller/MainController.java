package com.pgy.rentcar.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/Main")
	public String main(Model model, HttpServletRequest request) {
		return "Main";
	}

}
