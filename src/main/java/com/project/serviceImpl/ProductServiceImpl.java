package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.project.entity.Product;
import com.project.exception.ProductNotFoundException;
import com.project.repository.ProductRepository;
import com.project.service.ProductService;

@Service
@Primary
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	boolean flag;
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product fetchProduct(Long id) throws ProductNotFoundException {
		Product product = null;
		if(id != null && id != 0) {
			flag = productRepository.existsById(id);
		}
		if(flag) 
			product = productRepository.findById(id).get();
		else
			throw new ProductNotFoundException("Product Not Found");
		return product;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	 productRepository.deleteById(id);;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	

	

	
	

	
}