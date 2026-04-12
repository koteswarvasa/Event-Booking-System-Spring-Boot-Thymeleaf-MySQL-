package com.Thymeleaf01.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Thymeleaf01.customer.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/")
	String findAllCustomers(Model model) {
		model.addAttribute("customers" ,customerService.findAllCustomers());

		return "index";
	}

}
