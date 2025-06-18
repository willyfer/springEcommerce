package com.curso.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	public String cart(@RequestParam Integer id, @RequestParam Integer quantity, Model model) {
		DetailOrder detailOrder = new DetailOrder();

		Product product = new Product();

		double total = 0;
		Optional<Product> productOptional = productService.get(id);
		LOGGER.info("productOptional {}", productOptional.get());
		LOGGER.info("cantidad {}", quantity);
		product = productOptional.get();
		detailOrder.setQuantity(quantity);
		detailOrder.setPrice(product.getPrice());
		detailOrder.setName(product.getName());
		detailOrder.setProduct(product);
		detailOrder.setTotal(quantity * product.getPrice());
		
		// validar que no se repita el producto
		Integer idProduct = product.getId();
		boolean ingresado = details.stream().anyMatch(d->d.getProduct().getId()== idProduct);
		if(!ingresado){
			details.add(detailOrder);
		}
		
		
		total = details.stream().mapToDouble(dt -> dt.getTotal()).sum();
		LOGGER.info("total {}", total);
		order.setTotal(total);

		model.addAttribute("cart", details);
		model.addAttribute("order", order);
		LOGGER.info("cart {}", details);
		LOGGER.info("order {}", order);

		return "user/carrito";
	}

	@GetMapping("/delete/cart/{id}")
	public String deleteProductCart(@PathVariable Integer id, Model model) {
		List<DetailOrder> newDetailOrders = new ArrayList<DetailOrder>();

		for (DetailOrder detailOrder : details) {
			if (detailOrder.getProduct().getId() != id) {
				newDetailOrders.add(detailOrder);
			}
		}
		details = newDetailOrders;
		double total = 0;
		total = details.stream().mapToDouble(dt -> dt.getTotal()).sum();
		order.setTotal(total);

		model.addAttribute("cart", details);
		model.addAttribute("order", order);
		LOGGER.info("cart {}", details);
		LOGGER.info("order {}", order);

		return "user/carrito";

	}
	
	@GetMapping("/getCart")
	public String getCart(Model model) {
		model.addAttribute("cart", details);
		model.addAttribute("order", order);
		return "user/carrito";
	}
	
	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("cart", details);
		model.addAttribute("order", order);
		return "user/resumenorden";
	}
	
	@PostMapping("/search")
	public String searchProduct(@RequestParam String name, Model model) {
		List<Product> products = productService.findAll().stream().filter(p->p.getImage().contains(name)).collect(Collectors.toList());
		model.addAttribute("products", products);
		return "user/home";
	}
}
