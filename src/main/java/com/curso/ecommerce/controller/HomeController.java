package com.curso.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.model.DetailOrder;
import com.curso.ecommerce.model.Order;
import com.curso.ecommerce.model.Product;
import com.curso.ecommerce.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ProductService productService;

	 
 
	List<DetailOrder> details = new ArrayList<DetailOrder>();
	Order order = new Order();

	@GetMapping("")
	public String home(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);

		return "user/home";
	}

	@GetMapping("/product/{id}")
	public String productHome(@PathVariable Integer id, Model model) {
		Product p = new Product();
		Optional<Product> product = productService.get(id);

		p = product.get();
		LOGGER.info("product{}", p);
		model.addAttribute("product", p);
		return "user/productohome";
	}

	@PostMapping("/cart")
	public String cart(@RequestParam Integer id,@RequestParam Integer quantity) {
		DetailOrder detailOrder = new DetailOrder();
		
		Product product = new Product();
		
		double total = 0;
		Optional<Product> productOptional=productService.get(id);
		LOGGER.info("productOptional {}",productOptional.get());
		LOGGER.info("cantidad {}",quantity);

		return "user/carrito";
	}
}
