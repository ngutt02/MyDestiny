package com.pack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pack.entity.Employee;
import com.pack.repository.EmployeeRepository;
import com.pack.service.IEmpService;
@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	EmployeeRepository repository;
	@Override
	public Page<Employee> findEmployee(int pageIndex) {
		Pageable pageable = PageRequest.of(pageIndex,3,Sort.by("ename").ascending());
		System.out.println(pageable);
		Page<Employee> empPage=repository.findAll(pageable);
		System.out.println(empPage);
		return empPage;

	}

}
