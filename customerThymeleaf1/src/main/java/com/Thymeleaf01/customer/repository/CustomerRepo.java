package com.Thymeleaf01.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Thymeleaf01.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
