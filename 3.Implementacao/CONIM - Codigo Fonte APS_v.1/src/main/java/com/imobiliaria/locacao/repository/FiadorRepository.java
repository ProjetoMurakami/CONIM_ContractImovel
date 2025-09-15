package com.imobiliaria.locacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliaria.locacao.model.Fiador;

@Repository
public interface FiadorRepository extends JpaRepository<Fiador, Long> {

    Optional<Fiador> findByCpf(String cpf);
    
    List<Fiador> findByNomeContainingIgnoreCase(String nome);
    
    boolean existsByCpf(String cpf);
    
}