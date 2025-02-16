package com.healthCare.annotation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SymptomValidator implements ConstraintValidator<ValidSymptom, String> {
	private final List<String> availableSymptom = Arrays.asList("Arthritis", "Back Pain", "Tissue injuries", "Dysmenorrhea", "Skin infection", "skin burn", "Ear pain");

	@Override
	public boolean isValid(String symptom, ConstraintValidatorContext context) {
		return availableSymptom.contains(symptom);
	}
}