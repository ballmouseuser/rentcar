package com.pgy.rentcar.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pgy.rentcar.dto.JSPMember_Dto;

public interface JSPMember_IDao {
	public int insert(JSPMember_Dto dto) throws SQLException;
	public int delete(String key) throws SQLException;
	public int update(JSPMember_Dto dto) throws SQLException;
	public JSPMember_Dto select(String key) throws SQLException;
	public List<JSPMember_Dto> selectAll() throws SQLException;
	public List<JSPMember_Dto> find(Map<String,String> map) throws SQLException;
	public boolean close() throws SQLException;
	public String getPassWord(String id) throws SQLException;
	public int getAllCount() throws SQLException;
	public List<JSPMember_Dto> selectPart(int start, int end) throws SQLException;
	public int login(Map<String,String> map) throws SQLException;
	
	
}
