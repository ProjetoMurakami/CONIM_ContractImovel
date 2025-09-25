package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.Fiador;
import com.imobiliaria.locacao.repository.FiadorRepository;

@Service
public class FiadorService {

    private final FiadorRepository repository;

    public FiadorService(FiadorRepository repository) {
        this.repository = repository;
    }

    public List<Fiador> listarTodos() {
        return repository.findAll();
    }

    public Fiador buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fiador não encontrado com o ID: " + id));
    }

    public Fiador salvar(Fiador fiador) {
        return repository.save(fiador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}