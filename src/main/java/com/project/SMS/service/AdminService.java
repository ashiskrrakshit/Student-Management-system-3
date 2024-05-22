package com.project.SMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.entity.Admin;
import com.project.SMS.repo.CourseRepo;
import com.project.SMS.repo.StudentRepo;
import com.project.SMS.repo.AdminRepo;
@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

//	public Teacher createUser(Teacher teacher) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Teacher> findAllTeacher() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Teacher getTeacherById(Integer teacherId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String deleteTeacher(Integer teacherId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	public Admin createUser(Admin teacher) {
        return adminRepo.save(teacher);
    }

    public List<Admin> findAllTeacher() {
        return adminRepo.findAll();
    }

    
    @JsonIgnore
	public Admin getTeacherById(Integer teacherId) {
        return adminRepo.findById(teacherId).orElse(null);
    }
    
    
	//delete student
	public String deleteTeacher(Integer teacherId) {
        if (adminRepo.existsById(teacherId)) {
        	adminRepo.deleteById(teacherId);
            return "Student with ID " + teacherId + " deleted successfully.";
        } else {
            return "Student with ID " + teacherId + " not found.";
        }
    }
    
    
//-------------------------------------------------------------------


    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentRepo.save(student);
        return ResponseEntity.ok(createdStudent);
    }

    public ResponseEntity<String> deleteStudent(@RequestParam Integer studentId) {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
            return ResponseEntity.ok("Student with ID " + studentId + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + studentId + " not found");
        }
    }

    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course newCourse = courseRepo.save(course);
        return ResponseEntity.ok(newCourse);
    }
}




