package com.adixSoftware.relationship.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adixSoftware.relationship.annotation.PhoneNumberValidation;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValidation, String> {

	/*
	 * {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
	 * "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"}
	 */
	/*
	 * regexp =
	 * "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" +
	 * "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" +
	 * "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$"
	 */

	@Override
	public void initialize(PhoneNumberValidation phone) {

	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		return phoneField != null
				&& phoneField.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
						+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
						+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
	}
}
