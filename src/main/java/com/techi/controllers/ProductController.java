package com.techi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techi.Product;
import com.techi.service.ProductService;

@RestController
//@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(
				value="/add-product",
				consumes = {"application/xml", "application/json"}
			)
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		String responceMessage=null;
		System.out.println("Befpre call....");
		productService.saveOrUpdate(product);
		System.out.println("Product is Saved.");
		 
		responceMessage="Product is Saved.";
		
		return new ResponseEntity<String>(responceMessage,HttpStatus.CREATED);
	}
	
	/**
Input:
{
    "productId": 100120034,
    "product_name": "Laptop",
    "product_cost": 59990.00,
    "mfg_date": "2018-03-29",
    "exp_date": "2018-03-30"
}
{    
    "product_name": "Desktop",
    "product_cost": 59990.00,
    "mfg_date": "2018-03-29",
    "exp_date": "2018-03-30"
}
Output:
PostMan: Product is Saved.(Status:200K)
Oracle DB:
select * from product;
2	Laptop	59990	29-03-18	30-03-18
3	Desktop	59990	29-03-18	30-03-18

**/
	
	@PostMapping(
			value="/new-product",
			consumes = {"application/xml", "application/json"},
			produces = {"application/xml", "application/json"}
		)
public ResponseEntity<Product> newProduct(@RequestBody Product product){
	System.out.println("Befpre call....");
	productService.saveOrUpdate(product);
	System.out.println("New Product added");
	return new ResponseEntity<Product>(product,HttpStatus.CREATED);
}
	
	@PutMapping(
			value="/update-product",
			consumes = {"application/xml", "application/json"}
		)
public ResponseEntity<String> updateProduct(@RequestBody Product product){
	String responceMessage=null;
	System.out.println("Before call update....");
	productService.saveOrUpdate(product);
	System.out.println("Product is Updated.");
	 
	responceMessage="Product is Updated.";
	
	return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
}
/**
Input:
{
    "productId": 2,
    "product_name": "Laptop",
    "product_cost": 62990.00,
    "mfg_date": "2021-10-07",
    "exp_date": "2021-11-06"
}

Note:Before update data in DB
2	Laptop	59990	29-03-18	30-03-18
3	Desktop	59990	29-03-18	30-03-18
21	Phone	10000	10-11-21	09-11-26

PUT: localhost:8080/update-product
Content-Type:application/json

Output:
PostMan: Product is Updated.(Status:200 OK)
Oracle DB:
select * from product;
2	Laptop	59990	29-03-18	30-03-18
3	Desktop	59990	29-03-18	30-03-18
21	Phone	10000	10-11-21	09-11-26
22	Laptop	62990	07-10-21	06-11-21

**/
	
	@GetMapping(
			value="/all-products",
			consumes = {"application/xml", "application/json"}
		)
	public ResponseEntity<String> allProducts(){
		String responceMessage=null;
		List<Product> allProducts=productService.getAllProducts();
		System.out.println("No of Products are:"+allProducts.size());

		for(Product product:allProducts) {
			System.out.println(product.toString());
		}
	 
		responceMessage="Got all products";
	
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	
/**
	GET:localhost:8080/all-products
	Content-type: application/json
	Output:
	Postman: Got all products
	Console:
	No of Products are:2
	Product(product_Id=2, product_name=Laptop, product_cost=59990.0, mfg_date=2018-03-29 05:30:00.0, exp_date=2018-03-30 05:30:00.0)
	Product(product_Id=3, product_name=Desktop, product_cost=59990.0, mfg_date=2018-03-29 05:30:00.0, exp_date=2018-03-30 05:30:00.0)
  
**/
	
	@GetMapping(
			value="/select-product/{pid}",
			consumes = {"application/xml", "application/json"}
		)
	public ResponseEntity<String> getProductByProductId(@PathVariable("pid") int productId){
		String responceMessage=null;
		System.out.println("Selected Product Id :"+productId);
		Product choosedProduct=productService.getProductById(productId);
		
		System.out.println("Selected Product :"+choosedProduct.toString());
		responceMessage="Got selected product";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	
	
	//DELETE: localhost:8080/delete-product/3/
	@DeleteMapping(
			value="/delete-product/{pid}",
			consumes = {"application/xml", "application/json"}
		)
	public ResponseEntity<String> deleteProductByProductId(@PathVariable("pid") int productId){
		String responceMessage=null;
		productService.delete(productId);
		
		responceMessage="Deleted product";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	/*
	 Postman Body: Deleted product
	 Before: 
	 select * from product;
	 2	Laptop	59990	29-03-18	30-03-18
	 3	Desktop	59990	29-03-18	30-03-18
	 After:
	 select * from product;
	 2	Laptop	59990	29-03-18	30-03-18
	 
	 */
}