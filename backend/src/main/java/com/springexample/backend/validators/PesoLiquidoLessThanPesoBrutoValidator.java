package com.springexample.backend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springexample.backend.customannotations.PesoLiquidoLessThanPesoBruto;
import com.springexample.backend.dtos.ProductDto;

public class PesoLiquidoLessThanPesoBrutoValidator implements ConstraintValidator<PesoLiquidoLessThanPesoBruto, ProductDto>{
	
	@Override
    public void initialize(PesoLiquidoLessThanPesoBruto constraint) {
    }

    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext context) {
        return productDto.getPesoLiquido() <= productDto.getPesoBruto();
    }
}
