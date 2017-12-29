package com.sachin4java.productsdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin4java.productsdb.bo.ProductBO;
import com.sachin4java.productsdb.model.Product;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductBO productBO;
	
	@GetMapping
	public  List<Product> findAll(){
		
		return productBO.findAll();
		
	}
	
	@GetMapping("/category/{categoryname}")
	public  List<Product> findByCategoryName(@PathVariable String categoryname){
		
		return productBO.findByCategoryName(categoryname);
		
	}

	
	@PostMapping
	public Product create(@RequestBody Product product) {
		//Preconditions.checkNotNull(product);
		return productBO.create(product);
		
	}
	
	

}
