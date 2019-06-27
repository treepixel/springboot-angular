package com.springexamble.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springexample.backend.BackendApplication;
import com.springexample.backend.controllers.ProductController;
import com.springexample.backend.entities.Product;
import com.springexample.backend.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = BackendApplication.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ProductService productService;
		
	@Test
    public void shouldCreateProduct() throws Exception {
        
		ProductResource product = new ProductResource("Peça 01", "Pálio weekend", 1.99, 2.05);
		
		Product prod = new Product();
		
		when(productService.save(any(Product.class))).thenReturn(prod);
        
		mockMvc.perform(post("/api/products")
	        .content(objectMapper.writeValueAsString(product))
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
    }
	
	@Test
    public void shouldNotCreateProductWithoutNome() throws Exception {
        
		ProductResource product = new ProductResource("P", "Pálio weekend", 1.99, 2.05);
		
		Product prod = new Product();
		
		when(productService.save(any(Product.class))).thenReturn(prod);
        
		mockMvc.perform(post("/api/products")
	        .content(objectMapper.writeValueAsString(product))
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().is(400));
    }
	
	@Test
    public void shouldNotCreateProductWithPesoLiquidoGreaterThanPesoBruto() throws Exception {
        
		ProductResource product = new ProductResource("Peça 05", "Pálio weekend", 1.99, 1.05);
		
		Product prod = new Product();
		
		when(productService.save(any(Product.class))).thenReturn(prod);
        
		mockMvc.perform(post("/api/products")
	        .content(objectMapper.writeValueAsString(product))
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().is(400));
    }
}
