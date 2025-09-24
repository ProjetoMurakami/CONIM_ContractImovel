package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.Pagamento;
import com.imobiliaria.locacao.repository.PagamentoRepository;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}