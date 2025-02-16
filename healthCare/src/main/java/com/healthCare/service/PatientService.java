package com.healthCare.service;

import com.healthCare.entity.Patient;

public interface PatientService {

	public Patient addPatient(Patient patient);

	public void deletePatient(Long id);

	public Patient getPatientById(Long id);

}
