package com.adixSoftware.relationship.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.adixSoftware.relationship.Validation.EmailValidator;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {

	String message() default "Please enter valid email";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
