package com.curso.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Name;
	private String Description;
	private String image;
	private double price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	
	public Product() {}
	
	public Product(Integer id, String name, String description, String image, double price, int quantity, User user) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.setUser(user);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", Description=" + Description + ", image=" + image + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 
	
	

}
