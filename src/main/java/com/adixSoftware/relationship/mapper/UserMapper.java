package com.adixSoftware.relationship.mapper;

import org.springframework.stereotype.Component;

import com.adixSoftware.relationship.dto.UserDTO;
import com.adixSoftware.relationship.model.Users;

@Component
public class UserMapper {

	public Users dtoToEntity(UserDTO userDTO) {

		Users user = new Users();
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setEmail(userDTO.getEmail());
		user.setType(userDTO.getType());
		return user;
	}

	public UserDTO entityToDto(Users user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setEmail(user.getEmail());
		userDTO.setType(user.getType());
		return userDTO;
	}
}
