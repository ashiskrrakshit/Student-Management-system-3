package com.project.SMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SMS.entity.Course;
import com.project.SMS.entity.Enrollment;
import com.project.SMS.entity.Student;
import com.project.SMS.repo.CourseRepo;
import com.project.SMS.repo.EnrollmentRepo;
import com.project.SMS.repo.StudentRepo;

@Service
public class EnrollmentService {
	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;

//	public Enrollment createEnrollment(Enrollment enroll) {
//	Enrollment newEnroll = enrollmentRepo.save(enroll);
//		return newEnroll;
//	}
	
	
	//    "student" , course
	
	public Enrollment createEnrollment(Enrollment enroll) {
		Student student = studentRepo.findById(enroll.getStudent().getId()).orElse(null);
			enroll.setStudent(student);
		
		Course course = courseRepo.findById(enroll.getCourse().getId()).orElse(null);
			enroll.setCourse(course);
		
		return enrollmentRepo.save(enroll);	
		
	}
	
	
	
	
    public Enrollment getEnrollmentById(int enrollmentId) {
        return enrollmentRepo.findById(enrollmentId)
                .orElse(null);
    }

    
    public boolean deleteEnrollmentById(int enrollmentId) {
        if (enrollmentRepo.existsById(enrollmentId)) {
        	enrollmentRepo.deleteById(enrollmentId);
            return true;
        }
        return false;
    }


}

