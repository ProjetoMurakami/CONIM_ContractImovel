package com.imobiliaria.locacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.imobiliaria.locacao.model") 
@EnableJpaRepositories("com.imobiliaria.locacao.repository") 
public class LocacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}