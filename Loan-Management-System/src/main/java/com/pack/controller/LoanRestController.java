package com.pack.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.LoanDto;
import com.pack.entity.LoanEntity;
import com.pack.repository.LoanEntityRepository;

@RestController
public class LoanRestController {


	@Autowired
	private LoanEntityRepository repository;


	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, editor);
	}


	@GetMapping("/applyLoan/{ln}/{lam}/{lt}/{property}")
	public String applyLoan(@PathVariable("ln") int ln,@PathVariable("lam") double lam,@PathVariable("lt") String lt,
			@PathVariable("property") String property)
	{

		boolean flag=repository.existsById(ln);
		if(flag==false)
		{

			System.out.println("from apply loan"+ln);
			LoanEntity entity=new LoanEntity();
			entity.setLoanNumber(ln);
			entity.setLoanAmount(lam);
			entity.setLoanType(lt);
			entity.setProprtyAddress(property);

			repository.save(entity);
			return "Loan Applied pending for Confirmation";
		}

		else {
			return "Sorry Loan Number Already Exist,Try With Different LoanNumber";
		}
	}
	@GetMapping(value="/searchLoan",produces="application/json")
	public Object searchLoan(@RequestParam("loanNumber")Integer loanNumber)
	{

		boolean flag =repository.existsById(loanNumber);
		if(flag==true)
		{


			Optional<LoanEntity> opt=repository.findById(loanNumber);

			LoanEntity entity=opt.get();
			LoanDto dto=new LoanDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}else {
			return "loanNumber doesnot exist";
		}


	}
	@GetMapping("/approveLoan")
	public List<LoanDto> allLoan()
	{
		List<LoanEntity> entityList= repository.findAll();

		List<LoanDto> dtoList=new ArrayList<>();
		//BeanUtils.copyProperties(entityList, dtoList);
		for (LoanEntity entity : entityList) {
			LoanDto dto=new LoanDto();
			BeanUtils.copyProperties(entity,dto);
			dtoList.add(dto);
		}
		return dtoList;

	}


	@GetMapping("/approveLoan/approve/{ln}")
	public String approveLoan(@PathVariable("ln")Integer loanNumber)
	{

		boolean flag=repository.existsById(loanNumber);
		if(flag==true)
		{
			Optional<LoanEntity>	opt=repository.findById(loanNumber);
			LoanEntity entity=opt.get();
			entity.setStatus("approved");
			repository.saveAndFlush(entity);
			return "loan approved";
		}
		else {
			return "loan Number doest not exist";
		}
	}

	@GetMapping("/rejectLoan/reject/{ln}")
	public String rejectLoan(@PathVariable("ln")Integer loanNumber)
	{
		boolean flag=repository.existsById(loanNumber);
		if(flag==true)
		{
			Optional<LoanEntity>	opt=repository.findById(loanNumber);
			LoanEntity entity=opt.get();
			entity.setStatus("rejected");
			repository.saveAndFlush(entity);
			return "loan rejected";
		}else {
			return "loan Number doest not exist";
		}


	}
}
