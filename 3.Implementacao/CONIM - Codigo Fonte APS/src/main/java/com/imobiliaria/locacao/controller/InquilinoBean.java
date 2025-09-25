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

import com.imobiliaria.locacao.model.Inquilino;
import com.imobiliaria.locacao.service.GerarRelatorioService;
import com.imobiliaria.locacao.service.InquilinoService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/inquilinos")
public class InquilinoBean {
	private final InquilinoService service;
    private final GerarRelatorioService relatorioService;
    
    public InquilinoBean(InquilinoService service,GerarRelatorioService relatorioService) {
        this.service = service;
		this.relatorioService = relatorioService;
    }

    @GetMapping
    public String listarInquilinos(Model model) {
        model.addAttribute("inquilinos", service.listarTodos());
        model.addAttribute("urlRelatorio", "/inquilinos/relatorio");
        return "inquilinos/pesquisaInquilinos";
    }

    @GetMapping("/novo")
    public String formularioNovoInquilino(Model model) {
        model.addAttribute("inquilino", new Inquilino());
        return "inquilinos/cadastroAtualizarInquilino";
    }

    @PostMapping
    public String salvarInquilino(@ModelAttribute("inquilino") Inquilino inquilino) {
        service.salvar(inquilino);
        return "redirect:/inquilinos";
    }

    @GetMapping("/editar/{id}")
    public String editarInquilino(@PathVariable Long id, Model model) {
        model.addAttribute("inquilino", service.buscarPorId(id));
        return "inquilinos/cadastroAtualizarInquilino";
    }

    @GetMapping("/excluir/{id}")
    public String excluirInquilino(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/inquilinos";
    }
    
    @GetMapping("/relatorio")
    public void gerarRelatorioInquilinos(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio-inquilinos.pdf");
        List<Inquilino> lista = service.listarTodos();
        relatorioService.gerarPdfInquilinos(response, lista);
    }

}
