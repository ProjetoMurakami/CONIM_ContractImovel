package com.imobiliaria.locacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliaria.locacao.enums.StatusImovel;
import com.imobiliaria.locacao.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByStatusImovel(StatusImovel statusImovel);
    
}	