package com.healthCare.entity;

import com.healthCare.annotation.ValidCity;
import com.healthCare.annotation.ValidSpeciality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, message = "Name should be at least 3 characters")
	private String name;

	@Size(max = 20, message = "City should be at most 20 characters")
	@ValidCity
	private String city;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
	private String email;

	@Column(name = "phone_number")
	@NotBlank(message = "Phone number is mandatory")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number should be exactly 10 digits")
	private String phoneNumber;

	@ValidSpeciality
	private String speciality;

}