package com.project.SMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Address;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;
import com.project.SMS.repo.AddressRepository;
import com.project.SMS.repo.StudentRepo;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private StudentRepo studentRepo;

	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	public Address getAddressById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}

//	public Address saveAddress(Address address) {
//		return addressRepository.save(address);
//	}
	
	
	
	
	 public Address saveAddress(Address address) {
			Address savedAddress = new Address();
			savedAddress.setCity(address.getCity());
			savedAddress.setState(address.getState());
			savedAddress.setCountry(address.getCountry());
			savedAddress.setPincode(address.getPincode());

	        List<Student> students = new ArrayList<>();
	        for (Student student : address.getStudent()) {
	        	Student fetchedStudent = studentRepo.findById(student.getId())
	                    .orElseThrow(null);
	        	students.add(fetchedStudent);
	        }
	        savedAddress.setStudent(students);

	        return addressRepository.save(savedAddress);
	    }
	
	
	

	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}
}
