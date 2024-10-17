package com.session.graphql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.session.graphql.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(String category);

}
