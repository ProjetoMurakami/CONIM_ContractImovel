package com.imobiliaria.locacao.model;

import java.sql.Date;

import com.imobiliaria.locacao.enums.FormasDePagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double valor;
    private Date dataVencimento;
    private Date dataPagamento;
    private boolean status;
    
    @Enumerated(EnumType.STRING)
    private FormasDePagamento formaDePagamento;
    
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private ContratoDeLocacao contrato;

    public Pagamento() {
    }

    public Pagamento(Long id, Double valor, Date dataVencimento, Date dataPagamento, 
                    FormasDePagamento formaDePagamento, ContratoDeLocacao contrato, boolean status) {
        this.id = id;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.formaDePagamento = formaDePagamento;
        this.contrato = contrato;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormasDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setMetodoPagamento(FormasDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public ContratoDeLocacao getContrato() {
        return contrato;
    }

    public void setContrato(ContratoDeLocacao contrato) {
        this.contrato = contrato;
    }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
}