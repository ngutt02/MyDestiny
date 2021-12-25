package com.sathya.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sathya.dao.IEmployeeDao;
import com.sathya.entity.Employee;
@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Transactional
	public void saveEmp(Employee emp) {
		hibernateTemplate.save(emp);

	}
	public Employee findEmp(Integer empno) {

		return hibernateTemplate.get(Employee.class,empno);
	}
	public List<Employee> findAll() {

		return hibernateTemplate.loadAll(Employee.class);
	}
	public void updateEmp(Employee emp)
	{
		hibernateTemplate.update(emp);
	}
	@Override
	public void delete(Integer empno) {
		Employee e=hibernateTemplate.get(Employee.class,empno);
		hibernateTemplate.delete(e);

	}

}
