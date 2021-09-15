package com.adixSoftware.relationship.mapper;

import org.springframework.stereotype.Component;

import com.adixSoftware.relationship.dto.CompanyDTO;
import com.adixSoftware.relationship.dto.CompanyTaxDTO;
import com.adixSoftware.relationship.model.Company;
import com.adixSoftware.relationship.model.CompanyTax;

@Component
public class CompanyMapper {

	public Company dtoToEntity(CompanyDTO companyDTO) {

		Company company = new Company();

		CompanyTaxDTO taxDTO = companyDTO.getTax();
		CompanyTax tax = new CompanyTax();
		tax.setId(taxDTO.getId());
		tax.setTaxNumber(taxDTO.getTaxNumber());
		tax.setTaxAmount(taxDTO.getTaxAmount());

		company.setName(companyDTO.getName());
		company.setCountry(companyDTO.getCountry());
		company.setPhoneNumnber(companyDTO.getPhoneNumber());
		company.setEmail(companyDTO.getEmail());
		company.setOpeningDate(companyDTO.getOpeningDate());
		company.setTax(tax);
		return company;
	}

	public CompanyDTO entityToDto(Company company) {

		CompanyDTO companyDTO = new CompanyDTO();

		CompanyTax tax = company.getTax();
		CompanyTaxDTO taxDTO = new CompanyTaxDTO();
		taxDTO.setId(tax.getId());
		taxDTO.setTaxNumber(tax.getTaxNumber());
		taxDTO.setTaxAmount(tax.getTaxAmount());

		companyDTO.setId(company.getId());
		companyDTO.setName(company.getName());
		companyDTO.setCountry(company.getCountry());
		companyDTO.setPhoneNumber(company.getPhoneNumnber());
		companyDTO.setEmail(company.getEmail());
		companyDTO.setOpeningDate(company.getOpeningDate());
		companyDTO.setTax(taxDTO);
		return companyDTO;
	}
}
