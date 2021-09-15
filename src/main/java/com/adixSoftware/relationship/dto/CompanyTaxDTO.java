package com.adixSoftware.relationship.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class CompanyTaxDTO {

	private Long id;

	@NotBlank(message = "Tax number should not null, please enter tax number")
	private String taxNumber;

	@Size(min = 0, message = "tax amount should not less than 0")
	private Long taxAmount;
}
