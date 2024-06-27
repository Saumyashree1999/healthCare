package com.healthCare.service;

import java.util.List;

import com.healthCare.entity.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public void deleteDoctor(Long id);

	public List<Doctor> findDoctorBasedOnCityAndSpeciality(String city, String speciality);
}
