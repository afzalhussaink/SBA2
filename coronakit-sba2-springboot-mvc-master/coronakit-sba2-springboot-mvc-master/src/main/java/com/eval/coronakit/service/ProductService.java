package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.ProductMasterException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws ProductMasterException;
	public ProductMaster saveProduct(ProductMaster product) throws ProductMasterException;
	public List<ProductMaster> getAllProducts();
	public boolean deleteProduct(int productId) throws ProductMasterException;
	public ProductMaster getProductById(int productId);
}
