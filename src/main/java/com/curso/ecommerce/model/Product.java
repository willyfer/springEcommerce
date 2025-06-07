package com.curso.ecommerce.model;

public class Product {
	private Integer id;
	private String Name;
	private String Description;
	private String image;
	private double price;
	private int quantity;
	
	
	public Product() {}
	
	public Product(Integer id, String name, String description, String image, double price, int quantity) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
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
	
	

}
