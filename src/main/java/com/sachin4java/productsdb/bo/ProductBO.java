package com.sachin4java.productsdb.bo;

import java.util.List;

import com.sachin4java.productsdb.model.Product;

public interface ProductBO {

	List<Product> findAll();

	Product create(Product product);

	List<Product> findByCategoryName(String categoryname);

}
