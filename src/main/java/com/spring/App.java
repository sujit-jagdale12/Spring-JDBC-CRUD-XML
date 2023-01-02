package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.CollegeDao;
import com.entities.College;

public class App {

	public static void main(String[] args) {

		System.out.println("Program started....");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/config.xml");

		CollegeDao bean = context.getBean("impl", CollegeDao.class);

		College college = new College();
		/*
		 * college.setName("SCOE"); college.setCity("Sinhgad");
		 * 
		 * int result = bean.insert(college);
		 * System.out.println("No of college added: "+result);
		 * 
		 *
		 * 
		 * 
		 * bean.delete(5); System.out.println("Deleted");
		 * 
		 * college=bean.getByID(4); System.out.println(college.getId());
		 * System.out.println(college.getName()); System.out.println(college.getCity());
		 */
//		List<College> colleges=bean.getAllColleges();
//		
//		for (College c : colleges) {
//			System.out.println(c.getId());
//			System.out.println(c.getName());
//			System.out.println(c.getCity());
//			System.out.println("==========================");
//		}

		college.setId(2);
		college.setName("PMCOE");
		college.setCity("Pimpri");

		int update = bean.update(college);
		System.out.println("Update Done: " + update);
	}
}
