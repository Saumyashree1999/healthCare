package com.healthCare.annotation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<ValidCity, String> {

	private final List<String> availableCity = Arrays.asList("Delhi", "Noida", "Faridabad");

	@Override
	public boolean isValid(String city, ConstraintValidatorContext c) {
		return availableCity.contains(city);
	}

}
