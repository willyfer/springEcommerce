package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Product;
import com.curso.ecommerce.model.User;
import com.curso.ecommerce.service.ProductService;
import com.curso.ecommerce.service.UploadFileService;

 
@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService  productService; 
	
	@Autowired
	private UploadFileService uploadFile;
	
	@GetMapping("")
	public String products (Model model) {
		model.addAttribute("products", productService.findAll());
		return "products/show";
	}
	@GetMapping("/create")
	public String create () {
		return "products/create";
	}
	
	@PostMapping("/save")
	public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
		
		LOGGER.info("Este es el obj producto {}", product);
		User u = new User(1, "", "", "", "", "", "");
		product.setUser(u);
		
		if(product.getId() == null) {
			String imgName = uploadFile.saveImg(file);
			product.setImage(imgName);
		}else {
			
			
		}
		
		productService.save(product);
		
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id , Model model) {
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();
		LOGGER.info("Producto buscado {}", product);
		model.addAttribute("product", product);
		return "products/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Producto update {}", product);
		Product p = new Product();
		p = productService.get(product.getId()).get();
		if(file.isEmpty()) { // not change image
			product.setImage(p.getImage());
		}else { // change image

			if(!p.getImage().equals("default.jpg")) {
				uploadFile.deleteImg(p.getImage());
			}
			String imgName = uploadFile.saveImg(file);
			product.setImage(imgName);
			
		}
		product.setUser(p.getUser());
		productService.update(product);
		return  "redirect:/products";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Product p = new Product();
		p = productService.get(id).get();
		if(!p.getImage().equals("default.jpg")) {
			uploadFile.deleteImg(p.getImage());
		}
		productService.delete(id);
		return "redirect:/products";
		
	}
}
