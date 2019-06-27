package com.springexample.backend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -5116028919378648304L;
	
	private Long 			id;
	private String 			nome;
	private String			veiculoAplicacao;
	private Double			pesoLiquido;
	private Double			pesoBruto;
	private Date			createdAt;
    private Date			updatedAt;
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column
	public String getVeiculoAplicacao() {
		return veiculoAplicacao;
	}
	public void setVeiculoAplicacao(String veiculoAplicacao) {
		this.veiculoAplicacao = veiculoAplicacao;
	}
	
	@Column
	public Double getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	
	@Column
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
	@Column
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		createdAt = atual;
		updatedAt = atual;
	}
}
