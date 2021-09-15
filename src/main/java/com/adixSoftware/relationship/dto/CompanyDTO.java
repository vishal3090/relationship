package com.adixSoftware.relationship.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.adixSoftware.relationship.annotation.EmailValidation;
import com.adixSoftware.relationship.annotation.PhoneValidation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@PhoneValidation(message = "Please enter valid phone number")
public class CompanyDTO {

	private Long id;

	@NotBlank(message = "Name should not be null, Please enter name")
	@Size(min = 1, max = 100, message = "Name should be between 1 and 100 characters")
	private String name;

	@NotBlank(message = "Country should not be null, Please enter country")
	private String country;

	private String phoneNumber;

	@EmailValidation(message = "Please enter valid email")
	private String email;

	@Past(message = "Opening date should be before today, Please enter valid opening date")
	private Date openingDate;

	private CompanyTaxDTO tax;
}
