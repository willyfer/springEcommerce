package com.curso.ecommerce.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private Date createDate;
	private Date recievedDate;
	private double total;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; 
	
	@OneToOne(mappedBy = "order")
	private DetailOrder detailOrder;
	
	public Order() {}
	public Order(Integer id, String number, Date createDate, Date recievedDate, double total, User user) {
		super();
		this.id = id;
		this.number = number;
		this.createDate = createDate;
		this.recievedDate = recievedDate;
		this.total = total;
		this.user = user;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getRecievedDate() {
		return recievedDate;
	}


	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", createDate=" + createDate + ", recievedDate="
				+ recievedDate + ", total=" + total + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DetailOrder getDetailOrder() {
		return detailOrder;
	}
	public void setDetailOrder(DetailOrder detailOrder) {
		this.detailOrder = detailOrder;
	}
	
	
	
	

}
