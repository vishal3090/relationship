package com.adixSoftware.relationship.mapper;

import org.springframework.stereotype.Component;

import com.adixSoftware.relationship.dto.CompanyTaxDTO;
import com.adixSoftware.relationship.model.CompanyTax;

@Component
public class CompanyTaxMapper {

	public static CompanyTax dtoToEntity(CompanyTaxDTO companyTaxDTO) {

		CompanyTax companyTax = new CompanyTax();

		companyTax.setId(companyTaxDTO.getId());
		companyTax.setTaxAmount(companyTaxDTO.getTaxAmount());
		companyTax.setTaxNumber(companyTaxDTO.getTaxNumber());
		return companyTax;
	}

	public static CompanyTaxDTO entityToDto(CompanyTax companyTax) {

		CompanyTaxDTO companyTaxDTO = new CompanyTaxDTO();

		companyTaxDTO.setId(companyTax.getId());
		companyTaxDTO.setTaxAmount(companyTax.getTaxAmount());
		companyTaxDTO.setTaxNumber(companyTax.getTaxNumber());
		return companyTaxDTO;
	}
}
