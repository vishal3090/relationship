package com.adix.company.mapper;

import com.adix.company.dto.TaxDTO;
import com.adix.company.model.Tax;

public class TaxMapper {
	
	public static Tax dtoToEntity(TaxDTO taxDto) {
		return new Tax().setId(taxDto.getId())
				.setIncomeTaxNumber(taxDto.getIncomeTaxNumber())
				.setTaxAmount(taxDto.getTaxAmount());
	}
	
	public static TaxDTO entityToDto(Tax tax) {
		return new TaxDTO().setId(tax.getId())
				.setIncomeTaxNumber(tax.getIncomeTaxNumber())
				.setTaxAmount(tax.getTaxAmount());
	}
	
}
