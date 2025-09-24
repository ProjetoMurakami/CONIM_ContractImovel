package com.imobiliaria.locacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imobiliaria.locacao.model.Usuario;
import com.imobiliaria.locacao.repository.UsuarioRepository;

@Controller
public class HomeBean {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        String login = authentication.getName(); 

        Usuario usuario = usuarioRepository.findByEmail(login); 
        String nome = usuario != null ? usuario.getNome() : login; 
        System.out.println(nome);
        String role = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("ROLE_USUARIO");

        String funcao = switch (role) {
            case "ROLE_ADMINISTRADOR" -> "Administrador";
            case "ROLE_CORRETOR" -> "Corretor";
            default -> "Usuário";
        };

        model.addAttribute("userName", nome);
        model.addAttribute("userRole", funcao);

        return "home";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
    	return "dashboard";
    }
}
