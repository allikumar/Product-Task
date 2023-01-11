package com.product.control;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import com.product.entity.Product;

import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductControl {
	
	@Autowired
	ProductService productService;

	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("/updateproduct/{id}")
	public String updateProduct(@PathVariable String id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable String id) {
		return productService.deleteProduct(id);
	}

	@GetMapping("/findproduct/{id}")
	public Product findProduct(@PathVariable String id) {
		return productService.findProduct(id);
	}

	@GetMapping("/findallproduct")
	public List<Product> findAllProduct() {
		return productService.findAllProduct();
	}

}
