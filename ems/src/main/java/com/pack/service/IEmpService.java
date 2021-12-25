package com.pack.service;

import org.springframework.data.domain.Page;

import com.pack.entity.Employee;

public interface IEmpService {

	
	public Page<Employee> findEmployee(int pageIndex);
}
