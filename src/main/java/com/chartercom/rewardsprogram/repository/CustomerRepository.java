package com.chartercom.rewardsprogram.repository;

import org.springframework.data.repository.CrudRepository;

import com.chartercom.rewardsprogram.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
