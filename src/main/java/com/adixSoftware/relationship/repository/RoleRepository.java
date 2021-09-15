package com.adixSoftware.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adixSoftware.relationship.model.Role;
import com.adixSoftware.relationship.model.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role getByRole(RoleType role);

}
