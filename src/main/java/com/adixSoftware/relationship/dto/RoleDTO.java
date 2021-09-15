package com.adixSoftware.relationship.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.adixSoftware.relationship.model.RoleType;
import com.adixSoftware.relationship.model.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class RoleDTO {

	private Long id;

	@NotBlank(message = "Role should not null, Please enter role")
	private RoleType role;

	private Set<Users> users;
}
