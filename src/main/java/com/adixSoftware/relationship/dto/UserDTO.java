package com.adixSoftware.relationship.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.adixSoftware.relationship.annotation.EmailValidation;
import com.adixSoftware.relationship.annotation.PhoneNumberValidation;
import com.adixSoftware.relationship.model.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class UserDTO {

	private Long id;

	@NotBlank(message = "Name should not be blank")
	@Size(min = 1, max = 200, message = "Name should be between 1 and 200 characters")
	private String firstName;

	private String lastName;

	@PhoneNumberValidation(message = "Please enter valid phone number")
	private String phoneNumber;

	@EmailValidation(message = "Please enter valid email")
	private String email;

	private RoleType type;
}
