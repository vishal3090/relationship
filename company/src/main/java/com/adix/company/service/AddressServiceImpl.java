package com.adix.company.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adix.company.dto.AddressDTO;
import com.adix.company.exception.CompanyNotFoundException;
import com.adix.company.mapper.AddressMapper;
import com.adix.company.model.Address;
import com.adix.company.model.Company;
import com.adix.company.repository.AddressRepository;
import com.adix.company.repository.CompanyRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<AddressDTO> getAllAddresses() {

		return addressRepository.findAll().stream().map(address -> AddressMapper.entityToDto(address))
				.collect(Collectors.toList());
	}

	public AddressDTO createAddress(Long companyId, AddressDTO addressDto) {

		Address address = AddressMapper.dtoToEntity(addressDto);
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new CompanyNotFoundException("No Company with ID : " + companyId));

		address.setCompany(company);
		addressRepository.save(address);

		AddressDTO addressResponse = AddressMapper.entityToDto(address);
		return addressResponse;
	}
	
	public List<AddressDTO> getAddressByCompanyId(Long company_id) {
		
		//if(!companyRepository.existsById(company_id)) {
			
			//throw new CompanyNotFoundException("No Company with ID : " + company_id);
		//}
		
		
		//Address address1 = addressRepository.getById(companyId);
		//AddressDTO addressDto = AddressMapper.entityToDto(address1);
		
		
		return addressRepository.findById(company_id).stream().map(address -> AddressMapper.entityToDto(address))
				.collect(Collectors.toList());
		//return addressDto;
	}
	
	public AddressDTO updateAddress(Long id, AddressDTO addressDto) {
		
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("No Address found with Id: "+id));
		
		Address addressRequest = AddressMapper.dtoToEntity(addressDto);
		addressRequest.setId(address.getId());
		addressRequest.setCompany(address.getCompany());
		addressRepository.save(addressRequest);
		
		AddressDTO addresDto = AddressMapper.entityToDto(addressRequest);
		return addresDto;
	}

	public void deleteAddress(Long id) {

		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("No Address with ID : " + id));
		addressRepository.deleteById(address.getId());
	}

}
