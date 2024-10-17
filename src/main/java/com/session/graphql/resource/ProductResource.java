package com.session.graphql.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import com.session.graphql.entity.Product;
import com.session.graphql.service.ProductService;

@Controller
public class ProductResource {
	@Autowired
	private ProductService productService;
	
	@QueryMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@QueryMapping
	public List<Product> getProductByCategory(@Argument String category){
		return productService.getProductByCategory(category);
	}
	
	@MutationMapping
	public Product updateStock(@Argument int id,@Argument int stock) {
		return productService.updateStock(id,stock);
	}
	
	@MutationMapping
	public Product updateStockShipment(@Argument int id, @Argument int stock)  {
		return productService.updateProductStockShipment(id, stock);
	}
}
