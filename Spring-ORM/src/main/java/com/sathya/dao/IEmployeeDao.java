package com.sathya.dao;

import java.util.List;

import com.sathya.entity.Employee;

public interface IEmployeeDao {


	void saveEmp(Employee emp);
	Employee findEmp(Integer empno);
	List<Employee> findAll();
	void updateEmp(Employee emp);
	public void delete(Integer empno);

}
