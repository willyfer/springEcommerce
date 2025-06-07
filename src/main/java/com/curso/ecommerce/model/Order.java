package com.curso.ecommerce.model;

import java.sql.Date;

public class Order {
	private Integer id;
	private String number;
	private Date createDate;
	private Date recievedDate;
	private double total;
	
	public Order() {}
	public Order(Integer id, String number, Date createDate, Date recievedDate, double total) {
		super();
		this.id = id;
		this.number = number;
		this.createDate = createDate;
		this.recievedDate = recievedDate;
		this.total = total;
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
	
	
	
	

}
