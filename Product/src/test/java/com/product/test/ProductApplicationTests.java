package com.task.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.task.Product.entity.Product;
import com.task.Product.repo.ProductRepo;
import com.task.Product.service.ProductService;

@SpringBootTest
class ProductApplicationTests {

	
	
	@Test
	void contextLoads() {
	}
	@MockBean
	private ProductRepo productRepository;
		@Autowired
	private ProductService productService;
		
	@Test
		public void getAllTest() {
			when(productRepository.findAll()).thenReturn(Stream.of(new Product(1,"screw",2,"Other",500),
					new Product(1,"screw",2,"Other",500)).collect(Collectors.toList()));
			assertEquals(2, productService.findallProducts().size());
		}
	
	
	
	@Test
	public void deleteTest() {
		Product product = new Product(1,"screw",2,"Other",500);
		productService.deleteProduct(1);
		verify(productRepository,times(1)).deleteById(1);
	}
	


}

