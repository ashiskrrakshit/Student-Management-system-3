package com.project.SMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.SMS.entity.Course;
import com.project.SMS.repo.CourseRepo;

@SpringBootApplication
public class SmsApplication{

	@Autowired
	CourseRepo cr;
	
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}


}
