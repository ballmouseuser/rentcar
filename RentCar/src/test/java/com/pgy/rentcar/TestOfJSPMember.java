package com.pgy.rentcar;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pgy.rentcar.dao.JSPBoard_IDao;
import com.pgy.rentcar.dao.JSPMember_IDao;
import com.pgy.rentcar.dao.RentCar_IDao;
import com.pgy.rentcar.dto.JSPBoard_Dto;
import com.pgy.rentcar.dto.JSPMember_Dto;
import com.pgy.rentcar.dto.RentCar_Dto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

public class TestOfJSPMember {
	@Inject
	private SqlSession sqlSession;
	//private static final Logger logger = LoggerFactory.getLogger(TestBDao.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	public void 전체출력() {
//		try {
//			JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
//			ArrayList<JSPMember_Dto> list = dao.selectAll();
//			for(JSPMember_Dto x:list) {
//				System.out.println(x);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void 회원입력() {
//		try {
//			JSPMember_IDao dao = sqlSession.getMapper(JSPMember_IDao.class);
//			dao.insert("1234", "1234", "skdjal@naver.com", "2002030", "dfkjslk", "dkasdkla", "akjdlka");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void 게시글입력() {
		try {
			JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
			dao.insert("1234", "1234", "1234", "1234", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 게시글모드출력() {
		try {
			JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
			ArrayList<JSPBoard_Dto> list = dao.selectAll();
			for(JSPBoard_Dto x : list) {
				System.out.println(x);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 답글달기() {
		try {
			JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
			dao.re_level_up("11", "1");
			dao.insert_reply("5555", "5555", "5555", "5555", 11, 2, 2, "5555");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 수정하기() {
		try {
			JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
			dao.update("4444", "4444", "24");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 삭제하기() {
		try {
			JSPBoard_IDao dao = sqlSession.getMapper(JSPBoard_IDao.class);
			dao.delete(24);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void 차량등록() throws SQLException {
		RentCar_IDao dao = sqlSession.getMapper(RentCar_IDao.class);
		RentCar_Dto dto = new RentCar_Dto();
		dto.setName("소나타1");
		dto.setCategory(1);
		dto.setCompany("현대");
		dto.setImg("sonata.jpg");
		dto.setPrice(12222);
		dto.setUsepeople(4);
		dao.insert(dto);
	}
}
