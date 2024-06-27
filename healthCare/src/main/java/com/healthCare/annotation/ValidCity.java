package com.healthCare.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCity {

	String message() default "Invalid city, only Delhi, Noida, Faridabad are allowed.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
