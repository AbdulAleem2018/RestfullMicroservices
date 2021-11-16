package com.techi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techi.Springboot.Product;
import com.techi.Springboot.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	//getting all Product records  
	public List<Product> getAllProducts() {
		List<Product> productsList = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> productsList.add(product));
		return productsList;
	}

	//getting a specific record  
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}
	
	//update/insert record 
	public void saveOrUpdate(Product Product) {
		productRepository.save(Product);
	}

	//deleting a specific record  
	public void delete(int id) {
		productRepository.deleteById(id);
	}
}