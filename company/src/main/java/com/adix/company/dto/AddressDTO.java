package com.adix.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AddressDTO {
	
	private Long id;

	private String city;

	private String country;
	
    CompanyDTO company;

}
