package com.product.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.product.entity.Product;
import com.product.project.ProductApplication;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;



@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	@DisplayName("Add Product Test")
	public void addProductTest() {
		Product product=new Product("1028","Smart TV", "Grey-Black", "55000", "VEIRA Electronics", "Infinix" );
		when(productRepository.save(product)).thenReturn(product);
		Assertions.assertThat(product.getId()).hasSizeGreaterThan(0);
	}

	@Test
	@DisplayName("Delete Product Test")
	public void DeleteProductTest() {
		Product product=new Product("1028","Smart TV", "Grey-Black", "55000", "VEIRA Electronics", "Infinix");
		productService.deleteProduct(product.getId());
		assertEquals(0,productService.findAllProduct().size());
	}

}
