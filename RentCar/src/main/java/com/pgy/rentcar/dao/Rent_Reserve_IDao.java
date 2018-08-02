package com.pgy.rentcar.dao;

import java.sql.SQLException;
import java.util.List;

import com.pgy.rentcar.dto.Rent_Reserve_Dto;
import com.pgy.rentcar.dto.ReserveView;

public interface Rent_Reserve_IDao {
	public List<ReserveView> selectAllView(String key) throws SQLException;
	public int delete(int regno) throws SQLException;
	public Rent_Reserve_Dto selectVO(int regno) throws SQLException;
	public int update(Rent_Reserve_Dto dto) throws SQLException;
	public int insert(Rent_Reserve_Dto dto) throws SQLException;
	public int getCurrval() throws SQLException;
	
}
