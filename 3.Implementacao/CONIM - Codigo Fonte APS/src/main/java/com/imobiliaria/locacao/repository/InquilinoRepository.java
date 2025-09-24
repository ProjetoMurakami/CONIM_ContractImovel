package com.imobiliaria.locacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliaria.locacao.model.Inquilino;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {

  
    Optional<Inquilino> findByCpf(String cpf);
    
    List<Inquilino> findByNomeContainingIgnoreCase(String nome);
    
   
    boolean existsByCpf(String cpf);
}