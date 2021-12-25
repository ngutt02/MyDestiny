package com.sathya.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sathya.config.AppConfig;
import com.sathya.dao.ICustomerDao;
import com.sathya.dao.impl.CustomerDaoImpl;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		ICustomerDao dao= container.getBean("customerDaoImpl",CustomerDaoImpl.class);
		int result[]=dao.runBatch();
		System.out.println(result);
		System.out.println("batch executed");


	}

}
