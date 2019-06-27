package com.springexample.backend.customannotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.springexample.backend.validators.PesoLiquidoLessThanPesoBrutoValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PesoLiquidoLessThanPesoBrutoValidator.class})
public @interface PesoLiquidoLessThanPesoBruto {
	
	String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
