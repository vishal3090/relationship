package com.adixSoftware.relationship.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adixSoftware.relationship.dto.UserDTO;
import com.adixSoftware.relationship.exception.ResourceNotFoundException;
import com.adixSoftware.relationship.mapper.UserMapper;
import com.adixSoftware.relationship.model.RoleType;
import com.adixSoftware.relationship.model.Users;
import com.adixSoftware.relationship.repository.RoleRepository;
import com.adixSoftware.relationship.repository.UserRepository;
import com.adixSoftware.relationship.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDTO> getAllUsers() {
		log.debug("User service : retrieving all users");
		return userRepository.findAll().stream().map(userMapper::entityToDto).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long id) {
		log.debug("User service : retrieving user with id: {}", id);
		Users user = userRepository.getById(id);
		log.info("User service : Successfully retrieved user with id = {}", id);
		return userMapper.entityToDto(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		log.debug("User service: creating new user");
		Users userEntity = userMapper.dtoToEntity(userDTO);

		if (userDTO.getType().equals(RoleType.ADMIN)) {
			userEntity.setRole(roleRepository.getByRole(RoleType.ADMIN));
		}
		if (userDTO.getType().equals(RoleType.USER)) {
			userEntity.setRole(roleRepository.getByRole(RoleType.USER));
		}

		Users user = userRepository.save(userEntity);
		log.info("User service: User is successfully created ");
		return userMapper.entityToDto(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		log.debug("User service: updating info of User id: {}", userDTO.getId());
		Users user = userRepository.findById(userDTO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No User with Id: " + userDTO.getId()));

		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setEmail(userDTO.getEmail());
		userRepository.save(user);
		log.info("User service: successfully updated User with id = {}", userDTO.getId());
		return userMapper.entityToDto(user);
	}

	@Override
	public List<UserDTO> findByCompanyId(Long id) {
		log.debug("User service: retrieving all the users with company id: {}", id);
		return userRepository.findByCompanyId(id).stream().map(user -> userMapper.entityToDto(user))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long id) {
		log.debug("User service: deleting user with id: {}", id);
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No User with ID : " + id));
		log.info("Successfully user deleted with id = {}", id);
		userRepository.delete(user);
	}

	@Override
	public void updateActivate(Long id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User with Id: " + id));
		log.debug("User service: activating user with id = " + id);
		userRepository.updateActivate(id);
	}

}
