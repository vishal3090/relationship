package com.adixSoftware.relationship.service;

import java.util.List;

import com.adixSoftware.relationship.dto.UserDTO;

public interface UserService {

	List<UserDTO> getAllUsers();

	UserDTO getUserById(Long id);

	UserDTO updateUser(UserDTO userDto);

	void deleteUser(Long id);

	void updateActivate(Long id);

	UserDTO createUser(UserDTO userDto);

	List<UserDTO> findByCompanyId(Long id);

}
