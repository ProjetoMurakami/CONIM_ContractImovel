package com.imobiliaria.locacao.model;

import com.imobiliaria.locacao.enums.TiposDeCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inquilino {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Double rendaMensal;
	private TiposDeCliente categoria;
	
	public Inquilino() {
		super();
	}

	public Inquilino(Long id, String nome, String email, String cpf, String telefone, Double rendaMensal,
			TiposDeCliente categoria) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rendaMensal = rendaMensal;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public TiposDeCliente getCategoria() {
		return categoria;
	}

	public void setCategoria(TiposDeCliente categoria) {
		this.categoria = categoria;
	}

	
}