package com.curso.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.ecommerce.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
}
