package com.adix.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TaxDTO {

	private Long id;

	private String incomeTaxNumber;

	private Long taxAmount;
}
