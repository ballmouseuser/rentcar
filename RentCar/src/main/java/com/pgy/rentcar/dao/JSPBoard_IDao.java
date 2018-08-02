package com.pgy.rentcar.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pgy.rentcar.dto.JSPBoard_Dto;

public interface JSPBoard_IDao {
	// 글 삽입
	public int insert(String writer, String email, String subject, String password, String content) throws SQLException;
	// 글 목록 표시
	public ArrayList<JSPBoard_Dto> selectAll() throws SQLException;
	// 특정 글 
	public JSPBoard_Dto select(String key) throws SQLException;
	// 답글 달기
	public int insert_reply(String writer, String email, String subject, String password, int ref, int re_step, int re_level, String content) throws SQLException;
	// 글 수정 
	public int update(String subject, String content, String num) throws SQLException;
	// 글 삭제
	public int delete(int key) throws SQLException;
	// 글 그룹 분류
	public int re_level_up(String ref, String re_level) throws SQLException;
	// 조회수 증가
	public int upreadcnt(int num) throws SQLException;
	
	
	public int getAllCount() throws SQLException;
	public List<JSPBoard_Dto> selectPart(int key1, int key2) throws SQLException;
	public List<JSPBoard_Dto> selectPart2(int key1, int key2) throws SQLException;
	
}
