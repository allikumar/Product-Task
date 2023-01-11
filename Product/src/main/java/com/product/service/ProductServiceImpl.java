package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
//import com.product.service.ProductService;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public String addProduct(Product product) {
		productRepository.save(product);
		return "product added Successfully with id" +  product.getId(); 
	}

	public String updateProduct(String id, Product product) {
		Optional<Product> Container = productRepository.findById(id);
		if (Container.isPresent()) {
			Product n = Container.get();
			n.setId(product.getId());
			n.setProductName(product.getProductName());
		    n.setProductColor(product.getProductColor());
		    n.setProductPrice(product.getProductPrice());
		    n.setProductSeller(product.getProductSeller());
		    n.setProductBrand(product.getProductBrand());
		    
		  
		    
			
			productRepository.save(n);
			return "Product Updated Successfully with"+ id ;
		} else {
			return "Id not found";
		}
	}

	public String deleteProduct(String id) {
		java.util.Optional<Product> Container = productRepository.findById(id);
		if (Container.isPresent()) {
			Product cust =Container.get();
			productRepository.delete(cust);
			return " Product Deleted Successfully"+  id;
		} else {
			return "not found";
		}
	}

	public Product findProduct(String id) {
		return productRepository.findById(id).get();
	}

	public List<Product> findAllproduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}


}
