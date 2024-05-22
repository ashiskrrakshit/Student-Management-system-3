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
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.entity.Admin;
import com.project.SMS.service.CourseService;
import com.project.SMS.service.StudentService;
import com.project.SMS.service.AdminService;
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	// create a teacher
	@PostMapping("/create")
	private ResponseEntity<Admin> createStudent(@RequestBody Admin teacher) {
		Admin createdTeacher = adminService.createUser(teacher);
		return ResponseEntity.ok(createdTeacher);
	}
	
	
	//get all student
    @GetMapping("/all")
    @JsonIgnore
    public ResponseEntity<List<Admin>> getAllStudents() {
        List<Admin> allTeachers = adminService.findAllTeacher();
        return new ResponseEntity<>(allTeachers, HttpStatus.OK);
    }
	


    // get student by Id
    @GetMapping("/Id/{teacherId}")
    public ResponseEntity<Admin> getStudentById(@PathVariable Integer teacherId) {
    	Admin student = adminService.getTeacherById(teacherId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
	//deleteUser(
	@DeleteMapping("/delete/teacher/{teacherId}")
	public ResponseEntity<String> deleteTeacherById(@PathVariable Integer teacherId) {
		String status = adminService.deleteTeacher(teacherId);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	
	//add student
	@PostMapping("/create/student")
	private ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.createUser(student);
		return ResponseEntity.ok(createdStudent);
	}
	
//	//delete student(
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
		String status = studentService.deleteStudent(studentId);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	//create course
	@PostMapping("/create/course")
	private ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course newCourse = courseService.createCourse(course);
		return new ResponseEntity<>(newCourse, HttpStatus.OK);
	}

	//----------------------------------------------------------------------------------
	
//    // Admin can add a course
//    @PostMapping("/{adminId}/add-course")
//    public ResponseEntity<Course> addCourse(@PathVariable Integer adminId, @RequestBody Course course) {
//        Course createdCourse = adminService.addCourse(adminId, course);
//        return ResponseEntity.ok(createdCourse);
//    }
//    
//    
//    // Admin can see his added courses
//    @GetMapping("/{adminId}/courses")
//    public ResponseEntity<List<Course>> getAdminCourses(@PathVariable Integer adminId) {
//        List<Course> adminCourses = adminService.getAdminCourses(adminId);
//        return ResponseEntity.ok(adminCourses);
//    }
//    
//    
//    // Admin can delete his added courses
//    @DeleteMapping("/{adminId}/delete-course/{courseId}")
//    public ResponseEntity<String> deleteCourse(@PathVariable Integer adminId, @PathVariable Integer courseId) {
//        String status = adminService.deleteCourse(adminId, courseId);
//        return ResponseEntity.ok(status);
//    }
//    
//    
//    // Admin can update courses (add another courses with existing ones)
//    @PutMapping("/{adminId}/update-course")
//    public ResponseEntity<Course> updateCourse(@PathVariable Integer adminId, @RequestBody Course course) {
//        Course updatedCourse = adminService.updateCourse(adminId, course);
//        return ResponseEntity.ok(updatedCourse);
//    }
}
