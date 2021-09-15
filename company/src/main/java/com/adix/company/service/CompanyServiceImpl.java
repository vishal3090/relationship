package com.adix.company.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.adix.company.dto.CompanyDTO;
import com.adix.company.dto.TaxDTO;
import com.adix.company.exception.CompanyNotFoundException;
import com.adix.company.mapper.CompanyMapper;
import com.adix.company.model.Company;
import com.adix.company.model.Tax;
import com.adix.company.repository.CompanyRepository;
import com.adix.company.repository.TaxRepository;
import com.adix.company.specification.CompanySpecification;
import com.adix.company.specification.SearchCriteria;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private TaxRepository taxRepository;

	@Override
	public List<CompanyDTO> getAllCompanies() {

		return companyRepository.findAll().stream().map(company -> CompanyMapper.entityToDto(company))
				.collect(Collectors.toList());
	}

	public CompanyDTO getCompanyById(Long id) {
		Company company = companyRepository.getById(id);

		// convert entity to DTO
		CompanyDTO companyResponse = CompanyMapper.entityToDto(company);

		return companyResponse;
	}

	public CompanyDTO createCompany(CompanyDTO companyDto) {
		Company companyEntity = CompanyMapper.dtoToEntity(companyDto);
		if (companyDto.getTax() != null) {
			Tax tax = companyEntity.getTax();
			tax.setCompany(companyEntity);
			taxRepository.save(tax);
		}
		Company company = companyRepository.save(companyEntity);
		CompanyDTO companyResponse = CompanyMapper.entityToDto(company);
		return companyResponse;
	}

	public CompanyDTO updateCompany(long id, CompanyDTO companyDto) {

		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("No Company with ID : " + id));

		// convert DTO to Entity
		// Company companyRequest = modelMapper.map(companyDto, Company.class);
		TaxDTO tax = companyDto.getTax();
		company.getTax().setIncomeTaxNumber(tax.getIncomeTaxNumber());
		company.getTax().setTaxAmount(tax.getTaxAmount());
		company.setCompanyName(companyDto.getCompanyName());
		company.setCompanyPhoneNumber(companyDto.getCompanyPhoneNumber());
		company.setOpeningDate(companyDto.getOpeningDate());
		company.setCompanyEmail(companyDto.getCompanyEmail());
		company.setCompanyPhoto(companyDto.getCompanyPhoto());
		company.setActived(true);

		companyRepository.save(company);

		// entity to DTO
		CompanyDTO companyResponse = CompanyMapper.entityToDto(company);

		return companyResponse;
	}

	@Override
	public void deleteCompany(Long id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("No Company with ID : " + id));

		companyRepository.deleteById(company.getId());
	}

	@Override
	public void updateActive(Long id) {
		companyRepository.updateActive(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

	public List<CompanyDTO> searchCompanyPostMethod(List<SearchCriteria> searchCriteria) {
		CompanySpecification companySpecification = new CompanySpecification(searchCriteria);
		List<CompanyDTO> companyList = companyRepository.findAll(companySpecification).stream()
				.map(company -> CompanyMapper.entityToDto(company)).collect(Collectors.toList());
		return companyList;
	}

}
