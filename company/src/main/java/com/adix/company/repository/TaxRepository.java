package com.adix.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adix.company.model.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

}
