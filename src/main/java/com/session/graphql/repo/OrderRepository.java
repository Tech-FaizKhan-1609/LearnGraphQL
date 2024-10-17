package com.session.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.session.graphql.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
