package com.pack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.ProductDTO;
import com.pack.entity.Product;
import com.pack.repository.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts()
	{
		List<Product> productList=repository.findAll();
		List<ProductDTO> productDtoList=new ArrayList();
		productList.forEach(product->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(product, dto);
			productDtoList.add(dto);
		});
		return new ResponseEntity<List<ProductDTO>>(productDtoList,HttpStatus.OK);

	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("productId")Integer productId)
	{
		boolean flag=repository.existsById(productId);
		ProductDTO productDto=new ProductDTO();
		if(flag==true)
		{
			Optional<Product>opt=repository.findById(productId);
			Product product=opt.get();

			BeanUtils.copyProperties(product, productDto);


		}
		return new ResponseEntity<ProductDTO>(productDto,HttpStatus.OK);

	}
	@PostMapping("/product/create")
	public String createProduct(@RequestBody ProductDTO pdto)
	{
		Product product=new Product();
		BeanUtils.copyProperties(pdto, product);
		boolean flag=repository.existsById(product.getProductId());
		if(flag==true)
		{
			return "Sorry Product Id already exist";
		}
		else {
			repository.save(product);
			return "Product saved on database";
		}
		
	}
	
}
