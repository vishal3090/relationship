package com.adixSoftware.relationship.mapper;

import com.adixSoftware.relationship.dto.RoleDTO;
import com.adixSoftware.relationship.model.Role;

public class RoleMapper {

	public static Role dtoToEntity(RoleDTO roleDTO) {

		Role role = new Role();

		role.setId(roleDTO.getId());
		role.setRole(roleDTO.getRole());
		return role;
	}

	public static RoleDTO entityToDto(Role role) {

		RoleDTO roleDTO = new RoleDTO();

		roleDTO.setId(role.getId());
		roleDTO.setRole(role.getRole());
		return roleDTO;
	}
}
