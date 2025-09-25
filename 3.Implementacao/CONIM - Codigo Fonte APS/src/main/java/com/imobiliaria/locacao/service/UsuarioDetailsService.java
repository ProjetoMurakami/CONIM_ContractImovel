package com.imobiliaria.locacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User; // ✅ Correto
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.imobiliaria.locacao.model.Usuario;
import com.imobiliaria.locacao.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println(">> loadUserByUsername: '" + username + "'");
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        System.out.println("   encontrado: " + usuario.getUsername() + " / " + usuario.getRole());
        System.out.println("Senha codificada do admin → " + usuario.getSenha());
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name())
                .build();
    }
}


