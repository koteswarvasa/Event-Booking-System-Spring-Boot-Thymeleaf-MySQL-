package com.Thymeleaf01.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Thymeleaf01.customer.model.Customer;
import com.Thymeleaf01.customer.repository.CustomerRepo;

@Service
public class CustomerService {


	@Autowired
	CustomerRepo customerRepo;

	public List<Customer>findAllCustomers(){

		return customerRepo.findAll();

	}

}
