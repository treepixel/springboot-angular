package com.springexample.backend.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springexample.backend.entities.Product;
import com.springexample.backend.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Page<Product> getAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	public Optional<Product> get(Long id) {
		return productRepository.findById(id);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
