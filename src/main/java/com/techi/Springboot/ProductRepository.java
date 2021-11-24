package com.techi.Springboot;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//public List<Product> getListOfProductsById(Integer itemId);
	
}
