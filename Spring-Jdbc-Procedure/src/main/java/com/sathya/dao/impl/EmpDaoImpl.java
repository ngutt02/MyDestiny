package com.sathya.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.sathya.dao.IEmpDao;
@Repository("edi")
public class EmpDaoImpl implements IEmpDao {

	@Autowired
	SimpleJdbcCall simpleJdbcCall;


	public void callDbProcedure(int employeeNo) {
		simpleJdbcCall.withProcedureName("calc_bonus");
		Map<String,Integer> inMap=new HashMap<>();
		inMap.put("eno",employeeNo);
		Map<String,Object> outMap=simpleJdbcCall.execute(inMap);
		System.out.println("Name:"+outMap.get("NAME"));
		System.out.println("Bonus:"+outMap.get("BONUS"));

	}

}
