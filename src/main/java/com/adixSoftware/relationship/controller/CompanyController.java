package com.adixSoftware.relationship.controller;

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

import com.adixSoftware.relationship.dto.CompanyDTO;
import com.adixSoftware.relationship.dto.UserDTO;
import com.adixSoftware.relationship.service.CompanyService;
import com.adixSoftware.relationship.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "CompanyController", description = "REST APIs related to Company Entity")
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Get list of all companies")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 400, message = "Bad request"), 
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getALLCompanies() {
		log.debug("all companies are retrieving");
		List<CompanyDTO> companyDTO = companyService.getAllCompanies();
		log.info("All companies are retrieved");
		return ResponseEntity.ok(companyDTO);
	}
	
	@ApiOperation(value = "Get specific Company using its id")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
		log.debug("Retrieving info of Company id {}", id);
		CompanyDTO companyDTO = companyService.getCompanyById(id);
		log.info("Successfully retrieved company with id = {}", id);
		return ResponseEntity.ok(companyDTO);
	}

	@ApiOperation(value = "Create new company")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PostMapping
	public ResponseEntity<CompanyDTO> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
		log.debug("Creating new Company");
		CompanyDTO company = companyService.createCompany(companyDTO);
		log.info("Company is successfully created");
		return ResponseEntity.ok(company);
	}

	@ApiOperation(value = "Get users related to specific company using its id")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/{id}/users")
	public ResponseEntity<List<UserDTO>> getUsersByCompanyId(@PathVariable Long id) {
		log.debug("Retrieving users with company id: {}", id);
		List<UserDTO> users = userService.findByCompanyId(id);
		log.info("Successfully retrieved users with company id: {}", id);
		return ResponseEntity.ok(users);
	}

	@ApiOperation(value = "Update specific company")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PutMapping
	public ResponseEntity<CompanyDTO> updateCompany(@Valid @RequestBody CompanyDTO companyDTO) {
		log.debug("Updating info of Company");
		CompanyDTO company = companyService.updateCompany(companyDTO);
		log.info("successfully updated company with id");
		return ResponseEntity.ok(company);
	}

	@ApiOperation(value = "Create relationship between company and user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PostMapping("/{id}/users/{userId}/add")
	public ResponseEntity<String> addCompany(@PathVariable Long id, @PathVariable Long userId) {
		log.debug("Creating relationship between company id: {} and user id:{}", id, userId);
		companyService.addCompany(id, userId);
		log.info("Relationship created successfully between company id: {} and user id: {}", id, userId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@ApiOperation(value = "Remove relation between company and user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/{id}/users/{userId}/remove")
	public ResponseEntity<String> removeCompany(@PathVariable Long id, @PathVariable Long userId) {
		log.debug("Removing relationship between company id: {} and user id: {}", id, userId);
		companyService.removeCompany(id, userId);
		log.info("Relationship removed successfully between company: {} and user id: {}", id, userId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@ApiOperation(value = "Remove company")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		log.debug("Removing company with id: {}", id);
		companyService.deleteCompany(id);
		log.info("Successfully removed company with id: {}", id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
