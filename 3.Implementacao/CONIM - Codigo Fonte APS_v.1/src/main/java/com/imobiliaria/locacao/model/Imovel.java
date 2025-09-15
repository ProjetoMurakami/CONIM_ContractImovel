package com.imobiliaria.locacao.model;

import com.imobiliaria.locacao.enums.StatusImovel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Imovel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String CEP;
    private String bairro;
    private String endereco;
    private String numero;
    
    @Column(name = "valor_aluguel")
    private Double valorDeAluguel;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusImovel statusImovel;
    
    private Integer quartos;
    private Integer banheiros;
    private Double area;
    private String observacoes;
	
	public Imovel() {
	}

	public Imovel(Long id, String cEP, String bairro, String cidade, String estado, String endereco, String numero,
			Double valorDeAluguel, StatusImovel statusImovel, String tipo, Integer quartos, Integer banheiros,
			Double area, String observacoes) {
		super();
		this.id = id;
		CEP = cEP;
		this.bairro = bairro;
		this.endereco = endereco;
		this.numero = numero;
		this.valorDeAluguel = valorDeAluguel;
		this.statusImovel = statusImovel;
		this.quartos = quartos;
		this.banheiros = banheiros;
		this.area = area;
		this.observacoes = observacoes;
	}

	public String getCEP() {
		return CEP;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Integer getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(Integer banheiros) {
		this.banheiros = banheiros;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getValorDeAluguel() {
		return valorDeAluguel;
	}

	public void setValorDeAluguel(Double valorDeAluguel) {
		this.valorDeAluguel = valorDeAluguel;
	}

	public StatusImovel getStatusImovel() {
		return statusImovel;
	}

	public void setStatusImovel(StatusImovel statusImovel) {
		this.statusImovel = statusImovel;
	}

}
