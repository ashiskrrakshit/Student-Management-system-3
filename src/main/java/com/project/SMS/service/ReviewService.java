package com.project.SMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.SMS.entity.Enrollment;
import com.project.SMS.entity.Review;
import com.project.SMS.repo.EnrollmentRepo;
import com.project.SMS.repo.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
    
	@Transactional
        public Review addReview(Review review) {
            // Assuming review is associated with an enrollment
            //Enrollment enrollment = review.getEnrollment();
		Enrollment enrollment = enrollmentRepo.findById(review.getEnrollment().getId()).orElseThrow(null);
            //enrollment.setReview(review);
            review.setEnrollment(enrollment);
            // Save enrollment to ensure review is properly associated
            //enrollmentRepo.save(enrollment);
            // Save review
            return reviewRepo.save(review);
        }

//       
        
        
//        public String deleteReviewByEnrollmentId(Integer enrollmentId) {
//        	
//            Enrollment enrollment = enrollmentRepo.findById(enrollmentId).orElse(null);
//            if (enrollment != null) {
//                Review review = enrollment.getReview();
//                if (review != null) {
//                    // Remove review association from enrollment
//                    enrollment.setReview(null);
//                    enrollmentRepo.save(enrollment);
//                    // Delete the review
//                    reviewRepo.delete(review);
//                    return "Review deleted successfully";
//                } else {
//                    return "Review not found for enrollment";
//                }
//            } else {
//                return "Enrollment not found";
//            }
//        }
	
	
	
	 public String deleteReviewByEnrollmentId(Integer enrollmentId) {
	        // Retrieve the reviews associated with the enrollment ID
	        List<Review> reviews = reviewRepo.findByEnrollment(enrollmentId);
	        
	        // If reviews exist, delete them
	        if (!reviews.isEmpty()) {
	            for (Review review : reviews) {
	            	reviewRepo.delete(review);
	            }
	            return "Reviews deleted successfully for enrollment ID: " + enrollmentId;
	        } else {
	            return "No reviews found for enrollment ID: " + enrollmentId;
	        }
	    }
    }
