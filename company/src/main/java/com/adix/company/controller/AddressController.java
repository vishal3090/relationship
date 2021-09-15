package com.adix.company.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adix.company.dto.AddressDTO;
import com.adix.company.service.AddressServiceImpl;

@RestController
@RequestMapping("/api/company")
public class AddressController {
	
	private static final Logger log = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	AddressServiceImpl addressService;

	@GetMapping("address")
	public ResponseEntity<List<AddressDTO>> getAddressList() {

		log.debug("It will get all Addresses");
		List<AddressDTO> addressDto = addressService.getAllAddresses();
		log.info("All addresses are displayed");
		return ResponseEntity.ok(addressDto);
	}

	@PostMapping(value = "{companyId}/address")
	public ResponseEntity<AddressDTO> createAddress(@PathVariable Long companyId, @RequestBody AddressDTO addressDto) {
		
		log.debug("It will create new Address");
		AddressDTO address = addressService.createAddress(companyId, addressDto);
		log.info("New Address is created");
		return ResponseEntity.ok(address);
	}

	@GetMapping(value ="/{company_id}/address")
	public ResponseEntity<List<AddressDTO>> getAddressByCompanyId(@PathVariable Long company_id) {

		log.debug("It will Fetch Address details by Id");
		List<AddressDTO> address = addressService.getAddressByCompanyId(company_id);
		log.info("Display Address details respected Id");
		return ResponseEntity.ok(address);
	}

	@PutMapping(value = "address/{id}")
	public ResponseEntity<AddressDTO> updateAddressData(@PathVariable Long id, @RequestBody AddressDTO AddressDto) {
		
		log.debug("It is going to update address");
		AddressDTO address = addressService.updateAddress(id, AddressDto);
		log.info("Address is updated");
		return ResponseEntity.ok(address);
	}
	
	@DeleteMapping(value = "/address/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

		log.debug("It will delete address with Id = " + id);
		addressService.deleteAddress(id);
		log.info("Successfully deleted address with Id = " + id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
