package com.pack.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;
import com.pack.repository.UserEntityRepository;

@RestController
public class UserRestController {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	private UserEntityRepository repository;

	@PostMapping("/registerUser")
	public String registerUser(@RequestBody UserDto dto)
	{
		boolean flag=repository.existsById(dto.getUserName());
		if(flag==false)
		{
		UserEntity userEntity=new UserEntity();
		String pwd=encoder.encode(dto.getPassword());
		BeanUtils.copyProperties(dto,userEntity);
		userEntity.setPassword(pwd);
		repository.save(userEntity);
		return "user saved in database";
		}else {
			return "Sorry Username Already Exist in database,try with different username";
		}
		
	}
	/*@PostMapping("applyLoan")
	public String applyLoan(@RequestBody LoanDto loan)
	{
	  boolean flag=repository.existsById(loan.getLoanNumber());
	  
		
	}
	*/
	/*public List<String> getCrededntials(String userName)
	{
		return " ";
	}
	*/
	
}
