package com.imobiliaria.locacao.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ContratoDeLocacao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFinal;
	private Double valorAluguel;
	
	@ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    
    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private Inquilino inquilino;
    
    @ManyToOne
    @JoinColumn(name = "fiador_id")
    private Fiador fiador;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();
	
    
    public ContratoDeLocacao() {
		
	}

	public ContratoDeLocacao(long id, Date dataInicio, Date dataFinal, Double valorAluguel, Imovel imovel,
			Inquilino inquilino, Fiador fiador, ArrayList<Pagamento> pagamentos, Usuario usuario) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.valorAluguel = valorAluguel;
		this.imovel = imovel;
		this.inquilino = inquilino;
		this.fiador = fiador;
		this.usuario = usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Fiador getFiador() {
		return fiador;
	}

	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}

	public ArrayList<Pagamento> getPagamentos() {
		return (ArrayList<Pagamento>) pagamentos;
	}

	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}