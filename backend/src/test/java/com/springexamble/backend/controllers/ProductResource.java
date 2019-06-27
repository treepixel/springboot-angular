package com.springexamble.backend.controllers;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ProductResource {
	
	@NotNull
	private final String nome;

	@NotNull
	private final String veiculoAplicacao;
	
	@NotNull
	private final Double pesoLiquido;
	
	@NotNull
	private final Double pesoBruto;
	
	public ProductResource (
		@JsonProperty("nome") String nome,
	    @JsonProperty("veiculoAplicacao") String veiculoAplicacao,
	    @JsonProperty("pesoLiquido") Double pesoLiquido,
	    @JsonProperty("pesoBruto") Double pesoBruto
	    ) {
		this.nome = nome;
		this.veiculoAplicacao = veiculoAplicacao;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
	}

	public String getNome() {
		return nome;
	}

	public String getVeiculoAplicacao() {
		return veiculoAplicacao;
	}

	public Double getPesoLiquido() {
		return pesoLiquido;
	}

	public Double getPesoBruto() {
		return pesoBruto;
	}
}
