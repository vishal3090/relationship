package com.adix.company.mapper;

import com.adix.company.dto.AddressDTO;
import com.adix.company.dto.CompanyDTO;
import com.adix.company.model.Address;
import com.adix.company.model.Company;

public class AddressMapper {

	public static Address dtoToEntity(AddressDTO addressDto) {
		Address address = new Address();
		address.setId(addressDto.getId()).setCity(addressDto.getCity()).setCountry(addressDto.getCountry());
		return address;
	}

	public static AddressDTO entityToDto(Address address) {
		AddressDTO addressDto = new AddressDTO();

		Company company = address.getCompany();
		CompanyDTO companyDto = new CompanyDTO();
		companyDto.setId(company.getId());
		companyDto.setCompanyName(company.getCompanyName());

		addressDto.setId(address.getId());
		addressDto.setCity(address.getCity());
		addressDto.setCountry(address.getCountry());
		// addressDto.setCompany(companyDto);
		return addressDto;
	}

}
