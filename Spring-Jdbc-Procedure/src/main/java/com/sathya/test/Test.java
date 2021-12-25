package com.sathya.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sathya.config.AppConfig;
import com.sathya.dao.impl.EmpDaoImpl;

public class Test {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

	public static void main(String[] args) {
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		EmpDaoImpl bean = annotationConfigApplicationContext.getBean("edi",EmpDaoImpl.class);
		bean.callDbProcedure(102);
	}

}
