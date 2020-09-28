package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PRODUCT_MASTER")
public class ProductMaster {
	

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PRODUCT_NAME")
	@NotNull(message="Product Name is mandatory")
	@NotBlank(message="Product Name cannot be blank")
	@Size(min=3,message="Product Name should have minimum 3 chars in length")
	private String productName;
	
	@Column(name="COST")
	@NotNull(message="cost is mandatory")
	@Min(value=10,message="cost cannot be less than 10")
	private Integer cost;
	
	@Column(name="PRODUCT_DESCRIPTION")
	@NotNull(message="Product Description is mandatory")
	@NotBlank(message="Product Description cannot be blank")
	@Size(min=5,message="Product Description should have minimum 5 chars in length")
	private String productDescription;
	
	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMaster(int id, String productName, Integer cost, String productDescription) {
		super();
		this.id = id;
		this.productName = productName;
		this.cost = cost;
		this.productDescription = productDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productName=" + productName + ", cost=" + cost + ", productDescription="
				+ productDescription + "]";
	}

}

	


