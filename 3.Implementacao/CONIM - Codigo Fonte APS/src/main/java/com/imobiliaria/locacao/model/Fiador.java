package com.imobiliaria.locacao.model;

import com.imobiliaria.locacao.enums.TiposDeCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fiador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String CEP;
    private String bairro;
    private String endereco;
    private String numero;
	private Double rendaMensal;
	private String observacoes;
	private TiposDeCliente categoria;
	
	public Fiador() {
		super();
	}

	public Fiador(Long id, String nome, String cpf, String email, String telefone, String cEP, String bairro,
			String endereco, String numero, Double rendaMensal, String observacoes, TiposDeCliente categoria) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		CEP = cEP;
		this.bairro = bairro;
		this.endereco = endereco;
		this.numero = numero;
		this.rendaMensal = rendaMensal;
		this.observacoes = observacoes;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public TiposDeCliente getCategoria() {
		return categoria;
	}

	public void setCategoria(TiposDeCliente categoria) {
		this.categoria = categoria;
	}
	
}