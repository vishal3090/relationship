package com.adixSoftware.relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adixSoftware.relationship.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByUsersId(Long userId);

	boolean existsByName(String name);
}
