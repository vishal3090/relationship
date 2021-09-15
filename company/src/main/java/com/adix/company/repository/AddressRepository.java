package com.adix.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adix.company.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Address getAddressByCompanyId(Long company_id);

}
