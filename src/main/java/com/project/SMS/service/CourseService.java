package com.project.SMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Admin;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.repo.AdminRepo;
import com.project.SMS.repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	
	//@JsonIgnore
	public Course createCourse(Course course) {
		Admin admin = adminRepo.findById(course.getAdmin().getId()).orElse(null);
		course.setAdmin(admin);
		return courseRepo.save(course);
	}

	public List<Course> findAllCourse() {
		List<Course> allCourses = courseRepo.findAll();
		return allCourses;
	}

	public Course updateCourse(Course course) {
		// if course exist, update the existing course
		if(courseRepo.existsById(course.getId())) {
			Course existingCourse = courseRepo.findById(course.getId()).get();
			existingCourse.setName(course.getName());
			existingCourse.setDescription(course.getDescription());
			return courseRepo.save(existingCourse);
		}
		else {
			return courseRepo.save(course);
		}

	}

	public boolean deleteCourse(int id) {
		if(courseRepo.existsById(id)) {
			courseRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
