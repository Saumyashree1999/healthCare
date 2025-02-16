package com.healthCare.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.entity.Doctor;
import com.healthCare.entity.Patient;
import com.healthCare.service.DoctorService;
import com.healthCare.service.PatientService;

@RestController
public class SuggestionController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@GetMapping("/suggestDoctors/{patientId}")
	public ResponseEntity<?> suggestDoctorsByPatientId(@PathVariable Long patientId) {
		Patient patient = patientService.getPatientById(patientId);

		if (patient == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");

		String symptom = patient.getSymptom();
		String city = patient.getCity();
		String speciality = getSpecialistBySymptom(symptom);

		if (speciality == null)
			return ResponseEntity.badRequest().body("Invalid symptom");

		List<Doctor> doctorList = doctorService.findDoctorBasedOnCityAndSpeciality(city, speciality);

		if (doctorList.isEmpty()) {
			if (!Arrays.asList("Delhi", "Faridabad", "Noida").contains(city)) {
				return ResponseEntity.ok("We are still waiting to expand to your location.");
			} else {
				return ResponseEntity.ok("There isn't any doctor present at your location for your symptom.");
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(doctorList);
	}

	private String getSpecialistBySymptom(String symptom) {

		switch (symptom) {

		case "Arthritis":
		case "Back Pain":
		case "Tissue injuries":
			return "Orthopaedic";

		case "Skin infection":
		case "Skin burn":
			return "Dermatology";

		case "Dysmenorrhea":
			return "Gynecology";

		case "Ear pain":
			return "ENT";

		default:
			return null;

		}
	}

}
