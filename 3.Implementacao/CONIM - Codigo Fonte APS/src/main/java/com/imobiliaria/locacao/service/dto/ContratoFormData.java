package com.imobiliaria.locacao.service.dto;

import java.util.List;

import com.imobiliaria.locacao.model.Fiador;
import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.model.Inquilino;
import com.imobiliaria.locacao.model.Usuario;

public class ContratoFormData {
	private List<Imovel>   imoveis;
    private List<Fiador>   fiadores;
    private List<Inquilino> inquilinos;
    private List<Usuario>  usuarios;
    
	public ContratoFormData() {
	}

	public ContratoFormData(List<Imovel> imoveis, List<Fiador> fiadores, List<Inquilino> inquilinos,
			List<Usuario> usuarios) {
		this.imoveis = imoveis;
		this.fiadores = fiadores;
		this.inquilinos = inquilinos;
		this.usuarios = usuarios;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public List<Fiador> getFiadores() {
		return fiadores;
	}

	public void setFiadores(List<Fiador> fiadores) {
		this.fiadores = fiadores;
	}

	public List<Inquilino> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<Inquilino> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
    
}
