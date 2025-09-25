package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.Inquilino;
import com.imobiliaria.locacao.repository.InquilinoRepository;

@Service
public class InquilinoService {

    private final InquilinoRepository repository;

    public InquilinoService(InquilinoRepository repository) {
        this.repository = repository;
    }

    public List<Inquilino> listarTodos() {
        return repository.findAll();
    }

    public Inquilino buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquilino não encontrado com o ID: " + id));
    }

    public Inquilino salvar(Inquilino inquilino) {
        return repository.save(inquilino);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}