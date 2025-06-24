package br.pucrs.joaonataly.trabalhofinal.domain.services;

import br.pucrs.joaonataly.trabalhofinal.application.dtos.*;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.aluguel.CadastrarAluguelUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.BuscaClienteIdUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarClienteUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarEmpresarialUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.cliente.CadastrarIndividualUC;
import br.pucrs.joaonataly.trabalhofinal.application.useCases.jogo.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoEletronicoModel;
import br.pucrs.joaonataly.trabalhofinal.domain.model.ENUM.TipoMesaModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {

    private CadastrarClienteUC cadastrarClienteUC;
    private CadastrarEmpresarialUC cadastrarEmpresarialUC;
    private CadastrarIndividualUC cadastrarIndividualUC;
    private CadastrarJogoUC cadastrarJogoUC;
    private CadastrarAluguelUC cadastrarAluguelUC;
    private BuscaJogoIdUC buscaJogoIdUC;
    private BuscaClienteIdUC buscaClienteIdUC;

    public InitService(CadastrarEmpresarialUC cadastrarEmpresarialUC, CadastrarIndividualUC cadastrarIndividualUC,
                       CadastrarJogoUC cadastrarJogoUC,
                       CadastrarAluguelUC cadastrarAluguelUC, BuscaJogoIdUC buscaJogoIdUC,
                       BuscaClienteIdUC buscaClienteIdUC, CadastrarClienteUC cadastrarClienteUC) {
        this.cadastrarEmpresarialUC = cadastrarEmpresarialUC;
        this.cadastrarIndividualUC = cadastrarIndividualUC;
        this.cadastrarJogoUC = cadastrarJogoUC;
        this.cadastrarAluguelUC = cadastrarAluguelUC;
        this.buscaJogoIdUC = buscaJogoIdUC;
        this.buscaClienteIdUC = buscaClienteIdUC;
        this.cadastrarClienteUC = cadastrarClienteUC;
    }

    @Transactional
    public void cadastrarClientesEJogos() {
        // Clientes Individuais
        //(int numero, String tipoCliente, String nome, String endereco, String cpf, String nomeFantasia, String cnpj)
        cadastrarClienteUC.executar(new ClienteDTO(1, "INDIVIDUAL", "Ana Souza", "Rua das Flores, 123", "12345678901", null, null));
        cadastrarClienteUC.executar(new ClienteDTO(2, "INDIVIDUAL", "Carlos Lima", "Rua Brasil, 321", "98765432101", null, null));
        cadastrarClienteUC.executar(new ClienteDTO(3, "INDIVIDUAL", "Eduardo Oliveira", "Rua Indigo, 312", "98765678901", null, null));

        // Clientes Empresariais
        cadastrarClienteUC.executar(new ClienteDTO(4, "EMPRESARIAL", "Joana Carolina", "Rua das Ortencias, 132", null, "Eletronicos Joana", "12345678901"));
        cadastrarClienteUC.executar(new ClienteDTO(5, "EMPRESARIAL", "Sandra Santos", "Rua Carlos Oliveira, 213", null, "Games do Sul", "98765432101"));


        // Jogos de Eletronico
        cadastrarJogoUC.executar(new JogoRequestDTO("The Legend of Link", 209.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA, null, null));
        cadastrarJogoUC.executar(new JogoRequestDTO("Super Maria Sis", 199.99, "Nintendo Switch 2", TipoEletronicoModel.AVENTURA, null, null));
        cadastrarJogoUC.executar(new JogoRequestDTO("Call of Duty: Rustic Warfare", 249.99, "PlayStation 5", TipoEletronicoModel.ESTRATEGIA, null, null));
        cadastrarJogoUC.executar(new JogoRequestDTO("FIFA 28", 299.99, "Xbox Series X", TipoEletronicoModel.SIMULACAO, null, null));
        cadastrarJogoUC.executar(new JogoRequestDTO("Craft And Mine", 59.99, "PC", TipoEletronicoModel.SIMULACAO, null, null));
        //Jogos de Mesa
        cadastrarJogoUC.executar(new JogoRequestDTO("Catan", 89.99, null, null, 19, TipoMesaModel.CARTAS));
        cadastrarJogoUC.executar(new JogoRequestDTO("Ticket to Ride", 79.99, null, null, 15, TipoMesaModel.CARTAS));
        cadastrarJogoUC.executar(new JogoRequestDTO("Dungeons & Dragons", 129.99, null, null, 30, TipoMesaModel.TABULEIRO));
        cadastrarJogoUC.executar(new JogoRequestDTO("War", 69.99, null, null, 25, TipoMesaModel.TABULEIRO));
        cadastrarJogoUC.executar(new JogoRequestDTO("Xadrez", 19.99, null, null, 32, TipoMesaModel.TABULEIRO));
}   

    @Transactional
    public void cadastrarAlugueis() {
        var cliente1 = buscaClienteIdUC.executar(2)
                .orElseThrow(() -> new RuntimeException("Cliente ID 2 não encontrado"));
        var jogo1 = buscaJogoIdUC.executar(3)
                .orElseThrow(() -> new RuntimeException("Jogo ID 3 não encontrado"));
                //public AluguelDTO(int identificador, int periodo, String dataInicial, ClienteDTO clienteDTO, JogoDTO jogoDTO)
        var aluguel1 = new AluguelDTO(1, 7, LocalDate.of(2025, 6, 15), cliente1, jogo1);
        cadastrarAluguelUC.executar(aluguel1);

        var cliente2 = buscaClienteIdUC.executar(4)
                .orElseThrow(() -> new RuntimeException("Cliente ID 4 não encontrado"));
        var jogo2 = buscaJogoIdUC.executar(7)
                .orElseThrow(() -> new RuntimeException("Jogo ID 7 não encontrado"));
        var aluguel2 = new AluguelDTO(2, 10, LocalDate.of(2025, 7, 1), cliente2, jogo2);
        cadastrarAluguelUC.executar(aluguel2);

        var cliente3 = buscaClienteIdUC.executar(5)
                .orElseThrow(() -> new RuntimeException("Cliente ID 5 não encontrado"));
        var jogo3 = buscaJogoIdUC.executar(1)
                .orElseThrow(() -> new RuntimeException("Jogo ID 1 não encontrado"));
        var aluguel3 = new AluguelDTO(3, 5, LocalDate.of(2025, 7, 10), cliente3, jogo3);
        cadastrarAluguelUC.executar(aluguel3);
    }
}
