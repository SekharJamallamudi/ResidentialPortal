package com.project.service;

import java.util.List;

import com.project.entity.Product;
import com.project.exception.ProductNotFoundException;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> fetchAllProducts();
	public Product fetchProduct(Long id) throws ProductNotFoundException;
	public void delete(Long id);
	public void updateProduct(Product product);
}