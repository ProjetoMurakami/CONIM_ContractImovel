package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.enums.Role;
import com.imobiliaria.locacao.model.Usuario;
import com.imobiliaria.locacao.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Usuario> listarTodos() {
        return repository.findAll();
    }
	
	public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }
	
	public List<Usuario> findByRole(Role corretor) {
        return repository.findByRole(corretor);
    }

}
