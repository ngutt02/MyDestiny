package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.pack.bean.ProductBean;

@Controller
public class ProductController {
	@Value("${addurl}")
	private String ADD_PRODUCT_URL;

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("home")
	public String getHomePage()
	{
		
		return "home";
	}
	@GetMapping("AddProduct")
	public String addProduct(@RequestBody ProductBean bean)
	{
		return restTemplate.postForObject(ADD_PRODUCT_URL,bean,String.class);
		
	}
}
