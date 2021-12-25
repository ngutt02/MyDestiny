package com.sathya.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sathya.dao.IEmployeeDao;
import com.sathya.entity.Employee;

public class Test {

	public static void main(String[] args) {
		ApplicationContext container=new ClassPathXmlApplicationContext("applicationContext.xml");
		IEmployeeDao dao=(IEmployeeDao)container.getBean("employeeDaoImpl");

		/*Employee emp=new Employee(240,"wcott",40000.0,30);
		dao.saveEmp(emp);*/
	  
		/*Employee e=dao.findEmp(101);
	  System.out.println(e);
	  */
	  /*List<Employee> empList=dao.findAll();
	  empList.forEach(e->System.out.println(e));
	*/
		
		/*Employee e=new Employee(101,"sam",40000.0,40);
		dao.updateEmp(e);*/
		
		dao.delete(101);
	}

}
