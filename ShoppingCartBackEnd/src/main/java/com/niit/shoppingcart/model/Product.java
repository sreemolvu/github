package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Product
{
	@Id
	private String id;
	private String name;
	private String description;
	private int price; 
	@ManyToOne
	@JoinColumn(name="CID")
	private Category categoryID;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="SID")
	private Supplier suppilerID;
	
	public Category getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}
	public Supplier getSuppilerID() {
		return suppilerID;
	}
	public void setSuppilerID(Supplier suppilerID) {
		this.suppilerID = suppilerID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
