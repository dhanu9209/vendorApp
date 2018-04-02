package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="item")
public class Item {
	@Id
	@Column(name="ITEM_ID")
	private int  itemId;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column(name="ITEM_COST")
	private double itemost;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemost=" + itemost + ", customer=" + customer
				+ ", getItemId()=" + getItemId() + ", getItemName()="
				+ getItemName() + ", getItemost()=" + getItemost()
				+ ", getCustomer()=" + getCustomer() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemost() {
		return itemost;
	}
	public void setItemost(double itemost) {
		this.itemost = itemost;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
