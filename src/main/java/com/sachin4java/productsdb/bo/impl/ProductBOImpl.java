package com.sachin4java.productsdb.bo.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sachin4java.productsdb.bo.ProductBO;
import com.sachin4java.productsdb.dao.ProductRepository;
import com.sachin4java.productsdb.entity.ProductEntity;
import com.sachin4java.productsdb.model.Product;

@Component
class ProductBOImpl implements ProductBO {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Product> findAll() {
		List<ProductEntity> productEntities = productRepository.findAll();
		Type listType = new TypeToken<List<Product>>() {}.getType();
		return modelMapper.map(productEntities, listType);
		
	}

	@Override
	public Product create(Product product) {
		ProductEntity entity = modelMapper.map(product,ProductEntity.class);
		
		return modelMapper.map(productRepository.save(entity), Product.class);
	}

	@Override
	public List<Product> findByCategoryName(String categoryName) {
		List<ProductEntity> productEntities = productRepository.findByCategoryName(categoryName);
		Type listType = new TypeToken<List<Product>>() {}.getType();
		return modelMapper.map(productEntities, listType);
	}

}
