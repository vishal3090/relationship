package com.adixSoftware.relationship.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adixSoftware.relationship.dto.RoleDTO;
import com.adixSoftware.relationship.mapper.RoleMapper;
import com.adixSoftware.relationship.model.Role;
import com.adixSoftware.relationship.repository.RoleRepository;
import com.adixSoftware.relationship.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleDTO createRole(RoleDTO roleDTO) {

		log.debug("Role Service: creating Role");
		Role roleEntity = RoleMapper.dtoToEntity(roleDTO);
		Role role = roleRepository.save(roleEntity);
		log.info("Role Service: Role is successfully created");
		return RoleMapper.entityToDto(role);
	}
}
