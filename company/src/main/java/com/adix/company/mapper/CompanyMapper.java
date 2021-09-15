package com.adix.company.mapper;

import com.adix.company.dto.CompanyDTO;
import com.adix.company.dto.TaxDTO;
import com.adix.company.model.Company;
import com.adix.company.model.Tax;

public class CompanyMapper {

	public static Company dtoToEntity(CompanyDTO companyDto) {
		Company company = new Company();

		TaxDTO taxDto = companyDto.getTax();
		Tax tax = new Tax();
		tax.setId(taxDto.getId());
		tax.setIncomeTaxNumber(taxDto.getIncomeTaxNumber());
		tax.setTaxAmount(taxDto.getTaxAmount());

		company.setId(companyDto.getId());
		company.setCompanyName(companyDto.getCompanyName());
		company.setCompanyPhoneNumber(companyDto.getCompanyPhoneNumber());
		company.setOpeningDate(companyDto.getOpeningDate());
		company.setCompanyEmail(companyDto.getCompanyEmail());
		company.setCompanyPhoto(companyDto.getCompanyPhoto());
		company.setTax(tax);
		return company;
	}

	public static CompanyDTO entityToDto(Company company) {
		CompanyDTO companyDto = new CompanyDTO();

		Tax tax = company.getTax();
		TaxDTO taxDto = new TaxDTO();
		taxDto.setId(tax.getId());
		taxDto.setIncomeTaxNumber(tax.getIncomeTaxNumber());
		taxDto.setTaxAmount(tax.getTaxAmount());

		companyDto.setId(company.getId());
		companyDto.setCompanyName(company.getCompanyName());
		companyDto.setCompanyPhoneNumber(company.getCompanyPhoneNumber());
		companyDto.setOpeningDate(company.getOpeningDate());
		companyDto.setCompanyEmail(company.getCompanyEmail());
		companyDto.setCompanyPhoto(company.getCompanyPhoto());
		companyDto.setTax(taxDto);
		return companyDto;
	}

}
