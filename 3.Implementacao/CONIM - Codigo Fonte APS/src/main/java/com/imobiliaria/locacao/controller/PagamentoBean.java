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

import com.imobiliaria.locacao.enums.FormasDePagamento;
import com.imobiliaria.locacao.model.Pagamento;
import com.imobiliaria.locacao.service.ContratoDeLocacaoService;
import com.imobiliaria.locacao.service.GerarRelatorioService;
import com.imobiliaria.locacao.service.PagamentoService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoBean {
    private final PagamentoService pagamentoService;
    private final ContratoDeLocacaoService contratoService;
    private final GerarRelatorioService relatorioService;

    public PagamentoBean(PagamentoService pagamentoService,
                         ContratoDeLocacaoService contratoService,
                         GerarRelatorioService relatorioService) {
        this.pagamentoService = pagamentoService;
        this.contratoService = contratoService;
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String listarPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.listarTodos());
        model.addAttribute("urlRelatorio", "/pagamentos/relatorio");
        return "Pagamento/pesquisaPagamentos";
    }

    @PostMapping("/salvar")
    public String salvarPagamento(@ModelAttribute("pagamento") Pagamento pagamento) {
        pagamentoService.salvar(pagamento);
        return "redirect:/pagamentos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovo(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        model.addAttribute("contratos", contratoService.listarTodos());
        model.addAttribute("formas", FormasDePagamento.values());
        return "Pagamento/cadastroAtualizarPagamento";
    }

    @GetMapping("/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        model.addAttribute("pagamento", pagamentoService.buscarPorId(id));
        model.addAttribute("contratos", contratoService.listarTodos());
        model.addAttribute("formas", FormasDePagamento.values());
        return "Pagamento/cadastroAtualizarPagamento";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPagamento(@PathVariable Long id) {
        pagamentoService.deletar(id);
        return "redirect:/pagamentos";
    }

    @GetMapping("/relatorio")
    public void gerarRelatorio(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio-pagamentos.pdf");
        List<Pagamento> lista = pagamentoService.listarTodos();
        relatorioService.gerarPdfPagamentos(response, lista);
    }
}
