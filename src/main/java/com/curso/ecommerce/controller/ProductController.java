package com.curso.ecommerce.controller;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.model.Product;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("")
	public String products () {
		return "products/show";
	}
	@GetMapping("/create")
	public String create () {
		return "products/create";
	}
	
	@PostMapping("/save")
	public String save(Product product) {
		LOGGER.info("Este es el obj producto {}", product);
		return "redirect:/products";
	}
}
