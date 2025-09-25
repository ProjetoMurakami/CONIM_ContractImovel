package com.imobiliaria.locacao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.imobiliaria.locacao.enums.Role;
import com.imobiliaria.locacao.model.Usuario;
import com.imobiliaria.locacao.repository.UsuarioRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("admin");
            admin.setUsername("admin");                   
            admin.setSenha(passwordEncoder.encode("admin123")); 
            admin.setRole(Role.ADMINISTRADOR);            
            usuarioRepository.save(admin);
            System.out.println("Criado usuário" + admin.getUsername() + " " + admin.getSenha());
        }
        if (usuarioRepository.findByUsername("roberto12").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Roberto");
            admin.setUsername("roberto12");                   
            admin.setSenha(passwordEncoder.encode("roberto24")); 
            admin.setRole(Role.ADMINISTRADOR);            
            usuarioRepository.save(admin);
            System.out.println("Criado usuário" + admin.getUsername() + " " + admin.getSenha());
        }
        if (usuarioRepository.findByUsername("Maria").isEmpty()) {
            Usuario corretor = new Usuario();
            corretor.setNome("Maria Helena");
            corretor.setUsername("Maria");                   
            corretor.setSenha(passwordEncoder.encode("maria123")); 
            corretor.setRole(Role.CORRETOR);            
            usuarioRepository.save(corretor);
            System.out.println("Criado usuário" + corretor.getUsername() + " " + corretor.getSenha());
        }
    }
}

