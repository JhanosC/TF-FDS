package br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IEmpresarialRepositorio;
import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IndividualRepositorio;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.BD.entities.Individual;

@Configuration
public class BancoInicial {

@Autowired
private IEmpresarialRepositorio empresarialRepositorio;
@Autowired
private IndividualRepositorio individualRepositorio;

    @Bean
    CommandLineRunner iniciarBanco() {
        return args -> {
            // Clientes Individuais
            individualRepositorio.save(new Individual("Ana Souza", "Rua das Flores, 123", "12345678901"));
            individualRepositorio.save(new Individual("Carlos Lima", "Av. Brasil, 200", "98765432100"));
            individualRepositorio.save(new Individual("Fernanda Reis", "Rua A, 111", "11122233344"));

            // Clientes Empresariais
            empresarialRepositorio.save(new Empresarial("Supermercado Econômico", "Rua B, 222", "Econômico", "11222333444455"));
            empresarialRepositorio.save(new Empresarial("Livraria Cultura", "Rua C, 333", "Cultura", "22334455667788"));
        };
    }
}
