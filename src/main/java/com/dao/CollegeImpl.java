package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entities.College;

public class CollegeImpl implements CollegeDao {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(College college) {

		String query = "insert into college(collegeName,collegeCity)value(?,?);";
		int result = this.template.update(query, college.getName(), college.getCity());

		return result;
	}

	@Override
	public int update(College college) {
		String query = "update college set collegeName=?,collegeCity=? where collegeId=?";
		int result = this.template.update(query, college.getName(), college.getCity(), college.getId());

		return result;
	}

	@Override
	public int delete(int id) {
		String query = "delete from college where collegeId=?";
		int result = this.template.update(query, id);

		return result;
	}

	@Override
	public College getByID(int id) {
		College college = new College();
		String query = "select *from college where collegeId=?";
//		RowMapper<College> mapper = new RowMapperImpl();

		college = (College) this.template.queryForObject(query, new RowMapper<College>() {
			@Override
			public College mapRow(ResultSet rs, int rowNum) throws SQLException {
				College college = new College();
				college.setId(rs.getInt(1));
				college.setName(rs.getString(2));
				college.setCity(rs.getString(3));
				return college;
			}
		}, id);
		return college;
	}

	@Override
	public List<College> getAllColleges() {
//		RowMapper<College> mapper = new RowMapperImpl();
		
		String query = "select *from college";
		List<College> list = this.template.query(query, new RowMapperImpl());

		return list;

	}

}
