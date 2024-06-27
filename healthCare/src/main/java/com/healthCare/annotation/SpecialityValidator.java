package com.healthCare.annotation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpecialityValidator implements ConstraintValidator<ValidSpeciality, String> {
	private final List<String> availableSpeciality = Arrays.asList("Orthopaedic", "Gynecology", "Dermatology", "ENT");

	@Override
	public boolean isValid(String speciality, ConstraintValidatorContext context) {
		return availableSpeciality.contains(speciality);
	}
}
