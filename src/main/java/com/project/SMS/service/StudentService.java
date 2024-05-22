package com.project.SMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.repo.CourseRepo;
import com.project.SMS.repo.StudentRepo;
@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	//create student
//	public Student createUser(Student student) {
//		Student newStudent = studentRepo.save(student);
//		return newStudent;
//	}
	
	@JsonIgnore
	 public Student createUser(Student student) {
	        Student student1 = new Student();
	        student1.setFirstName(student.getFirstName());
	        student1.setLastName(student.getLastName());
	        student1.setEmail(student.getEmail());
	        student1.setMobileNumber(student.getMobileNumber());

	        List<Course> courses = new ArrayList<>();
	        for (Course course1 : student.getCourses()) {
	            Course course = courseRepo.findById(course1.getId())
	                    .orElseThrow(null);
	            courses.add(course);
	        }
	        student.setCourses(courses);

	        return studentRepo.save(student);
	    }
	

	//find all student
	@JsonIgnore
	public List<Student> findAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		return allStudent;
	}

	//get student by id
//	public Student getStuedentById(Integer studentId) {
//		Student getStudentById = studentRepo.findById(studentId);
//		return getStudentById;
//	}
	@JsonIgnore
	public Student getStudentById(Integer studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

	//delete student
		public String deleteStudent(Integer studentId) {
	        if (studentRepo.existsById(studentId)) {
	            studentRepo.deleteById(studentId);
	            return "Student with ID " + studentId + " deleted successfully.";
	        } else {
	            return "Student with ID " + studentId + " not found.";
	        }
	    }
	}









//package com.project.SMS.service;
//
//import com.project.SMS.entity.Enrollment;
//import com.project.SMS.entity.Student;
//import com.project.SMS.repo.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepo studentRepo;
//
//    public Student createUser(Student student) {
//        List<Enrollment> enrollments = student.getEnrollments();
//        if (enrollments != null && !enrollments.isEmpty()) {
//            Enrollment enrollment = enrollments.get(0); // Assuming only one enrollment is provided
//            enrollment.setStudent(student); // Set the student for the enrollment
//            student.setEnrollments(Collections.singletonList(enrollment)); // Set the enrollment for the student
//        }
//        return studentRepo.save(student);
//    }
//
//    public List<Student> findAllStudent() {
//        return studentRepo.findAll();
//    }
//
//    public Student getStudentById(Integer studentId) {
//        return studentRepo.findById(studentId).orElse(null);
//    }
//
//    public String deleteStudent(Integer studentId) {
//        if (studentRepo.existsById(studentId)) {
//            studentRepo.deleteById(studentId);
//            return "Student with ID " + studentId + " deleted successfully.";
//        } else {
//            return "Student with ID " + studentId + " not found.";
//        }
//    }
//}
//
//
//
