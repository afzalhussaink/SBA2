package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="KIT_DETAIL")
public class KitDetail {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private int coronaKitId;
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="QUANTITY")
	@Min(value=1,message="Quantity should be greater than or equals to 1")
	private int quantity;
	
	@Column(name="AMOUNT")
	private int amount;
	
	public KitDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public KitDetail(int id, int productId, int quantity, int amount) {
		this.id = id;
		//this.coronaKitId = coronaKitId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public int getCoronaKitId() { return coronaKitId; } public void
	 * setCoronaKitId(int coronaKitId) { this.coronaKitId = coronaKitId; }
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
