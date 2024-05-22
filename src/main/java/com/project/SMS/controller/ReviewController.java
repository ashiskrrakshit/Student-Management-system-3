package com.project.SMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.SMS.entity.Enrollment;
import com.project.SMS.entity.Review;
import com.project.SMS.entity.Student;
import com.project.SMS.service.ReviewService;
import com.project.SMS.service.StudentService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;


	// student can add review their enrolled courses
//	@PostMapping("/student/{studentId}/{coursId}")
//	public ResponseEntity<Review> createReview(@PathVariable("studentId")Integer id, @RequestBody Review review) {
//		Student student = studentService.findById(Integer.ParseInt("studentId));
//		return new ResponseEntity<Review>(HttpStatus.OK);
//	}

//    @PostMapping("/add")
//    public Review addReview(@RequestBody Review review) {
//        return reviewService.addReview(review);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteReview(@PathVariable int id) {
//        reviewService.deleteReview(id);
//    }

	
	

//		@PostMapping("/add")
//		public ResponseEntity<Review> addReview(@RequestBody Review review) {
//			Review addedReview = reviewService.addReview(review);
//			return ResponseEntity.ok(addedReview);
//		}

		
	    @PostMapping("/add")
	    public ResponseEntity<Review> addReview(@RequestBody Review review) {
	        Review addedReview = reviewService.addReview(review);
	        return new ResponseEntity<>(addedReview, HttpStatus.OK);
	    }
	    
	    
//		@DeleteMapping("/delete/{enrollmentId}")
//		public ResponseEntity<String> deleteReview(@PathVariable Integer enrollmentId) {
//			String status = reviewService.deleteReview(enrollmentId);
//			return new ResponseEntity<>(status, HttpStatus.OK);
//		}
//		
		
//		@DeleteMapping("/delete/{enrollmentId}")
//		public ResponseEntity<String> deleteReview(@PathVariable Integer enrollmentId) {
//			Enrollment enroll = reviewService.findByEnrollment(enrollmentId);
//			String status = reviewService.deleteReview(reviewId);
//			return new ResponseEntity<>(status, HttpStatus.OK);
//		}
	    
	    
	    @DeleteMapping("/delete/{enrollmentId}")
	    public ResponseEntity<String> deleteReviewByEnrollmentId(@PathVariable Integer enrollmentId) {
	        String status = reviewService.deleteReviewByEnrollmentId(enrollmentId);
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }
	}
