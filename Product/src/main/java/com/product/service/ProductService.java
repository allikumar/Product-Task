package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {
	
	public String addProduct(Product product);

	public String updateProduct(String id, Product product);

	public String deleteProduct(String id);

	public Product findProduct(String id);

	public List<Product> findAllProduct();

}
