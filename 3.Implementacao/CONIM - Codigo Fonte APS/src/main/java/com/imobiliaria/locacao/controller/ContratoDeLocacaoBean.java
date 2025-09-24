package com.imobiliaria.locacao.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imobiliaria.locacao.model.ContratoDeLocacao;
import com.imobiliaria.locacao.service.ContratoDeLocacaoService;
import com.imobiliaria.locacao.service.GerarRelatorioService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/contratos")
public class ContratoDeLocacaoBean {

	private final ContratoDeLocacaoService contratoService;
    private final GerarRelatorioService relatorioService;
	
    @Autowired
    public ContratoDeLocacaoBean(ContratoDeLocacaoService contratoService, GerarRelatorioService relatorioService) {
        this.contratoService = contratoService;
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String listarContratos(Model model) {
        model.addAttribute("contratos", contratoService.listarTodos());
        model.addAttribute("urlRelatorio", "/contratos/relatorio");
        return "contrato/pesquisaContratosDeLocacao";
    }


    @GetMapping("/novo")
    public String novoContrato(Model model) {
        model.addAttribute("formData", contratoService.prepararDadosFormulario());
        model.addAttribute("contrato", new ContratoDeLocacao());
        return "contrato/cadastroAtualizarLocacao";
    }

    @PostMapping("/salvar")
    public String salvarContrato(@ModelAttribute ContratoDeLocacao contrato) {
        contratoService.salvar(contrato);
        return "redirect:/contratos";
    }

    @GetMapping("/editar/{id}")
    public String editarContrato(@PathVariable Long id, Model model) {
        model.addAttribute("formData", contratoService.prepararDadosFormulario());
        model.addAttribute("contrato", contratoService.buscarPorId(id));
        return "contrato/cadastroAtualizarLocacao";
    }

    @GetMapping("/excluir/{id}")
    public String excluirContrato(@PathVariable Long id) {
    	contratoService.deletar(id);
        return "redirect:/contratos";
    }
    
    @GetMapping("/relatorio")
    public void gerarRelatorio(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio-contratos.pdf");
        List<ContratoDeLocacao> lista = contratoService.listarTodos();
        relatorioService.gerarPdfContratos(response, lista);
    }
    
    @GetMapping("/buscar")
    public String buscarContratos(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String imovel,
        @RequestParam(required = false) String inquilino,
        Model model) {
        	    
    	List<ContratoDeLocacao> contratos = contratoService.buscarContratos(id, imovel, inquilino);
        model.addAttribute("contratos", contratos);
        return "contrato/pesquisaContratosDeLocacao";
    }
}