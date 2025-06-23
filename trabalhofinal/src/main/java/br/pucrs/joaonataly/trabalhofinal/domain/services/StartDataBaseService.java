package br.pucrs.joaonataly.trabalhofinal.domain.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartDataBaseService {
    @Bean
    CommandLineRunner initializeDB(InitService initService) {
        return args -> {
            initService.cadastrarClientesEJogos();
            initService.cadastrarAlugueis();
        };
    }
}

