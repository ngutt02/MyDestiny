package com.pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.entity.Employee;
import com.pack.repository.AbcDAO;
import com.pack.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@Autowired
	private AbcDAO repository;
	Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	@GetMapping("/home")
	public String getHomePage()
	{
		return "home.jsp";
	}

	@RequestMapping("/addEmployee")
	public String addEmploye(Employee emp)
	{


		repository.save(emp);
		log.info(service.getNoOfStudent());
		logger.info("addEmployee() method is accessed");
		return "home.jsp";
	}

}
