package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pack.dao.IEmpDao;
import com.pack.entity.Employee;

@Controller
public class PdfExcelController {

	@Autowired
	IEmpDao dao;

	@GetMapping("/pdfReport")
	public String getReportInPdf(Model model)
	{
		List<Employee> empList=dao.getAllEmployee();
		model.addAttribute("employees",empList);
		return "employeesPdfView";
	}

	@GetMapping("/excelReport")
	public String getReportInExcel(Model model)
	{
		List<Employee> empList=dao.getAllEmployee();
		model.addAttribute("employees",empList);
		return "employeesExcelView";
	}


}
