package com.imobiliaria.locacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;

import com.imobiliaria.locacao.model.Fiador;
import com.imobiliaria.locacao.service.FiadorService;

@Controller
@RequestMapping("/fiadores")
public class FiadorBean {
	
	 private FiadorService service;
	 
	 @Autowired
	 public FiadorBean(FiadorService service) {
	        this.service = service;
	 }

	 @GetMapping
	 public String listarFiadores(Model model) {
	     model.addAttribute("fiadores", service.listarTodos());
	     return "fiador/pesquisaFiadores";
	 }
	 
	 @GetMapping("/novo")
	 public String formularioNovoFiador(
	         Model model,
	         @RequestParam(value="redirectTo", required=false) String redirectTo) {

	     model.addAttribute("fiador", new Fiador());
	     model.addAttribute("redirectTo", redirectTo);
	     return "fiador/cadastroAtualizarFiador";
	 }

	 @PostMapping
	 public String salvarFiador(
	         @ModelAttribute Fiador fiador,
	         @RequestParam(value="redirectTo", required=false) String redirectTo) {

	     service.salvar(fiador);

	     if (StringUtils.hasText(redirectTo)) {
	         return "redirect:" + redirectTo;
	     }
	     return "redirect:/fiadores";
	 }

	    @GetMapping("/editar/{id}")
	    public String editarFiador(@PathVariable Long id, Model model) {
	        model.addAttribute("fiador", service.buscarPorId(id));
	        return "fiador/cadastroAtualizarFiador";
	    }

	    @GetMapping("/excluir/{id}")
	    public String excluirFiador(@PathVariable Long id) {
	        service.deletar(id);
	        return "redirect:/fiadores";
	    }
}