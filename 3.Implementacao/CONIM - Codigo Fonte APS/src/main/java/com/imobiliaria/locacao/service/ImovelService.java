package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.repository.ImovelRepository;

@Service
public class ImovelService {

    private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    public List<Imovel> listarTodos() {
        return repository.findAll();
    }

    public Imovel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado com o ID: " + id));
    }

    public Imovel salvar(Imovel imovel) {
        return repository.save(imovel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}