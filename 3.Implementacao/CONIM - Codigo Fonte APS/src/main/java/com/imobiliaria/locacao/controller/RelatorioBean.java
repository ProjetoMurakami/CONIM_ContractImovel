package com.imobiliaria.locacao.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imobiliaria.locacao.model.ContratoDeLocacao;
import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.model.Pagamento;
import com.imobiliaria.locacao.service.ContratoDeLocacaoService;
import com.imobiliaria.locacao.service.GerarRelatorioService;
import com.imobiliaria.locacao.service.ImovelService;
import com.imobiliaria.locacao.service.InquilinoService;
import com.imobiliaria.locacao.service.PagamentoService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/relatorios")
public class RelatorioBean {
	
	private final GerarRelatorioService pdfGeneratorService;
    private final ImovelService imovelService;
    private final PagamentoService pagamentoService;
    private final ContratoDeLocacaoService contratoService;
    
    public RelatorioBean(GerarRelatorioService pdfGeneratorService, ImovelService imovelService,
			InquilinoService inquilinoService, PagamentoService pagamentoService,
			ContratoDeLocacaoService contratoService) {
		this.pdfGeneratorService = pdfGeneratorService;
		this.imovelService = imovelService;
		this.pagamentoService = pagamentoService;
		this.contratoService = contratoService;
	}
    
    @GetMapping
    public String paginaRelatorios() {
        return "relatorio/opcoes";  
    }

    @GetMapping("/imoveis")
    public void gerarRelatorioImoveis(HttpServletResponse response) throws IOException {
        List<Imovel> imoveis = imovelService.listarTodos();
        pdfGeneratorService.gerarPdfImoveis(response, imoveis);
    }

    @GetMapping("/contratos")
    public void gerarRelatorioContratos(HttpServletResponse response) throws IOException {
        List<ContratoDeLocacao> contratos = contratoService.listarTodos();
        pdfGeneratorService.gerarPdfContratos(response, contratos);
    }

    @GetMapping("/pagamentos")
    public void gerarRelatorioPagamentos(HttpServletResponse response) throws IOException {
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        pdfGeneratorService.gerarPdfPagamentos(response, pagamentos);
    }

}
