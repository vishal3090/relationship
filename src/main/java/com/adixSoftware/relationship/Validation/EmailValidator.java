package com.adixSoftware.relationship.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adixSoftware.relationship.annotation.EmailValidation;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {

	// private static final String regex =
	// "^[a-zA-Z0-9+_.-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	@Override
	public void initialize(EmailValidation email) {

	}

	@Override
	public boolean isValid(String emailField, ConstraintValidatorContext cxt) {
		return emailField != null && emailField.matches("^[a-zA-Z0-9+_.-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
	}
}
