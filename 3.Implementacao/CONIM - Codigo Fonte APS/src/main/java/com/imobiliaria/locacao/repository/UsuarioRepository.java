package com.imobiliaria.locacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliaria.locacao.enums.Role;
import com.imobiliaria.locacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username);
	
	List<Usuario> findByRole(Role corretor);

	Usuario findByEmail(String login);
}
