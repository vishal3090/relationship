package com.adixSoftware.relationship.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adixSoftware.relationship.dto.CompanyDTO;
import com.adixSoftware.relationship.exception.DuplicateValueException;
import com.adixSoftware.relationship.exception.ResourceNotFoundException;
import com.adixSoftware.relationship.mapper.CompanyMapper;
import com.adixSoftware.relationship.model.Company;
import com.adixSoftware.relationship.model.CompanyTax;
import com.adixSoftware.relationship.model.RoleType;
import com.adixSoftware.relationship.model.Users;
import com.adixSoftware.relationship.repository.CompanyRepository;
import com.adixSoftware.relationship.repository.UserRepository;
import com.adixSoftware.relationship.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public List<CompanyDTO> getAllCompanies() {
		log.debug("Company service : retrieving all companies");
		return companyRepository.findAll().stream().map(companyMapper::entityToDto).collect(Collectors.toList());
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {
		log.debug("Company service : retrieving company with id: {}", id);
		Company company = companyRepository.getById(id);
		log.info("Company service : Successfully retrieved company with id: {}", id);
		return companyMapper.entityToDto(company);
	}

	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {
		log.debug("Company service: creating new company");
		Company companyEntity = companyMapper.dtoToEntity(companyDTO);

		if (companyRepository.existsByName(companyDTO.getName())) {
			throw new DuplicateValueException("Duplicate company name not allowed");
		}

		if (companyDTO.getTax() != null) {
			CompanyTax tax = companyEntity.getTax();
			tax.setCompany(companyEntity);
			companyEntity.setTax(tax);
		}

		Company company = companyRepository.save(companyEntity);
		log.info("Company service: Company is successfully created");
		return companyMapper.entityToDto(company);
	}

	@Override
	public CompanyDTO updateCompany(CompanyDTO companyDTO) {
		log.debug("Company service: updating info of Company id: {}");
		Company company = companyRepository.findById(companyDTO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No Company with Id: " + companyDTO.getId()));

		Company companyRequest = companyMapper.dtoToEntity(companyDTO);
		companyRequest.setId(company.getId());
		companyRepository.save(companyRequest);
		log.info("Company service : successfully updated company with id: {}", companyDTO.getId());
		return companyMapper.entityToDto(company);
	}

	@Override
	public void addCompany(Long id, Long userId) {
		log.debug("Creating relationship between company id: {} and user id: {}", id, userId);
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Company with ID : " + id));
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No User with ID : " + userId));
		if (user.isActivated() == true && user.getType() == RoleType.USER) {
			user.getCompany().add(company);
			companyRepository.save(company);
		} else {
			throw new ResourceNotFoundException("User must have 'USER' role");
		}
	}

	@Override
	public void removeCompany(Long id, Long userId) {
		log.debug("Removing relationship between company id: {} and user id: {}", id, userId);
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Company with ID : " + id));
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No User with ID : " + userId));

		user.getCompany().remove(company);
		companyRepository.save(company);
	}

	@Override
	public List<CompanyDTO> findByUsersId(Long id) {
		log.debug("Company service: retrieving all the companies with user id: {}", id);
		return companyRepository.findByUsersId(id).stream().map(companyMapper::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteCompany(Long id) {
		log.debug("Company service: deleting company with id: {}", id);
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Company with ID : " + id));

		company.getUsers().forEach(users -> users.getCompany().remove(company));
		userRepository.saveAll(company.getUsers());
		log.info("Company service : Successfully removed company with id: {}", id);
		companyRepository.delete(company);
	}
}
