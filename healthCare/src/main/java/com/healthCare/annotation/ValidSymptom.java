package com.healthCare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = SymptomValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSymptom {
	String message() default "Invalid symptom, only Arthritis, Back Pain, Tissue injuries, Dysmenorrhea, Skin infection, skin burn, Ear pain are allowed.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
