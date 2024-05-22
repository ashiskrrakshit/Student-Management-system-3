package com.project.SMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Student;

import com.project.SMS.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// create a student by a student
	@JsonIgnore
	@PostMapping("/create")
	private ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.createUser(student);
		return ResponseEntity.ok(createdStudent);
	}
	
	
	//get all student by admin
    @GetMapping("/all")
    @JsonIgnore
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.findAllStudent();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
	


    // get student by Id by admin and student(about user)
    @GetMapping("/studentId/{studentId}")
    @JsonIgnore
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	//deleteUser(by student)
		@DeleteMapping("/delete/{studentId}")
		public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
			String status = studentService.deleteStudent(studentId);

			return new ResponseEntity<String>(status, HttpStatus.OK);
		}
	
}
