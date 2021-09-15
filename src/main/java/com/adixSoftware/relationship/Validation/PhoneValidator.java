package com.adixSoftware.relationship.Validation;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adixSoftware.relationship.annotation.PhoneValidation;
import com.adixSoftware.relationship.dto.CompanyDTO;
import com.adixSoftware.relationship.exception.PhoneNumberValidationException;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneValidator implements ConstraintValidator<PhoneValidation, CompanyDTO> {

	public boolean numberValidator(String phoneNumber, String country) {
		PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
		PhoneNumber googlePhoneNumber;
		try {
			String[] locales = Locale.getISOCountries();
			for (String countryCode : locales) {
				Locale obj = new Locale("", countryCode);

				if (country.equalsIgnoreCase(obj.getDisplayCountry())) {
					googlePhoneNumber = numberUtil.parse(phoneNumber, obj.getCountry());
					boolean isValid = numberUtil.isValidNumber(googlePhoneNumber);
					if (isValid) {
						return isValid;
					} else {
						throw new PhoneNumberValidationException("Please enter valid phone numnber");
					}
				}
			}
		}

		catch (NumberParseException e) {
			System.out.println("Invalid phone numbner");
		}

		return false;
	}

	@Override
	public boolean isValid(CompanyDTO companyDTO, ConstraintValidatorContext context) {
		if (companyDTO == null)
			return false;
		if (companyDTO.getCountry() == null || companyDTO.getPhoneNumber() == null)
			return false;

		return numberValidator(companyDTO.getPhoneNumber(), companyDTO.getCountry());
	}

}
