package com.springexample.backend.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProductDto {
	
	private Long 			id;
	private String 			nome;
	private String			veiculoAplicacao;
	private Double			pesoLiquido;
	private Double			pesoBruto;
	private Date			createdAt;
    private Date			updatedAt;
	
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome do produto não pode ser vazio")
	@Length(min = 5, max = 200, message = "Nome do produto deve conter entre 5 e 200 caracteres")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message = "Veículo de aplicação não pode ser vazio")
	@Length(min = 5, max = 200, message = "Veículo de aplicação deve conter entre 5 e 200 caracteres")
	public String getVeiculoAplicacao() {
		return veiculoAplicacao;
	}
	public void setVeiculoAplicacao(String veiculoAplicacao) {
		this.veiculoAplicacao = veiculoAplicacao;
	}

	@NotEmpty(message = "Peso líquido não pode ser vazio")
	public Double getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	
	@NotEmpty(message = "Peso bruto não pode ser vazio")
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
