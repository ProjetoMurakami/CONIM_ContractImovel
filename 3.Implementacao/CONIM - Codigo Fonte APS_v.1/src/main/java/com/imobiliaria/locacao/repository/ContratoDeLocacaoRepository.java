package com.imobiliaria.locacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imobiliaria.locacao.model.ContratoDeLocacao;
import com.imobiliaria.locacao.model.Fiador;
import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.model.Inquilino;
import com.imobiliaria.locacao.model.Pagamento;
import com.imobiliaria.locacao.model.Usuario;

@Repository
public interface ContratoDeLocacaoRepository extends JpaRepository<ContratoDeLocacao, Long>{

	ContratoDeLocacao findByImovel (Imovel imovelProcurado);
	ContratoDeLocacao findByInquilino (Inquilino inquilino);
	ContratoDeLocacao findByFiador (Fiador fiador);
	ContratoDeLocacao findByPagamentos (Pagamento pagamento);
	ContratoDeLocacao findByUsuario (Usuario usuario);
	ContratoDeLocacao save(ContratoDeLocacao contrato);
	ContratoDeLocacao findByImovelId(Long imovelId);
	ContratoDeLocacao findByInquilinoId(Long inquilinoId);
	ContratoDeLocacao findByFiadorId(Long fiadorId);
	@Query("SELECT con FROM ContratoDeLocacao con " +
		       "JOIN  con.inquilino " +
		       "LEFT JOIN  con.fiador " +
		       "JOIN  con.imovel " +
		       "LEFT JOIN  con.pagamentos")
	List<ContratoDeLocacao> findAllComRelacionamentos();
	
	@Query("SELECT c FROM ContratoDeLocacao c " +
		       "WHERE (:id IS NULL OR c.id = :id) " +
		       "AND (:imovel IS NULL OR CAST(c.imovel.id AS string) LIKE CONCAT('%', :imovel, '%')) " +
		       "AND (:inquilino IS NULL OR LOWER(c.inquilino.nome) LIKE LOWER(CONCAT('%', :inquilino, '%'))) ")
		List<ContratoDeLocacao> findByFiltros(
		    @Param("id") Long id,
		    @Param("imovel") String imovel,
		    @Param("inquilino") String inquilino);

}