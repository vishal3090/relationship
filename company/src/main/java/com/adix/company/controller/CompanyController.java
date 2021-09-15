package com.adix.company.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adix.company.dto.CompanyDTO;
import com.adix.company.service.CompanyServiceImpl;
import com.adix.company.specification.SearchCriteria;

@RestController
@RequestMapping("/api")
public class CompanyController {

	private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyServiceImpl companyService;

	@GetMapping(value = "/company")
	public ResponseEntity<List<CompanyDTO>> getCompanyList() {
		log.debug("It will get all companies");
		List<CompanyDTO> companyDto = companyService.getAllCompanies();
		log.info("All companies are displayed");
		return ResponseEntity.ok(companyDto);
	}

	@PostMapping(value = "/company")
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDto) {

		log.debug("Its going to create new company " + companyDto);
		CompanyDTO company = companyService.createCompany(companyDto);
		log.info("Company is created " + companyDto);
		return ResponseEntity.ok(company);
	}

	@GetMapping(value = "/company/{id}")
	public ResponseEntity<CompanyDTO> getById(@PathVariable Long id) {

		log.debug("Its going to get info of Company ID = " + id);
		CompanyDTO companyDto = companyService.getCompanyById(id);
		log.info("Displayed company ID = " + id);
		return ResponseEntity.ok(companyDto);
	}

	@PutMapping(value = "/company/{id}")
	public ResponseEntity<CompanyDTO> updateCompanyData(@PathVariable Long id,
			@Valid @RequestBody CompanyDTO companyDto) {

		log.debug("It will update info of Company ID = " + id);
		CompanyDTO company = companyService.updateCompany(id, companyDto);
		log.info("Updated info of company = " + id);
		return ResponseEntity.ok(company);
	}

	@DeleteMapping(value = "/company/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

		log.debug("It will delete company with Id = " + id);
		companyService.deleteCompany(id);
		log.info("Successfully deleted company with Id = " + id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(value = "company/active/{id}")
	public ResponseEntity<String> updateActive(@PathVariable Long id) {
		
		log.debug("It will update true in activated column in company Id = " + id);
		companyService.updateActive(id);
		log.info("Updated true in activated column company Id = " + id);
		return ResponseEntity.ok().body("Company with ID : " + id + " activated with success!");
	}

	@PostMapping(value = "/company/search")
	public ResponseEntity<List<CompanyDTO>> searchCompanyList(
			@Valid @RequestBody ArrayList<SearchCriteria> searchCriteriaList) {

		log.debug("It is going to search the results");
		List<CompanyDTO> company = companyService.searchCompanyPostMethod(searchCriteriaList);
		log.info("search results are displayed");
		return ResponseEntity.ok(company);
	}

}
