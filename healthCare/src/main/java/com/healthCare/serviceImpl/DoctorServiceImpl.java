package com.healthCare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.entity.Doctor;
import com.healthCare.repository.DoctorRepository;
import com.healthCare.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public List<Doctor> findDoctorBasedOnCityAndSpeciality(String city, String speciality) {
		return doctorRepository.findDoctorByCityAndSpeciality(city, speciality);
	}
}
