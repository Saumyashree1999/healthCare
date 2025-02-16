package com.healthCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.entity.Doctor;
import com.healthCare.service.DoctorService;

import jakarta.validation.Valid;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/saveDoctor")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody @Valid Doctor doctor) {

		try {
			Doctor addDoctor = this.doctorService.addDoctor(doctor);
			return ResponseEntity.status(HttpStatus.CREATED).body(addDoctor);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id) {
		try {
			this.doctorService.deleteDoctor(id);
			return ResponseEntity.ok("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
