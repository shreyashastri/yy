package com.emp.api.repository;

import org.springframework.data.repository.CrudRepository;


import com.emp.api.entity.AddressEntity;

public interface AddressRepo extends CrudRepository<AddressEntity, Integer> {
 
	
	}
 