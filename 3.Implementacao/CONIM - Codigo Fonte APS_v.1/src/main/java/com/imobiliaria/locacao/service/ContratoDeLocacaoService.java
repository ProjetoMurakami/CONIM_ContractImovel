package com.imobiliaria.locacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.ContratoDeLocacao;
import com.imobiliaria.locacao.repository.ContratoDeLocacaoRepository;
import com.imobiliaria.locacao.service.dto.ContratoFormData;

@Service
public class ContratoDeLocacaoService {

    private final ContratoDeLocacaoRepository repository;
    private final ImovelService              imovelService;
    private final FiadorService              fiadorService;
    private final InquilinoService           inquilinoService;
    private final UsuarioService             usuarioService;
    
    @Autowired
    public ContratoDeLocacaoService(ContratoDeLocacaoRepository repository, ImovelService imovelService,FiadorService fiadorService,InquilinoService inquilinoService,UsuarioService usuarioService) {
        this.repository      = repository;
        this.imovelService   = imovelService;
        this.fiadorService   = fiadorService;
        this.inquilinoService= inquilinoService;
        this.usuarioService  = usuarioService;
    }

    public ContratoFormData prepararDadosFormulario() {
        ContratoFormData data = new ContratoFormData();
        data.setImoveis(   imovelService.listarTodos()   );
        data.setFiadores(  fiadorService.listarTodos()   );
        data.setInquilinos(inquilinoService.listarTodos());
        data.setUsuarios(  usuarioService.listarTodos()  );
        return data;
    }
    
    public ContratoDeLocacao salvar(ContratoDeLocacao contrato) {
        return repository.save(contrato);
    }

    public List<ContratoDeLocacao> listarTodos() {
        return repository.findAll();
    }

    public ContratoDeLocacao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<ContratoDeLocacao> findAllComRelacionamentos() {
        return repository.findAllComRelacionamentos();
    }
    
    public List<ContratoDeLocacao> buscarContratos(Long id, String imovel, String inquilino) {
        return repository.findByFiltros(id, imovel, inquilino);
    }

}