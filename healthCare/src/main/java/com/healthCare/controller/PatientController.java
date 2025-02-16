package com.healthCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.entity.Patient;
import com.healthCare.service.PatientService;

import jakarta.validation.Valid;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/savePatient")
	public ResponseEntity<?> savePatient(@RequestBody @Valid Patient patient) {

		try {
			Patient addPatient = this.patientService.addPatient(patient);
			return ResponseEntity.status(HttpStatus.CREATED).body(addPatient);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
		try {
			this.patientService.deletePatient(id);
			return ResponseEntity.ok("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
