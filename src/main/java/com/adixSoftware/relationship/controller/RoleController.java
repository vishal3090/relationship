package com.adixSoftware.relationship.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adixSoftware.relationship.dto.RoleDTO;
import com.adixSoftware.relationship.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "RoleController", description = "REST APIs related to Role Entity")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "Create new role")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad request"), 
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PostMapping
	public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
		log.debug("It is going to create Role");
		RoleDTO role = roleService.createRole(roleDTO);
		log.info("Role is successfully created");
		return ResponseEntity.ok(role);
	}
}
