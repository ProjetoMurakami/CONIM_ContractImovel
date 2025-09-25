package com.imobiliaria.locacao.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.ContratoDeLocacao;
import com.imobiliaria.locacao.model.Imovel;
import com.imobiliaria.locacao.model.Inquilino;
import com.imobiliaria.locacao.model.Pagamento;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class GerarRelatorioService {

	public void gerarPdfContratos(HttpServletResponse response, List<ContratoDeLocacao> lista) {
	    try {
	        gerarPdf(
	            response.getOutputStream(),
	            "Relatório de Contratos de Aluguel",
	            new String[]{"ID","Data de Início","Data Final","Valor do Aluguel","Inquilino (ID)","Fiador (ID)","Imóvel (ID)","Corretor (ID)"},
	            lista.stream().map(c -> new String[]{
	                String.valueOf(c.getId()),
	                formatDate(c.getDataInicio()),
	                formatDate(c.getDataFinal()),
	                formatCurrency(c.getValorAluguel()),
	                c.getInquilino()  != null ? String.valueOf(c.getInquilino().getId())  : "-",
	                c.getFiador()     != null ? String.valueOf(c.getFiador().getId())     : "-",
	                c.getImovel()     != null ? String.valueOf(c.getImovel().getId())     : "-",
	                c.getUsuario()    != null ? String.valueOf(c.getUsuario().getId())    : "-"  // assumindo que 'usuario' é o corretor
	            }).toList()
	        );
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void gerarPdfImoveis(HttpServletResponse response, List<Imovel> lista) {
	    try {
	        gerarPdf(
	            response.getOutputStream(),
	            "Relatório de Imóveis",
	            new String[]{"ID","CEP","Bairro","Endereço","Número","Valor do Aluguel","Status do Imóvel","Quartos","Banheiros","Área (m²)","Observações"},
	            lista.stream().map(i -> new String[]{
	                String.valueOf(i.getId()),
	                i.getCEP(),
	                i.getBairro(),
	                i.getEndereco(),
	                i.getNumero(),
	                formatCurrency(i.getValorDeAluguel()),
	                i.getStatusImovel() != null ? i.getStatusImovel().toString() : "-",
	                i.getQuartos()    != null ? String.valueOf(i.getQuartos())    : "-",
	                i.getBanheiros()  != null ? String.valueOf(i.getBanheiros())  : "-",
	                i.getArea()       != null ? String.valueOf(i.getArea())       : "-",
	                i.getObservacoes() != null ? i.getObservacoes() : "-"
	            }).toList()
	        );
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void gerarPdfPagamentos(HttpServletResponse response, List<Pagamento> lista) {
	    try {
	        gerarPdf(
	            response.getOutputStream(),
	            "Relatório de Pagamentos",
	            new String[]{"ID","Valor","Data Vencimento","Data Pagamento","Status","Forma de Pagamento","ID Contrato"},
	            lista.stream().map(p -> new String[]{
	                String.valueOf(p.getId()),
	                formatCurrency(p.getValor()),
	                formatDate(p.getDataVencimento()),
	                formatDate(p.getDataPagamento()),
	                p.isStatus() ? "Pago" : "Vencido",
	                p.getFormaDePagamento() != null ? p.getFormaDePagamento().toString() : "-",
	                p.getContrato() != null ? String.valueOf(p.getContrato().getId()) : "-"
	            }).toList()
	        );
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

    public void gerarPdfInquilinos(HttpServletResponse response, List<Inquilino> lista) {
        try {
			gerarPdf(response.getOutputStream(), "Relatório de Inquilinos",
			    new String[]{"ID", "Nome", "Email", "CPF", "Telefone", "Renda Mensal", "Categoria"},
			    lista.stream().map(i -> new String[]{
			            String.valueOf(i.getId()),
			            i.getNome(),
			            i.getEmail(),
			            i.getCpf(),
			            i.getTelefone(),
			            formatCurrency(i.getRendaMensal()),
			            i.getCategoria().toString()
			        }).toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void gerarPdf(OutputStream out, String titulo, String[] headers, List<String[]> rows) {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, out);
            documento.open();
            documento.add(new Paragraph(titulo));
            documento.add(new Paragraph(" "));

            PdfPTable tabela = new PdfPTable(headers.length);
            for (String header : headers) {
                tabela.addCell(new Paragraph(header));
            }
            for (String[] row : rows) {
                for (String cell : row) {
                    tabela.addCell(new Paragraph(cell));
                }
            }
            documento.add(tabela);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }

    private String formatDate(java.util.Date date) {
        if (date == null) return "N/A";
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    private String formatDate(java.time.LocalDate date) {
        if (date == null) return "N/A";
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private String formatCurrency(double value) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(value);
    }
}
