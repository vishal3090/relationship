package com.adixSoftware.relationship.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.adixSoftware.relationship.Validation.PhoneNumberValidator;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumberValidation {

	String message() default "Please enter valid phone number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
