package com.algo.productrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.algo.productrestapi.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests 
{
	@Value("${productrestapi.services.url}")
	private String BASE_URL;
	@Test
	public void testGetProduct() {
//		System.out.println(BASE_URL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(BASE_URL+"1", Product.class);
		assertNotNull(product);
//		assertEquals("ASUS-X509",product.getName());		
	}
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung M21");
		product.setDescription("Mobile Phone");
		product.setPrice(12000);
		Product prod = restTemplate.postForObject(BASE_URL,product,Product.class);
		assertNotNull(prod);
		assertEquals("Samsung M21",prod.getName());		
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(BASE_URL+"5", Product.class);
		product.setPrice(12999);
		restTemplate.put(BASE_URL, product);
//		assertNotNull(prod);
//		assertEquals(12999, prod.getPrice());		
	}
//	@Test
//	public void testDeleteProduct() {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(BASE_URL+"9");		
//	}
}
