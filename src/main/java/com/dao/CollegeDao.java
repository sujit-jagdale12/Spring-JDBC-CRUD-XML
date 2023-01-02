package com.dao;

import java.util.List;

import com.entities.College;

public interface CollegeDao {
	int insert(College college);

	int update(College college);

	int delete(int id);

	College getByID(int id);

	List<College> getAllColleges();

}
