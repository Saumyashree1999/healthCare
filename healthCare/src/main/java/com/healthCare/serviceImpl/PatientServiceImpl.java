package com.healthCare.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.entity.Patient;
import com.healthCare.repository.PatientRepository;
import com.healthCare.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).orElse(null);
	}
}
