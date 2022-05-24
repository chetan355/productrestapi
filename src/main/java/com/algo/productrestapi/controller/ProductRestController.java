package com.algo.productrestapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.productrestapi.entities.Product;
import com.algo.productrestapi.repos.ProductRepository;


@RestController
public class ProductRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
	@Autowired
	private ProductRepository repos;
	
	@RequestMapping(value = "/products" , method = RequestMethod.GET)
	public List<Product> getProducts(){
		return repos.findAll();
	}
	
	@RequestMapping(value = "/products/{id}" , method = RequestMethod.GET)
	public Product getProduct(@PathVariable int id) {
		LOGGER.info("Getting product of id"+id);
		return repos.findById(id).get();
	}
	
	@RequestMapping(value = "/products" , method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repos.save(product);
	}
	
	@RequestMapping(value = "/products" , method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody  Product product) {
		return repos.save(product);		
	}

	@RequestMapping(value = "/products/{id}" , method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		repos.deleteById(id);		
	}
}
