package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Product;
import com.project.exception.ProductNotFoundException;
import com.project.pojo.AuthRequest;
import com.project.service.ProductService;
import com.project.serviceImpl.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	  
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.fetchAllProducts(), HttpStatus.CREATED);
	}

	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Product getProduct(@PathVariable Long id) throws ProductNotFoundException {
		return productService.fetchProduct(id);
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(@PathVariable Long id)
	{
	      productService.delete(id);	
	}
	 @PutMapping("/update")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
	        productService.updateProduct(product);
	        return ResponseEntity.ok("Product updated successfully");
	    }
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
		return jwtService.generateToken(authRequest.getUsername());
		
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}
		
   }

	
}
