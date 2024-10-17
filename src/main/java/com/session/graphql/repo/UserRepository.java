package com.session.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.session.graphql.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
