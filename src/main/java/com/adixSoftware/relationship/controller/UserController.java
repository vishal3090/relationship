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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "UserController", description = "REST APIs related to User Entity")
@RestController
@RequestMapping("/api/users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyService;

	@ApiOperation(value = "Get list of all users")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		log.debug("All users are retrieving");
		List<UserDTO> userDTO = userService.getAllUsers();
		log.info("All users are retrieved");
		return ResponseEntity.ok(userDTO);
	}

	@ApiOperation(value = "Get specific user using its id")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		log.debug("Retrieving info of User with id = {}", id);
		UserDTO userDTO = userService.getUserById(id);
		log.info("Successfully retrieved user with id = {}", id);
		return ResponseEntity.ok(userDTO);
	}

	@ApiOperation(value = "Create new user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
		log.debug("Creating new user ");
		UserDTO user = userService.createUser(userDTO);
		log.info("User is successfully created ");
		return ResponseEntity.ok(user);
	}
	
	@ApiOperation(value = "Update specific user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
		log.debug("Updating info of User with id = {}", userDTO.getId());
		UserDTO user = userService.updateUser(userDTO);
		log.info("successfully updated User with id = {}", userDTO.getId());
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = "Get companies related to specific user using its id")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/{id}/companies")
	public ResponseEntity<List<CompanyDTO>> getCompaniesByUsersId(@PathVariable Long id) {
		log.debug("Retrieving all the companies with user id: {}", id);
		List<CompanyDTO> company = companyService.findByUsersId(id);
		log.info("Successfully retrieved compaies with user id: {}", id);
		return ResponseEntity.ok(company);
	}

	@ApiOperation(value = "Remove user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		log.debug("Deleting user with id: {}", id);
		userService.deleteUser(id);
		log.info("Successfully user deleted with id: {}", id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@ApiOperation(value = "Activate user")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PutMapping("/{id}/activate")
	public ResponseEntity<String> userActivate(@PathVariable Long id) {
		log.debug("Activating user with id: {}", id);
		userService.updateActivate(id);
		log.info("Successfully activated user with id: {}", id);
		return ResponseEntity.ok().body("User with ID: " + id + " activated with success");
	}
}
