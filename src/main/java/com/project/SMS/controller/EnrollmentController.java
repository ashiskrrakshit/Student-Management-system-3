package com.project.SMS.controller;

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

import com.project.SMS.entity.Enrollment;
import com.project.SMS.service.EnrollmentService;

@RestController
@RequestMapping("student/enrollment")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	//create Enrollment
	@PostMapping("/create")
	private ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enroll){
			Enrollment newEnroll = enrollmentService.createEnrollment(enroll);
			 return new ResponseEntity<>(newEnroll, HttpStatus.OK);
		}
	
	@GetMapping("/enrollment/{enrollmentId}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable int enrollmentId) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
        if (enrollment != null) {
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	 @DeleteMapping("/delete/{enrollmentId}")
	    public ResponseEntity<String> deleteEnrollmentById(@PathVariable int enrollmentId) {
	        boolean deleted = enrollmentService.deleteEnrollmentById(enrollmentId);
	        if (deleted) {
	            return new ResponseEntity<>("Enrollment with ID " + enrollmentId + " deleted successfully.", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Enrollment not found or unable to delete.", HttpStatus.NOT_FOUND);
	        }
	
}
}
