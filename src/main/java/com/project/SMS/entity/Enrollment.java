package com.project.SMS.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Enrollment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String date;
	
	private String status;

	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Enrollment_Id")//, referencedColumnName = "id")
	private Student student;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "course_id")//,referencedColumnName = "id")
	private Course course;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enrollment")
	private List<Review> review;

}




