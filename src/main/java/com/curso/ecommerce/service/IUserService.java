package com.curso.ecommerce.service;

import java.util.Optional;

import com.curso.ecommerce.model.User;

public interface IUserService {
	Optional<User> findById (Integer id);


}
