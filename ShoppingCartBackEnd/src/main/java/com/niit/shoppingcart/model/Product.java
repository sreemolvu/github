package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private int stock;
	

	@ManyToOne
	@JoinColumn(name="CID")
	private Category categoryID;
	
	@ManyToOne
	@JoinColumn(name="SID")
	private Supplier suppilerID;
	@OneToMany(targetEntity=Cart.class,mappedBy = "productID", cascade = CascadeType.ALL)
	private Set<Cart> carts;
	

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

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
/*
	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	*/
}
