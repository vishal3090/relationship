package com.adix.company.service;

import java.util.List;

import com.adix.company.dto.CompanyDTO;
import com.adix.company.specification.SearchCriteria;

public interface CompanyService {

	List<CompanyDTO> getAllCompanies();

	void deleteCompany(Long id);

	void updateActive(Long id);

	List<CompanyDTO> searchCompanyPostMethod(List<SearchCriteria> search);

}
