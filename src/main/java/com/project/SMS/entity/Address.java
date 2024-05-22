package com.project.SMS.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String city;


private String state;


private String country;


private String pincode;



@ManyToMany  // cascade = CascadeType.PERSIST)
@JoinTable(name = "STUDENT_ADDRESS", 
joinColumns = @JoinColumn(name="ADDRESS_ID",referencedColumnName = "id"), 
inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id"))
private List<Student> student = new ArrayList<>();
}
