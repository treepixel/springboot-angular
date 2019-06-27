package com.springexample.backend.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.backend.dtos.ProductDto;
import com.springexample.backend.entities.Product;
import com.springexample.backend.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(value ="/products", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto, 
			BindingResult result) throws ParseException {
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(this.getErrors(result));
		}
		
		Product product = convertToEntity(productDto);
		Product productCreated = productService.save(product);
		return new ResponseEntity<>(convertToDto(productCreated), HttpStatus.OK );
	}
	
	
	@RequestMapping(value ="/products", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts(Pageable pageable) {
		return new ResponseEntity<>(productService.getAll(pageable), HttpStatus.OK );
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
		Optional<Product> product = productService.get(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		Optional<Product> product = productService.get(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private ProductDto convertToDto(Product product) {
	    ProductDto productDto = modelMapper.map(product, ProductDto.class);
	    return productDto;
	}
	
	private Product convertToEntity(ProductDto productDto) throws ParseException {
	    Product product = modelMapper.map(productDto, Product.class);
	    return product;
	}
	
	private Map<String, ArrayList<String>> getErrors(BindingResult result) {
		Map<String, ArrayList<String>> response = new HashMap<>();
		ArrayList<String> errors = new ArrayList<String>();
		
		result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
		
		response.put("message", errors);
	    
		return response;
	}
}
