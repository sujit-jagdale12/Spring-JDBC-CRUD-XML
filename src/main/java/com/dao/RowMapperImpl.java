package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entities.College;

public class RowMapperImpl implements RowMapper<College> {

	@Override
	public College mapRow(ResultSet rs, int rowNum) throws SQLException {
		College college = new College();
		college.setId(rs.getInt(1));
		college.setName(rs.getString(2));
		college.setCity(rs.getString(3));
		return college;
	}

}
