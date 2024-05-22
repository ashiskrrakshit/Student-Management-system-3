package com.project.SMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//create course by teacher
	//@JsonIgnore
	@PostMapping("/create/byteacher")
	private ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course newCourse = courseService.createCourse(course);
		return new ResponseEntity<>(newCourse, HttpStatus.OK);
	}
	
	//get all course by student
	@GetMapping("/all/bystudent")
	@JsonIgnore
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> allStudents = courseService.findAllCourse();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
	
	
	//update course by teacher
	@PutMapping("/update")
	@JsonIgnore
	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
		Course updatedCourse = courseService.updateCourse(course);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
	}
	
	
	
	//delete course by teacher
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteCourse(@PathVariable int id){
		boolean isDeleted = courseService.deleteCourse(id);
		if(isDeleted) {
			return new ResponseEntity<String>("course deleted successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("course not deleted",HttpStatus.NOT_FOUND);
		}
	}
	
}
