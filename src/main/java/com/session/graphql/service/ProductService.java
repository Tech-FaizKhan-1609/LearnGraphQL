package com.session.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.graphql.entity.Product;
import com.session.graphql.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductByCategory(String category){
		return productRepository.findByCategory(category);
	}

	public Product updateStock(int id, int stock) {
		Product product =productRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource Not Found"+id));
		product.setStock(stock);
		return productRepository.save(product);
	}

	public Product updateProductStockShipment(int id, int stock) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id :" + id));
		
		int stock2 = product.getStock();
		int addStock = stock+stock2;
		product.setStock(addStock);
		return productRepository.save(product);
	}

}
