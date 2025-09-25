package com.imobiliaria.locacao.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.service.GerarRelatorioService;
import com.imobiliaria.locacao.service.ImovelService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/imoveis")
public class ImovelBean {
	private final ImovelService service;
    private final GerarRelatorioService relatorioService;
	
    public ImovelBean(ImovelService service, GerarRelatorioService relatorioService) {
		this.service = service;
		this.relatorioService = relatorioService;
	}

	@GetMapping
    public String listarImoveis(Model model) {
        model.addAttribute("imoveis", service.listarTodos());
        model.addAttribute("urlRelatorio", "/imoveis/relatorio");
        return "imoveis/pesquisaImoveis";
    }

    @GetMapping("/novo")
    public String formularioNovoImovel(Model model) {
        model.addAttribute("imovel", new Imovel());
        return "imoveis/cadastroAtualizarImovel";
    }

    @PostMapping
    public String salvarImovel(@ModelAttribute("imovel") Imovel imovel) {
        service.salvar(imovel);
        return "redirect:/imoveis";
    }

    @GetMapping("/editar/{id}")
    public String editarImovel(@PathVariable Long id, Model model) {
        model.addAttribute("imovel", service.buscarPorId(id));
        return "imoveis/cadastroAtualizarImovel";
    }

    @GetMapping("/excluir/{id}")
    public String excluirImovel(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/imoveis";
    }
    
    @GetMapping("/relatorio")
    public void gerarRelatorio(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio-contratos.pdf");
        List<Imovel> lista = service.listarTodos();
        relatorioService.gerarPdfImoveis(response, lista);
    }
}
