package com.springexample.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springexample.backend.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
