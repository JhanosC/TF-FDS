package br.pucrs.joaonataly.trabalhofinal;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.ClienteDTO;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.JogoRequestDTO;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.CadastrarAluguelUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarClienteUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.CadastrarJogoUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.application.dtos.AluguelValorFinalDTO;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.ValorFinalAluguelUC;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IAluguelRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IClienteRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IIndividualRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.services.AluguelService;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.EletronicoRepository;
import br.pucrs.joaonataly.trabalhofinal.infrastructure.repositoryImpl.MesaRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExemploTrabalhofinalApplication {

    @Autowired
    private CadastrarClienteUC cadastrarClienteUC;

    @Autowired
    private CadastrarJogoUC cadastrarJogoUC;

    @Autowired
    private CadastrarAluguelUC cadastrarAluguelUC;

    @Autowired
    private ValorFinalAluguelUC valorFinalAluguelUC;

    @Autowired
    private IAluguelRepository aluguelRepository;

    @Autowired
    private IJogoRepository jogoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IIndividualRepository individualRepository;

    @Autowired
    private EletronicoRepository eletronicoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    private ClienteDTO cliente;
    private JogoRequestDTO jogo;

    @BeforeEach
    public void setUp() {
        cliente = new ClienteDTO(99, "INDIVIDUAL", "Individual Teste", "Rua Teste, 123",
        "123456789", null, null);
        jogo = new JogoRequestDTO(1,"Jogo Teste", 100.0, "PC",
            TipoEletronicoModel.ESTRATEGIA, null, null);
    }

    @Test
    void contextLoads() {
        // Verifica se o Spring Boot inicializa corretamente
    }

    @Test
    void deveCadastrarClienteComSucesso() {

        boolean resultado = cadastrarClienteUC.executar(cliente);
        assertTrue(resultado, "Cliente deveria ser cadastrado com sucesso.");
    }

    @Test
    void deveCadastrarJogoComSucesso() {

        boolean resultado = cadastrarJogoUC.executar(jogo);
        assertTrue(resultado, "Jogo deveria ser cadastrado com sucesso.");
    }

    @Test
    void deveCadastrarAluguelComSucesso() {
        // Aluguel usando identificador = 99, clienteNumero = 99 e jogoCodigo = 99
        AluguelDTO aluguel = new AluguelDTO(1,7, LocalDate.now(), 99, 99
        );

        boolean resultado = cadastrarAluguelUC.executar(aluguel);
        assertTrue(resultado, "Aluguel deveria ser cadastrado com sucesso.");
    }
}
