package com.pack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.entity.Employee;
import com.pack.model.EmployeeModel;
import com.pack.repository.EmployeeRepository;
import com.pack.service.IEmpService;

@Controller
public class EmployeeController {


	@Autowired
	EmployeeRepository repository;

	@Autowired
	IEmpService service;

	@GetMapping("/index")
	public String getIndexPage()
	{
		return "index";
	}
	@GetMapping("/addEmployee")
	public String getAddEmployeePage(Model model)
	{
		EmployeeModel empModel=new EmployeeModel();
		model.addAttribute("empModel",empModel);
		return "addEmployee";
	}

	@PostMapping("saveEmployee")
	public String saveEmployee(@ModelAttribute("empModel")EmployeeModel modelEmp,Model model)
	{
		Employee employee=new Employee();
		BeanUtils.copyProperties(modelEmp,employee);
		boolean flag=repository.existsById(employee.getEmpno());
		if(flag==true)
		{
			model.addAttribute("message","sorry Employee already exist");
			return "index";
		}else {
			repository.save(employee);
			model.addAttribute("message","Employee Added to database");
			return "index";
		}
	}
	@GetMapping("listEmployees")
	public String listEmployees(@RequestParam(value="pageIndex",defaultValue="0")int pageIndex,Model model)
	{
		/*List<Employee> empList=repository.findAll();
		List<EmployeeModel> modelEmpList=new ArrayList<>();
		for(Employee e:empList)
		{
			EmployeeModel em=new EmployeeModel();
			BeanUtils.copyProperties(e,em);
			modelEmpList.add(em);

		}
		model.addAttribute("employees",modelEmpList);
		return "employeesList";
		 */		
		Page<Employee> empPage=service.findEmployee(pageIndex);
		List<Employee> empList=empPage.getContent();
		boolean previous=empPage.hasPrevious();
		boolean next=empPage.hasNext();
		int x=empPage.getNumber();
		model.addAttribute("employees",empList);
		model.addAttribute("previous",previous);
		model.addAttribute("next",next);
		model.addAttribute("cpn",x);
		System.out.println(empList);
		return "employeesList";
		/*PageRequest em=new PageRequest();
		for(Employee e:empPage)
		{
			EmployeeModel em=new EmployeeModel();

		}*/
	}
	@GetMapping("/editEmployee")
	public String editEmployeePage(@RequestParam int id,Model model)
	{
		System.out.println("id property:"+id);
		Optional<Employee> opt=repository.findById(id);
		Employee emp=opt.get();
		System.out.println(emp);
		EmployeeModel em=new EmployeeModel();
		BeanUtils.copyProperties(emp,em);

		System.out.println(em);
		model.addAttribute("emp",em);
		return "editEmployee";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("emp")EmployeeModel em)
	{
		Employee employee = new Employee();
		BeanUtils.copyProperties(em,employee);
		repository.saveAndFlush(employee);
		return "redirect:listEmployees";

	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id")Integer id)
	{
		repository.deleteById(id);
		return "redirect:listEmployees";

	}
	
	@GetMapping("/login")
	public String getLoginPage()
	{
		return "login";
	}
	
	@GetMapping("/doLogin")
	public String 

}



