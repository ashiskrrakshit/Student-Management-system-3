package com.project.SMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.SMS.entity.Review;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	@Query("SELECT r FROM Review r WHERE r.enrollment.id =:enrollmentId")
	List<Review> findByEnrollment(@Param("enrollmentId")Integer enrollmentId);

}
