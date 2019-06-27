package com.springexample.backend.dtos;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ProductDtoTest {
	
	private Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    
    @Test
    public void shouldMarkNomeAsInvalid() throws Exception {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setNome("P");
        productDto.setVeiculoAplicacao("Pálio");
        productDto.setPesoLiquido(1.95);
        productDto.setPesoBruto(2.50);
        //when
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        //then
        assertEquals(1, violations.size());
    }
    
    @Test
    public void shouldMarkAplicacaoVeiculoAsInvalid() throws Exception {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setNome("Peça 01");
        productDto.setVeiculoAplicacao("Po");
        productDto.setPesoLiquido(1.95);
        productDto.setPesoBruto(2.50);
        //when
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        //then
        assertEquals(1, violations.size());
    }
    

    @Test
    public void shouldMarkPesoLiquidoAsInvalid() throws Exception {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setNome("Peça 01");
        productDto.setVeiculoAplicacao("Pálio");
        productDto.setPesoLiquido(1.95);
        productDto.setPesoBruto(1.05);
        //when
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        //then
        assertEquals(1, violations.size());
    }
    
}
