package com.pack.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pack.dao.IEmpDao;
import com.pack.entity.Employee;
@Repository
public class EmpDaoImpl implements IEmpDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	public List<Employee> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee.class);

	}
}
