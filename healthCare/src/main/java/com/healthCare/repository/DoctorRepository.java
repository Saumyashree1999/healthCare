package com.healthCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthCare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findDoctorByCityAndSpeciality(String city, String speciality);

}
