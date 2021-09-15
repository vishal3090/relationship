package com.adixSoftware.relationship.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adixSoftware.relationship.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Transactional
	@Modifying
	@Query("update users set activated = true where id = :id")
	void updateActivate(Long id);

	List<Users> findByCompanyId(Long companyId);

}
