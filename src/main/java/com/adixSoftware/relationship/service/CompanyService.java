package com.adixSoftware.relationship.service;

import java.util.List;

import com.adixSoftware.relationship.dto.CompanyDTO;

public interface CompanyService {

	List<CompanyDTO> getAllCompanies();

	CompanyDTO getCompanyById(Long id);

	CompanyDTO updateCompany(CompanyDTO companyDTO);

	CompanyDTO createCompany(CompanyDTO companyDTO);

	List<CompanyDTO> findByUsersId(Long id);

	void deleteCompany(Long id);

	void addCompany(Long id, Long userId);

	void removeCompany(Long id, Long userId);

}
