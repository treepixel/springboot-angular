package com.springexample.backend.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.springexample.backend.entities.Product;
import com.springexample.backend.repositories.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	@Test
	public void shouldReturnProductWhenSave() {
		Product product = new Product();
		
		product.setNome("Peça 01");
		product.setVeiculoAplicacao("Pálio ddd");
		product.setPesoBruto(2.85);
		product.setPesoLiquido(1.85);
		
		when(productRepository.save(any(Product.class))).thenReturn(product);
		
		Product created = productService.save(product);
		
		assertThat(created.getNome()).isSameAs(product.getNome());
	}
}
