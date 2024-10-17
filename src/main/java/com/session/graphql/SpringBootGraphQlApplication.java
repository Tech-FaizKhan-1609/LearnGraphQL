package com.session.graphql;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Stream;
import com.session.graphql.entity.Product;
import com.session.graphql.repo.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootGraphQlApplication {
	
	@Autowired
	private ProductRepository productRepository;
	
//	@PostConstruct
//	public void initDB() {
//		List<Product> products= Stream.of(
//				new Product("Laptop","Electronics",74999.99f,50),
//				new Product("SmartPhone","Electronics",55999.99f,70),
//				new Product("Chair","Furniture",3999.99f,80),
//				new Product("Notebook","Stationery",899.99f,120),
//				new Product("Table","Furniture",4999.99f,50),
//				new Product("WaterBotle","Accessories",999.99f,50),
//				new Product("Dest Lamp","Furniture",1099.99f,50)
//				
//				).toList();
//		productRepository.saveAll(products);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphQlApplication.class, args);
		System.out.println("Application is up....");
	}

}
